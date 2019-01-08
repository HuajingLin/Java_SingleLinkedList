//
//  Created by Huajing Lin on 9/4/18.
//  Copyright © 2018 Huajing Lin. All rights reserved.
//
package single.linked_lists;

public class SingleLinkedList<E> {
    private Node<E> head = null;
    private int size = 0;
    
    public int indexOf(E item) {
        int index = 0;
        Node<E> current = head;

        while (current != null) {
            if (current.data.equals(item)) {
                return index;
            }
            index++;
            current = current.next;
        }

        return -1;
    }
    
    public boolean remove(E item){
        boolean found = false;
        Node<E> current = head;
        Node<E> previous = head;
        while (current != null) {
            if (current.data.equals(item)) {
                found = true;
                size--;
                
                if(current == head)
                {
                    head = current.next;
                }
                else
                    previous.next = current.next;
                break;
            }
            previous = current;
            current = current.next;
        }
        return found;
    }
    
    public boolean add ( int index, E item){
        if(index < 0 || index > size) {
            //throw new IndexOutOfBoundsException(Integer.toString(index));
            System.out.println("iIndex Out Of Bounds Exception.");
            return false;
        }
        
        if( index == 0 ){
            addFirst(item);
        }
        else{
            Node<E> node = getNode(index - 1);
            addAfter(node, item);
        }
        return true;
    }
    
    private void addFirst( E item){
        head = new Node<E>(item, head);
        
        size ++;
    }
    
    private void addAfter( Node<E> node, E item){
        node.next = new Node<E>(item, node.next);
        
        size ++;
    }
    
    private Node<E> getNode(int index){
        Node<E> node = head;
        for (int i=0; i<index && node!= null; i++){
            node = node.next;
        }
        return node;
    }
    
    public E get(int index){
        if(index <0 || index >= size){
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        Node<E> node = getNode(index);
        return node.data;
    }
    
    public void displayAll(){
        int index = 0;
        Node<E> current = head;
        System.out.println("single-linked list:");
        System.out.println("========================================");
        while (current != null) {
            System.out.printf("%d. %s\n", index, current.data);
            current = current.next;
            index++;
        }
        System.out.println("========================================");
    }
}
