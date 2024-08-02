public class Node3 {
   private int value;
   private Node3 next;
   
   public Node3(int val) { value = val; next = null; }
   
   public int getValue() { return value; }
   public Node3 getNext() { return next; }
   
   public void setValue(int val) { value = val; }
   public void setNext(Node3 nxt) { next = nxt; }
   
   public String toString() { return "" + value; }
}