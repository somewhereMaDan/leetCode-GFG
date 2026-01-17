
import java.util.HashMap;

public class Valid_Anagram_242 {
  public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }
    HashMap<Character, Integer> hs = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      if (!hs.containsKey(s.charAt(i))) {
        hs.put(s.charAt(i), 1);
      } else {
        hs.put(s.charAt(i), hs.get(s.charAt(i)) + 1);
      }
    }

    for(int i = 0; i < t.length(); i++){
      if(!hs.containsKey(t.charAt(i))){
        return false;
      }else{
        hs.put(t.charAt(i), hs.get(t.charAt(i)) - 1);
      }
    }
    for(int val : hs.values()){
      if(val != 0){
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    Valid_Anagram_242 v = new Valid_Anagram_242();
    System.out.println(v.isAnagram("anagram", "nagaram"));
  }
}
