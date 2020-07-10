import java.util.ArrayList;
import java.util.Arrays;


public class Level1 {

    public static String[] ShopOLAP(int N, String[] items) {
        return convertListToFinalArray(udalenieDubley(poluchenieLista(items)));
    }

    public static ArrayList<String> udalenieDubley(ArrayList<String> resultlist) {
        for (int i = 0; i < resultlist.size() - 3; i++) {
            if (resultlist.get(i).equals(resultlist.get(i + 2))) {
                resultlist.set(i + 3, String.valueOf(Integer.parseInt(resultlist.get(i + 3)) + Integer.parseInt(resultlist.get(i + 1))));
                resultlist.remove(i);
                resultlist.remove(i);
            }
        }
        return resultlist;
    }

    public static String[] convertListToFinalArray(ArrayList<String> resultlist) {
        ArrayList<String> resultlistf = new ArrayList<>();
        for (int i = 0; i < resultlist.size() - 1; i += 2) {
            resultlistf.add(resultlist.get(i) + " " + resultlist.get(i + 1));
        }
        String[] myArray = resultlistf.toArray(new String[0]);
        return myArray;
    }

    public static ArrayList<String> poluchenieLista(String[] result) {
        Arrays.sort(result);
        ArrayList<String> first = new ArrayList<>();
        for (int i = 0; i < result.length; i++) {
            first.add(result[i].split(" ")[0]);
            first.add(result[i].split(" ")[1]);
        }
        return first;
    }
}
