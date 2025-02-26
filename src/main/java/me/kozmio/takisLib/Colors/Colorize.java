package me.kozmio.takisLib.Colors;

import java.util.regex.Pattern;

public class Colorize {
    private static final Colorize instance = new Colorize();
    public static Colorize getInstance() {
        return instance;
    }
    private Colorize() {}

    public static final Pattern HEX_PATTERN = Pattern.compile("&#([a-fA-F0-9]{6})");

    public static String applyColors(String msg) {
        msg = HexColors.applyHex(msg);
        msg = Gradients.applyGradient(msg);
        msg = Legacy.translate(msg);
        return msg;
    }
}
