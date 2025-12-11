public class Reverse_String_344 {
  public static void reverseString(char[] s) {
    int p1 = 0;
    int p2 = s.length - 1;

    while (p1 != p2 && (p1 >= 0 && p2 >= 0)) {
      Character temp = s[p1];
      s[p1] = s[p2];
      s[p2] = temp;
      p2--;
      p1++;
    }
  }

  public static void main(String[] args) {
    char[] s = new char[] { 'H', 'a', 'n', 'n', 'a', 'h' };
    reverseString(s);
    for (char value : s) {
      System.out.print(value + "_");
    }
  }
}
