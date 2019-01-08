//
//  Created by Huajing Lin on 9/4/18.
//  Copyright © 2018 Huajing Lin. All rights reserved.
//
package single.linked_lists;

import java.util.Scanner;

public class SingleLinked_Lists {

    private static SingleLinkedList<String> my_List = null;
    
    public static void main(String[] args) {
        my_List = new SingleLinkedList<String>();
        int quit = 0;
        do {
            System.out.print("\nPlease select one thing you want to do ");
            System.out.println("(Index of list starts 0.) ");
            System.out.print("1. indexOf \t");
            System.out.print("2. remove \t");
            System.out.println("3. Add \t");
            System.out.print("4. display \t");
            System.out.println("0. Exit");

            Scanner kb = new Scanner(System.in);
            int num = kb.nextInt();
            switch (num) {
                case 1:
                    indexOf();
                    break;
                case 2:
                    remove();//Load
                    break;
                case 3:
                    Add();//Add
                    break;
                case 4:
                    display();//Find
                    break;
                case 0:
                    quit = 1;//Exit
                    break;
                default:
                    break;
            }

        } while (quit == 0);
    }
    
    private static void indexOf()
    {
        String str;
        Scanner kb = new Scanner(System.in);

        System.out.println(" please enter a string:");
        str = kb.nextLine();
        
        int index = my_List.indexOf(str);
        System.out.printf("indexOf: %d\n", index);
    }
    
    private static void remove()
    {
        String str;
        Scanner kb = new Scanner(System.in);

        System.out.println(" please enter a string that need to remove:");
        str = kb.nextLine();
        
        boolean ret = my_List.remove(str);
        if(ret)
            System.out.printf("item remove successfully.\n");
        else
            System.out.printf("item is fail to remove.\n");
    }
    
    private static void Add()
    {
        String str;
        int index = 0;
        Scanner kb = new Scanner(System.in);

        System.out.println(" please enter index that need to add on:");
        str = kb.nextLine();
        
        try {
            index = Integer.parseInt(str.trim());
        } catch (NumberFormatException nfe) {
            System.out.println("index number error.");
            return;
        }
        
        
        if(index<0 || index > 100)
        {
            System.out.println(" index error.");
            return;
        }
        System.out.println(" please enter a string that need to add:");
        str = kb.nextLine();
        
        if(my_List.add(index, str))
            System.out.println(" item added.");
        else
            System.out.println(" item added fail.");
    }
    
    private static void display()
    {
        my_List.displayAll();
    }
}
