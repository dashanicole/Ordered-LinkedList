public class OrderedLinkedListTester {
   public static void main(String[] args) {
      // create an empty ordered linked list
      OrderedLinkedList list = new OrderedLinkedList();
      list.insertInOrder(10);
      list.insertInOrder(5);
      list.insertInOrder(6);
      list.insertInOrder(2);
      list.insertInOrder(3);
      list.insertInOrder(1);
      list.insertInOrder(4);
      list.insertInOrder(7);
      list.insertInOrder(9);
      list.insertInOrder(8);
      
      list.traverse();
      
      /*
       * if (list.isEmpty()) 
       *    System.out.println("List created successfully!");
       * else
       *    System.out.println("Something is wrong.");
       */   
   }
}