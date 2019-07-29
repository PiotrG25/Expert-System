package polynomials;

import numbers.Rational;

import java.util.ArrayList;
import java.util.List;

public class Polynomial {
    private List<Monomial> monomials;
    private int degree;


    public Polynomial(){
        monomials = new ArrayList<>();
    }


    public void sort(){
        for(int i = 0; i < monomials.size() - 1; i++){
            for(int j = 0; j < monomials.size() - 1; j++){
                Monomial m = monomials.get(j);
                Monomial n = monomials.get(j + 1);
                if(m.n < n.n){
                    monomials.set(j, n);
                    monomials.set(j + 1, m);
                }
            }
        }
    }

    public void addMonomial(Monomial m){
        boolean toAdd = true;
        for(int i = 0; i < monomials.size(); i++){
            if(monomials.get(i).n == m.n){
                monomials.get(i).a.add(m.a);
                if(monomials.get(i).a.numerator == 0){
                    monomials.remove(i);
                }
                toAdd = false;
                break;
            }
        }
        if(toAdd){
            monomials.add(Monomial.copyOf(m));
        }
    }

    public void checkDegree(){
        this.sort();
        this.degree = monomials.get(0).n;
    }

    public List<Monomial> getMonomials() {
        return monomials;
    }
    public void setMonomials(List<Monomial> monomials) {
        this.monomials = monomials;
    }


    public void add(Polynomial p){
        for(Monomial m : p.getMonomials()){
            this.addMonomial(m);
        }
    }
    public Polynomial resultOfAddition(Polynomial p){
        Polynomial result = Polynomial.copyOf(this);
        for(Monomial m : p.getMonomials()){
            result.addMonomial(m);
        }
        return result;
    }

    public void subtract(Polynomial p){
        for(Monomial m : p.getMonomials()){
            this.addMonomial(new Monomial(new Rational(-m.a.numerator, m.a.denominator), m.n));
        }
    }
    public Polynomial resultOfSubtraction(Polynomial p){
        Polynomial result = Polynomial.copyOf(this);
        for(Monomial m : p.getMonomials()){
            result.addMonomial(new Monomial(new Rational(-m.a.numerator, m.a.denominator), m.n));
        }
        return result;
    }

    public void multiply(Polynomial p){
        this.monomials = resultOfMultiplication(p).getMonomials();
    }
    public Polynomial resultOfMultiplication(Polynomial p){
        Polynomial result = new Polynomial();
        for(Monomial m : this.monomials){
            for(Monomial n : p.getMonomials()){
                result.addMonomial(m.resultOfMultiplication(n));
            }
        }
        return result;
    }

    //todo dividing polynomials
    //todo restFromDivision
/*
    public Polynomial resultOfDivision(Polynomial p){
        Polynomial result = new Polynomial();
        Polynomial currentDivident = new Polynomial();
        for(Monomial m : monomials){
            currentDivident.addMonomial(m);
        }

    }
    public Polynomial restOfDivision(Polynomial p){

    }
*/

    public static Polynomial copyOf(Polynomial p){
        Polynomial result = new Polynomial();
        List<Monomial> monomials = new ArrayList<>();
        for(Monomial m : p.getMonomials()){
            monomials.add(Monomial.copyOf(m));
        }
        result.setMonomials(monomials);
        return result;
    }

}
