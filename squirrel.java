public class Level1{
        public static int factnuts(int n) {
        int result = 1;
		for (int i = 1; i <= n; i ++){
			result = result*i;
		}
		return Integer.parseInt(String.valueOf(result).substring(0, 1));
        }
    }
