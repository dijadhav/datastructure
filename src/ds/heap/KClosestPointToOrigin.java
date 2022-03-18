package ds.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPointToOrigin {

	public static void main(String[] args) {
		int[][] arr = { { 1, 3 }, { -2, 2 } };
		int[][] ans = findKClosestPoints(arr, 1);
		for (int i = 0; i < ans.length; i++) {
			for (int j = 0; j < ans[0].length; j++) {
				System.out.print(ans[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static int[][] findKClosestPoints(int[][] arr, int k) {
		PriorityQueue<Pair> pqueue = new PriorityQueue<Pair>(k, new Comparator<Pair>() {

			@Override
			public int compare(Pair o1, Pair o2) {
				return Double.compare(o1.distance, o2.distance);
			}
		});
		for (int i = 0; i < arr.length; i++) {
			double xsq = Math.pow((0 - arr[i][0]), 2);
			double sqy = Math.pow((0 - arr[i][1]), 2);
			double dist = Math.sqrt(xsq + sqy);
			pqueue.offer(new Pair(dist, new Point(arr[i][0], arr[i][1])));
		}
		int j = 0;
		int[][] ans = new int[k][2];
		while (!pqueue.isEmpty() && k-- != 0) {
			Pair poll = pqueue.poll();
			ans[j++] = new int[] { poll.p.x, poll.p.y };
		}
		return ans;
	}

	static class Pair {
		double distance;
		Point p;

		/**
		 * @param distance
		 * @param p
		 */
		public Pair(double distance, Point p) {
			this.distance = distance;
			this.p = p;
		}

		@Override
		public String toString() {
			return distance + "," + p;
		}

	}

	static class Point {
		int x;
		int y;

		/**
		 * @param x
		 * @param y
		 */
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return x + "," + y;
		}

	}
}
