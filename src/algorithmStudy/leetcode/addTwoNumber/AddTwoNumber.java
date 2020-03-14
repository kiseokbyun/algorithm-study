package algorithmStudy.leetcode.addTwoNumber;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class AddTwoNumber {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbers(l1, l2, 0);
    }
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2, final int carry) {
        if (l1 == null && l2 == null) {
            if (carry == 0) {
                return null;
            } else {
                return new ListNode(carry);
            }
        }
        
        int val = 0, localCarry = 0;
        val = l1 != null ? val + l1.val : val;
        val = l2 != null ? val + l2.val : val;
        val += carry;
        
        if (val >= 10) {
            val -= 10;
            localCarry = 1;
        }
        
        ListNode next1 = l1 != null ? l1.next : null;
        ListNode next2 = l2 != null ? l2.next : null;
        
        ListNode result = new ListNode(val);
        result.next = addTwoNumbers(next1, next2, localCarry);
        return result;
    }
    

    @Test
    public void test01() {
       ListNode l1 = new ListNode(2);
       l1.next = new ListNode(4);
       l1.next.next = new ListNode(3);
       
       ListNode l2 = new ListNode(5);
       l2.next = new ListNode(6);
       l2.next.next = new ListNode(4);
       
       ListNode result = addTwoNumbers(l1, l2);

       assertThat(result.val, equalTo(7));
       assertThat(result.next.val, equalTo(0));
       assertThat(result.next.next.val, equalTo(8));
    }
    
    @Test
    public void test02() {
        ListNode l1 = new ListNode(5);
        
        ListNode l2 = new ListNode(5);
        
        ListNode result = addTwoNumbers(l1, l2);

        assertThat(result.val, equalTo(0));
        assertThat(result.next.val, equalTo(1));
    }
    
    @Test
    public void test03() {
        ListNode l1 = new ListNode(6);
        l1.next = new ListNode(0);
        l1.next.next = new ListNode(1);
        
        ListNode l2 = new ListNode(0);
        
        ListNode result = addTwoNumbers(l1, l2);
        
System.out.println("" + result.val + result.next.val + result.next.next.val);

        assertThat(result.val, equalTo(6));
        assertThat(result.next.val, equalTo(0));
        assertThat(result.next.next.val, equalTo(1));
    }
}