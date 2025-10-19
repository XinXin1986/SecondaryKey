package com.ifels.secondary.key.client;

import com.ifels.secondary.key.util.KeyboardUtil;
import com.ifels.secondary.key.util.LogUtil;
import com.mojang.blaze3d.platform.InputConstants;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import org.lwjgl.glfw.GLFW;

import static com.ifels.secondary.key.client.Keybinding.*;
import static com.ifels.secondary.key.util.KeyboardUtil.isMatchKey;

public class KeyEventInGameHandler {
    private static final InputConstants.Key KEY_B = InputConstants.Type.KEYSYM.getOrCreate(GLFW.GLFW_KEY_B);

    private static final InputConstants.Key KEY_A = InputConstants.Type.KEYSYM.getOrCreate(GLFW.GLFW_KEY_A);
    private static final InputConstants.Key KEY_W = InputConstants.Type.KEYSYM.getOrCreate(GLFW.GLFW_KEY_W);
    private static final InputConstants.Key KEY_S = InputConstants.Type.KEYSYM.getOrCreate(GLFW.GLFW_KEY_S);
    private static final InputConstants.Key KEY_D = InputConstants.Type.KEYSYM.getOrCreate(GLFW.GLFW_KEY_D);

    private static final InputConstants.Key KEY_1 = InputConstants.Type.KEYSYM.getOrCreate(GLFW.GLFW_KEY_1);
    private static final InputConstants.Key KEY_2 = InputConstants.Type.KEYSYM.getOrCreate(GLFW.GLFW_KEY_2);
    private static final InputConstants.Key KEY_3 = InputConstants.Type.KEYSYM.getOrCreate(GLFW.GLFW_KEY_3);
    private static final InputConstants.Key KEY_KP_1 = InputConstants.Type.KEYSYM.getOrCreate(GLFW.GLFW_KEY_KP_1);
    private static final InputConstants.Key KEY_KP_2 = InputConstants.Type.KEYSYM.getOrCreate(GLFW.GLFW_KEY_KP_2);
    private static final InputConstants.Key KEY_KP_3 = InputConstants.Type.KEYSYM.getOrCreate(GLFW.GLFW_KEY_KP_3);

    public static void registerKeyMapping(RegisterKeyMappingsEvent e) {
        e.register(Keybinding.SecondaryGameBKey);
        e.register(Keybinding.SecondaryGameAKey);
        e.register(Keybinding.SecondaryGameWKey);
        e.register(Keybinding.SecondaryGameSKey);
        e.register(Keybinding.SecondaryGameDKey);
        e.register(Keybinding.SecondaryEpicFightMineMineKey);
        e.register(Keybinding.SecondaryEpicFightBattleMineKey);
    }

    public static boolean handleKeyEventInGame(InputEvent.Key e) {
        if (SecondaryGameBKey.consumeClick()) {
            LogUtil.i("isMatchKey SecondaryGameBKey..");
            if (e.getAction() == InputConstants.PRESS) {
                KeyboardUtil.pressKey(KEY_B, false);
            } else if (e.getAction() == InputConstants.RELEASE) {
                KeyboardUtil.releaseKey(KEY_B, false);
            }
            return true;

        } else if (isMatchKey(e, SecondaryGameAKey)) {
            LogUtil.i("isMatchKey SecondaryGameAKey..");
            if (e.getAction() == InputConstants.PRESS) {
                KeyboardUtil.pressKey(KEY_A, false);
            } else if (e.getAction() == InputConstants.RELEASE) {
                KeyboardUtil.releaseKey(KEY_A, false);
            }
            return true;

        } else if (isMatchKey(e, SecondaryGameWKey)) {
            LogUtil.i("isMatchKey SecondaryGameWKey..");
            if (e.getAction() == InputConstants.PRESS) {
                KeyboardUtil.pressKey(KEY_W, false);
            } else if (e.getAction() == InputConstants.RELEASE) {
                KeyboardUtil.releaseKey(KEY_W, false);
            }
            return true;

        } else if (isMatchKey(e, SecondaryGameSKey)) {
            LogUtil.i("isMatchKey SecondaryGameSKey..");
            if (e.getAction() == InputConstants.PRESS) {
                KeyboardUtil.pressKey(KEY_S, false);
            } else if (e.getAction() == InputConstants.RELEASE) {
                KeyboardUtil.releaseKey(KEY_S, false);
            }
            return true;

        } else if (isMatchKey(e, SecondaryGameDKey)) {
            LogUtil.i("isMatchKey SecondaryGameDKey..");
            if (e.getAction() == InputConstants.PRESS) {
                KeyboardUtil.pressKey(KEY_D, false);
            } else if (e.getAction() == InputConstants.RELEASE) {
                KeyboardUtil.releaseKey(KEY_D, false);
            }
            return true;
        }
        return false;
    }
}
