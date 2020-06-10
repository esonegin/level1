import java.util.*;


public class Level1 {
        public static int [] WordSearch(int len, String s, String subs) {
            int[] result;

            //Разбиваем строку по ширине переносом
            String razbienie = Razbienie(s, len);

            //Создаем массив подстрок по признаку перехода на новую строку
            String[] podstroki = razbienie.split(System.lineSeparator());

            if (s.contains(" ")) {
                result = SearchInArrayWithProbel(podstroki, subs);
            } else {
                result = SearchInArrayWithoutProbel(podstroki, subs);
            }
            return result;
        }

        //Считаем количество вхождений искомой строки в массив для строки с пробелом
        public static int[] SearchInArrayWithProbel(String[] podstroki, String subs) {
            int[] result = new int[podstroki.length];


            for (int i = 0; i < podstroki.length; i++) {
                if (podstroki[i].contains(" " + subs + " ")
                        || podstroki[i].contains(" " + subs + "\n")
                        || podstroki[i].contains("\n" + subs + "\n")
                        || podstroki[i].contains("\n" + subs + " ")
                        || podstroki[i].contains("" + subs + " ")) {
                    result[i] = 1;
                } else result[i] = 0;
            }
            return result;
        }

        //Считаем количество вхождений искомой строки в массив для строки без пробела
        public static int[] SearchInArrayWithoutProbel(String[] podstroki, String subs) {
            int[] result = new int[podstroki.length];


            for (int i = 0; i < podstroki.length; i++) {
                if (podstroki[i].contains(" " + subs + " ")
                        || podstroki[i].contains(" " + subs + "\n")
                        || podstroki[i].contains("\n" + subs + "\n")
                        || podstroki[i].contains("\n" + subs + " ")
                        || podstroki[i].contains(" " + subs + "")
                        || podstroki[i].contains("" + subs + " ")) {
                    result[i] = 1;
                } else result[i] = 0;
            }
            return result;
        }


        //Разбиваем строку по ширине
        public static String Razbienie(String s, int len) {
            Pattern p = Pattern.compile("\\s*(?:(\\w{10,})|(.{1,12})(?!\\w))\\s*", Pattern.UNICODE_CHARACTER_CLASS);
            String first = (p.matcher(s).replaceAll("$1$2\n"));

            String second = (p.matcher(s).replaceAll("$1$2"));
            String finalstring = "";

            if (s.contains(" ")) {
                finalstring = first;

            } else {
                String newStr = second.replaceAll("(.{" + len + "})", "$1|");
                String[] newStrings = newStr.split("\\|");
                for (int j = 0; j < newStrings.length; j++) {
                    finalstring += " " + newStrings[j] + "\n";
                }
            }
            return finalstring;
        }
    }