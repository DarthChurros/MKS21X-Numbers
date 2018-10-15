public class RationalNumber extends RealNumber{
  private int num;
  private int denom;

  public RationalNumber (int a, int b) {
    super(1.0 * a / b);
    num = a;
    denom = b;
  }

  public boolean greaterThan(RationalNumber other) {
    return true;
  }
}
