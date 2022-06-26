package ds.array;

import java.util.HashMap;
import java.util.Map;

public class RomanToNum {
	public static void main(String[] args) {
		//System.out.println(romanToInt("MCMXCIV"));
		int[] nums= {3,2,2,3};
		int val=3;
		System.out.println(removeElement(nums, val));
	}
	public static int removeElement(int[] nums, int val) {
        int n=nums.length;
        
        for(int i=0;i<n;i++){
            if(nums[i]==val){
                n--;
                for(int j=i;j<nums.length-1;j++){
                    nums[j]=nums[j+1];   
                }
            }            
        }
        return n;
    }
	public static int romanToInt(String s) {
		Map<Character, Integer> map = new HashMap<>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
		int num = map.get(s.charAt(0));
		for (int i = 1; i < s.length(); i++) {
			num += map.get(s.charAt(i));
			if (map.get(s.charAt(i - 1)) < map.get(s.charAt(i))) {
				System.out.println(s.charAt(i - 1));
				num -= 2*map.get(s.charAt(i - 1));
				System.out.println(num);
			}
		}
		return num;
	}
}
