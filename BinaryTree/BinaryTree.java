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
      if(rootNode == null) {
         rootNode = new Node(data);
      }
      else {
         insert(rootNode, data);
      }
   }

   private void insert(Node parentNode, Integer data) {
      // Deal with no data in the tree
      if(parentNode == null) {
         return;
      }

      // Deal with current node
      if(data == parentNode.getData()) {
         return; 
      }

      // Deal with sub trees
      if(data < parentNode.getData()){
         if(parentNode.getLeft() == null) {
            parentNode.setLeft(new Node(data));
         }
         else {
            insert(parentNode.getLeft(), data);
         }
      }
      else {
         if(parentNode.getRight() == null) {
            parentNode.setRight(new Node(data));
         }
         else {
            insert(parentNode.getRight(), data);
         }
      }
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
