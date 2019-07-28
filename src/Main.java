import dekompositionToSimpleFractions.Monomial;
import dekompositionToSimpleFractions.Polynomial;

public class Main {
    public static void main(String[] args) {
        Polynomial p = new Polynomial();

        p.addMonomial(new Monomial(1, 1));
        p.addMonomial(new Monomial(2, 1));
        p.addMonomial(new Monomial(5, 5));
        p.addMonomial(new Monomial(2, 2));
        p.sort();
        for(Monomial m : p.getMonomials()){
            System.out.println(m.a + " x^" + m.n);
        }
    }
}
