import java.util.*;


public class Level1 {
        public static int [] WordSearch(int len, String s, String subs) {
            int[] result = new int[0];
            String razbienie = Razbienie(s, len);
            String[] podstroki = razbienie.split(System.lineSeparator());
            result = SearchInArray(podstroki, subs);
            return result;
        }

        //Считаем количество вхождений искомой строки в массив
        public static int[] SearchInArray(String[] podstroki, String subs) {

            int[] result = new int[podstroki.length];
            for (int i = 0; i < podstroki.length; i++) {
                if (podstroki[i].contains(" " + subs + " ")
                        || podstroki[i].contains("\n" + subs + "\n")
                        || podstroki[i].contains(subs + " ")
                        || podstroki[i].contains(" " + subs + "\n")
                        || podstroki[i].contains(subs + "\n")) {
                    result[i] = 1;
                } else {
                    result[i] = 0;
                }
            }

            return result;
        }


        //Разбиваем строку по ширине
        public static String Razbienie(String s, int len) {
            Pattern p = Pattern.compile("\\s*(?:(\\w{10,})|(.{1,12})(?!\\w))\\s*", Pattern.UNICODE_CHARACTER_CLASS);
            return (p.matcher(s).replaceAll("$1$2\n"));
        }
    }
