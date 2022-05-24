class MyCircularDeque {

    LinkedList<Integer> start;
    LinkedList<Integer> end;
    int k;
    
    public MyCircularDeque(int k) {
        start = new LinkedList<>();
        end = new LinkedList<>();
        this.k = k;
    }
    
    public boolean insertFront(int value) {
        if(start.size() + end.size() == k) 
            return false;
        start.add(value);
        return true;
    }
    
    public boolean insertLast(int value) {
        if(start.size() + end.size() == k) 
            return false;
        end.addLast(value);
        return true;
    }
    
    public boolean deleteFront() {
        if(start.size() == 0 && end.size() == 0) return false;
        if(start.size() > 0) start.removeLast();
        else if(end.size() > 0) end.removeFirst();
        return true;
    }
    
    public boolean deleteLast() {
        if(start.size() == 0 && end.size() == 0) return false;
        if(end.size() > 0) end.removeLast();
        else if(start.size() > 0) start.removeFirst();
        return true;
    }
    
    public int getFront() {
        if(start.size() == 0 && end.size() == 0) return -1;
        if(start.size() > 0) return start.peekLast();
        else return end.peekFirst();
    }
    
    public int getRear() {
        if(start.size() == 0 && end.size() == 0) return -1;
        if(end.size() > 0) return end.peekLast();
        else return start.peekFirst();
    }
    
    public boolean isEmpty() {
        if(start.size() == 0 && end.size() == 0) return true;
        return false;
    }
    
    public boolean isFull() {
        if(start.size() + end.size() == k) return true;
        return false;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */