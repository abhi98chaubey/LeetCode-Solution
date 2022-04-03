class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        Map<String,List<Integer>> dp = new HashMap<>();
        List<Integer> ret = dfs(expression, 0, expression.length()-1,dp); //2*3
        return ret;
    }
    
    public List<Integer> dfs(String expression, int i, int j, Map<String,List<Integer>> dp){
        try{
            int val = Integer.parseInt(expression.substring(i,j+1));
            return Arrays.asList(val);
        }catch(Exception e){
            //its not a number
        }
        
        if(dp.containsKey(i+"-"+j)){
            return dp.get(i+"-"+j);
        }
        List<Integer> total = new ArrayList<>();
        int k = i+1;
        while(k<j){
            while(Character.isDigit(expression.charAt(k))){
                k++;
            }
            List<Integer> left = dfs(expression, i,k-1,dp);//0,0 2
            List<Integer> right = dfs(expression, k+1,j,dp);//2,2 3
            for(Integer m:left){
                for(Integer n:right){
                    if(expression.charAt(k)=='*'){
                        total.add(m*n);   //6
                    }else if(expression.charAt(k)=='-'){
                        total.add(m-n);   
                    }else if(expression.charAt(k)=='+'){
                        total.add(m+n);   
                    }
                }
            }
            k+=2;
        }
        
        dp.put(i+"-"+j,total);
        return total;        
    }
}