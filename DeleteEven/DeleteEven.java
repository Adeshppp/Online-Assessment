// problem:
// given a head of linkedlist, we have to delete the node which contains even number in it.


import java.util.Scanner;

public class DeleteEven {
    private static ListNode head = null;
    private static int size = 0;

    static class ListNode {
        ListNode next;
        String val;

        ListNode(String val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of nodes in LinkedList : ");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) add(sc.next());
        System.out.println();
        deleteEven();
        print();
    }

    public static void add(String n) {
        size++;
        if (head == null) head = new ListNode(n, null);
        else head = new ListNode(n, head);

    }

    public static void deleteEven() {
        if (head == null || head.next == null) System.out.println("List is empty.");
        else {
            while (Integer.parseInt(head.val) % 2 == 0) {
                head = head.next;
                if (head == null) break;
            }
            if (head == null || head.next == null) System.out.println("All nodes were Even. ");
            else {
                ListNode temp = new ListNode("temp", head);
                while (temp != null && temp.next != null) {
                    if (Integer.parseInt(temp.next.val) % 2 == 0) {
                        temp.next = temp.next.next;
                        if (temp.next == null) break;
                    } else temp = temp.next;
                }
            }
        }
    }

    public static void print() {
        if (head == null) System.out.println("List is empty.");
        ListNode n1 = head;
        while (n1 != null) {
            System.out.print(n1.val + " ");
            n1 = n1.next;
        }
    }
}
