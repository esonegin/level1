public static class Squirell{
        
        public int factnuts(int n) throws Exception{
            if(n < 0){
                throw new Exception();
            }
            
        int result = 1;
		for (int i = 1; i <= n; i ++){
			result = result*i;
		}
		
		return Integer.parseInt(String.valueOf(result).substring(0, 1));
        }
    }
