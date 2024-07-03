package org.dnamaster10.nooplightblock;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.data.Levelled;
import org.bukkit.block.data.type.Light;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import static org.dnamaster10.nooplightblock.NoOpLightBlock.getPlugin;

public class BlockClickEvent implements Listener {
    @EventHandler(ignoreCancelled = true)
    void onPlayerInteract(PlayerInteractEvent event) {
        if (event.getAction() != Action.RIGHT_CLICK_BLOCK) return;
        Block block = event.getClickedBlock();
        if (block == null) return;
        BlockState state = block.getState();
        if (state.getType() != Material.LIGHT) return;
        if (getPlugin().getConfig().getBoolean("UsePermissionManager")) {
            if (!event.getPlayer().hasPermission("nooplightblock.changelightlevel")) return;
        }

        Light light = (Light) block.getBlockData();
        int level = light.getLevel();
        int maxLevel = light.getMaximumLevel();
        int newLevel;
        if (level == maxLevel) newLevel = 0;
        else newLevel = level + 1;

        light.setLevel(newLevel);
        block.setBlockData(light);
    }
}
