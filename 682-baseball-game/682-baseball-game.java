class Solution {
    public int calPoints(String[] ops) {
    List<Integer> res=new ArrayList<>();
        for(String c:ops){
            if(c.equals("+"))res.add(res.get(res.size()-1)+res.get(res.size()-2));
            else if(c.equals("D"))res.add(res.get(res.size()-1)*2);
            else if(c.equals("C"))res.remove(res.size()-1);
            else res.add(Integer.parseInt(c));
        }
        int count=0;
        for(int i: res)
            count+=i;

        return count;
}
}