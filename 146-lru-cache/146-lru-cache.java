class Node{
    Node prev;
    Node next;
    int val;
    Node(int val_a){
        val=val_a;
    }
}

class LRUCache {
    int cap;
    int size;
    Node start;
    Node end;
    HashMap<Integer,Integer>map1 = new HashMap<>();
    HashMap<Integer,Node>map2 = new HashMap<>();
	
    public LRUCache(int capacity) {
        cap = capacity;
        size=0;
        start=null;end=null;
    }
    
    public int get(int key) {
	// if value is contained in cache
        if(map1.containsKey(key))
        {
            // getting a value will update the LRU list
			  // take the node out of LRU list and append it at last
            Node node = map2.get(key);
            // if the node is the last node, just return
            if(node==end)
            {
                // this.print();
                return map1.get(key) ;
             }
            // if node is start node, take the start node and put it in the end
            if(node==start)
            {
                start=start.next;
                start.prev.next=null;
                start.prev=null;
            }
            else
            {
                node.prev.next=node.next;
                node.next.prev = node.prev;
            }
            // move end pointer forward
            end.next=node;
            node.prev=end;
            end=end.next;
            return map1.get(key);
        }
		else return -1;
    }
    public void put(int key, int value) {
        
        if(!map1.containsKey(key))
        {
            // check if there is space left in cache
            if(size>=cap)
            {
			// remove the LRU node ie the start node
			// remove form map1 and map2
                int lruK = start.val;
				map1.remove(lruK);
                map2.remove(lruK);
				// remove from LRU list
                start = start.next;
                if(start!=null)
                start.prev=null;
                size--;
                
            }
            // put key value pair in map1
            map1.put(key,value);
            // create new Node
            Node node = new Node(key);
			// put key node pair in map2
            map2.put(key,node);
            // if it is a first put operation
            if(start==null)
            {
                // set the start and end node
                start=node;
                end=node;
                size++;
                return;
            }
            // append the node at the end of the list, to mark it as most recently used.
            end.next=node;
            node.prev=end;
            end = end.next;
            size++;
        }
		// else updating value of already added key
        else
        {
            map1.put(key,value);
            // update the LRU list order
            this.get(key);
        }
       
    }
}