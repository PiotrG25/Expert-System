package dekompositionToSimpleFractions;

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
    public List<Monomial> getMonomials() {
        return monomials;
    }
    public void addMonomial(Monomial m){
        boolean toAdd = true;
        for(int i = 0; i < monomials.size(); i++){
            if(monomials.get(i).n == m.n){
                monomials.get(i).a += m.a;
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
}
