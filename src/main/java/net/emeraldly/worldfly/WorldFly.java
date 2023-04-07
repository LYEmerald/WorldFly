package net.emeraldly.worldfly;

import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerMoveEvent;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.Config;

import java.util.List;

/**
 * @author LYEmerald Copyright (c) 2023
 * @version 1.0.0
 * WorldFly 启动类
 */

public class WorldFly extends PluginBase implements Listener {

    @Override
    public void onEnable(){
        this.getLogger().info("§a欢迎使用WorldFly");
        this.getServer().getPluginManager().registerEvents(this,this);
        this.getDataFolder().mkdirs();
        this.saveDefaultConfig();
        Config config = this.getConfig();
    }

    @EventHandler
    public void onMovePlayer(PlayerMoveEvent event){
        Player player = event.getPlayer();
        String pn = player.getName();
        String level = event.getPlayer().getLevel().getName();
        List<String> list = this.getConfig().getStringList("Worlds");
        boolean debug = this.getConfig().getBoolean("DebugMode");
        if(list.contains(level)){
            player.setAllowFlight(true);
            if(debug == true){
                player.sendMessage("Player:"+pn+" Level:"+level+" Status:True");
            }
        }else {
            player.setAllowFlight(false);
            if(debug == true){
                player.sendMessage("Player:"+pn+" Level:"+level+" Status:False");
            }
        }
    }
}
