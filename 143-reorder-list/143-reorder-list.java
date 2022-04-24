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
    public void reorderList(ListNode head) {
        ListNode curr = head;
        ListNode mid = middleNode(head);
        ListNode newHead = reverse(mid);
        ListNode ans = mergeTwoLists(curr, newHead);
        head = ans;
    }
    // MERGE TWO LIST IN sorted list
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //BASE CASES
        if (list1 == null && list2 == null)
            return list1;
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;
        
        ListNode tmp1 = list1;
        ListNode tmp2 = list2;
        ListNode node = new ListNode(0);//CREATING NEW NODE TO STORE NEW LIST FROM 2 LISTS
        ListNode tmp = node;
        int i=0;//USING i TO ADD NODES ATLERNATIVELY FROM TW0 LISTS

        while (tmp1 != null && tmp2 != null) {
            if (i%2 == 0) {     //EVEN INDEX 0,2,4,6,8
                tmp.next = tmp1;
                tmp = tmp.next;
                tmp1 = tmp1.next;
            } else {            // ODD INDEX 1,3,5,7,9
                tmp.next = tmp2;
                tmp = tmp.next;
                tmp2 = tmp2.next;
            }
            
                i++;
        }

        return node.next;
    }
    
    // GET MIDDLE NODE
    public ListNode middleNode(ListNode head) {
        // WE CAN USE FAST AND SLOW POINTER METHOD HERE AS WELL
        ListNode fast = head;
        ListNode slow = head;
        // IDEA IS FAST POINTER WILL BE AT 2X SPEED THAN SLOW POINTER
        // SO WHEN THE FAST POINTER WILL REACH THE LAST -> NULL
        // THE SLOW WILL BE AT MIDDLE
        while (fast != null && fast.next != null) {
            fast = fast.next.next;// 2 STEPS
            slow = slow.next;// 1 STEP
        }
        return slow;
    }
    
    // REVERSE BY ITERATION -> IN PLACE REVERSAL OF LIST
    public ListNode reverse(ListNode head) {
        ListNode curr = head;
        ListNode pre = null;
        while (curr != null) {
            ListNode tmp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = tmp;
        }
        return pre;
    }
}