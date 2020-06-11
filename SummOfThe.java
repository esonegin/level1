import java.util.*;
import java.util.ArrayList;


public class Level1 {
    
    public static int SumOfThe(int N, int [] data) {

        int result = 0;
        if (data.length > 2 || (data.length == 2 && data[0] != 0 && data[1] != 0)) {
            result = SravnenieElementaSSummoy(N, data);
        }
        else{
            result = SummTwoWithNull(N, data);
        }
            return result;
    }

    public static int SummTwoWithNull(int N, int[] data) {
        int result = 0;
        if (data[0] != 0) {
            result = data[0];
        } else {
            result = data[1];
        }

        return result;
    }

    public static int SravnenieElementaSSummoy(int N, int[] data) {
        int result = 0;

        //Проходим по массиву сравнивая каждый элемент с суммой оставшихся
        for (int i = 0; i < data.length; i++) {
            if (SumWithoutIndex(i, data) == true) {
                result = data[i];
            }
        }
        return result;
    }

    public static boolean SumWithoutIndex(int index, int[] data) {
        boolean result = false;
        //Копируем входящий массив
        int[] dataCopy = Arrays.copyOf(data, data.length);
        //"Удаляем" индекс из копии входящего массива
        dataCopy[index] = 0;
        //Считаем сумму элементов массива
        int sum = 0;
        for (int i = 0; i < dataCopy.length; i++)
            sum += dataCopy[i];

        if (data[index] == sum) {
            result = true;
        }
        return result;
    }
}
