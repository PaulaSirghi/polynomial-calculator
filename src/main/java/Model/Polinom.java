package Model;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Objects;

public class Polinom{
    private ArrayList<Monom> elemente=new ArrayList<>();
    private static DecimalFormat df = new DecimalFormat("0.00");
    //vom retine in lista de elemente fiecare monom din polinom
    public Polinom()
    {

    }

    public ArrayList<Monom> getElemente() {
        return elemente;
    }

    public void splitInput(String s){ //s e polinomul
        try{
            int neg=0;
            if(s.charAt(0)=='-') {
                neg=1;s=s.substring(1);
            }
            s=s.replace("-","+-");
            String[] poli = s.split("\\+"); int coeficient=0;
            for(String i:poli) {
                String[] mono=i.split("\\^");int ct=0;
                for (String j:mono) {
                    if(ct%2==0) {//contor e par deci e coeficient si x, altfel e putere
                        String[] c=j.split("\\*");int ct2=0;
                        for (String j2:c) {
                            if(ct2%2==0) {
                                if(neg==1) {
                                    coeficient=(-1)*Integer.parseInt(j2);neg=0;
                                }
                                else
                                    coeficient=Integer.parseInt(j2);  //retinem coeficientul
                            }
                            ct2++;
                        }
                    }
                    else {
                        int pow=Integer.parseInt(j);
                        Monom m=new MonomInt(pow,coeficient);elemente.add(m);
                    }
                    ct++;
                }
            }
        } catch (Exception e) {
            System.out.println("Polinom introdus gresit");
        }
    }
    public String toStringI()
    {
        String s="";
        int sem=0;
        int j=0;
        while(j<this.getElemente().size())
        {
            if(this.getElemente().get(j).getCoeficient1()==0)
                this.getElemente().remove(j);
            else
                j++;
        }
        for (Monom i:this.getElemente()) {
            if(sem!=0)
            {
                if(i.getCoeficient1()>0)
                    s+="+";
                else
                if(i.getCoeficient1()==0)
                    continue;
            }
            s+=i.getCoeficient1();
            s+="*x^";
            s+=i.getPow();
            sem=1;
        }
        return s;
    }
    public String toStringD()
    {
        int j=0;
        while(j<this.getElemente().size())
        {
            if(this.getElemente().get(j).getCoeficient2()==0.00)
                this.getElemente().remove(j);
            else
                j++;
        }
        df.setRoundingMode(RoundingMode.DOWN);
        String s="";
        int sem=0;
        for (Monom i:this.getElemente()) {
            if(sem!=0)
            {
                if(i.getCoeficient2()>0)
                    s+="+";
                else
                if(i.getCoeficient2()==0.0)
                    continue;
            }
            s+=df.format(i.getCoeficient2());
            s+="*x^";
            s+=i.getPow();
            sem=1;
        }
        return s;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Polinom polinom = (Polinom) o;
        return Objects.equals(elemente, polinom.elemente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(elemente);
    }
}
