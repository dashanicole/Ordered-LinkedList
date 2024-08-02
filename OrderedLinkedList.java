public class OrderedLinkedList {
   private Node3 headPtr = null;
   
   // The constructor creates an empty list
   public OrderedLinkedList() { headPtr = null; }
   
   // Determine if the List is empty
   public boolean isEmpty() {
      return headPtr == null;
   }
   
   // Traverse the list, printing each node
   // (Slightly improved from previous version.)
   public void traverse() {
      Node3 p = headPtr;
      
      while (p != null) {
         if (p == headPtr)
            System.out.print(p);
         else
            System.out.print(", " + p);
            
         p = p.getNext();
      }
   } 
   
   // Insert one Node containing data  
   // into the list in ascending order
   public void insertInOrder(int data) {
      // Create the node to be inserted
      Node3 newNode = new Node3(data);
      newNode.setNext(null);
      
      // CASE 1: insert into an empty list
      if (headPtr == null) {
         headPtr = newNode;
         return; 
      }
      
      // CASE 2: data is less than current first   
      else if (data < headPtr.getValue()) {
         newNode.setNext(headPtr); // current first becomes second
         headPtr = newNode;        // newNode becomes first
         return;
      }
      
      // CASE 3: data goes at end of the list
      // First, advance current to the current end of the list.
      /*
      Node3 curr = headPtr;
       
      while (curr.getNext() != null) 
         curr = curr.getNext(); // advance the pointer
          
      if (data > curr.getValue()) {
         curr.setNext(newNode); // link the node at the end
         return;
      }
      
      // CASE 4: data goes between two nodes
      curr = headPtr;
      Node3 next = headPtr.getNext();
      
      while (data > next.getValue()) { // search for the proper gap
         curr = next;
         next = next.getNext();
      }
      
      // link in the new node
      newNode.setNext(next);
      curr.setNext(newNode);
      */
      
      else {
         // initialize the pointers
         Node3 curr = headPtr;
         Node3 next = headPtr.getNext();
         
         // search for the end or a gap
         while (next != null && data > next.getValue()) {
            curr = next;
            next = next.getNext();
         }
      
         // link in the new node
         newNode.setNext(next);
         curr.setNext(newNode);
      }
   }
   
   public int get(int index) throws IndexOutOfBoundsException {
      
      if (isEmpty())
         throw new IndexOutOfBoundsException();
      
      Node3 p = headPtr;
      int counter = 0;
      
      while (index > counter && p != null) {
         p = p.getNext();
         counter++;
      }
      
      if (index == counter)
         return p.getValue();
      else
         throw new IndexOutOfBoundsException();
   }
   
   // Delete the first node that contains value.
   // It is now garbage.
   public boolean deleteVal(int value) {
      // for empty list, return false
      if (headPtr == null) return false;
      
      // value is in first node, unlink it, return true
      if (headPtr.getValue() == value) {
         headPtr = headPtr.getNext();
         return true;
      }
      
      // search for a node that contains value
      // or end of list
      Node3 curr = headPtr;
      Node3 next = headPtr.getNext();
      
      while (next != null && next.getValue() < value) { // you can use "!="
         curr = next;
         next = next.getNext();
      }
      
      // if value is found, unlink it, return true
      if (next != null && next.getValue() == value) {
         curr.setNext(next.getNext());
         return true;
      }
      
      // value not in the list: return false
      return false;
      
   // Note: A small change would make it work with an unordered list
   }
   
   // Array to list but in order without returning values 
   public void toList(int[] arr) { 
      if (headPtr == null) {
         OrderedLinkedList copy = new OrderedLinkedList();

         for (int i = 0; i < arr.length; i++) copy.insertInOrder(arr[i]);
         
         for (int targ = arr.length-1; targ >= 0; targ--) {
            Node3 node = new Node3(copy.get(targ));
            node.setNext(headPtr);
            headPtr = node;
         }
      }  
      
      return;
   }
   
   // Array to list but in order with returning values
   public OrderedLinkedList arrToList(int[] arr) {
      if (headPtr == null) {
         OrderedLinkedList copy = new OrderedLinkedList();

         for (int i = 0; i < arr.length; i++) copy.insertInOrder(arr[i]);
      
         return copy;   
      }
      
      return null;
   }
   
   // Array to list but in order inside a constructor method
   public OrderedLinkedList(int[] arr) {
      if (headPtr == null) {
         OrderedLinkedList copy = new OrderedLinkedList();

         for (int i = 0; i < arr.length; i++) copy.insertInOrder(arr[i]);
         
         for (int targ = arr.length-1; targ >= 0; targ--) {
            Node3 node = new Node3(copy.get(targ));
            node.setNext(headPtr);
            headPtr = node;
         }
      }  
      
      return;
   }
   
   // Searches for a target value
   public int search(int target) {
      Node3 p = headPtr;
      int index = 0;
      
      while (p != null && p.getValue() < target) {
         p = p.getNext();
         index++;
      }
      
      if (p != null && p.getValue() == target)
         return index; // returns the index of the node that contains the target
      else
         return -1; // returns -1 if no node contains the target
   }
   
   // Changes the value of the node at location index
   // A node must already exist at that location
   public void set(int index, int value) throws IndexOutOfBoundsException {
      if (headPtr == null)
         throw new IndexOutOfBoundsException();
      
      Node3 p = headPtr;
      
      for (int i = 0; p != null && i < index; i++) p = p.getNext();
      
      if (p != null) 
         p.setValue(value);   
      else
         throw new IndexOutOfBoundsException();   
   }
   
   // Make a copy of the object corresponding to the LinkedList class 
   // and make new copies of all the Nodes linked to it
   public OrderedLinkedList copy() {
      Node3 p = headPtr;
      
      // The copy is a separate of the original list, with its own nodes chained off its own headPtr variable
      OrderedLinkedList copy = new OrderedLinkedList();
      
      while (p != null) {
         copy.insertInOrder(p.getValue());
         p = p.getNext();
      }
      
      return copy;
   }
   
   // A method that deletes all Nodes holding a particular value
   // Delete all Nodes containing victim from the LinkedList
   public int delete(int target) {
      Node3 next = headPtr;
      Node3 prev = null;
      int num = 0;
     
      while (next != null) {
         if (next.getValue() == target) {
            if (prev == null) // if the first Node matches victim, change headPtr
               headPtr = headPtr.getNext();
            else if (next.getNext() == null)
               prev.setNext(null);
            else 
               prev.setNext(next.getNext());
     
            num++;
         }
         else 
            prev = next;
         
         next = next.getNext();
      }      
      
      // Return the number of Nodes deleted
      return num;
   }
   
   public void clear() {
      headPtr = null; // the garbage collector recycles all the orphan nodes
   }
}

