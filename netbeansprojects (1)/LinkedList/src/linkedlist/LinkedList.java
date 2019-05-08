/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlist;



public class LinkedList {    
    
    node front;
    
    static class node{
    int data;
    node next;
}
    
    void init(){
       front = null;
    }
    public static void makeNode(int num){
        node myNode;
        myNode = new node();
        myNode.data = num;
        myNode.next = null;
    }
    public static void findTail(){
        node current;
        current = front;
        while (current.next != null){
            current = current.next;
        }
    }
    
    
    public static void main(String[] args){
        int i;  
        init();
        LinkedList list = new LinkedList();
        for(i=0; i<10; i++){
            findTail();
            makeNode(i);
            System.out.println(findTail());
        }
        
    }
    

    
}

