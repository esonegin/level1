import java.util.Arrays;
import java.util.Collections;

public class Level1 {

    public static int MaximumDiscount(int N, int[] price) {
        int result = 0;
        if (price.length < 3) {
            result = 0;
        } else {
            Integer[] price2 = new Integer[N];
            for (int i = 0; i < N; i++) {
                price2[i] = price[i];
            }
            Arrays.sort(price2, Collections.reverseOrder());
            for (int i = 2; i < price2.length; i += 3) {
                result += price2[i];
            }
        }
        return result;
    }
}
