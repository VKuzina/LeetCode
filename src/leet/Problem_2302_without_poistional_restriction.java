package leet;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Problem_2302_without_poistional_restriction {
	public long countSubarrays(int[] nums, long k) {
		Arrays.sort(nums);
        Queue<State> legal_states = new LinkedList<>();
        legal_states.add(new State(0,0,-1));
        
        int sum = 0;
        while(!legal_states.isEmpty()) {
        	State current = legal_states.poll();
        	
        	for (int i = current.last_index + 1; i < nums.length; i++) {
        		if ((current.sum + (long)nums[i]) * (current.size + 1) < k) {
        			sum++;
        			legal_states.add(new State(current.sum + nums[i], current.size + 1, i));
        		}
        	}
        }
        
        return sum;
    }
	
	public class State {
		int sum;
		int size;
		int last_index;
		
		public State(int sum, int size, int last_index) {
			this.sum = sum;
			this.size = size;
			this.last_index = last_index;
		}
	}
	
	public static void main(String[] args) {
		Problem_2302_without_poistional_restriction a = new Problem_2302_without_poistional_restriction();
		
		a.countSubarrays(new int[]{2,1,4,3,5}, 10);
	}
}
