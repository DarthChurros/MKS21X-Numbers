public class RationalNumber extends RealNumber{
  private int num;
  private int denom;

  public RationalNumber (int a, int b) {
    super((double)a / b);
    int x = gcf(a, b);
    num = a / x;
    denom = b / x;
  }

  public boolean equals(RationalNumber other) {
    return num == other.num && denom == other.denom;
  }

  public static int gcf(int a, int b) {
    while (a % b != 0 && b % a != 0) {
      int c = Math.min(a,b);
      a = Math.max(a,b) % Math.min(a,b);
      b = c;
    }
    return Math.min(a,b);
  }

  public static int lcm(int a, int b) {
    for (int i = 1; i <= b; i++) {
      if ((i * a) % b == 0) {
        return i * a;
      }
    }
    return null;
  }

  public RationalNumber reciprocal() {
    return new RationalNumber(denom, num);
  }

  public RationalNumber multiply(RationalNumber other) {
    return new RationalNumber(num * other.num, denom * other.denom);
  }

  public RationalNumber divide(RationalNumber other) {
    return multiply(other.reciprocal());
  }

  public RationalNumber add(RationalNumber other) {
    int x = lcm(denom, other.denom);
    return new RationalNumber(num * x / denom + other.num * x / other.denom, x);
  }

  public RationalNumber subtract(RationalNumber other) {
    return add(new RationalNumber(num * -1, denom));
  }
}
