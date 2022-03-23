class Solution {
    public int addDigits(int num) {
     
        while (num > 9) {
            num = addDigitsCalc(num);
        }

         return num;
    }

    public int addDigitsCalc(int num) {
        int sum = 0;
        while (num > 0) {
            sum = sum + num % 10;
            num = num / 10;
        }

        return sum;
    }
}