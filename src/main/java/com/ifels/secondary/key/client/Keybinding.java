package com.ifels.secondary.key.client;

import com.mojang.blaze3d.platform.InputConstants.Type;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.client.settings.KeyModifier;
import org.lwjgl.glfw.GLFW;

public class Keybinding {
    public static final String KEY_CATEGORY_SECONDARY = "key.categories.secondary.bind";

    public static final String KEY_SECONDARY_GAME_B = "key.secondary.game.b";
    public static final String KEY_SECONDARY_GAME_A = "key.secondary.game.a";
    public static final String KEY_SECONDARY_GAME_W = "key.secondary.game.w";
    public static final String KEY_SECONDARY_GAME_S = "key.secondary.game.s";
    public static final String KEY_SECONDARY_GAME_D = "key.secondary.game.d";

    public static final String KEY_SECONDARY_GAME_F10 = "key.secondary.game.F10";
    public static final String KEY_SECONDARY_GAME_F12 = "key.secondary.game.F12";
    public static final String KEY_SECONDARY_GAME_ENTER = "key.secondary.game.enter";
    public static final String KEY_SECONDARY_GAME_TAB = "key.secondary.game.tab";
    public static final String KEY_SECONDARY_GAME_CAPSLOCK = "key.secondary.game.capslock";
    public static final String KEY_SECONDARY_GAME_BACKSPACE = "key.secondary.game.backspace";
    public static final String KEY_SECONDARY_GAME_DELETE = "key.secondary.game.delete";
    public static final String KEY_SECONDARY_GAME_INSERT = "key.secondary.game.insert";

    public static final String KEY_SECONDARY_GUI_ESC = "key.secondary.gui.esc";
    public static final String KEY_SECONDARY_GUI_M_LEFT = "key.secondary.gui.mouse.left";
    public static final String KEY_SECONDARY_GUI_M_RIGHT = "key.secondary.gui.mouse.right";
    public static final String KEY_SECONDARY_GUI_R = "key.secondary.gui.r";
    public static final String KEY_SECONDARY_GUI_U = "key.secondary.gui.u";
    public static final String KEY_SECONDARY_EPIC_FIGHT_MINE_MINE_KEY = "compact.epicfight.mine.mineKey";
    public static final String KEY_SECONDARY_EPIC_FIGHT_BATTLE_MINE_KEY = "compact.epicfight.battle.mineKey";

    public static final KeyMapping SecondaryGuiEscKey = new KeyMapping(
            KEY_SECONDARY_GUI_ESC,
            KeyConflictContext.UNIVERSAL,
            Type.KEYSYM,
            GLFW.GLFW_KEY_F7,
            KEY_CATEGORY_SECONDARY
    );

    public static final KeyMapping SecondaryGuiMouseLeftKey = new KeyMapping(
            KEY_SECONDARY_GUI_M_LEFT,
            KeyConflictContext.UNIVERSAL,
            Type.KEYSYM,
            GLFW.GLFW_KEY_F6,
            KEY_CATEGORY_SECONDARY
    );

    public static final KeyMapping SecondaryGuiMouseRightKey = new KeyMapping(
            KEY_SECONDARY_GUI_M_RIGHT,
            KeyConflictContext.UNIVERSAL,
            Type.KEYSYM,
            GLFW.GLFW_KEY_F8,
            KEY_CATEGORY_SECONDARY
    );


    public static final KeyMapping SecondaryGuiRKey = new KeyMapping(
            KEY_SECONDARY_GUI_R,
            KeyConflictContext.GUI,
            Type.KEYSYM,
            GLFW.GLFW_KEY_HOME,
            KEY_CATEGORY_SECONDARY
    );

    public static final KeyMapping SecondaryGuiUKey = new KeyMapping(
            KEY_SECONDARY_GUI_U,
            KeyConflictContext.GUI,
            Type.KEYSYM,
            GLFW.GLFW_KEY_END,
            KEY_CATEGORY_SECONDARY
    );



}
