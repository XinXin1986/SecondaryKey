package com.ifels.secondary.key.client;

import com.ifels.secondary.key.util.KeyboardUtil;
import com.ifels.secondary.key.util.LogUtil;
import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.client.settings.KeyConflictContext;
import org.lwjgl.glfw.GLFW;

import static com.ifels.secondary.key.client.Keybinding.*;
import static com.ifels.secondary.key.util.KeyboardUtil.isMatchKey;

public class KeyEventInGameHandler {
    private static final InputConstants.Key KEY_B = InputConstants.Type.KEYSYM.getOrCreate(GLFW.GLFW_KEY_B);

    private static final InputConstants.Key KEY_A = InputConstants.Type.KEYSYM.getOrCreate(GLFW.GLFW_KEY_A);
    private static final InputConstants.Key KEY_W = InputConstants.Type.KEYSYM.getOrCreate(GLFW.GLFW_KEY_W);
    private static final InputConstants.Key KEY_S = InputConstants.Type.KEYSYM.getOrCreate(GLFW.GLFW_KEY_S);
    private static final InputConstants.Key KEY_D = InputConstants.Type.KEYSYM.getOrCreate(GLFW.GLFW_KEY_D);

    private static final InputConstants.Key KEY_ENTER = InputConstants.Type.KEYSYM.getOrCreate(GLFW.GLFW_KEY_ENTER);
    private static final InputConstants.Key KEY_BACKSPACE = InputConstants.Type.KEYSYM.getOrCreate(GLFW.GLFW_KEY_BACKSPACE);
    private static final InputConstants.Key KEY_TAB = InputConstants.Type.KEYSYM.getOrCreate(GLFW.GLFW_KEY_TAB);
    private static final InputConstants.Key KEY_CAPS_LOCK = InputConstants.Type.KEYSYM.getOrCreate(GLFW.GLFW_KEY_CAPS_LOCK);
    private static final InputConstants.Key KEY_INSERT = InputConstants.Type.KEYSYM.getOrCreate(GLFW.GLFW_KEY_INSERT);
    private static final InputConstants.Key KEY_DELETE = InputConstants.Type.KEYSYM.getOrCreate(GLFW.GLFW_KEY_DELETE);
    private static final InputConstants.Key KEY_F10 = InputConstants.Type.KEYSYM.getOrCreate(GLFW.GLFW_KEY_F10);
    private static final InputConstants.Key KEY_F12 = InputConstants.Type.KEYSYM.getOrCreate(GLFW.GLFW_KEY_F12);

    public static final KeyMapping SecondaryEpicFightMineMineKey = new KeyMapping(
            KEY_SECONDARY_EPIC_FIGHT_MINE_MINE_KEY,
            KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_RIGHT_ALT,
            KEY_CATEGORY_SECONDARY
    );

    public static final KeyMapping SecondaryEpicFightBattleMineKey = new KeyMapping(
            KEY_SECONDARY_EPIC_FIGHT_BATTLE_MINE_KEY,
            KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_UNKNOWN,
            KEY_CATEGORY_SECONDARY
    );

    public static final KeyMapping SecondaryGameBKey = new KeyMapping(
            KEY_SECONDARY_GAME_B,
            KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_UNKNOWN,
            KEY_CATEGORY_SECONDARY
    );

    public static final KeyMapping SecondaryGameAKey = new KeyMapping(
            KEY_SECONDARY_GAME_A,
            KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_UNKNOWN,
            KEY_CATEGORY_SECONDARY
    );

    public static final KeyMapping SecondaryGameWKey = new KeyMapping(
            KEY_SECONDARY_GAME_W,
            KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_UNKNOWN,
            KEY_CATEGORY_SECONDARY
    );

    public static final KeyMapping SecondaryGameSKey = new KeyMapping(
            KEY_SECONDARY_GAME_S,
            KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_UNKNOWN,
            KEY_CATEGORY_SECONDARY
    );

    public static final KeyMapping SecondaryGameDKey = new KeyMapping(
            KEY_SECONDARY_GAME_D,
            KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_UNKNOWN,
            KEY_CATEGORY_SECONDARY
    );

    public static final KeyMapping SecondaryGameF10Key = new KeyMapping(
            KEY_SECONDARY_GAME_F10,
            KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_UNKNOWN,
            KEY_CATEGORY_SECONDARY
    );

    public static final KeyMapping SecondaryGameF12Key = new KeyMapping(
            KEY_SECONDARY_GAME_F12,
            KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_UNKNOWN,
            KEY_CATEGORY_SECONDARY
    );

    public static final KeyMapping SecondaryGameEnterKey = new KeyMapping(
            KEY_SECONDARY_GAME_ENTER,
            KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_UNKNOWN,
            KEY_CATEGORY_SECONDARY
    );

    public static final KeyMapping SecondaryGameBackspaceKey = new KeyMapping(
            KEY_SECONDARY_GAME_BACKSPACE,
            KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_UNKNOWN,
            KEY_CATEGORY_SECONDARY
    );

    public static final KeyMapping SecondaryGameTabKey = new KeyMapping(
            KEY_SECONDARY_GAME_TAB,
            KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_UNKNOWN,
            KEY_CATEGORY_SECONDARY
    );

