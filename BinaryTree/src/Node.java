public class Node {

   private Node right;
   private Node left;
   private Integer data;

   public Node(Node left, Node right, Integer data) {
      this(data);
      this.left = left;
      this.right = right;
   } 

   public Node(Integer data) {
      this.data = data;
   }

   public Integer getData() {
      return data;
   }

   public Node getRight(){
      return right;
   }

   public Node getLeft(){
      return left;
   }

   public void setData(Integer data) {
      this.data = data;
   }

   public void setLeft(Node left) {
      this.left = left;
   }

   public void setRight(Node right) {
      this.right = right;
   }

   public String toString() {
      return data.toString();
   }
}
