/**
 *  Problem Link : https://www.spoj.com/problems/LCA/
 *  TLE : With Buffered Reader & Streams & Split
 *  Runtime : 1.07s with BufferedReader and String Tokenizer
 *  Runtime : 0.53s with Reader Class & System.out
 *  Runtime : 0.34s with Reader Class & BufferedWriter
 */

package spoj.classical;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class LCA {
	private static int tree[][];
	private static int depth[];

	public static void main(String[] args) throws Exception {
		Reader br = new Reader();
		int t = br.nextInt();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < t; i++) {
			int n = br.nextInt();
			ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
			for (int j = 0; j <= n; j++) adj.add(new ArrayList<>());
			
			for (int j = 1; j <= n; j++) {
				int childs = br.nextInt();
				
				for(int k = 0; k < childs; k++){
					adj.get(j).add(br.nextInt());
				}
			}
			buildTree(adj);
			sb.append("Case ").append(i+1).append(":\n");

			int q = br.nextInt();
			for(int j = 0; j < q; j++){
				sb.append(serveQuery(br.nextInt(), br.nextInt())).append("\n");
			}
		}

		br.close();
		// System.out.print(sb);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());
		bw.close();
	}

	private static void buildTree(ArrayList<ArrayList<Integer>> adj) {
		int log = 0;
		for (; 1 << log < adj.size(); log++);
		// Incrementing for UpperBoun
		log++;
		depth = new int[adj.size()];
		tree = new int[adj.size()][log];
		for (int arr[] : tree)
			Arrays.fill(arr, -1);

		dfs(adj, 1);
		// System.out.println(Arrays.toString(depth));
		// for(int arr[] : tree)System.out.println(Arrays.toString(arr));
	}

	private static void dfs(ArrayList<ArrayList<Integer>> adj, int cur) {
		// Recursively Creating Binary Lifted Tree
		for (int i : adj.get(cur)) {
			depth[i] = depth[cur] + 1;
			tree[i][0] = cur;
			int log = 0;

			for (; 1 << log <= depth[i]; log++);

			for (int j = 1; j < log; j++) {
				tree[i][j] = tree[tree[i][j - 1]][j - 1];
			}

			dfs(adj, i);
		}
	}

	private static int serveQuery(int a, int b) throws Exception {
		if (depth[a] > depth[b]) {
			int temp = a;
			a = b;
			b = temp;
		}

		int diff = depth[b] - depth[a];
		int log = 0;
		for (; 1 << log <= diff; log++);

		// Bringing the B up to level of A
		for (int i = log; i >= 0; i--) {
			if (1 << i <= diff) {
				b = tree[b][i];
				diff -= 1 << i;
			}
		}

		if (a == b)
			return a;

		log = 0;
		for (; 1 << log <= depth[a]; log++);
		log++;

		for (int i = log; i >= 0; i--) {
			if (tree[a][i] != -1 && (tree[a][i] != tree[b][i])) {
				a = tree[a][i];
				b = tree[b][i];
			}
		}
		// System.out.println(a +" "+b);
		if (tree[a][0] == tree[b][0])
			return tree[a][0];
		else
			throw new Exception("Error in LCA");
		// return tree[a][0];
		// return 0;
	}

	private static class Reader {
		final private int BUFFER_SIZE = 1 << 16;
		private DataInputStream din;
		private byte[] buffer;
		private int bufferPointer, bytesRead;

		public Reader() {
			din = new DataInputStream(System.in);
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead = 0;
		}

		public int nextInt() throws IOException {
			int ret = 0;
			byte c = read();
			while (c <= ' ') {
				c = read();
			}
			boolean neg = (c == '-');
			if (neg)
				c = read();
			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');

			if (neg)
				return -ret;
			return ret;
		}

		private void fillBuffer() throws IOException {
			bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
			if (bytesRead == -1)
				buffer[0] = -1;
		}

		private byte read() throws IOException {
			if (bufferPointer == bytesRead)
				fillBuffer();
			return buffer[bufferPointer++];
		}

		public void close() throws IOException {
			if (din == null)
				return;
			din.close();
		}
	}
}
