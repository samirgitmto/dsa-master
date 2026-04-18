package code.ab15_trees.ps;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Bit complex iterative traversal than other 2 as it requires a Node to be visited twice.
 * @author Mohammad Samir
 * @since 21-11-2025
 */
public class PS06_PostOrderTraversal {

	/**
	 * using lastVisited pointer and a Stack
	 * @param root
	 */
	static void postOrder(TreeNode root) {
		if (root == null)	return;
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode current = root;
		TreeNode lastVisited = null;
		
		while (current != null || !stack.isEmpty()) {
			if (current != null) {
				stack.push(current);
				current = current.left;
			}
			else {
				TreeNode peek = stack.peek();
				// CASE 1: right child exists and is not processed yet
				if (peek.right != null && peek.right != lastVisited) {
					current = peek.right;
				}
				// CASE 2: right is null OR already processed
				else {
					System.out.print(peek.val + " ");
					lastVisited = stack.pop();
				}
			}
		}
	}
	
	static List<Integer> postOrderUsing2Stacks(TreeNode root) {
		if (root == null)	return new ArrayList<Integer>();
		Stack<TreeNode> stack1 = new Stack<TreeNode>();
		Stack<TreeNode> stack2 = new Stack<TreeNode>();
		stack1.push(root);
		
		while (!stack1.isEmpty()) {
			TreeNode currentNode = stack1.pop();
			stack2.push(currentNode);
			
			if (currentNode.left != null)
				stack1.push(currentNode.left);
			if (currentNode.right != null)
				stack1.push(currentNode.right);
		}
		
		List<Integer> postOrderList = new ArrayList<Integer>();
		while(!stack2.isEmpty()) {
			postOrderList.add(stack2.pop().val);
		}
		
		return postOrderList;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);		
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		postOrder(root);
		postOrderUsing2Stacks(root);
	}
}

/**
 * @since 18-04-2026
 */
class Solution3 {
	
	/**
	 * Have I already come back from the right subtree?
	 *        node
     *		 /    \
   	 *	  done?  done?
   	 * 
   	 * go right if not processed.
   	 * 
   	 * Because unlike inorder/preorder, postorder needs to ensure both subtrees are processed before visiting the node.
   	 *  The stack alone doesn’t tell us whether we have already processed the right subtree, so we track the last visited node.
	 * @param root
	 * @return
	 */
    public List<Integer> postorderTraversal(TreeNode root) {
    	List<Integer> list = new ArrayList<Integer>();
    	if (root == null)	return list;
    	
    	Stack<TreeNode> stack = new Stack<TreeNode>();
    	TreeNode curr = root;
    	TreeNode lastVisitedNode = null;
    	
    	while (curr != null || !stack.isEmpty()) {
    		if (curr != null) {
    			stack.push(curr);
    			curr = curr.left;
    		}
    		else {
    			TreeNode localRoot = stack.peek();
    			// go right if not processed
    			if (localRoot.right != null && lastVisitedNode != localRoot.right) {
    				curr = localRoot.right;
    			}
    			else {
    				// process
    				list.add(localRoot.val);
    				// update lastVisitedNode only after processing it
    				lastVisitedNode = stack.pop();
    			}
    		}
    	}
    	
    	return list;
    }
}
