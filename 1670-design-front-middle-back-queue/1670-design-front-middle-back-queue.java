class FrontMiddleBackQueue {
    List<Integer>list;
    public FrontMiddleBackQueue() {
        list=new ArrayList<>();
    }
    
    public void pushFront(int val) {
        list.add(0,val);
    }
    
    public void pushMiddle(int val) {
        list.add(list.size()/2,val);
    }
    
    public void pushBack(int val) {
        list.add(val);
    }
    
    public int popFront() {
        if (list.size()==0){return -1;}
        int x=list.remove(0);
        return x;
    }
    
    public int popMiddle() {
        int x;
        if (list.size()==0){return -1;}
        if (list.size()%2==0){
            x=list.remove(list.size()/2-1);
        }
        else
        {
            x=list.remove(list.size()/2);
        }
        return x;
    }
    
    public int popBack() {
        if (list.size()==0){return -1;}
        int x=list.remove(list.size()-1);
        return x;
    }
}