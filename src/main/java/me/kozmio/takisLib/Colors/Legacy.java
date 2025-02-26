package me.kozmio.takisLib.Colors;

import net.md_5.bungee.api.ChatColor;

public class Legacy {
    public static String translate(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }
}
