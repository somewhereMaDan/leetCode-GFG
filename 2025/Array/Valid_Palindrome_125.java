public class Valid_Palindrome_125 {
  public static boolean isPalindrome(String s) {
    StringBuilder sb = new StringBuilder();
    s = s.toLowerCase();
    for (char c : s.toCharArray()) {
      if (Character.isLetterOrDigit(c)) {
        sb.append(c);
      }
    }
    String temp = sb.toString();
    int start = 0;

    for (int i = temp.length() - 1; i >= 0; i--) {
      if (temp.charAt(i) != sb.toString().charAt(start)) {
        return false;
      }
      start++;
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
  }
}
