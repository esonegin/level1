import java.util.ArrayList;
import java.util.*;

public class Level1 {
//23.06 v2
    public static String BigMinus(String s1, String s2) {
        String result = "";
        ArrayList<Integer> resultlist = new ArrayList<Integer>();
        Long pervoechislo = Long.valueOf(s1);
        Long vtoroechislo = Long.valueOf(s2);

        //Первое число равно второму
        if (pervoechislo.equals(vtoroechislo)){
            result = "0";
        }
        //Первое число больше второго
        else if (pervoechislo > vtoroechislo) {
            resultlist = vichitaniePosimvolnoPolozhitelno(s1, s2);
        } else if (pervoechislo < vtoroechislo) {
            resultlist = vichitaniePosimvolnoPolozhitelno(s2, s1);
        }

        //Наполняем строку результат символами из списка
        for (int k = 0; k < resultlist.size(); k++) {
            result += resultlist.get(k);

        }
        return result;
    }

    public static ArrayList<Integer> vichitaniePosimvolnoPolozhitelno(String s1, String s2) {
        ArrayList<Integer> first = poluchaemSpisok(s1, s2, 1);
        ArrayList<Integer> second = poluchaemSpisok(s1, s2, 2);
        ArrayList<Integer> third = new ArrayList<Integer>();
        //Вычитаем посимвольно
        for (int i = 0; i < first.size(); i++) {
            //Если символ из первого числа больше или равен символу из второго числа
            if (first.get(first.size() - 1 - i) >= second.get(second.size() - 1 - i)) {
                third.add(0, first.get(first.size() - 1 - i) - second.get(second.size() - 1 - i));
                continue;
            }
            //Если символ из первого числа меньше чем символ из второго числа и первое число "длиннее" чем второе
            else if (first.get(first.size() - 1 - i) < second.get(second.size() - 1 - i) && s1.length() > s2.length()) {
                third.add(0, (first.get(first.size() - 1 - i) + 10) - second.get(second.size() - 1 - i));
                first.set(first.size() - 2 - i, first.get(first.size() - 2 - i) - 1);
                continue;
            }
            //Если чила состоят из одной цифры
            else if (first.size() == 1 && second.size() == 1) {
                third.set(0, first.get(0) - second.get(0));
                continue;
            }
        }
        //Удаляем артефактный ноль
        if (third.get(0) == 0 && third.size() > 1) {
            third.remove(0);
        }
        return third;
    }

    public static ArrayList<Integer> poluchaemSpisok(String first, String second, int listnumber) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        String[] firstarray = first.split("");
        String[] secondarray = second.split("");

        //Создаем списки из строк
        ArrayList<Integer> firstlist = new ArrayList<Integer>();
        for (int i = 0; i < firstarray.length; i++) {
            firstlist.add(Integer.parseInt(firstarray[i]));
        }
        ArrayList<Integer> secondlist = new ArrayList<Integer>();
        for (int i = 0; i < secondarray.length; i++) {
            secondlist.add(Integer.parseInt(secondarray[i]));
        }

        //Добавляем нули в начало короткого списка
        if (secondlist.size() > firstlist.size()) {
            for (int i = 0; i < secondlist.size() - firstlist.size(); i++) {
                firstlist.add(0, 0);
            }
        } else if (secondlist.size() < firstlist.size()) {
            for (int i = 0; i < firstlist.size(); i++) {
                secondlist.add(0, 0);
            }
        }
        if (listnumber == 1) {
            result = firstlist;
        } else if (listnumber == 2) {
            result = secondlist;
        }
        return result;
    }
}
