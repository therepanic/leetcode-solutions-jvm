package generateParentheses;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static List<String> generateParenthesis(int n) {
        List<String> parenthesis = new ArrayList<>();
        StringBuilder sb = new StringBuilder("(");

        generate(n - 1, n,sb, parenthesis);

        return parenthesis;
    }

    public static void generate(int openBracket, int closeBracket, StringBuilder brackets, List<String> parenthesis) {
        if (openBracket == 0 && closeBracket == 0) {
            parenthesis.add(brackets.toString());
            return;
        }

        if (openBracket != 0) {
            brackets.append("(");
            generate(openBracket - 1, closeBracket, brackets, parenthesis);
            brackets.deleteCharAt(brackets.length() - 1);
        }

        if (closeBracket != 0 && openBracket < closeBracket) {
            brackets.append(")");
            generate(openBracket, closeBracket - 1, brackets, parenthesis);
            brackets.deleteCharAt(brackets.length() - 1);
        }
    }
}
