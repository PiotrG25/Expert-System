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


    public void multiply(Monomial m){
        this.a.multiply(m.a);
        this.n += m.n;
    }
    public Monomial resultOfMultiplication(Monomial m){
        Monomial before = new Monomial(new Rational(a.numerator, a.denominator), n);

        this.multiply(m);
        Monomial result = new Monomial(new Rational(this.a.numerator, this.a.denominator), this.n);

        this.a = before.a;
        this.n = before.n;

        return result;
    }

    public void divide(Monomial m){
        this.a.divide(m.a);
        this.n -= m.n;
    }
    public Monomial resultOfDivision(Monomial m){
        Monomial before = new Monomial(new Rational(a.numerator, a.denominator), n);

        this.divide(m);
        Monomial result = new Monomial(new Rational(this.a.numerator, this.a.denominator), this.n);

        this.a = before.a;
        this.n = before.n;

        return result;
    }


    @Override
    public String toString() {
        return a.toString() + " * x ^ " + n;
    }
}
