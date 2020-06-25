import java.util.*;


public class Level1 {
//v2
    public static int[] UFO(int N, int[] data, boolean octal) {
        int[] result = new int[data.length];
        for (int i = 0; i < data.length; i++) {
            result[i] = strokaPoNomeruIndexa(data, i, octal);
        }
        return result;
    }

    public static int strokaPoNomeruIndexa(int[] array, int index, boolean octal) {
        int dlinnaelementa = String.valueOf(array[index]).length();
        int[] result = new int[dlinnaelementa];
        for (int i = 0; i < dlinnaelementa; i++) {
            result[i] = (sixPoIndexu(array, index)[i]);
        }
        int[] secondres = finalint(result, octal);
        String thirdres = "";
        for (int i = 0; i < secondres.length; i++) {
            thirdres += String.valueOf(secondres[i]);
        }
        return Integer.parseInt(thirdres);
    }

    public static int[] sixPoIndexu(int array[], int index) {
        String number = String.valueOf(array[index]);
        String[] first = number.split("");
        int[] resultfirst = new int[first.length];
        for (int i = 0; i < first.length; i++) {
            if (first.length - i > 0) {
                resultfirst[i] = Integer.parseInt(first[first.length - i - 1]);
            } else break;
        }
        return resultfirst;
    }
    
    public static int[] finalint(int[] array, boolean octal) {
        String[] resultstring;

        int resultintpred = 0;
        if (octal) {
            for (int i = 0; i < array.length; i++) {
                resultintpred += (int) (array[i] * Math.pow(8, i));
            }

        } else
            for (int i = 0; i < array.length; i++) {
                resultintpred += (int) (array[i] * Math.pow(16, i));
            }
        resultstring = String.valueOf(resultintpred).split("");
        int[] resultint = new int[resultstring.length];
        for (int i = 0; i < resultstring.length; i++) {
            resultint[i] = Integer.parseInt(resultstring[i]);
        }
        return resultint;
    }
}
