public class Plus_One_66 {
  public static int[] plusOne(int[] digits) {
    for(int i = digits.length - 1; i > 0; i--){
      if(digits[i] < 9){
        digits[i]++;
        return digits;
      }
      digits[i] = 0;
    }
    int[] res = new int[digits.length + 1];
    res[0] = 1;
    return res;
  }

  public static void main(String[] args) {
    int[] digits = { 1, 2, 3, 9 };
    int[] temp = plusOne(digits);
    for (int num : temp) {
      System.out.print(num + "_");
    }
  }
}