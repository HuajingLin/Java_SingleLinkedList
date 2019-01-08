//
//  Created by Huajing Lin on 9/4/18.
//  Copyright © 2018 Huajing Lin. All rights reserved.
//
package single.linked_lists;

class Node<E> {
    public E data;
    public Node<E> next;
    
    private Node(E dataItem){
        data = dataItem;
        next = null;
    }
    
    Node(E dataItem, Node<E> nodeRef){
        data = dataItem;
        next = nodeRef;
    }
}
