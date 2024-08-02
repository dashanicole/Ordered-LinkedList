import java.util.Scanner;

public class OrderedLinkedListTester1 {
   public static void main(String[] args) {
      OrderedLinkedList list = new OrderedLinkedList();
      list.insertInOrder(10);
      list.insertInOrder(6);
      list.insertInOrder(8);
      list.insertInOrder(3);
      list.insertInOrder(1);
      
      Scanner scan = new Scanner(System.in);
      /*
      System.out.print("Node: ");
      int ind1 = scan.nextInt();
      
      System.out.println("Value: " + list.get(ind1));
      */
      System.out.println("What value to delete? ");
      int ind2 = scan.nextInt();
      
      if (list.deleteVal(ind2))
         System.out.println("The value successfully deleted.");
      else
         System.out.println("The value cannot be deleted.");
         
      System.out.println("\nCheck the list!");
      list.traverse();
   }
}