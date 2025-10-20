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

    private static final InputConstants.Key KEY_F13 = InputConstants.Type.KEYSYM.getOrCreate(GLFW.GLFW_KEY_F13);
    private static final InputConstants.Key KEY_F14 = InputConstants.Type.KEYSYM.getOrCreate(GLFW.GLFW_KEY_F14);
    private static final InputConstants.Key KEY_F15 = InputConstants.Type.KEYSYM.getOrCreate(GLFW.GLFW_KEY_F15);
    private static final InputConstants.Key KEY_F16 = InputConstants.Type.KEYSYM.getOrCreate(GLFW.GLFW_KEY_F16);
    private static final InputConstants.Key KEY_F17 = InputConstants.Type.KEYSYM.getOrCreate(GLFW.GLFW_KEY_F17);
    private static final InputConstants.Key KEY_F18 = InputConstants.Type.KEYSYM.getOrCreate(GLFW.GLFW_KEY_F18);
    private static final InputConstants.Key KEY_F19 = InputConstants.Type.KEYSYM.getOrCreate(GLFW.GLFW_KEY_F19);
    private static final InputConstants.Key KEY_F20 = InputConstants.Type.KEYSYM.getOrCreate(GLFW.GLFW_KEY_F20);
    private static final InputConstants.Key KEY_F21 = InputConstants.Type.KEYSYM.getOrCreate(GLFW.GLFW_KEY_F21);
    private static final InputConstants.Key KEY_F22 = InputConstants.Type.KEYSYM.getOrCreate(GLFW.GLFW_KEY_F22);
    private static final InputConstants.Key KEY_F23 = InputConstants.Type.KEYSYM.getOrCreate(GLFW.GLFW_KEY_F23);
    private static final InputConstants.Key KEY_F24 = InputConstants.Type.KEYSYM.getOrCreate(GLFW.GLFW_KEY_F24);

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
            GLFW.GLFW_KEY_PAGE_UP,
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

    public static final KeyMapping SecondaryGameF13Key = new KeyMapping(
            KEY_SECONDARY_GAME_F13,
            KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_UNKNOWN,
            KEY_CATEGORY_SECONDARY
    );

    public static final KeyMapping SecondaryGameF14Key = new KeyMapping(
            KEY_SECONDARY_GAME_F14,
            KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_UNKNOWN,
            KEY_CATEGORY_SECONDARY
    );

    public static final KeyMapping SecondaryGameF15Key = new KeyMapping(
            KEY_SECONDARY_GAME_F15,
            KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_UNKNOWN,
            KEY_CATEGORY_SECONDARY
    );

    public static final KeyMapping SecondaryGameF16Key = new KeyMapping(
            KEY_SECONDARY_GAME_F16,
            KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_UNKNOWN,
            KEY_CATEGORY_SECONDARY
    );

    public static final KeyMapping SecondaryGameF17Key = new KeyMapping(
            KEY_SECONDARY_GAME_F17,
            KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_UNKNOWN,
            KEY_CATEGORY_SECONDARY
    );

    public static final KeyMapping SecondaryGameF18Key = new KeyMapping(
            KEY_SECONDARY_GAME_F18,
            KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_UNKNOWN,
            KEY_CATEGORY_SECONDARY
    );

    public static void registerKeyMapping(RegisterKeyMappingsEvent e) {
        e.register(SecondaryGameF13Key);
        e.register(SecondaryGameF14Key);
        e.register(SecondaryGameF15Key);
        e.register(SecondaryGameF16Key);
        e.register(SecondaryGameF17Key);
        e.register(SecondaryGameF18Key);

        e.register(SecondaryGameBKey);
        e.register(SecondaryGameAKey);
        e.register(SecondaryGameWKey);
        e.register(SecondaryGameSKey);
        e.register(SecondaryGameDKey);
        e.register(SecondaryEpicFightMineMineKey);
        e.register(SecondaryEpicFightBattleMineKey);
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

        } else if (isMatchKey(e, SecondaryGameF13Key)) {
            LogUtil.i("isMatchKey SecondaryGameF13Key..");
            if (e.getAction() == InputConstants.PRESS) {
                KeyboardUtil.pressKey(KEY_F13, false);
            } else if (e.getAction() == InputConstants.RELEASE) {
                KeyboardUtil.releaseKey(KEY_F13, false);
            }
            return true;

        } else if (isMatchKey(e, SecondaryGameF14Key)) {
            LogUtil.i("isMatchKey SecondaryGameF14Key..");
            if (e.getAction() == InputConstants.PRESS) {
                KeyboardUtil.pressKey(KEY_F14, false);
            } else if (e.getAction() == InputConstants.RELEASE) {
                KeyboardUtil.releaseKey(KEY_F14, false);
            }
            return true;

        } else if (isMatchKey(e, SecondaryGameF15Key)) {
            LogUtil.i("isMatchKey SecondaryGameF15Key..");
            if (e.getAction() == InputConstants.PRESS) {
                KeyboardUtil.pressKey(KEY_F15, false);
            } else if (e.getAction() == InputConstants.RELEASE) {
                KeyboardUtil.releaseKey(KEY_F15, false);
            }
            return true;

        } else if (isMatchKey(e, SecondaryGameF16Key)) {
            LogUtil.i("isMatchKey SecondaryGameF16Key..");
            if (e.getAction() == InputConstants.PRESS) {
                KeyboardUtil.pressKey(KEY_F16, false);
            } else if (e.getAction() == InputConstants.RELEASE) {
                KeyboardUtil.releaseKey(KEY_F16, false);
            }
            return true;

        } else if (isMatchKey(e, SecondaryGameF17Key)) {
            LogUtil.i("isMatchKey SecondaryGameF17Key..");
            if (e.getAction() == InputConstants.PRESS) {
                KeyboardUtil.pressKey(KEY_F17, false);
            } else if (e.getAction() == InputConstants.RELEASE) {
                KeyboardUtil.releaseKey(KEY_F17, false);
            }
            return true;

        } else if (isMatchKey(e, SecondaryGameF18Key)) {
            LogUtil.i("isMatchKey SecondaryGameF18Key..");
            if (e.getAction() == InputConstants.PRESS) {
                KeyboardUtil.pressKey(KEY_F18, false);
            } else if (e.getAction() == InputConstants.RELEASE) {
                KeyboardUtil.releaseKey(KEY_F18, false);
            }
            return true;
        }
        return false;
    }
}
