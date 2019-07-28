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

        if(numerator != 0)
            toProperFriction();
        else
            denominator = 1;
    }
    public void toProperFriction(){
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
