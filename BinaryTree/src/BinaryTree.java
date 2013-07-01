import java.util.ArrayList;
import java.util.List;

public class BinaryTree {

   private Node rootNode;

   public BinaryTree() {
   }

   public Boolean lookup(Integer target) {
      return lookup(rootNode, target);
   }

   private Boolean lookup(Node node, Integer target){
      // Deal with no data in the tree
      if(node == null) {
         return false;
      }
      // Deal with current node
      if(node.getData() == target){
         return true;
      }
      // Deal with sub tree
      if(target < node.getData()){
         return lookup(node.getLeft(), target);
      }
      else {
         return lookup(node.getRight(), target);
      }
   }

   public void insert(Integer data) {
      // Deal with no data in the tree
      rootNode = insert(rootNode, data);
   }

   private Node insert(Node node, Integer data) {
      // Deal with no data in the tree
      if(node == null) {
         return new Node(data);
      }

      // Deal with current node
      if(data == node.getData()) {
         return new Node(data); 
      }

      // Deal with sub trees
      if(data < node.getData()){
         node.setLeft(insert(node.getLeft(), data));
      }
      else {
         node.setRight(insert(node.getRight(), data));
      }
      return node;
   }

   public String toString(){
      String tree = "\n";
      List<Node> rootLevel = new ArrayList<Node>();
      rootLevel.add(rootNode);
      return treeString(rootLevel, tree);
   }

   private String treeString(List<Node> level, String tree){
      List<Node> nextLevel = new ArrayList<Node>();
      String levelString = "";
      for(Node node : level) {
         levelString = levelString + node.toString() + " ";
         if(node.getLeft() != null) {
            nextLevel.add(node.getLeft());
         }
         if(node.getRight() != null) {
            nextLevel.add(node.getRight());
         }
      }
      tree = tree + "\n" + levelString;
      if(!nextLevel.isEmpty()) {
         tree = treeString(nextLevel, tree);
      }
      return tree;
   }
}
