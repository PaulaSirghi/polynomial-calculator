package Model;

import java.util.Objects;

abstract public class Monom  implements Comparable{
    private int pow;
    public Monom(int pow) {
        this.pow = pow;
    }
    public int getPow() {
        return pow;
    }
    public abstract int getCoeficient1();
    public abstract double getCoeficient2();
    public abstract void setCoeficient1(int x);
    public abstract void setCoeficient2(double x);
    @Override
    public int compareTo(Object o) {
        int cp=((Monom)o).getPow();
        return cp-this.getPow();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Monom monom = (Monom) o;
        return pow == monom.pow;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pow);
    }
}
