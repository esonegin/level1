import java.util.*;

public static int odometer(int [] oksana) {
            int result = 0;
            int i = 0;
            while(i < oksana.length-1){
                if(i == 0){
                    result = result + oksana[i] * oksana[i + 1];
                }
                else {
                    result = result + oksana[i] * (oksana[i + 1] - oksana[i - 1]);
                }
                i+=2;
            }
            return result;
        }
