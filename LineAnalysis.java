import java.util.*;

public class Level1 {
    
    public static boolean LineAnalysis(String line) {
        boolean result = true;
        char first = line.charAt(0);
        char posledniy = line.charAt(line.length() - 1);
        if (first != '*' || posledniy != '*') {
            result = false;
        } else {
            String[] myArray = line.split("\\*");
            for (int i = 2; i < myArray.length; i++) {
                if (myArray[i].equals(myArray[1])) {
                    result = true;
                } else {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }
}
