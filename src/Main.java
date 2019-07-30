import numbers.Rational;
import polynomials.Monomial;
import polynomials.Polynomial;

import java.util.ArrayList;
import java.util.List;


//todo
//todo
//todo
public class Main {
    public static void main(String[] args) {
        Polynomial p = new Polynomial();

        p.addMonomial(new Monomial(1, 1));
        p.addMonomial(new Monomial(2, 1));
        p.addMonomial(new Monomial(5, 5));
        p.addMonomial(new Monomial(2, 2));
        p.sort();
        for(Monomial m : p.getMonomials()){
            System.out.println(m);
        }
        System.out.println(p.getMonomials().size());

        p.addMonomial(new Monomial(-3, 1));
        p.sort();
        for(Monomial m : p.getMonomials()){
            System.out.println(m);
        }
        System.out.println(p.getMonomials().size());

        Polynomial r = new Polynomial();
        r.addMonomial(new Monomial(10, 2));
        r.addMonomial(new Monomial(3, 0));
        p.multiply(r);
        p.sort();
        for(Monomial m : p.getMonomials()){
            System.out.println(m);
        }
        System.out.println();
        for(Monomial m : r.getMonomials()){
            System.out.println(m);
        }

        Polynomial result = p.resultOfDivision(r);
        Polynomial rest = p.restOfDivision(r);

        System.out.println();
        System.out.println();
        System.out.println("result");
        for(Monomial m : result.getMonomials()){
            System.out.println(m);
        }
        System.out.println("rest");
        for(Monomial m : rest.getMonomials()){
            System.out.println(m);
        }
    }
}
