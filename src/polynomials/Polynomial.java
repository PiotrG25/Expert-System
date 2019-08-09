package polynomials;

import numbers.Rational;

import java.util.ArrayList;
import java.util.List;

public class Polynomial {
    private List<Monomial> monomials;

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
        if(m.a.numerator == 0){
            return;
        }
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
            monomials.add((Monomial)m.clone());
        }
    }

    public int getDegree(){
        int degree = 0;
        for(Monomial m : monomials){
            if(m.n > degree){
                degree = m.n;
            }
        }
        return degree;
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
        Polynomial result = (Polynomial)this.clone();
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
        Polynomial result = (Polynomial)this.clone();
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
    public Polynomial resultOfMultiplication(Monomial m){
        Polynomial result = new Polynomial();
        for(Monomial monomial : this.monomials){
            result.addMonomial(monomial.resultOfMultiplication(m));
        }
        return result;
    }

    public Polynomial resultOfDivision(Polynomial p){
        Polynomial result = new Polynomial();

        if(this.getDegree() < p.getDegree()){
            return result;
        }
        if(p.getMonomials().size() == 0){
            System.err.println("Dividing polynomial by 0");
            return null;
        }

        p.sort();
        Monomial pHeadMonomial = p.getMonomials().get(0);
        Polynomial currentDivident = (Polynomial)this.clone();

        for(;currentDivident.getDegree() >= p.getDegree() && currentDivident.getMonomials().size() != 0;){
            currentDivident.sort();

            Monomial currentDividentHeadMonomial = currentDivident.getMonomials().get(0);

            Monomial smallestMonomialInResult = currentDividentHeadMonomial.resultOfDivision(pHeadMonomial);
            result.addMonomial(smallestMonomialInResult);

            Polynomial toSubtract = p.resultOfMultiplication(smallestMonomialInResult);
            currentDivident.subtract(toSubtract);
        }
        return result;
    }
    public Polynomial restOfDivision(Polynomial p){
        return this.resultOfSubtraction(this.resultOfDivision(p).resultOfMultiplication(p));
    }


    @Override
    public Object clone(){
        Polynomial result = new Polynomial();
        List<Monomial> monomials = new ArrayList<>();
        for(Monomial m : this.monomials){
            monomials.add((Monomial)m.clone());
        }
        result.setMonomials(monomials);
        return result;
    }
}
