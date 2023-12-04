package Tree.BST;

import java.sql.SQLOutput;

public class BinarySearchTree {
    private class TreeNode{
        private int data;
        private TreeNode left;
        private TreeNode right;

        TreeNode(int data){
            this.data = data;
            left = null;
            right = null;
        }
    }
    private TreeNode root;
    private int size;

    public BinarySearchTree(){
        this.root = null;
        size = 0;
    }
    public int size(){
        return this.size;
    }
    public void insert(int data){
        size++;
        root = insert(root,data);
    }
    private TreeNode insert(TreeNode root,int data){
        if(root==null){
            TreeNode node = new TreeNode(data);
            return node;
        }
        if(root.data > data){
            root.left = insert(root.left,data);
        }
        else {
            root.right = insert(root.right, data);
        }
        return root;
    }
    public void inOrderTraversal(){
        inOrderTraversal(root);
    }
    private void inOrderTraversal(TreeNode root){
        if(root==null) return;
        inOrderTraversal(root.left);
        System.out.println(root.data);
        inOrderTraversal(root.right);
    }
    public boolean search(int target){
        return search(root,target);
    }
    private boolean search(TreeNode root, int target){
        if(root == null) return false;

        if(root.data == target) return true;

        else if(root.data>target) return search(root.left,target);

        return search(root.right,target);
    }
    public void delete(int value){
        root = delete(root,value);
    }
    private TreeNode delete(TreeNode root,int value){
        if(root == null) return null;

        else if(root.data>value) root.left = delete(root.left,value);

        else if(root.data<value) root.right = delete(root.right,value);

        else {
            //we will be in else block when r.data==value

            //case 1 : Node to be deleted has no child
            if(root.left == null && root.right == null){
                size--;
                return null;
            }
//            case 2: Node to be deleted has only one child
            else if(root.left==null){
                size--;
                return root.right;
            }
            else if(root.right==null){
                return root.left;
            }
            else{
//                case3:Node has 2 child.
                TreeNode node = inOrderSuccessor(root.right);
                root.data = node.data;
                root.right = delete(root.right,node.data);//delete the inorder successor.

            }
        }
        return root;
    }
    private TreeNode inOrderSuccessor(TreeNode node){
        //find the leftmost leaf.

        while(node.left!=null) node = node.left;
        return node;
    }

    public int totalNodes(){
        return totalNodes(root);
    }
    private int totalNodes(TreeNode root){
        if(root==null) return 0;
        int left = totalNodes(root.left);
        int right = totalNodes(root.right);

        return left+right+1;
    }
    public int totalInternalNodes(){
        return totalInternalNodes(root);
    }
    private int totalInternalNodes(TreeNode root){
        if(root==null) return 0;
        if(root.left==null && root.right==null) return 0;
        int left = totalInternalNodes(root.left);
        int right = totalInternalNodes(root.right);

        return left+right+1;
    }
    public int totalLeafNodes(){
        return totalLeafNodes(root);
    }
    private int totalLeafNodes(TreeNode root){
        if(root==null) return 0;
        if(root.left==null && root.right==null) return 1;
        int left = totalLeafNodes(root.left);
        int right = totalLeafNodes(root.right);

        return left+right;
    }
    public int totalSumOfNodes(){
        return totalSumOfNodes(root);
    }
    private int totalSumOfNodes(TreeNode root){
        if (root==null) return 0;
        int left = totalSumOfNodes(root.left);
        int right = totalSumOfNodes(root.right);

        return left+right+root.data;
    }
    public int height(){
        return height(root);
    }
    private int height(TreeNode root){
        if(root==null) return 0;
        int left = height(root.left);
        int right = height(root.right);

        return Math.max(left,right)+1;
    }
}
class Test{
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(5);
        bst.insert(4);
        bst.insert(10);
        bst.insert(1);
        bst.insert(2);
        bst.insert(8);
        bst.insert(9);
        bst.insert(17);
        bst.insert(20);

//        bst.inOrderTraversal();
        System.out.println(bst.size());
        System.out.println(bst.totalInternalNodes());
        System.out.println(bst.totalLeafNodes());
        System.out.println(bst.height());

//        System.out.println(bst.size());
////        System.out.println(bst.search(20));
//        bst.inOrderTraversal();
//
//        System.out.println();
//
//        bst.delete(2);
//        System.out.println(bst.size());
//        bst.inOrderTraversal();
//
//        System.out.println();
//
//        bst.delete(20);
//        System.out.println(bst.size());
//        bst.inOrderTraversal();
//
//        System.out.println();
//
//        bst.delete(5);
//        System.out.println(bst.size());
//        bst.inOrderTraversal();
    }
}
