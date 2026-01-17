public class Maximum_subarr_53 {
  public int maxSubArray(int[] nums) {
    int currSum = nums[0];
    int maxSum = nums[0];

    for (int i = 1; i < nums.length; i++) {
      if (currSum < 0) {
        currSum = 0;
      }
      currSum += nums[i];
      maxSum = Math.max(currSum, maxSum);
    }
    return maxSum;
  }

  public static void main(String[] args) {
    int[] nums = new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
    Maximum_subarr_53 obj = new Maximum_subarr_53();
    int result = obj.maxSubArray(nums);
    System.out.println(result);
  }
}
