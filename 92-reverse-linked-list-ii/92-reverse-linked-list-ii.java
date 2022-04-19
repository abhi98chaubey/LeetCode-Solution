/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head==null) return null;   // checking if the LL is empty...
        
        ListNode dum = new ListNode(0);  // create a dummy node pointing to head, because at the end we need to return
        dum.next = head;         //  the head i.e. starting point of the LL
		
        ListNode cur = head;    // nodes needed for reversing LL
        ListNode prev = dum;
		
        ListNode lnode = null;   //   storing the value of  'left-1'  and
        ListNode rnode = null;  
		
		// before starting we have LL  :  dum -> 1 -> 2 -> 3 -> 4 -> 5 -> null
		
        int count=0;
        while(count<right){    // travesing until we reach the right pos
            if(count==left-1){       //  storing the value of  'left-1' in lnode
                lnode = prev;
            }
            if(count>=left){              //   reversing the LL
                ListNode nextNode = cur.next;
                cur.next = prev;
                prev = cur;
                cur = nextNode;
            }else{
                prev = cur; 
                cur = cur.next;
            }
            count++;       // incrementing the count value
        }
		// prev = 4 ; cur = 5
		// updated LL after revering LL from left to right : dum -> 1 -> 2 <- 3 <- 4 -> 5
		                          // lnode = 1
        rnode = lnode.next;      //  rnode = 2
        lnode.next = prev;      //  1-> 4
        rnode.next = cur;      // 2-> 5
		                      // updated : dum -> 1 -> 4 -> 3-> 2-> 5
        return dum.next;
    }
}