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
        return new Monomial(this.a.resultOfMultiplication(m.a), this.n + m.n);
    }

    public void divide(Monomial m){
        this.a.divide(m.a);
        this.n -= m.n;
    }
    public Monomial resultOfDivision(Monomial m){
        return new Monomial(this.a.resultOfDivision(m.a), this.n - m.n);
    }


    @Override
    public Object clone() {
        return new Monomial((Rational) a.clone(), n);
    }

    @Override
    public String toString() {
        return a.toString() + " * x ^ " + n;
    }
}
