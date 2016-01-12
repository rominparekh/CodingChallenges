/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.Scanner;

/**
 *
 * @author rominparekh
 */
class LinkedListElement {

    LinkedListElement next;
    int data;

    LinkedListElement(int data) {
        this.data = data;
    }
}

public class LinkedList {

    static int LinkedListSize = 0;

    private static LinkedListElement InsertAtFront(LinkedListElement head, int data) {
        LinkedListSize += 1;
        if (head == null) {
            head = new LinkedListElement(data);
            return head;
        } else {
            LinkedListElement l = new LinkedListElement(data);
            l.next = head;
            return l;
        }
    }

    private static LinkedListElement Add(LinkedListElement head, int data, int position) {

        if (head == null) {
            LinkedListSize += 1;
            head = new LinkedListElement(data);
            System.out.println("LinkedList is empty. Storing at position " + LinkedListSize);
            return head;

        } else {
            if (position < 0 || position > LinkedListSize) {
                head = InsertAtBack(head, data);
                System.out.println("Position is out of LinkedList range. Inserting at Back");
                return head;

            } else if (position == 1) {
                head = InsertAtFront(head, data);
                System.out.println("Position is 1. Inserting at Front");
                return head;

            } else {
                LinkedListElement temphead = head;
                LinkedListSize += 1;
                int pos = 1;
                while (head != null && pos != position - 1) {
                    head = head.next;
                    pos += 1;
                }
                LinkedListElement temp = head;
                LinkedListElement l = new LinkedListElement(data);
                temp.next = l;
                l.next = head.next;

                return temphead;
            }
        }
    }

//    private static LinkedListElement Delete(LinkedListElement head, int data) {
//        if (head == null) {
//            System.out.println("LinkedList is empty");
//            return head;
//        } else {
//            while (head != null && head.data != data) {
//                head.next = head;
//            }
//            
//
//        }
//    }
    private static LinkedListElement InsertAtBack(LinkedListElement head, int data) {
        LinkedListSize += 1;
        if (head == null) {
            head = new LinkedListElement(data);
        } else {
            LinkedListElement temp = head;
            while (head.next != null) {
                head = head.next;
            }
            LinkedListElement l = new LinkedListElement(data);
            head.next = l;
            head = temp;
        }
        return head;
    }

    private static void PrintLinkedList(LinkedListElement head) {
        if (head != null) {
            String output = "LinkedList :";
            while (head != null) {
                output += " " + head.data + "->";
                head = head.next;
            }
            System.out.println(output);
            System.out.println("LinkedList Size: " + LinkedListSize);
        } else {
            System.out.println("LinkedList is Empty");
        }
    }
    
    protected void start(){
        LinkedListElement head = null;
        Scanner in = new Scanner(System.in);
        int data, choice;
        do {
            System.out.println("0. Exit\n1. Add\n2. Delete\n3. Insert at Front\n4. Insert at Back\n5. Print LinkedList");
            choice = in.nextInt();
            switch (choice) {
                case 0:
                    System.out.println("Exiting");
                    break;

                case 1:
                    System.out.println("Adding new Node. Enter data value");
                    data = in.nextInt();
                    System.out.println("Enter node position (starting from 1)");
                    int position = in.nextInt();
                    head = Add(head, data, position);
                    //System.out.println("LinkedList Size: " + LinkedListSize);
                    break;

                case 2:
                    System.out.println("Delete Node. Enter data value");
                    data = in.nextInt();
                    //head = Delete(head, data);
                    break;

                case 3:
                    System.out.println("Inserting at Front. Enter data value");
                    data = in.nextInt();
                    head = InsertAtFront(head, data);
                    //System.out.println("LinkedList Size: " + LinkedListSize);
                    break;

                case 4:
                    System.out.println("Inserting at Back. Enter data value");
                    data = in.nextInt();
                    head = InsertAtBack(head, data);
                    //System.out.println("LinkedList Size: " + LinkedListSize);
                    break;

                case 5:
                    PrintLinkedList(head);
                    break;

                default:
                    System.out.println("Incorrect input");
                    break;
            }
        } while (choice != 0);
    }
}
