package Model;

import java.util.Objects;

public class MonomDou extends Monom{
    double coeficient;
    public MonomDou(int pow,double coeficient) {
        super(pow);
        this.coeficient=coeficient;
    }

    @Override
    public int getCoeficient1() {
        return 0;
    }

    @Override
    public double getCoeficient2() {
        return coeficient;
    }

    @Override
    public void setCoeficient1(int x) {

    }

    @Override
    public void setCoeficient2(double x) {
        this.coeficient=x;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        MonomDou monomDou = (MonomDou) o;
        return Double.compare(monomDou.coeficient, coeficient) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), coeficient);
    }
}
