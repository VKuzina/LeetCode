package leet;

import java.util.Arrays;

public class Problem_2300 {
	
	public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        
        int[] pairs = new int[spells.length];
        for (int i = 0; i < spells.length; i++) {
            int spell = spells[i];
        	long min = (long)Math.ceil((double)success / spell);
        	
        	int index = binary_greater_equal(potions, 0, potions.length - 1, min);
        	
        	if (index == -1) pairs[i] = 0;
        	else pairs[i] = potions.length - index;
        }
        
        return pairs;
	 }
	 
	 public int binary_greater_equal(int[] array, int start, int end, long value) {
		 int ans = -1;
		 
		 while (start <= end) {
			 int mid = (start + end) / 2;
			 
			 if (array[mid] < value) start = mid + 1;
			 else {
				 ans = mid; end = mid - 1;
			 }
		 }
		 
		 return ans;
	 }
}
