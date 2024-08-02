import java.util.*;

public class OrderedLinkedListTester0 {
   public static void main(String[] args) {
      OrderedLinkedList list = new OrderedLinkedList();
      Random rand = new Random();
      
      Scanner scan = new Scanner(System.in);
      System.out.print("How many nodes? "); // asks how many nodes the user wants
      int count = scan.nextInt();
      
      // creates a linked list of random integers in the range 0 to 100
      for (int i = 0; i < count; i++) list.insertInOrder(rand.nextInt(101));
      
      list.traverse();
      list.clear();
   }
}