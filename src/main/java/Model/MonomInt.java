package Model;

import java.util.Objects;

public class MonomInt extends Monom{
    int coeficient;
    public MonomInt(int pow,int coeficient) {
        super(pow);
        this.coeficient=coeficient;
    }

    public int getCoeficient1() {
        return coeficient;
    }

    public void setCoeficient1(int coeficient) {
        this.coeficient = coeficient;
    }

    @Override
    public void setCoeficient2(double x) {
    }

    public double getCoeficient2() {
        return 1.0*coeficient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        MonomInt monomInt = (MonomInt) o;
        return coeficient == monomInt.coeficient;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), coeficient);
    }
}
