package coderpad.searchTree;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/*
 * Instructions to candidate.
 * Implement the "put" and "contains" methods.
 * Fix the "inOrderTraversal" method.
 */

public class Solution {

    static class BST  {

        private Node root;

        public BST() {
            this.root = new Node();
        }

        public void put(int value) {
            // your code
            if(root.val == null)
                root.val=value;
            else {
                Node node = new Node();
                node.val=value;
                Node temp = root;
                Node back = null;
                while(temp != null){
                    back=temp;
                    if(value <= temp.val){
                        temp=temp.left;
                    } else{
                        temp=temp.right;

                    }
                }
                if(value <= back.val)
                    back.left=node;
                else
                    back.right=node;
            }
        }

        public boolean contains(int value) {
            // your code
            return inOrderTraversal().contains(value);
        }

        public List<Integer> inOrderTraversal() {
            final ArrayList<Integer> acc = new ArrayList<>();
            inOrderTraversal(root, acc);
            return acc;
        }

        private void inOrderTraversal(Node node, List<Integer> acc) {
            if (node == null) {
                return;
            }
            inOrderTraversal(node.left, acc);
            acc.add(node.val);
            inOrderTraversal(node.right, acc);

        }

        private static class Node {
            Integer val;
            Node left;
            Node right;
        }
    }


    public static void main(String[] args) {

        final BST searchTree = new BST();

        searchTree.put(3);
        searchTree.put(1);
        searchTree.put(2);
        searchTree.put(5);

        if(Arrays.asList(1,2,3,5).equals(searchTree.inOrderTraversal())
                && !searchTree.contains(0)
                && searchTree.contains(1)
                && searchTree.contains(2)
                && searchTree.contains(3)
                && !searchTree.contains(4)
                && searchTree.contains(5)
                && !searchTree.contains(6)){
            System.out.println("Pass");
        }else {
            System.out.println("Fail");
        }

    }

}
