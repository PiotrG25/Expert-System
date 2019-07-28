import polynomials.Monomial;
import polynomials.Polynomial;

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


    }
}
