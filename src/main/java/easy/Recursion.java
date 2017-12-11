package easy;

import core.model.Node;

import java.util.Scanner;

public class Recursion {
    public static void main(String[] args) {
        //printBinary();
        //printLinkedList();

        System.out.println(power(3,4));
    }

    static int power(int num, int p)
    {
        if(p == 0)
            return 1;

        int mul = power(num,p/2);
        mul = mul * mul;

        if(p % 2 == 0)
            return mul;
        else
        {
            return mul * num;
        }
    }

    private static void printLinkedList()
    {
        Node node1 = new Node(1,null);
        Node node2 = new Node(2,null);
        Node node3 = new Node(3,null);

        node1.setNext(node2);
        node2.setNext(node3);

        printNodes(node1);
    }

    private static void printNodes(Node node) {
        System.out.print(node.getVal());
        if(node.getNext() != null)
        {
            printNodes(node.getNext());
        }
    }

    private static void printBinary()
    {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.printf("%d in binary would be: ",n);
        printDecimalInBinary(n);

    }

    private static void printDecimalInBinary(int n) {
        int remainder = n %2;
        int div = n / 2;
        if(div == 0)
        {
            System.out.print(1);
        }
        else
        {
            printDecimalInBinary(div);
            System.out.print(remainder);
        }
    }
}
