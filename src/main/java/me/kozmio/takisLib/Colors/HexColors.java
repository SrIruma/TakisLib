package me.kozmio.takisLib.Colors;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.md_5.bungee.api.ChatColor;

public class HexColors {

    public static String applyHex(String msg) {
        Matcher match = Colorize.getInstance().HEX_PATTERN.matcher(msg);
        while (match.find()) {
            String color = match.group(1);
            msg = msg.replace("&#" + color, String.valueOf(ChatColor.of("#" + color)));
            match = Colorize.getInstance().HEX_PATTERN.matcher(msg);
        }
        return msg;
    }
}
