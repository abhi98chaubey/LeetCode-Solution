class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
         int key=0,ans=0;
    switch(ruleKey){
        case "type":
            key = 0;
            break;
        case "color":
            key = 1;
            break;
        case "name":
            key = 2;
            break;
    }
    
    for(List< String> al: items){
        if(al.get(key).equals(ruleValue)){
            ans++;
        }
    }
    return ans;

    }
}