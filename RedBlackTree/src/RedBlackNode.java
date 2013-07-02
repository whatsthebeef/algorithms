public class RedBlackNode {

   public enum Color {
      RED, BLACK
   }

   private RedBlackNode right;
   private RedBlackNode left;
   private Integer data;
   private Color color;
   private RedBlackNode parent;

   public RedBlackNode(Integer data) {
      this.data = data;
      this.color = Color.RED;
   }

   public RedBlackNode(RedBlackNode left, RedBlackNode right, Integer data, RedBlackNode parent) {
      this(data);
      this.left = left;
      this.right = right;
      this.parent = parent;
   }

   public Color getColor() {
      return color;
   }

   public void setColor(Color color) {
      this.color = color;
   }

   public RedBlackNode getParent() {
      return parent;
   }

   public void setParent(RedBlackNode parent) {
      this.parent = parent;
   }

   public Integer getData() {
      return data;
   }

   public RedBlackNode getRight(){
      return right;
   }

   public RedBlackNode getLeft(){
      return left;
   }

   public void setData(Integer data) {
      this.data = data;
   }

   public void setLeft(RedBlackNode left) {
      this.left = left;
   }

   public void setRight(RedBlackNode right) {
      this.right = right;
   }

   public String toString() {
      return data.toString();
   }
}