    public static final KeyMapping SecondaryGameCapslockKey = new KeyMapping(
            KEY_SECONDARY_GAME_CAPSLOCK,
            KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_UNKNOWN,
            KEY_CATEGORY_SECONDARY
    );

    public static final KeyMapping SecondaryGameDeleteKey = new KeyMapping(
            KEY_SECONDARY_GAME_DELETE,
            KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_UNKNOWN,
            KEY_CATEGORY_SECONDARY
    );

    public static final KeyMapping SecondaryGameInsertKey = new KeyMapping(
            KEY_SECONDARY_GAME_INSERT,
            KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_UNKNOWN,
            KEY_CATEGORY_SECONDARY
    );

    public static void registerKeyMapping(RegisterKeyMappingsEvent e) {
        e.register(SecondaryGameF10Key);
        e.register(SecondaryGameF12Key);
        e.register(SecondaryGameEnterKey);
        e.register(SecondaryGameTabKey);
        e.register(SecondaryGameCapslockKey);
        e.register(SecondaryGameBackspaceKey);
        e.register(SecondaryGameInsertKey);
        e.register(SecondaryGameDeleteKey);

        e.register(SecondaryGameBKey);
        e.register(SecondaryGameAKey);
        e.register(SecondaryGameWKey);
        e.register(SecondaryGameSKey);
        e.register(SecondaryGameDKey);
        e.register(SecondaryEpicFightMineMineKey);
        e.register(SecondaryEpicFightBattleMineKey);
    }

    public static boolean handleKeyEventInGame(InputEvent.Key e) {
//        if (SecondaryGameBKey.consumeClick()) {
//            KeyboardUtil.clickKey(KEY_B);
//        }
        if (isMatchKey(e, SecondaryGameBKey)) {
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

        } else if (isMatchKey(e, SecondaryGameF10Key)) {
            LogUtil.i("isMatchKey SecondaryGameF10Key..");
            if (e.getAction() == InputConstants.PRESS) {
                KeyboardUtil.pressKey(KEY_F10, false);
            } else if (e.getAction() == InputConstants.RELEASE) {
                KeyboardUtil.releaseKey(KEY_F10, false);
            }
            return true;

        } else if (isMatchKey(e, SecondaryGameF12Key)) {
            LogUtil.i("isMatchKey SecondaryGameF12Key..");
            if (e.getAction() == InputConstants.PRESS) {
                KeyboardUtil.pressKey(KEY_F12, false);
            } else if (e.getAction() == InputConstants.RELEASE) {
                KeyboardUtil.releaseKey(KEY_F12, false);
            }
            return true;

        } else if (isMatchKey(e, SecondaryGameEnterKey)) {
            LogUtil.i("isMatchKey SecondaryGameEnterKey..");
            if (e.getAction() == InputConstants.PRESS) {
                KeyboardUtil.pressKey(KEY_ENTER, false);
            } else if (e.getAction() == InputConstants.RELEASE) {
                KeyboardUtil.releaseKey(KEY_ENTER, false);
            }
            return true;

        } else if (isMatchKey(e, SecondaryGameTabKey)) {
            LogUtil.i("isMatchKey SecondaryGameTabKey..");
            if (e.getAction() == InputConstants.PRESS) {
                KeyboardUtil.pressKey(KEY_TAB, false);
            } else if (e.getAction() == InputConstants.RELEASE) {
                KeyboardUtil.releaseKey(KEY_TAB, false);
            }
            return true;

        } else if (isMatchKey(e, SecondaryGameCapslockKey)) {
            LogUtil.i("isMatchKey SecondaryGameCapslockKey..");
            if (e.getAction() == InputConstants.PRESS) {
                KeyboardUtil.pressKey(KEY_CAPS_LOCK, false);
            } else if (e.getAction() == InputConstants.RELEASE) {
                KeyboardUtil.releaseKey(KEY_CAPS_LOCK, false);
            }
            return true;

        } else if (isMatchKey(e, SecondaryGameInsertKey)) {
            LogUtil.i("isMatchKey SecondaryGameInsertKey..");
            if (e.getAction() == InputConstants.PRESS) {
                KeyboardUtil.pressKey(KEY_INSERT, false);
            } else if (e.getAction() == InputConstants.RELEASE) {
                KeyboardUtil.releaseKey(KEY_INSERT, false);
            }
            return true;

        } else if (isMatchKey(e, SecondaryGameDeleteKey)) {
            LogUtil.i("isMatchKey SecondaryGameDeleteKey..");
            if (e.getAction() == InputConstants.PRESS) {
                KeyboardUtil.pressKey(KEY_DELETE, false);
            } else if (e.getAction() == InputConstants.RELEASE) {
                KeyboardUtil.releaseKey(KEY_DELETE, false);
            }
            return true;
        } else if (isMatchKey(e, SecondaryGameBackspaceKey)) {
            LogUtil.i("isMatchKey SecondaryGameBackspaceKey..");
            if (e.getAction() == InputConstants.PRESS) {
                KeyboardUtil.pressKey(KEY_BACKSPACE, false);
            } else if (e.getAction() == InputConstants.RELEASE) {
                KeyboardUtil.releaseKey(KEY_BACKSPACE, false);
            }
            return true;
        }
        return false;
    }
}
