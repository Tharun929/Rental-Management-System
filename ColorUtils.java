public class ColorUtils {
    // ANSI escape codes for colors
    public static final String RESET = "\u001B[0m";

    // Regular colors
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String MAGENTA = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";

    // Bright colors
    public static final String BRIGHT_RED = "\u001B[91m";
    public static final String BRIGHT_GREEN = "\u001B[92m";
    public static final String BRIGHT_YELLOW = "\u001B[93m";
    public static final String BRIGHT_BLUE = "\u001B[94m";
    public static final String BRIGHT_MAGENTA = "\u001B[95m";
    public static final String BRIGHT_CYAN = "\u001B[96m";
    public static final String BRIGHT_WHITE = "\u001B[97m";

    // Background colors
    public static final String BG_RED = "\u001B[41m";
    public static final String BG_GREEN = "\u001B[42m";
    public static final String BG_YELLOW = "\u001B[43m";
    public static final String BG_BLUE = "\u001B[44m";
    public static final String BG_MAGENTA = "\u001B[45m";
    public static final String BG_CYAN = "\u001B[46m";

    // Text styles
    public static final String BOLD = "\u001B[1m";
    public static final String UNDERLINE = "\u001B[4m";

    // Utility methods
    public static String colorize(String text, String color) {
        return color + text + RESET;
    }

    public static String success(String text) {
        return BRIGHT_GREEN + text + RESET;
    }

    public static String error(String text) {
        return BRIGHT_RED + text + RESET;
    }

    public static String warning(String text) {
        return BRIGHT_YELLOW + text + RESET;
    }

    public static String info(String text) {
        return BRIGHT_BLUE + text + RESET;
    }

    public static String header(String text) {
        return BRIGHT_CYAN + BOLD + text + RESET;
    }

    public static String highlight(String text) {
        return BRIGHT_MAGENTA + text + RESET;
    }
}