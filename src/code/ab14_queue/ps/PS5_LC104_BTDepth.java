package code.ab14_queue.ps;

import java.util.LinkedList;
import java.util.Queue;

public class PS5_LC104_BTDepth {

	static int maxDepth(NodeBT root) {
		if (root == null)	return 0;
		
		Queue<NodeBT> queue = new LinkedList<NodeBT>();
		queue.offer(root);
		int maxDepth = 0;
		
		while (!queue.isEmpty()) {
			maxDepth++;
			int levelNodes = queue.size();
			
			for (int i=0; i<levelNodes; i++) {
				NodeBT polled = queue.poll();
				if (polled.left != null) queue.offer(polled.left);
				if (polled.right != null) queue.offer(polled.right);
			}
		}
		return maxDepth;
	}
	
	public static void main(String[] args) {
		NodeBT bt = new NodeBT(1);
		bt.left = new NodeBT(2);
		bt.right = new NodeBT(3);
		bt.right.left = new NodeBT(4);
		bt.right.right = new NodeBT(5);
		System.out.println(maxDepth(bt));
	}
	
}
class NodeBT {
	int val;
	NodeBT left, right;
	public NodeBT(int x) {
		this.val = x;
	}
}