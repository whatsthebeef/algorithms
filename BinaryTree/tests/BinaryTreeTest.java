import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BinaryTreeTest {

   private BinaryTree binaryTree;

   @Before 
   public void before(){
      binaryTree = new BinaryTree();
   }

   @Test
   public void testLookupEmpty(){
      assertFalse(binaryTree.lookup(1));
   }

   @Test
   public void testInsert(){
      binaryTree.insert(6);
      binaryTree.insert(5);
      binaryTree.insert(7);
      binaryTree.insert(4);
      binaryTree.insert(3);
      binaryTree.insert(2);
      assertTrue(binaryTree.lookup(7));
      System.out.print(binaryTree.toString());
   }
}

