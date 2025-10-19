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

    private static final InputConstants.Key KEY_N1 = InputConstants.Type.KEYSYM.getOrCreate(GLFW.GLFW_KEY_1);
    private static final InputConstants.Key KEY_N2 = InputConstants.Type.KEYSYM.getOrCreate(GLFW.GLFW_KEY_2);
    private static final InputConstants.Key KEY_N3 = InputConstants.Type.KEYSYM.getOrCreate(GLFW.GLFW_KEY_3);
    private static final InputConstants.Key KEY_N4 = InputConstants.Type.KEYSYM.getOrCreate(GLFW.GLFW_KEY_4);
    private static final InputConstants.Key KEY_N5 = InputConstants.Type.KEYSYM.getOrCreate(GLFW.GLFW_KEY_5);
    private static final InputConstants.Key KEY_N6 = InputConstants.Type.KEYSYM.getOrCreate(GLFW.GLFW_KEY_6);

    public static void registerKeyMapping(RegisterKeyMappingsEvent e) {
        e.register(Keybinding.SecondaryGameN1Key);
        e.register(Keybinding.SecondaryGameN2Key);
        e.register(Keybinding.SecondaryGameN3Key);
        e.register(Keybinding.SecondaryGameN4Key);
        e.register(Keybinding.SecondaryGameN5Key);
        e.register(Keybinding.SecondaryGameN6Key);

        e.register(Keybinding.SecondaryGameBKey);
        e.register(Keybinding.SecondaryGameAKey);
        e.register(Keybinding.SecondaryGameWKey);
        e.register(Keybinding.SecondaryGameSKey);
        e.register(Keybinding.SecondaryGameDKey);
        e.register(Keybinding.SecondaryEpicFightMineMineKey);
        e.register(Keybinding.SecondaryEpicFightBattleMineKey);
    }

    public static boolean handleKeyEventInGame(InputEvent.Key e) {
        if (isMatchKey(e, SecondaryGameAKey)) {
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

        } else if (isMatchKey(e, SecondaryGameN1Key)) {
            LogUtil.i("isMatchKey SecondaryGameN1Key..");
            if (e.getAction() == InputConstants.PRESS) {
                KeyboardUtil.pressKey(KEY_N1, false);
            } else if (e.getAction() == InputConstants.RELEASE) {
                KeyboardUtil.releaseKey(KEY_N1, false);
            }
            return true;

        } else if (isMatchKey(e, SecondaryGameN2Key)) {
            LogUtil.i("isMatchKey SecondaryGameN2Key..");
            if (e.getAction() == InputConstants.PRESS) {
                KeyboardUtil.pressKey(KEY_N2, false);
            } else if (e.getAction() == InputConstants.RELEASE) {
                KeyboardUtil.releaseKey(KEY_N2, false);
            }
            return true;

        } else if (isMatchKey(e, SecondaryGameN3Key)) {
            LogUtil.i("isMatchKey SecondaryGameN3Key..");
            if (e.getAction() == InputConstants.PRESS) {
                KeyboardUtil.pressKey(KEY_N3, false);
            } else if (e.getAction() == InputConstants.RELEASE) {
                KeyboardUtil.releaseKey(KEY_N3, false);
            }
            return true;

        } else if (isMatchKey(e, SecondaryGameN4Key)) {
            LogUtil.i("isMatchKey SecondaryGameN4Key..");
            if (e.getAction() == InputConstants.PRESS) {
                KeyboardUtil.pressKey(KEY_N4, false);
            } else if (e.getAction() == InputConstants.RELEASE) {
                KeyboardUtil.releaseKey(KEY_N4, false);
            }
            return true;

        } else if (isMatchKey(e, SecondaryGameN5Key)) {
            LogUtil.i("isMatchKey SecondaryGameN5Key..");
            if (e.getAction() == InputConstants.PRESS) {
                KeyboardUtil.pressKey(KEY_N5, false);
            } else if (e.getAction() == InputConstants.RELEASE) {
                KeyboardUtil.releaseKey(KEY_N5, false);
            }
            return true;

        } else if (isMatchKey(e, SecondaryGameN6Key)) {
            LogUtil.i("isMatchKey SecondaryGameN6Key..");
            if (e.getAction() == InputConstants.PRESS) {
                KeyboardUtil.pressKey(KEY_N6, false);
            } else if (e.getAction() == InputConstants.RELEASE) {
                KeyboardUtil.releaseKey(KEY_N6, false);
            }
            return true;
        }
        return false;
    }
}
