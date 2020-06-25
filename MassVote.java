import java.math.BigDecimal;
import java.math.RoundingMode;
//25.06

public class Level1 {

    public static String MassVote(int N, int[] Votes) {
        String result = "";
        if (kolvomax(Votes) > 1) {
            result = "no winner";
        } else if (procentkandidata(Votes, indexmax(Votes)) > 50) {
            result = "majority winner " + (indexmax(Votes) + 1);
        } else if (procentkandidata(Votes, indexmax(Votes)) <= 50) {
            result = "minority winner " + (indexmax(Votes) + 1);
        }
        return result;
    }

    public static int kolvomax(int[] Votes) {
        int kolvomax = 0;
        for (
                int i = 0;
                i < Votes.length; i++) {
            if (Votes[i] == maximum(Votes)) {
                kolvomax++;
            }
        }
        return kolvomax;
    }


    public static int maximum(int[] Votes) {
        int max = Votes[0];

        for (int i = 0; i < Votes.length; i++)
            if (max < Votes[i]) {
                max = Votes[i];
            }
        return max;
    }


    public static int indexmax(int[] Votes) {
        int max = Votes[0];
        int indexmax = 0;
        for (int i = 0; i < Votes.length; i++)
            if (max < Votes[i]) {
                max = Votes[i];
                indexmax = i;
            }
        return indexmax;
    }
    
    public static double procentkandidata(int[] Votes, int nomer) {
        double kolvogolosov = Votes[nomer];
        double odinprocent = stoprocentov(Votes) / 100.00;
        double result = kolvogolosov / odinprocent;
        BigDecimal resultf = new BigDecimal(result);
        resultf = resultf.setScale(2, RoundingMode.DOWN);
        return resultf.doubleValue();

    }


    public static int stoprocentov(int[] Votes) {
        int stoprocentov = 0;
        for (int i = 0; i < Votes.length; i++) {
            stoprocentov = stoprocentov + Votes[i];
        }
        return stoprocentov;
    }
}
