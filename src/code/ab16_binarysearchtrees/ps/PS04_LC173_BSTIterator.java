package code.ab16_binarysearchtrees.ps;

import java.util.Stack;

import code.ab16_binarysearchtrees.ps.PS01_LC783_MinDiffBST.TreeNode;

public class PS04_LC173_BSTIterator {

	Stack<TreeNode> stack;
	
	public PS04_LC173_BSTIterator(TreeNode root) {
		stack = new Stack<>();
		pushLeft(root);
    }
    
    private void pushLeft(TreeNode root) {
		while (root != null) {
			stack.push(root);
			root = root.left;
		}
	}

	public int next() {
        TreeNode current = stack.pop();
        
        if (current.right != null) {
        	pushLeft(current.right);
        }
        
        return current.val;
    }
    
    public boolean hasNext() {
    	return !stack.isEmpty();
    }
    
    public static void main(String[] args) {
    	TreeNode node = new TreeNode(7);
		node.left = new TreeNode(3);
		node.right= new TreeNode(15);
		node.left.right = new TreeNode(4);
		node.left.right.right = new TreeNode(5);
//		node.right.right = new TreeNode(15);
		
		PS04_LC173_BSTIterator bstIterator = new PS04_LC173_BSTIterator(node);
		System.out.println(bstIterator.next());
		System.out.println(bstIterator.hasNext());
		System.out.println(bstIterator.next());
		System.out.println(bstIterator.hasNext());
		System.out.println(bstIterator.next());
		System.out.println(bstIterator.hasNext());
		System.out.println(bstIterator.next());
	}
}