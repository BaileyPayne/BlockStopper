
package me.baileypayne.blockstopper;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

/**
 *
 * @author Bailey
 */
class SaplingListener implements Listener {
    
    private BlockStopper plugin;

    public SaplingListener(BlockStopper aThis) {
        this.plugin = plugin;
    }
    @EventHandler
public void onLogBreak(BlockBreakEvent event) {
final Player player = event.getPlayer();
final Block block = event.getBlock();
final byte id = block.getData();
if( "true".equals(plugin.getConfig().getString("SaplingReplant"))){
if (block.getType() == Material.LOG
&& block.getRelative(BlockFace.DOWN).getType() == Material.DIRT) {
final Location loc = block.getLocation();
int task = plugin.getServer().getScheduler()
.scheduleSyncDelayedTask(plugin, new Runnable() {
public void run() {
player.getWorld()
.getBlockAt(loc)
.setTypeIdAndData(Material.SAPLING.getId(),
id, true);
}
}, 10L);
}
}
    }
    @EventHandler
    public void onBlockBreakEvent(BlockBreakEvent event){
        Player player = event.getPlayer();
                        Block block = event.getBlock();
                        if("true".equals(plugin.getConfig().getString("SaplingBreak"))){
 
                        if (block.getType() == Material.SAPLING) {
                            event.setCancelled(true);
        
    }
    }
    
}
}
