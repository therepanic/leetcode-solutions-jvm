package hTMLEntityParser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HTMLEntityParser {
    public String entityParser(String text) {
        Pattern p = Pattern.compile("&quot;|&apos;|&amp;|&gt;|&lt;|&frasl;");
        Matcher matcher = p.matcher(text);
        return matcher.replaceAll(match -> {
            return switch (match.group()) {
                case "&quot;" -> "\"";
                case "&apos;" -> "'";
                case "&amp;" -> "&";
                case "&gt;" -> ">";
                case "&lt;" -> "<";
                case "&frasl;" -> "/";
                default -> matcher.group();
            };
        });
    }
}
