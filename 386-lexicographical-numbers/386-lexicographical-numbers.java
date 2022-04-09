class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> bag= new ArrayList<>();
        for(int i=1;i<10;i++){
            dsf(i, n, bag);
        }
        return bag;
    }
    public void dsf(int i, int n, List<Integer> bag){
        if(i>n) return;
        bag.add(i);
        for(int j=0;j<10;j++){
            dsf(i*10+j,n,bag);
        }
    }
}