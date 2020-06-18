import java.util.*;
import java.util.HashMap;

public class Level1 {

    public static int PrintingCosts(String Line) {
        return podshet(Line);
    }

    public static int podshet(String Line) {
        int result = 0;
        String[] symbols = Line.split("");
        for (int i = 0; i < symbols.length; i++) {
            if (Instrukcia().containsKey(symbols[i])) {
                result = result + PoluchenieNomera(symbols[i]);
            } else {
                result = result + 23;
            }
        }
        return result;
    }

    public static int PoluchenieNomera(String symbol) {
        return (int) Instrukcia().get(symbol);
    }

    public static HashMap Instrukcia() {
        HashMap<String, Integer> instrukcia = new HashMap<>();
        instrukcia.put(" ", 0);
        instrukcia.put("&", 24);
        instrukcia.put(",", 7);
        instrukcia.put("2", 22);
        instrukcia.put("8", 23);
        instrukcia.put(">", 10);
        instrukcia.put("D", 26);
        instrukcia.put("J", 18);
        instrukcia.put("P", 23);
        instrukcia.put("V", 19);
        instrukcia.put("\\", 10);
        instrukcia.put("b", 25);
        instrukcia.put("h", 21);
        instrukcia.put("n", 18);
        instrukcia.put("t", 17);
        instrukcia.put("z", 19);
        instrukcia.put("!", 9);
        instrukcia.put("'", 3);
        instrukcia.put("-", 7);
        instrukcia.put("3", 23);
        instrukcia.put("9", 26);
        instrukcia.put("?", 15);
        instrukcia.put("E", 26);
        instrukcia.put("K", 21);
        instrukcia.put("Q", 31);
        instrukcia.put("W", 26);
        instrukcia.put("]", 18);
        instrukcia.put("c", 17);
        instrukcia.put("i", 15);
        instrukcia.put("o", 20);
        instrukcia.put("u", 17);
        instrukcia.put("{", 18);
        instrukcia.put("\"", 6);
        instrukcia.put("(", 12);
        instrukcia.put(".", 4);
        instrukcia.put("4", 21);
        instrukcia.put(":", 8);
        instrukcia.put("@", 32);
        instrukcia.put("F", 20);
        instrukcia.put("L", 16);
        instrukcia.put("R", 28);
        instrukcia.put("X", 18);
        instrukcia.put("^", 7);
        instrukcia.put("d", 25);
        instrukcia.put("j", 20);
        instrukcia.put("p", 25);
        instrukcia.put("v", 13);
        instrukcia.put("|", 12);
        instrukcia.put("#", 24);
        instrukcia.put(")", 12);
        instrukcia.put("/", 10);
        instrukcia.put("5", 27);
        instrukcia.put(";", 11);
        instrukcia.put("A", 24);
        instrukcia.put("G", 25);
        instrukcia.put("M", 28);
        instrukcia.put("S", 25);
        instrukcia.put("Y", 14);
        instrukcia.put("_", 8);
        instrukcia.put("e", 23);
        instrukcia.put("k", 21);
        instrukcia.put("q", 25);
        instrukcia.put("w", 19);
        instrukcia.put("}", 18);
        instrukcia.put("$", 29);
        instrukcia.put("*", 17);
        instrukcia.put("0", 22);
        instrukcia.put("6", 26);
        instrukcia.put("<", 10);
        instrukcia.put("B", 29);
        instrukcia.put("H", 25);
        instrukcia.put("N", 25);
        instrukcia.put("T", 16);
        instrukcia.put("Z", 22);
        instrukcia.put("`", 3);
        instrukcia.put("f", 18);
        instrukcia.put("l", 16);
        instrukcia.put("r", 13);
        instrukcia.put("x", 13);
        instrukcia.put("~", 9);
        instrukcia.put("%", 22);
        instrukcia.put("+", 13);
        instrukcia.put("1", 19);
        instrukcia.put("7", 16);
        instrukcia.put("=", 14);
        instrukcia.put("C", 20);
        instrukcia.put("I", 18);
        instrukcia.put("O", 26);
        instrukcia.put("U", 23);
        instrukcia.put("[", 18);
        instrukcia.put("a", 23);
        instrukcia.put("g", 30);
        instrukcia.put("m", 22);
        instrukcia.put("s", 21);
        instrukcia.put("y", 24);
        return instrukcia;
    }
}
