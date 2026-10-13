package code.ab16_binarysearchtrees.ps.psII;

import java.util.Stack;

public class BST01_Basics {

	static void inOrderTraversal(TreeNode head) {
		if (head!=null) {
			inOrderTraversal(head.left);
			System.out.print(head.val + " ");
			inOrderTraversal(head.right);
		}
	}
	
	private static TreeNode insertRecur(TreeNode root, int i) {
		if (root == null) {
			return new TreeNode(i);
		}
		if (i < root.val) {
			root.left = insertRecur(root.left, i);
		}
		else if (i > root.val) {
			root.right = insertRecur(root.right, i);
		}
		
		return root;
	}
	
	private static TreeNode delete(TreeNode root, int i) {
		if (root == null) {
			return null;
		}
		if (root.left == null && root.right == null && root.val == i) {
			return null;
		}
		
		if (i < root.val) {
			root.left = delete(root.left, i);
		}
		else if (i > root.val) {
			root.right = delete(root.right, i);
		}
		else {
			
			// Case 1 - leaf
			if (root.left == null && root.right == null)
				return null;
						
						// Case 2 - single child
			if (root.left == null)	return root.right;
			if (root.right == null)	return root.left;
			
						
						// Case 3 - 2 children
			
			if (height(root.left) > height(root.right)) {
				TreeNode pred = getInorderPredecessor(root.left);
				root.val = pred.val;
				root.left = delete(root.left, pred.val);
			}
			else {
				TreeNode inorderSuccessor = getInorderSuccessor(root.right);
				root.val = inorderSuccessor.val;
				root.right = delete(root.right, inorderSuccessor.val);
			}
		}
		
		return root;
	}
	
	private static TreeNode getInorderPredecessor(TreeNode root) {
		while (root != null && root.right != null) {
			root = root.right;
		}
		
		return root;
	}
	private static TreeNode getInorderSuccessor(TreeNode root) {
		while (root != null && root.left != null) {
			root = root.left;
		}
		
		return root;
	}

	private static int height(TreeNode root) {
		if (root == null)	return 0;
		
		return 1 + Math.max(height(root.left), height(root.right));
	}

	
	static TreeNode createBSTFromPreOrder(int[] arr) {
		if (arr == null || arr.length == 0)	return null;
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		
		TreeNode root = new TreeNode(arr[0]);
		TreeNode prev = root;
		int i = 1;
		int curr;
		
		
		while (i < arr.length) {
			curr = arr[i];
			
			if (curr < prev.val) {
				prev.left = new TreeNode(curr);
				stack.push(prev);
				prev = prev.left;
				i++;
			}
			else if (curr > prev.val) {
				if (stack.isEmpty() || curr < stack.peek().val) {
					prev.right = new TreeNode(curr);
					prev = prev.right;
					i++;
				}
				else if (curr > stack.peek().val) {
					prev = stack.pop();
				}
			}
		}
		
		return root;
	}
	
	static int i = 0;
	
	static int kthSmallest(TreeNode root, int k) {
        if (root == null)	return -1;
        i = 0;
        return dfs(root, k);
    }
	
	private static int dfs(TreeNode root, int k) {
		if (root == null || i > k)	return -1;
		
		int left = dfs(root.left, k);
		if (left != -1)	return left;
		i++;
		if (i == k) {
			return root.val;
		}
		
		return dfs(root.right, k);
	}
	
	static int kthSmallestUsingStack(TreeNode root, int k) {
		if (root == null)	return -1;
		
		int i = 0;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode current = root;
		
		while (current != null || !stack.isEmpty()) {
			if (current != null) {
				stack.push(current);
				current = current.left;
			}
			else {
				i++;
				TreeNode pop = stack.pop();
				
				if (i == k) {
					return pop.val;
				}
				
				if (pop.right != null) {
					current = pop.right;
				}
			}
		}
		return -1;
	}
  
	static int runningSum = 0;
	static TreeNode bstToGst(TreeNode root) {
        if (root == null)	return null;
        runningSum = 0;
        dfs(root);
        
        return root;
    }
	
	private static void dfs(TreeNode root) {
		if (root == null)	return;
		
		dfs(root.right);
		runningSum += root.val;
		root.val = runningSum;
		dfs(root.left);
	}

