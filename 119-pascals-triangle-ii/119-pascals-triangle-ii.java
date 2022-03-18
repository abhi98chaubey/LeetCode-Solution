class Solution {
   public List<Integer> getRow(int r) {
    r++;
    ArrayList<Integer> nm=new ArrayList<>();
    if(r==1)
    {
        nm.add(1);
        return nm;
    }
    if(r==2)
    {
        nm.add(1);
        nm.add(1);
        return nm;
    }
    int i,j;
    nm.add(1);
    nm.add(1);
    for(i=3;i<=r;i++)
    {
        nm.add(0,1);
        int x=nm.size()-1;
        for(j=1;j<x;j++)
        {
            nm.set(j,(nm.get(j)+nm.get(j+1)));
        }
    }
    return nm;  
}
}