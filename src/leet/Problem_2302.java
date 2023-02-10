package leet;

public class Problem_2302 {
	 public long countSubarrays(int[] nums, long k) {
        long count = 0;
        int end = -1;
        long sum = 0;
        for (int start = 0; start < nums.length; start++) {
            end++;
            for (; end < nums.length; end++) {
                if ((sum + nums[end]) * (end - start + 1) < k) {
                    count++;
                    sum += nums[end];
                } else {
                    end--;
                    break;
                }
            }
            
            if (end >= nums.length) end--;

            if (end < start) {
            	end++;
            	continue;
            }

            sum -= nums[start];
            count += (end - start);
        }

        return count;
    }
	
	public static void main(String[] args) {
		Problem_2302 a = new Problem_2302();
		
		System.out.println(a.countSubarrays(new int[]{9,5,3,8,4,7,2,7,4,5,4,9,1,4,8,10,8,10,4,7}, 4));
	}
}
