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

    public static final String KEY_SECONDARY_GAME_F13 = "key.secondary.game.F13";
    public static final String KEY_SECONDARY_GAME_F14 = "key.secondary.game.F14";
    public static final String KEY_SECONDARY_GAME_F15 = "key.secondary.game.F15";
    public static final String KEY_SECONDARY_GAME_F16 = "key.secondary.game.F16";
    public static final String KEY_SECONDARY_GAME_F17 = "key.secondary.game.F17";
    public static final String KEY_SECONDARY_GAME_F18 = "key.secondary.game.F18";
    public static final String KEY_SECONDARY_GAME_F19 = "key.secondary.game.F19";
    public static final String KEY_SECONDARY_GAME_F20 = "key.secondary.game.F20";
    public static final String KEY_SECONDARY_GAME_F21 = "key.secondary.game.F21";
    public static final String KEY_SECONDARY_GAME_F22 = "key.secondary.game.F22";
    public static final String KEY_SECONDARY_GAME_F23 = "key.secondary.game.F23";
    public static final String KEY_SECONDARY_GAME_F24 = "key.secondary.game.F24";

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
