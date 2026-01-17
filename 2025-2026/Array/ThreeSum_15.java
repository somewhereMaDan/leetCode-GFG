import java.util.ArrayList;
import java.util.Arrays;

public class ThreeSum_15 {
  public static ArrayList<ArrayList<Integer>> threeSum(int[] nums) {
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    Arrays.sort(nums);

    for (int i = 0; i < nums.length - 2; i++) {
      if (i > 0 && nums[i] == nums[i - 1]) {
        continue;
      }
      int left = i + 1;
      int right = nums.length - 1;

      while (left < right) {
        int sum = nums[i] + nums[left] + nums[right];

        if (sum == 0) {
          ArrayList<Integer> arr = new ArrayList<>();
          arr.add(nums[i]);
          arr.add(nums[left]);
          arr.add(nums[right]);
          result.add(arr);

          int leftVal = nums[left];
          int rightVal = nums[right];

          while (left < right && leftVal == nums[left]) {
            left++;
          }
          while (left < right && rightVal == nums[right]) {
            right--;
          }
        } else if (sum < 0) {
          left++;
        } else {
          right--;
        }
      }
    }
    return result;
  }

  public static void main(String[] args) {
    int[] nums = new int[] { -1, 0, 1, 2, -1, -4 };
    ArrayList<ArrayList<Integer>> res = threeSum(nums);
    System.out.println(res);
  }
}
