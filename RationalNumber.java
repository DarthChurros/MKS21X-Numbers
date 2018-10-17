public class RationalNumber extends RealNumber{
  private int num;
  private int denom;

  public RationalNumber (int a, int b) {
    super((double)a / b);
    num = a;
    denom = b;
  }

  public boolean equals(RationalNumber other) {
    return getValue() == other.getValue();
  }

  public static int gcf(int a, int b) {
    while (a % b != 0 && b % a != 0) {
      int c = Math.min(a,b);
      a = Math.max(a,b) % Math.min(a,b);
      b = c;
    }
    return Math.min(a,b);
  }
}
