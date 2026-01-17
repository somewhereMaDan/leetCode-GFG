import java.util.HashMap;

public class containsDuplicate_2_219 {
  public static boolean containsNearbyDuplicate(int[] nums, int k) {
    HashMap<Integer, Integer> hs = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
      if (!hs.containsKey(nums[i])) {
        hs.put(nums[i], i);
      } else {
        if (Math.abs(hs.get(nums[i]) - i) <= k) {
          return true;
        } else {
          hs.put(nums[i], i);
        }
      }
    }
    return false;
  }

  public static void main(String[] args) {
    int[] nums = new int[] { 1, 2, 3, 1 };
    boolean result = containsNearbyDuplicate(nums, 3);
    System.out.println(result);
  }
}
