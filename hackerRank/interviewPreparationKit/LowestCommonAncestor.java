package hackerRank.interviewPreparationKit;

import java.util.ArrayList;

public class LowestCommonAncestor {
	static class Node{
		int data;
		Node left,right;
		Node(int data){
			this.data = data;
			this.left = null;
			this.right = null;
		}
		public String toString() {
			return this.data+" ";
		}
	}
	
	public static void main(String[] args) {
		Node root = new Node(4);
		
		root.left = new Node(2);
		root.left.left = new Node(1);
		root.left.right = new Node(3);
		
		root.right = new Node(7);
		root.right.left = new Node(6);
		
		
		System.out.println(lca(root, 1, 7).data);
		
	}
	
	private static ArrayList<Node> path(Node root, int v) {
		ArrayList<Node> ret = new ArrayList<>();
		ret.add(root);
		
		while(ret.get(ret.size()-1).data != v) {
			Node current = ret.get(ret.size()-1);
			if(v < current.data)ret.add(current.left);
			else ret.add(current.right);
		}
		
		return ret;
	}
	
	
	private static Node lca(Node root, int v1, int v2) {
		ArrayList<Node> pathTov1 = path(root, v1);
		ArrayList<Node> pathTov2 = path(root, v2);
		
		Node cur = root;
		for(int i = 0 ; i < Math.min(pathTov1.size(), pathTov2.size()); i++) {
			if(pathTov1.get(i) != pathTov2.get(i))break;
			cur = pathTov1.get(i);
		}
		
		return cur;
	}
}
