class Solution {
    public String destCity(List<List<String>> paths) {
       var arrli1=new ArrayList<String>();
       var arrli2=new ArrayList<String>();
        int a=0;
        for(List<String> list:paths){
            for(String s: list){
                 ++a;
                if(a==1)
                    arrli1.add(s);
                else
                    arrli2.add(s);
            }
            a=0;
        }
        if(arrli1.size()==1)
            return arrli2.get(0);
        String ss="";
        for(int i=0;i<arrli1.size();i++){
         ss=arrli2.get(i);
            if(!arrli1.contains(ss))
                return ss;
        }
        return ss;
    }
}