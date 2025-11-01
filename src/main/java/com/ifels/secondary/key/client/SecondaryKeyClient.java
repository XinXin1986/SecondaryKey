package com.ifels.secondary.key.client;

import com.ifels.secondary.key.SecondaryKey;
import com.ifels.secondary.key.compat.EpicFightCompat;
import com.ifels.secondary.key.util.KeyboardUtil;
import com.ifels.secondary.key.util.LogUtil;
import com.ifels.secondary.key.util.MouseUtil;
import com.mojang.blaze3d.platform.InputConstants;
import com.mojang.blaze3d.platform.InputConstants.Type;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.controls.KeyBindsScreen;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.client.event.ScreenEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.TickEvent.Phase;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import org.lwjgl.glfw.GLFW;

import static com.ifels.secondary.key.client.Keybinding.*;

public class SecondaryKeyClient {
    private static final InputConstants.Key KEY_R = Type.KEYSYM.getOrCreate(GLFW.GLFW_KEY_R);
    private static final InputConstants.Key KEY_U = Type.KEYSYM.getOrCreate(GLFW.GLFW_KEY_U);

    private static boolean EMU_LEFT_DOWN = false;
    private static boolean EMU_RIGHT_DOWN = false;
    private static Screen lastScreen = null;
    private static InputConstants.Key savedJumpKey = null;
    private static boolean jumpUnbound = false;

    private static boolean isInGame(Minecraft mc) {
        return mc.player != null && mc.level != null;
    }

    @EventBusSubscriber(modid = SecondaryKey.MODID, bus = Bus.MOD, value = {Dist.CLIENT})
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onKeyRegister(RegisterKeyMappingsEvent e) {
            KeyEventInGameHandler.registerKeyMapping(e);
            e.register(SecondaryGuiEscKey);
            e.register(SecondaryGuiMouseLeftKey);
            e.register(SecondaryGuiMouseRightKey);
            e.register(Keybinding.SecondaryGuiRKey);
            e.register(Keybinding.SecondaryGuiUKey);
        }