	// using BST property
	static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)	return null;
        TreeNode lca = null;
        
        if (p.val < root.val && q.val < root.val) {
        	lca = lowestCommonAncestor(root.left, p, q);
        }
        else if (p.val > root.val && q.val > root.val) {
        	lca = lowestCommonAncestor(root.right, p, q);
        }
        else
        	return root;
        return lca;
    }
	
	static TreeNode first, second;
	static TreeNode prev;
	// dfs
	static void recoverTree(TreeNode root) {
        first = null;
        second = null;
        prev = null;
        dfsInorder(root);
        
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
	
	private static void dfsInorder(TreeNode root) {
		if (root == null)	return;
		dfsInorder(root.left);
		if (prev != null && root.val < prev.val) {
			if (first == null) {
				first = prev;
				second = root;
			}
			else {
				second = root;
			}
		}
		prev = root;
		
		dfsInorder(root.right);
	}

	static TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null)	return null;
        
        if (root.val < low) {
        	return trimBST(root.right, low, high);
        }
        else if (root.val > high) {
        	return trimBST(root.left, low, high);
        }
        else if (root.val >= low && root.val <= high) {
        	root.left = trimBST(root.left, low, high);
        	root.right = trimBST(root.right, low, high);
        }
        return root;
    }
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(0);
		root.right = new TreeNode(2);
		TreeNode trimBST = trimBST(root, 1, 2);
		inOrderTraversal(trimBST);
		System.err.println();
		
		TreeNode head = new TreeNode(30);
		head.left = new TreeNode(20);
		head.right = new TreeNode(40);
//		head.left.left = new TreeNode(10);
		head.left.left = new TreeNode(25);
//		head.left.right = new TreeNode(25);
		head.left.right = new TreeNode(10);
		head.right.left = new TreeNode(35);
		head.right.right = new TreeNode(50);
		inOrderTraversal(head);
		System.err.println();
		recoverTree(head);
		inOrderTraversal(head);
		System.err.println();
		
		System.out.println(isPresent(head, 25));
		System.out.println(isPresentIter(head, 25));
		System.out.println(isPresentIter(head, 26));
		inOrderTraversal(head);
		System.out.println();
		System.err.println(height(head));
		
//		TreeNode root = insertRecur(null, 30);
		TreeNode head2 = insertRecur(head, 28);
		inOrderTraversal(head);
		System.err.println();
		inOrderTraversal(head2);
		System.out.println();
		System.err.println(height(head));
		
//		delete(head, 30);
		inOrderTraversal(head);
		System.out.println();
		delete(head, 25);
		inOrderTraversal(head);
		System.out.println();
		
		int[] preOrder = {30, 20, 10, 15, 25, 40};
		TreeNode bstFromPreOrder = createBSTFromPreOrder(preOrder);
		inOrderTraversal(bstFromPreOrder);
		System.out.println();

		int[] preOrder2 = {10, 5, 2, 7, 8};
		TreeNode bstFromPreOrder2 = createBSTFromPreOrder(preOrder2);
		inOrderTraversal(bstFromPreOrder2);
		System.out.println();
		
		int kthSmallest = kthSmallest(bstFromPreOrder2, 3);
		System.out.println(kthSmallest);
		System.out.println(kthSmallestUsingStack(bstFromPreOrder2, 3));
		
		
		TreeNode root5 = new TreeNode(1);
		root5.right = new TreeNode(2);
		root5.right.right = new TreeNode(3);
		System.out.println(kthSmallestUsingStack(root5, 2));
		
		BSTIterator bstIterator = new BSTIterator(root5);
		System.err.println(bstIterator.next());
		System.err.println(bstIterator.hasNext());	
		System.err.println(bstIterator.next());
		System.err.println(bstIterator.next());
		System.err.println(bstIterator.hasNext());
	}

	private static boolean isPresentIter(TreeNode root, int i) {
		if (root == null)	return false;
		
		while (root != null) {
			if (root.val == i)	return true;
			
			if (i < root.val)	root = root.left;
			else	root = root.right;
		}
		
		return false;
	}

	private static boolean isPresent(TreeNode head, int i) {
		if (search(head, i) == null)	return false;
		return true;
	}

	private static TreeNode search(TreeNode root, int i) {
		if (root == null)	return null;
		
		if (root.val == i)	return root;
		
		if (i < root.val) {
			return search(root.left, i);
		}
		else {
			return search(root.right, i);
		}
	}
}

class BSTIterator {

	Stack<TreeNode> stack = new Stack<TreeNode>();
	
    public BSTIterator(TreeNode root) {
        pushLeft(root);
    }
    
    private void pushLeft(TreeNode root) {
    	while (root != null) {
    		stack.push(root);
    		root = root.left;
    	}
    }
    
    public int next() {
        TreeNode pop = stack.pop();
        pushLeft(pop.right);
        return pop.val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}

class TreeNode {
	int val;
	TreeNode left, right;
	public TreeNode(int x) {
		this.val = x;
	}
}
