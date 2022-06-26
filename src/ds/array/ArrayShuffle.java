package ds.array;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ArrayShuffle {

	public static void main(String[] args) {
		int [] nums = {2,5,1,3,4,7};
		 Scanner sc=new Scanner(System.in);
		    int cnt=sc.nextInt();
		    PriorityQueue<Integer> queue= new PriorityQueue<>(cnt,new Comparator<Integer>(){
		        @Override 
		        public int compare(Integer i1,Integer i2){
					return i2;
		            
		        }

		    });
		    sc.close();
	}

	public static int[] shuffle(int[] nums, int n) {
		if (null == nums || nums.length == 0 || n <= 0) {
			return new int[0];
		}
		int mid = n / 2;
		for (int i = 1, j = mid; i < mid && j < n; i++, j++) {
			int temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;
		}
		return nums;
	}
}
