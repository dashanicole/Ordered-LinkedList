import java.util.*;
public class OrderedLinkedListTester2 { 
   public static void main(String[] args) {
      //OrderedLinkedList list = new OrderedLinkedList();
      //OrderedLinkedList listA = new OrderedLinkedList();
      int[] array = {2, 1, 4, 3, 6, 5};
      
      //listA.toList(array);
      
      //OrderedLinkedList listB = listA.arrToList(array);
      //listB.traverse(); 
      
      //listA.arrToList(array).traverse();
      
      //OrderedLinkedList listB = new OrderedLinkedList(array);
      //listB.traverse();
      
      OrderedLinkedList listC = new OrderedLinkedList();
      listC.insertInOrder(10);
      listC.insertInOrder(6);
      listC.insertInOrder(6);
      listC.insertInOrder(2);
      listC.insertInOrder(8);
      listC.insertInOrder(4);

      OrderedLinkedList listD = listC.copy();
      listD.traverse();
      
      System.out.println("\nNumber of nodes deleted: " + listD.delete(1));
      listD.traverse();
      
      /*
      Scanner scan = new Scanner(System.in);
      System.out.print("\nTarget value: ");
      int targ = scan.nextInt();
            
      if (listB.search(targ) >= 0)
         System.out.println("Index: " + listB.search(targ));
      else
         System.out.println("Index: " + listB.search(targ) + " (doesn't exist)");
      
      System.out.print("\nSet Value: ");
      int val = scan.nextInt();
      System.out.print("Index: ");
      int ind = scan.nextInt();
      
      listB.set(ind, val);
      listB.traverse();
      */
   }
}