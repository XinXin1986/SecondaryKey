//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.ifels.secondary.key.client;

import com.mojang.blaze3d.platform.InputConstants.Type;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.client.settings.KeyModifier;

public class Keybinding {
    public static final String KEY_CATEGORY_SECONDARY = "key.categories.secondary.bind";
    public static final String KEY_SECONDARY_GAME_B = "key.secondary.game.b";
    public static final String KEY_SECONDARY_GUI_ESC = "key.secondary.gui.esc";
    public static final String KEY_SECONDARY_GUI_M_LEFT = "key.secondary.gui.mouse.left";
    public static final String KEY_SECONDARY_GUI_M_RIGHT = "key.secondary.gui.mouse.right";
    public static final String KEY_SECONDARY_GUI_R = "key.secondary.gui.r";
    public static final String KEY_SECONDARY_GUI_U = "key.secondary.gui.u";
    public static final String KEY_SECONDARY_EPIC_FIGHT_BATTLE_MINE_KEY = "compact.epicfight.battle.mineKey";
    public static final String KEY_SECONDARY_EPIC_FIGHT_MINE_MINE_KEY = "compact.epicfight.mine.mineKey";
    public static final KeyMapping SecondaryGameBKey;
    public static final KeyMapping SecondaryGuiEscKey;
    public static final KeyMapping SecondaryGuiMouseLeftKey;
    public static final KeyMapping SecondaryGuiMouseRightKey;
    public static final KeyMapping SecondaryGuiRKey;
    public static final KeyMapping SecondaryGuiUKey;
    public static final KeyMapping SecondaryEpicFightMineMineKey;
    public static final KeyMapping SecondaryEpicFightBattleMineKey;

    static {
        SecondaryGameBKey = new KeyMapping("key.secondary.game.b", KeyConflictContext.IN_GAME, Type.KEYSYM, 266, "key.categories.secondary.bind");
        SecondaryGuiEscKey = new KeyMapping("key.secondary.gui.esc", KeyConflictContext.UNIVERSAL, Type.KEYSYM, 296, "key.categories.secondary.bind");
        SecondaryGuiMouseLeftKey = new KeyMapping("key.secondary.gui.mouse.left", KeyConflictContext.UNIVERSAL, Type.KEYSYM, 295, "key.categories.secondary.bind");
        SecondaryGuiMouseRightKey = new KeyMapping("key.secondary.gui.mouse.right", KeyConflictContext.UNIVERSAL, Type.KEYSYM, 297, "key.categories.secondary.bind");
        SecondaryGuiRKey = new KeyMapping("key.secondary.gui.r", KeyConflictContext.GUI, Type.KEYSYM, 268, "key.categories.secondary.bind");
        SecondaryGuiUKey = new KeyMapping("key.secondary.gui.u", KeyConflictContext.GUI, Type.KEYSYM, 269, "key.categories.secondary.bind");
        SecondaryEpicFightMineMineKey = new KeyMapping("compact.epicfight.mine.mineKey", KeyConflictContext.UNIVERSAL, Type.KEYSYM, 346, "key.categories.secondary.bind");
        SecondaryEpicFightBattleMineKey = new KeyMapping("compact.epicfight.battle.mineKey", KeyConflictContext.UNIVERSAL, KeyModifier.ALT, Type.KEYSYM, 297, "key.categories.secondary.bind");
    }
}
