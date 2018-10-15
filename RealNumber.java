public class RealNumber {
  private double value;

  public RealNumber(double val) {
    value = val;
  }

  public double getValue() {
    return value;
  }

  public boolean greaterThan(RealNumber other) {
    return (value > other.value);
  }
}
