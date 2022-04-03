class Solution {
   public List<List<String>> partition(String s) {
    if(s=="" || s.length() == 0){
        List<String> temp1 = new ArrayList<>();
        List<List<String>> temp2 = new ArrayList<>();
        temp2.add(temp1);
        return temp2;
    }
    
    List<String> curList = new ArrayList<String>(); 
    List<List<String>> restfinalList = new ArrayList<>();
    List<List<String>> finalList = new ArrayList<>();
    
    if(s.length()==1){
        curList.add(s);
        finalList.add(curList);
    }else{
        for(int i = 0;i<s.length();i++){
            if(IsPalidrome(s,0,i)){
                restfinalList = partition(s.substring(i+1));
                if(restfinalList != null && restfinalList.size() >= 0){
                     for(List<String> tempList : restfinalList){
                         if(tempList != null && tempList.size() > 0){
                             curList = new ArrayList<>(tempList);
                         }else{
                             curList = new ArrayList<>();
                         }
                             curList.add(0,s.substring(0,i+1));
                             finalList.add(curList);
                     }
                }
            }
        }
    }
    
    
    
    return finalList;
    
}


public boolean IsPalidrome(String s, int startIndex, int endIndex){
    while(startIndex<endIndex){
        if(s.charAt(startIndex) != s.charAt(endIndex)){
            return false;
        }
            startIndex++;
            endIndex--;
    }
    return true;
}
}