package me.kozmio.takisLib.Colors;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.md_5.bungee.api.ChatColor;

public class Gradients {

    public static String applyGradient(String msg) {
        Matcher matcher = Colorize.getInstance().HEX_PATTERN.matcher(msg);
        StringBuilder gradientMsg = new StringBuilder();
        int start = 0;
        while (matcher.find()) {
            String hexColor = matcher.group(1);
            String colorCode = "#" + hexColor;
            gradientMsg.append(msg, start, matcher.start());
            gradientMsg.append(ChatColor.of(colorCode));
            start = matcher.end();
        }
        gradientMsg.append(msg.substring(start));
        return gradientMsg.toString();
    }
}
