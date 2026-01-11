import java.util.HashMap;

public class Longest_substring_without_repeat_3 {

  public int lengthOfLongestSubstring(String s) {
    // a b c b a z
    // 0 1 2 3 4 5
    HashMap<Character, Integer> hs = new HashMap<>();
    int left = 0;
    int maxLen = 0;

    for (int right = 0; right < s.length(); right++) {
      char curr = s.charAt(right);
      if (hs.containsKey(curr) && hs.get(curr) >= left) {
        left = hs.get(curr) + 1; // left = 2 , 
      }
      hs.put(curr, right);
      maxLen = Math.max(maxLen, right - left + 1);
    }
    return maxLen;
  }

  public static void main(String[] args) {
    String s = "abcbaz";
    Longest_substring_without_repeat_3 obj = new Longest_substring_without_repeat_3();
    int result = obj.lengthOfLongestSubstring(s);
    System.out.println(result);
  }
}
