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
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        if (n == 0) return null;
        int gap = 1;
        while (gap < n) {
            for (int i = 0; i < n - gap; i = i + 2 * gap) {
                lists[i] = merge(lists[i], lists[i + gap]);
            }
            gap *= 2;
        }

        return lists[0];
    }

    ListNode merge(ListNode list1, ListNode list2) {

        ListNode DUMMY = new ListNode(), curr = DUMMY;

        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                curr.next = list2;
                list2 = list2.next;
            } else {
                curr.next = list1;
                list1 = list1.next;
            }
            curr = curr.next;
            curr.next = null;
        }

        while (list1 != null) {
            curr.next = list1;
            list1 = list1.next;
            curr = curr.next;
            curr.next = null;
        }

        while (list2 != null) {
            curr.next = list2;
            list2 = list2.next;
            curr = curr.next;
            curr.next = null;
        }

        return DUMMY.next;
    }
}