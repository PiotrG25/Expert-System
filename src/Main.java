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
        p.addMonomial(new Monomial(1, 15));
        p.addMonomial(new Monomial(3, 13));
        p.addMonomial(new Monomial(4, 10));

        Polynomial r = new Polynomial();
        r.addMonomial(new Monomial(1, 5));
        r.addMonomial(new Monomial(1, 0));

        System.out.println("Polynomial p before: ");
        for(Monomial m : p.getMonomials()){
            System.out.println(m);
        }

        System.out.println("Polynomial r before: ");
        for(Monomial m : r.getMonomials()){
            System.out.println(m);
        }

        Polynomial result = p.resultOfDivision(r);
        Polynomial rest = p.restOfDivision(r);

        System.out.println("Dividing p by r");
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
