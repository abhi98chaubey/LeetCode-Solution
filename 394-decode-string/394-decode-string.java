class Solution {
     public String decodeString(String s) {
        StringBuilder mainsb = new StringBuilder(s);

        Stack<Integer> repeats = new Stack<>();
        Stack<Integer> indx = new Stack<>();

        int r = 0, num = 0;

        while(r < mainsb.length()){
            char c = mainsb.charAt(r);
            if(Character.isDigit(c)){
                num = num * 10 + c - '0';
                mainsb.deleteCharAt(r--);
            }else if(c == '['){
                indx.push(r);
                repeats.push(num);
                num = 0;
            }else if(c == ']'){
                int l = indx.pop();
                int repeat = repeats.pop();

                StringBuilder sb = new StringBuilder((r - l + 1) * repeat);
                String seg = mainsb.substring(l + 1, r);

                while(repeat-- > 0) sb.append(seg);
                mainsb = mainsb.replace(l, r + 1, sb.toString());
                r = l;
            }

            r++;
        }

        return mainsb.toString();
    }
}