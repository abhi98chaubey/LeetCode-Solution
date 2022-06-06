/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode l1=headA;
        ListNode l2=headB;
        
        while(l1!=l2){
            l1=l1.next;
            l2=l2.next;
            if(l1==null){
                l1=headB;
                headB=null;
            }
            if(l2==null){
                l2=headA;
                headA=null;
            }
        }
        return l1;
    }
}