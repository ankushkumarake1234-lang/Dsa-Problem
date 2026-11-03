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
        // ListNode a = headA;
        // ListNode b = headB;
        // while (a != b) {
        //     if (a == null) {
        //         a = headB;
        //     } else {
        //         a = a.next;
        //     }

        //     if (b == null) {
        //         b = headA;
        //     } else {
        //         b = b.next;
        //     }
        // }
        // return a;



        // this method of given by sir

        int lengthA = 0;
        int lengthB = 0;

        ListNode tempA = headA;
        ListNode tempB = headB;

        while(tempA != null) {
            lengthA++;
            tempA = tempA.next;
        }
        while(tempB != null) {
            lengthB++;
            tempB = tempB.next;
        }
        while (lengthA > lengthB) {
            headA = headA.next;
            lengthA--;
        }

        while (lengthB > lengthA) {
            headB = headB.next;
            lengthB--;
        }
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;

        
    }
}