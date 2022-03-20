class Solution {
    public int minimumSum(int num) {
        
        // convert number to int array
       String temp = Integer.toString(num);
       int[] dig= new int[temp.length()];
       for (int i = 0; i < temp.length(); i++)
         dig[i] = temp.charAt(i) - '0';
        
        Arrays.sort(dig);
        int num1 = dig[0]*10+dig[2]; // 1st and 3rd digit
        int num2 = dig[1]*10+dig[3]; // 2nd and 4th digit
        return num1 + num2;

        
    }
}