package numbers;

public class Rational {
    public long numerator;
    public long denominator;


    public Rational(long numerator, long denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }


    public void add(Rational r){
        long den = this.denominator;

        this.numerator *= r.denominator;
        this.denominator *= r.denominator;

        this.numerator += r.numerator * den;

        toProperFriction();
    }
    public Rational resultOfAddition(Rational r){
        long num = numerator;
        long den = denominator;

        this.add(r);
        Rational result = new Rational(this.numerator, this.denominator);

        this.numerator = num;
        this.denominator = den;

        return result;
    }

    public void subtract(Rational r){
        long den = denominator;

        this.numerator *= r.denominator;
        this.denominator *= r.denominator;

        this.numerator -= r.numerator * den;

        toProperFriction();
    }
    public Rational resultOfSubtraction(Rational r){
        long num = numerator;
        long den = denominator;

        this.subtract(r);
        Rational result = new Rational(this.numerator, this.denominator);

        this.numerator = num;
        this.denominator = den;

        return result;
    }

    public void multiply(Rational r){
        numerator *= r.numerator;
        denominator *= r.denominator;

        toProperFriction();
    }
    public Rational resultOfMultiplication(Rational r){
        long num = numerator;
        long den = denominator;

        this.multiply(r);
        Rational result = new Rational(this.numerator, this.denominator);

        this.numerator = num;
        this.denominator = den;

        return result;
    }

    public void divide(Rational r){
        this.multiply(new Rational(r.denominator, r.numerator));
    }
    public Rational resultOfDivision(Rational r){
        long num = numerator;
        long den = denominator;

        this.divide(r);
        Rational result = new Rational(this.numerator, this.denominator);

        this.numerator = num;
        this.denominator = den;

        return result;
    }


    public void toProperFriction(){
        if(numerator == 0){
            denominator = 1;
            return;
        }

        long min;
        if(denominator < numerator){
            min = denominator;
        }else{
            min = numerator;
        }
        for(long i = min; i >= 2; i--){
            if(numerator % i == 0 && denominator % i == 0){
                numerator /= i;
                denominator /= i;
                break;
            }
        }
    }


    @Override
    public String toString() {
        return numerator + " / " + denominator;
    }
}
