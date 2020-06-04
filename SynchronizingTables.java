import java.util.*;
import java.util.Arrays;


public class Level1 {
        public static int [] SynchronizingTables(int N, int [] ids, int [] salary) {
            int[] result = new int[N];
            for (int j = 0; j < N; j++) {
                result[j] = (int) sortMap(ids, salary).get(ids[j]);
            }
            System.out.println(Arrays.toString(result));
            return result;
        }


        public static HashMap sortMap(int[] ids, int[] salary) {
            int[] dublids = Arrays.copyOf(ids, ids.length);
            int[] dublsalary = Arrays.copyOf(salary, salary.length);
            Arrays.sort(dublids);
            Arrays.sort(dublsalary);
            HashMap<Integer, Integer> sortcoll = new HashMap<>();
            for (int i = 0; i < ids.length; i++) {
                sortcoll.put(dublids[i], dublsalary[i]);
            }
            return sortcoll;
        }
    }
