package ds.array;

public class FindMedianOfSortedArray {
	public static void main(String[] args) {
		int[] nums1 = { 1, 3 };
		int[] nums2 = { 2 };
		System.out.println(findMedianSortedArrays(nums1, nums2));
	}

	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int n = nums1.length;
		int m = nums2.length;
		int arr[] = new int[n + m];
		int i = 0, j = 0;
		int k = 0;
		while (i < n && j < m) {
			if (nums1[i] <= nums2[j]) {
				arr[k++] = nums1[i++];
			}
			if (nums1[i] > nums2[j]) {
				arr[k++] = nums2[j++];
			}
		}
		while (i < n) {
			arr[k++] = nums1[i++];
		}
		while (j < m) {
			arr[k++] = nums2[j++];
		}

		double median = 0;
		if ((n + m) % 2 == 0) {
			int mid = m + n / 2;
			median = (arr[mid] + arr[mid - 1]) / 2;
		} else {
			int mid = m + n / 2;
			median = arr[mid];
		}
		return median;
	}
}
