public class RedBlackTree {

   private RedBlackNode rootNode;

   public RedBlackTree() {
   }

   public void rotateLeft(RedBlackNode node){
      RedBlackNode rightNode = (RedBlackNode)node.getRight();
      node.setRight(rightNode.getLeft());
      if(rightNode.getLeft() != null) {
         ((RedBlackNode)rightNode.getLeft()).setParent(node);
      }
      rightNode.setParent(node.getParent());
      if(node.getParent() == null) {
         rootNode = rightNode;
      }
      else {
         if(node == node.getParent().getLeft()){
            node.getParent().setLeft(rightNode);
         }
         else {
            node.getParent().setRight(rightNode);
         }
      }
      rightNode.setLeft(node);
      node.setParent(rightNode);
   }

}