        @SubscribeEvent
        public static void onCommonSetup(FMLCommonSetupEvent e) {
            if (ModList.get().isLoaded("epicfight")) {
                LogUtil.i("Epic Fight mod detected. Registering compatibility event listeners.", new Object[0]);
                MinecraftForge.EVENT_BUS.register(new EpicFightCompat());
            } else {
                LogUtil.i("Epic Fight mod not detected. Skipping compatibility registration.", new Object[0]);
            }

        }
    }

    @EventBusSubscriber(modid = SecondaryKey.MODID, value = {Dist.CLIENT})
    public static class ClientForgeEvents {
        @SubscribeEvent
        public static void onKeyInput(InputEvent.Key e) {
            Minecraft mc = Minecraft.getInstance();
            int key = e.getKey();

            if (mc.screen == null && isInGame(mc)) {
                if (KeyEventInGameHandler.handleKeyEventInGame(e)) {
                    return;
                }
            }

            if (mc.screen != null && isInGame(mc)) {
                if (mc.screen instanceof KeyBindsScreen) {
                    return;
                }

                //LogUtil.i("onKeyInput. screen {}, key {}", new Object[]{mc.screen, key});
                if (key == SecondaryGuiEscKey.getKey().getValue()
                        || key == SecondaryGuiMouseLeftKey.getKey().getValue()
                        || key == SecondaryGuiMouseRightKey.getKey().getValue()) {

                    if (e.isCancelable()) {
                        e.setCanceled(true);
                    }

                    KeyMapping.set(Type.KEYSYM.getOrCreate(key), false);
                    KeyMapping.set(mc.options.keyJump.getKey(), false);
                }
            } else if (mc.screen == null
                    && isInGame(mc)
                    && key == SecondaryGuiMouseLeftKey.getKey().getValue()
                    && mc.options.keyJump.getKey() == InputConstants.UNKNOWN) {

                mc.options.keyJump.setKey(SecondaryGuiMouseLeftKey.getKey());
                KeyMapping.resetMapping();
                LogUtil.i("Jump key was UNKNOWN, set to SecondaryGuiMouseLeftKey", new Object[0]);
            }

        }

        @SubscribeEvent
        public static void onKeyPressedInUI(ScreenEvent.KeyPressed.Pre e) {
            if (e.getScreen() instanceof KeyBindsScreen) return;

            int keyCode = e.getKeyCode();
            if (keyCode == SecondaryGuiEscKey.getKey().getValue()) {
                e.getScreen().onClose();
                e.setCanceled(true);

            } else if (keyCode == Keybinding.SecondaryGuiRKey.getKey().getValue()) {
                KeyboardUtil.clickKey(KEY_R);
                e.setCanceled(true);

            } else if (keyCode == Keybinding.SecondaryGuiUKey.getKey().getValue()) {
                KeyboardUtil.clickKey(KEY_U);
                e.setCanceled(true);

            } else if (keyCode == SecondaryGuiMouseLeftKey.getKey().getValue()) {
                if (!EMU_LEFT_DOWN) {
                    MouseUtil.pressMouseKey(GLFW.GLFW_MOUSE_BUTTON_LEFT);
                    EMU_LEFT_DOWN = true;
                }

                e.setCanceled(true);
            } else {
                if (keyCode == SecondaryGuiMouseRightKey.getKey().getValue()) {
                    if (!EMU_RIGHT_DOWN) {
                        MouseUtil.pressMouseKey(GLFW.GLFW_MOUSE_BUTTON_RIGHT);
                        EMU_RIGHT_DOWN = true;
                    }
                    e.setCanceled(true);
                }
            }
        }

        @SubscribeEvent
        public static void onKeyReleasedInUI(ScreenEvent.KeyReleased.Pre e) {
            if (e.getScreen() instanceof KeyBindsScreen) return;

            int keyCode = e.getKeyCode();
            if (keyCode == SecondaryGuiMouseLeftKey.getKey().getValue()) {
                if (EMU_LEFT_DOWN) {
                    MouseUtil.releaseMouseKey(GLFW.GLFW_MOUSE_BUTTON_LEFT);
                    EMU_LEFT_DOWN = false;
                }

                e.setCanceled(true);
            } else if (keyCode == SecondaryGuiMouseRightKey.getKey().getValue()) {
                if (EMU_RIGHT_DOWN) {
                    MouseUtil.releaseMouseKey(GLFW.GLFW_MOUSE_BUTTON_RIGHT);
                    EMU_RIGHT_DOWN = false;
                }

                e.setCanceled(true);
            }

        }

        @SubscribeEvent
        public static void onClientTick(TickEvent.ClientTickEvent e) {
            if (e.phase != Phase.END) return;

            Minecraft mc = Minecraft.getInstance();

            boolean inGame = isInGame(mc);
            Screen cur = mc.screen;
            //LogUtil.i("screen = {}, player = {}, level = {}", new Object[]{cur != null ? cur.toString() : null, mc.player, mc.level});
            if (!inGame) {
                if (jumpUnbound && savedJumpKey != null) {
                    mc.options.keyJump.setKey(savedJumpKey);
                    KeyMapping.resetMapping();
                    jumpUnbound = false;
                    savedJumpKey = null;
                    LogUtil.i("Jump key restored (out of game)", new Object[0]);
                }

                lastScreen = cur;
            } else {
                if (cur != lastScreen) {
                    if (cur != null) {
                        InputConstants.Key jumpKey = mc.options.keyJump.getKey();
                        boolean sameAsLeft = jumpKey.equals(SecondaryGuiMouseLeftKey.getKey());
                        boolean sameAsRight = jumpKey.equals(SecondaryGuiMouseRightKey.getKey());
                        LogUtil.d("mc.screen {}, isPauseScreen {}", new Object[]{mc.screen, mc.screen.isPauseScreen()});
                        if (!jumpUnbound && (sameAsLeft || sameAsRight) && !mc.screen.isPauseScreen()) {
                            savedJumpKey = jumpKey;
                            mc.options.keyJump.setKey(InputConstants.UNKNOWN);
                            KeyMapping.resetMapping();
                            jumpUnbound = true;
                            LogUtil.i("Jump temporarily unbound while GUI open (conflicts with secondary mouse key)", new Object[0]);
                        }
                    } else if (jumpUnbound && savedJumpKey != null) {
                        mc.options.keyJump.setKey(savedJumpKey);
                        KeyMapping.resetMapping();
                        jumpUnbound = false;
                        savedJumpKey = null;
                        LogUtil.i("Jump key restored after GUI closed", new Object[0]);
                    }

                    lastScreen = cur;
                }

                if (cur != null) {
                    KeyMapping.set(mc.options.keyJump.getKey(), false);
                }
            }
        }
    }
}
