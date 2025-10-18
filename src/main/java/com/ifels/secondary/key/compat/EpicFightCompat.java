package com.ifels.secondary.key.compat;

import com.ifels.secondary.key.client.Keybinding;
import com.ifels.secondary.key.util.LogUtil;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import yesman.epicfight.api.forgeevent.ChangePlayerModeEvent;
import yesman.epicfight.client.world.capabilites.entitypatch.player.LocalPlayerPatch;
import yesman.epicfight.world.capabilities.EpicFightCapabilities;
import yesman.epicfight.world.capabilities.entitypatch.player.PlayerPatch;
import yesman.epicfight.world.capabilities.entitypatch.player.PlayerPatch.PlayerMode;

public class EpicFightCompat {
    public EpicFightCompat() {
        boolean battleMode = isBattleMode();
        switchMiningKeyBinding(battleMode);
    }

    @SubscribeEvent(
            priority = EventPriority.LOWEST
    )
    public void onPlayerModeChange(ChangePlayerModeEvent event) {
        if (event.isCanceled()) {
            return;
        }
        Player player = (Player) event.getPlayerPatch().getOriginal();
        if (player == null || !player.level().isClientSide) {
            return;
        }

        PlayerPatch.PlayerMode newMode = event.getPlayerMode();
        if (newMode == PlayerMode.BATTLE) {
            LogUtil.i("Player {} switched to BATTLE mode!", new Object[]{player.getName().getString()});
            switchMiningKeyBinding(true);
        } else if (newMode == PlayerMode.MINING) {
            LogUtil.i("Player {} switched to MINING mode!", new Object[]{player.getName().getString()});
            switchMiningKeyBinding(false);
        }

        KeyMapping.resetMapping();
    }

    public static boolean isBattleMode() {
        LocalPlayer localPlayer = Minecraft.getInstance().player;
        if (localPlayer == null) {
            return false;
        } else {
            LocalPlayerPatch localPlayerPatch = (LocalPlayerPatch) EpicFightCapabilities.getEntityPatch(localPlayer, LocalPlayerPatch.class);
            return localPlayerPatch != null && localPlayerPatch.isBattleMode();
        }
    }

    public static void switchMiningKeyBinding(boolean battleMode) {
        Minecraft mc = Minecraft.getInstance();
        LogUtil.i("switchMiningAttackKeyBinding isBattleMode {}", new Object[]{battleMode});
        KeyMapping kepMapping = battleMode ? Keybinding.SecondaryEpicFightBattleMineKey : Keybinding.SecondaryEpicFightMineMineKey;
        mc.options.keyAttack.setKeyModifierAndCode(kepMapping.getKeyModifier(), kepMapping.getKey());
    }
}
