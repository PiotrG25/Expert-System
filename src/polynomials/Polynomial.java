package polynomials;

import java.util.ArrayList;
import java.util.List;

public class Polynomial {
    private List<Monomial> monomials;
    private int degree;

    //todo dividing polynomials
    //todo restFromDivision
    //todo multiply polynomials


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
                monomials.get(i).a += m.a;
                if(monomials.get(i).a == 0){
                    monomials.remove(i);
                }
                toAdd = false;
                break;
            }
        }
        if(toAdd){
            monomials.add(m);
            if(m.n > degree){
                degree = m.n;
            }
        }
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
    public void subtract(Polynomial p){
        for(Monomial m : p.getMonomials()){
            this.addMonomial(new Monomial(-m.a, m.n));
        }
    }

    public void multiply(Polynomial p){
        Polynomial result = new Polynomial();

        for(int i = 0; i < monomials.size(); i++){
            for(int j = 0; j < p.getMonomials().size(); j++){
                result.addMonomial(new Monomial(monomials.get(i).a * p.getMonomials().get(j).a, monomials.get(i).n + p.getMonomials().get(j).n));
            }
        }

        monomials = result.monomials;
    }

/*
    public Polynomial resultOfDivision(Polynomial p){

    }
    public Polynomial restOfDivision(Polynomial p){

    }
    */

}
