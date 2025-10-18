
package com.ifels.secondary.key.client;

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

public class SecondaryKeyClient {
    private static boolean EMU_LEFT_DOWN = false;
    private static boolean EMU_RIGHT_DOWN = false;
    private static final InputConstants.Key KEY_B;
    private static final InputConstants.Key KEY_R;
    private static final InputConstants.Key KEY_U;
    private static Screen lastScreen;
    private static InputConstants.Key savedJumpKey;
    private static boolean jumpUnbound;

    private static boolean isInGame(Minecraft mc) {
        return mc.player != null && mc.level != null;
    }

    static {
        KEY_B = Type.KEYSYM.getOrCreate(66);
        KEY_R = Type.KEYSYM.getOrCreate(82);
        KEY_U = Type.KEYSYM.getOrCreate(85);
        lastScreen = null;
        savedJumpKey = null;
        jumpUnbound = false;
    }

    @EventBusSubscriber(
            modid = "secondarykey",
            bus = Bus.MOD,
            value = {Dist.CLIENT}
    )
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onKeyRegister(RegisterKeyMappingsEvent e) {
            e.register(Keybinding.SecondaryGameBKey);
            e.register(Keybinding.SecondaryGuiEscKey);
            e.register(Keybinding.SecondaryGuiMouseLeftKey);
            e.register(Keybinding.SecondaryGuiMouseRightKey);
            e.register(Keybinding.SecondaryGuiRKey);
            e.register(Keybinding.SecondaryGuiUKey);
            e.register(Keybinding.SecondaryEpicFightMineMineKey);
            e.register(Keybinding.SecondaryEpicFightBattleMineKey);
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

    @EventBusSubscriber(
            modid = "secondarykey",
            value = {Dist.CLIENT}
    )
    public static class ClientForgeEvents {
        @SubscribeEvent
        public static void onKeyInput(InputEvent.Key e) {
            Minecraft mc = Minecraft.getInstance();
            if (Keybinding.SecondaryGameBKey.consumeClick() && mc.screen == null && SecondaryKeyClient.isInGame(mc)) {
                KeyboardUtil.clickKey(SecondaryKeyClient.KEY_B);
            }

            int key = e.getKey();
            if (mc.screen != null && SecondaryKeyClient.isInGame(mc)) {
                if (mc.screen instanceof KeyBindsScreen) {
                    return;
                }

                LogUtil.i("onKeyInput. screen {}, key {}", new Object[]{mc.screen, key});
                if (key == Keybinding.SecondaryGuiEscKey.getKey().getValue() || key == Keybinding.SecondaryGuiMouseLeftKey.getKey().getValue() || key == Keybinding.SecondaryGuiMouseRightKey.getKey().getValue()) {
                    if (e.isCancelable()) {
                        e.setCanceled(true);
                    }

                    KeyMapping.set(Type.KEYSYM.getOrCreate(key), false);
                    if (mc.options != null) {
                        KeyMapping.set(mc.options.keyJump.getKey(), false);
                    }
                }
            } else if (mc.screen == null && SecondaryKeyClient.isInGame(mc) && key == Keybinding.SecondaryGuiMouseLeftKey.getKey().getValue() && mc.options.keyJump.getKey() == InputConstants.UNKNOWN) {
                mc.options.keyJump.setKey(Keybinding.SecondaryGuiMouseLeftKey.getKey());
                KeyMapping.resetMapping();
                LogUtil.i("Jump key was UNKNOWN, set to SecondaryGuiMouseLeftKey", new Object[0]);
            }

        }

        @SubscribeEvent
        public static void onKeyPressedInUI(ScreenEvent.KeyPressed.Pre e) {
            if (!(e.getScreen() instanceof KeyBindsScreen)) {
                int keyCode = e.getKeyCode();
                if (keyCode == Keybinding.SecondaryGuiEscKey.getKey().getValue()) {
                    e.getScreen().onClose();
                    e.setCanceled(true);
                } else if (keyCode == Keybinding.SecondaryGuiRKey.getKey().getValue()) {
                    KeyboardUtil.clickKey(SecondaryKeyClient.KEY_R);
                    e.setCanceled(true);
                } else if (keyCode == Keybinding.SecondaryGuiUKey.getKey().getValue()) {
                    KeyboardUtil.clickKey(SecondaryKeyClient.KEY_U);
                    e.setCanceled(true);
                } else if (keyCode == Keybinding.SecondaryGuiMouseLeftKey.getKey().getValue()) {
                    if (!SecondaryKeyClient.EMU_LEFT_DOWN) {
                        MouseUtil.pressMouseKey(0);
                        SecondaryKeyClient.EMU_LEFT_DOWN = true;
                    }

                    e.setCanceled(true);
                } else {
                    if (keyCode == Keybinding.SecondaryGuiMouseRightKey.getKey().getValue()) {
                        if (!SecondaryKeyClient.EMU_RIGHT_DOWN) {
                            MouseUtil.pressMouseKey(1);
                            SecondaryKeyClient.EMU_RIGHT_DOWN = true;
                        }

                        e.setCanceled(true);
                    }

                }
            }
        }

        @SubscribeEvent
        public static void onKeyReleasedInUI(ScreenEvent.KeyReleased.Pre e) {
            if (!(e.getScreen() instanceof KeyBindsScreen)) {
                int keyCode = e.getKeyCode();
                if (keyCode == Keybinding.SecondaryGuiMouseLeftKey.getKey().getValue()) {
                    if (SecondaryKeyClient.EMU_LEFT_DOWN) {
                        MouseUtil.releaseMouseKey(0);
                        SecondaryKeyClient.EMU_LEFT_DOWN = false;
                    }

                    e.setCanceled(true);
                } else if (keyCode == Keybinding.SecondaryGuiMouseRightKey.getKey().getValue()) {
                    if (SecondaryKeyClient.EMU_RIGHT_DOWN) {
                        MouseUtil.releaseMouseKey(1);
                        SecondaryKeyClient.EMU_RIGHT_DOWN = false;
                    }

                    e.setCanceled(true);
                }

            }
        }

        @SubscribeEvent
        public static void onClientTick(TickEvent.ClientTickEvent e) {
            if (e.phase == Phase.END) {
                Minecraft mc = Minecraft.getInstance();
                if (mc.options != null) {
                    boolean inGame = SecondaryKeyClient.isInGame(mc);
                    Screen cur = mc.screen;
                    LogUtil.i("screen = {}, player = {}, level = {}", new Object[]{cur != null ? cur.toString() : null, mc.player, mc.level});
                    if (!inGame) {
                        if (SecondaryKeyClient.jumpUnbound && SecondaryKeyClient.savedJumpKey != null) {
                            mc.options.keyJump.setKey(SecondaryKeyClient.savedJumpKey);
                            KeyMapping.resetMapping();
                            SecondaryKeyClient.jumpUnbound = false;
                            SecondaryKeyClient.savedJumpKey = null;
                            LogUtil.i("Jump key restored (out of game)", new Object[0]);
                        }

                        SecondaryKeyClient.lastScreen = cur;
                    } else {
                        if (cur != SecondaryKeyClient.lastScreen) {
                            if (cur != null) {
                                InputConstants.Key jumpKey = mc.options.keyJump.getKey();
                                boolean sameAsLeft = jumpKey.equals(Keybinding.SecondaryGuiMouseLeftKey.getKey());
                                boolean sameAsRight = jumpKey.equals(Keybinding.SecondaryGuiMouseRightKey.getKey());
                                LogUtil.d("mc.screen {}, isPauseScreen {}", new Object[]{mc.screen, mc.screen.isPauseScreen()});
                                if (!SecondaryKeyClient.jumpUnbound && (sameAsLeft || sameAsRight) && !mc.screen.isPauseScreen()) {
                                    SecondaryKeyClient.savedJumpKey = jumpKey;
                                    mc.options.keyJump.setKey(InputConstants.UNKNOWN);
                                    KeyMapping.resetMapping();
                                    SecondaryKeyClient.jumpUnbound = true;
                                    LogUtil.i("Jump temporarily unbound while GUI open (conflicts with secondary mouse key)", new Object[0]);
                                }
                            } else if (SecondaryKeyClient.jumpUnbound && SecondaryKeyClient.savedJumpKey != null) {
                                mc.options.keyJump.setKey(SecondaryKeyClient.savedJumpKey);
                                KeyMapping.resetMapping();
                                SecondaryKeyClient.jumpUnbound = false;
                                SecondaryKeyClient.savedJumpKey = null;
                                LogUtil.i("Jump key restored after GUI closed", new Object[0]);
                            }

                            SecondaryKeyClient.lastScreen = cur;
                        }

                        if (cur != null) {
                            KeyMapping.set(mc.options.keyJump.getKey(), false);
                        }

                    }
                }
            }
        }
    }
}
