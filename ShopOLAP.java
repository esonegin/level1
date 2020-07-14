import java.util.*;
import java.util.stream.Stream;

class Level1 {
//v2
    public static String[] ShopOLAP(int N, String[] items) {
        String[] resultf = convertListToFinalArray(udalenieDubley(poluchenieLista(items)));
        ArrayList<String> result = (udalenieDubley(RazbienieItemAndValue(items)));
        HashMap<String, Integer> map = new HashMap<>();
        String[] resultfinal = new String[result.size()/2];
        for (int i = 0; i < result.size(); i += 2) {
            map.put(result.get(i), Integer.parseInt(result.get(i + 1)));
        }

        if (hasDuplicates(map)) {

            for (int i = 0; i < resultf.length; i++) {
                resultfinal[i] = resultf[i];
            }
        }
        else if (!hasDuplicates(map)) {
            for (int i = 0; i < finalSort(items).length; i++) {
                resultfinal[i] = finalSort(items)[i];
            }
        }
        return resultfinal;
    }

    private static boolean hasDuplicates(Map<String, Integer> datamap) {
        boolean status = false;
        Set valueset = new HashSet(datamap.values());

        if (datamap.values().size() != valueset.size()) {
            status = true;
        } else {
            status = false;
        }
        return status;
    }

    public static String[] finalSort(String[] items) {
        ArrayList<String> result = (udalenieDubley(RazbienieItemAndValue(items)));
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < result.size(); i += 2) {
            map.put(result.get(i), Integer.parseInt(result.get(i + 1)));
        }
        map = (HashMap<String, Integer>) sortByValue(map);
        String[] resultarray = new String[map.size()];
        int i = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            resultarray[resultarray.length - 1 - i] = (entry.getKey() + " " + entry.getValue());
            i++;
        }
        return resultarray;
    }

    public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
        Map<K, V> result = new LinkedHashMap<>();
        Stream<Map.Entry<K, V>> st = map.entrySet().stream();
        st.sorted(Comparator.comparing(e -> e.getValue())).forEach(e -> result.put(e.getKey(), e.getValue()));
        return result;
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

    public static ArrayList<String> RazbienieItemAndValue(String[] result) {
        Arrays.parallelSort(result);
        ArrayList<String> first = new ArrayList<>();
        for (int i = 0; i < result.length; i++) {
            first.add(result[i].split(" ")[0]);
            first.add(result[i].split(" ")[1]);
        }
        return first;
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
