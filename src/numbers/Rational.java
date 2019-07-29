package numbers;

public class Rational {
    public long numerator;
    public long denominator;


    public Rational(long numerator, long denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
        toProperFriction();
    }


    public void add(Rational r){
        long den = this.denominator;

        this.numerator *= r.denominator;
        this.denominator *= r.denominator;
        this.numerator += r.numerator * den;

        toProperFriction();
    }
    public Rational resultOfAddition(Rational r){
        Rational result = new Rational(this.numerator * r.denominator + r.numerator * this.denominator, this.denominator * r.denominator);
        result.toProperFriction();
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
        Rational result = new Rational(this.numerator * r.denominator - r.numerator * this.denominator, this.denominator * r.denominator);
        result.toProperFriction();
        return result;
    }

    public void multiply(Rational r){
        numerator *= r.numerator;
        denominator *= r.denominator;

        toProperFriction();
    }
    public Rational resultOfMultiplication(Rational r){
        Rational result = new Rational(this.numerator * r.numerator, this.denominator * r.denominator);
        result.toProperFriction();
        return result;
    }

    public void divide(Rational r){
        numerator *= r.denominator;
        denominator *= r.numerator;

        toProperFriction();
    }
    public Rational resultOfDivision(Rational r){
        Rational result = new Rational(this.numerator * r.denominator, this.denominator * r.numerator);
        result.toProperFriction();
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


    public static Rational copyOf(Rational r){
        return new Rational(r.numerator, r.denominator);
    }


    @Override
    public String toString() {
        return numerator + " / " + denominator;
    }
}
