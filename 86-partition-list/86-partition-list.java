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
    public ListNode partition(ListNode head, int x) {
        
        if(head == null || head.next == null)
            return head;
        
        ListNode prev = null, curr = head, head2 = null, tail2 = null;
        
        while(curr != null) {
            
            if(curr.val < x) {             
                prev = curr;
                curr = curr.next;
            }
            else {
                if(head2 == null) {
                    head2 = curr;
                    tail2 = curr;                    
                }
                else {
                    tail2.next = curr;
                    tail2 = tail2.next;
                }
                
                if(prev == null) {
                    head = head.next;
                    curr = curr.next;
                }
                else {
                    prev.next = curr.next;
                    curr = curr.next;
                }
            }
            
        }
        
        if(tail2 == null) {
            return head;
        }
        tail2.next = null;
        if(prev == null) {
            return head2;
        }
        prev.next = head2;
        return head;

    }
}