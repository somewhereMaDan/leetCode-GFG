

public class Maximum_avg_subarr_643 {
  public static double findMaxAverage(int[] nums, int k) {
    int sum = 0;
    int left = 0;
    int right = 0;

    while (right < k) {
      sum += nums[right];
      right++;
    }

    double maxSum = sum;
    
    while (right < nums.length) {
      sum -= nums[left];
      sum += nums[right];

      maxSum = Math.max(sum, maxSum);
      left++;
      right++;
    }
    return maxSum / 4;
  }

  public static void main(String[] args) {
    int[] nums = new int[] { 1, 12, -5, -6, 50, 3 };
    double result = findMaxAverage(nums, 4);
    System.out.println(result);
  }
}
