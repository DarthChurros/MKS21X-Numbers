public class RationalNumber extends RealNumber{
  private int num;
  private int denom;

  public static int gcd(int a, int b) {
    a = Math.abs(a);
    b = Math.abs(b);
    while (a % b != 0 && b % a != 0) {
      int c = Math.min(a,b);
      a = Math.max(a,b) % Math.min(a,b);
      b = c;
    }
    if (a == 0) {
      return 1;
    }
    return Math.min(a,b);
  }

  public static int lcm(int a, int b) {
    for (int i = 1; i <= b; i++) {
      if ((i * a) % b == 0) {
        return i * a;
      }
    }
    return 0;
  }

  public RationalNumber (int a, int b) {
    super((double)a / b);
    if (b == 0) {
      a = 0;
      b = 1;
    } else if (b < 0) {
      a *= -1;
      b *= -1;
    }
    int x = gcd(a, b);
    num = a / x;
    denom = b / x;
  }

  public boolean equals(RationalNumber other) {
    return num == other.num && denom == other.denom;
  }

  public int getNumerator() {
    return num;
  }

  public int getDenominator() {
    return denom;
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

  public String toString() {
    if (num == 0) {
      return "0";
    } else if (denom == 1) {
      return "" + num;
    } else {
      return num + "/" + denom;
    }
  }
}
