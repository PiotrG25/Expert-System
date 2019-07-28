package polynomials;

import numbers.Rational;

public class Monomial {
    // a * x^n
    public Rational a;
    public int n;

    public Monomial(Rational a, int n) {
        this.a = a;
        this.n = n;
    }
    public Monomial(long a, int n) {
        this.a = new Rational(a, 1);
        this.n = n;
    }

    @Override
    public String toString() {
        return a.toString() + " * x ^ " + n;
    }
}
