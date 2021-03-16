package Model;

import java.util.Collections;

public class Operatii {

    public Polinom aduna(Polinom p1, Polinom p2)
    {
        Polinom rez=new Polinom();
        int i=0,j=0;
        while(i<p1.getElemente().size() && j<p2.getElemente().size()) {    //parcurgem ambele liste de monoame si verificam sa fie puterile la fel si le adunam, altfel adunam cu 0
            if (p1.getElemente().get(i).getPow() == p2.getElemente().get(j).getPow()) {
                int c = p1.getElemente().get(i).getCoeficient1() + p2.getElemente().get(j).getCoeficient1();
                int pow = p1.getElemente().get(i).getPow();
                Monom m = new MonomInt(pow, c);
                if(m.getCoeficient1()!=0)
                  rez.getElemente().add(m);
                i++;j++;
            } else {
                if (p1.getElemente().get(i).getPow() > p2.getElemente().get(j).getPow()) {
                    rez.getElemente().add(p1.getElemente().get(i));
                    i++;
                } else {
                    rez.getElemente().add(p2.getElemente().get(j));
                    j++;
                }
            }
        }
        while(i<p1.getElemente().size())
        {
            rez.getElemente().add(p1.getElemente().get(i));
            i++;
        }
        while(j<p2.getElemente().size())
        {
            rez.getElemente().add(p2.getElemente().get(j));
            j++;
        }
        return rez;
    }
    public Polinom scade(Polinom p1,Polinom p2)
    {
        Polinom rez=new Polinom();
        int i=0,j=0;
        while(i<p1.getElemente().size() && j < p2.getElemente().size()) {
            if (p1.getElemente().get(i).getPow() == p2.getElemente().get(j).getPow()) {
                int c = p1.getElemente().get(i).getCoeficient1() - p2.getElemente().get(j).getCoeficient1();
                int pow = p1.getElemente().get(i).getPow();
                Monom m = new MonomInt(pow, c);
                if(m.getCoeficient1()!=0) rez.getElemente().add(m);
                i++;j++;
            } else {
                if (p1.getElemente().get(i).getPow() > p2.getElemente().get(j).getPow()) {
                    rez.getElemente().add(p1.getElemente().get(i));i++;
                } else {
                    int pow=p2.getElemente().get(j).getPow();
                    int co=p2.getElemente().get(j).getCoeficient1()*(-1);
                    rez.getElemente().add(new MonomInt(pow,co));j++;
                }
            }
        }
        while(j<p2.getElemente().size()){
            int pow=p2.getElemente().get(j).getPow();
            int co=p2.getElemente().get(j).getCoeficient1()*(-1);
            rez.getElemente().add(new MonomInt(pow,co));
            j++;
        }
        while(i<p1.getElemente().size())
        {
            rez.getElemente().add(p1.getElemente().get(i));
            i++;
        }
        return rez;
    }
    public Polinom multiplica(Polinom p1,Polinom p2)
    {
        Polinom rez=new Polinom();
        int sem=0;
        for (Monom m1:p1.getElemente()) {
            for (Monom m2:p2.getElemente()) {
                int coef=m1.getCoeficient1()*m2.getCoeficient1();
                int pow=m1.getPow()+m2.getPow();
                sem=0;
                for (Monom mr:rez.getElemente()) {
                    if(pow==mr.getPow())
                    {
                        mr.setCoeficient1(mr.getCoeficient1()+coef);
                        sem=1;
                    }
                }
                if(sem==0)
                    rez.getElemente().add(new MonomInt(pow,coef));
            }
        }
        return rez;
    }
    public Polinom multiplicaD(Polinom p1,Polinom p2)
    {
        Polinom rez=new Polinom();
        int sem=0;
        for (Monom m1:p1.getElemente()) {
            for (Monom m2:p2.getElemente()) {
                double coef=m1.getCoeficient1()*m2.getCoeficient2();
                int pow=m1.getPow()+m2.getPow();
                sem=0;
                for (Monom mr:rez.getElemente()) {
                    if(pow==mr.getPow())
                    {
                        mr.setCoeficient2(mr.getCoeficient2()+coef);
                        sem=1;
                    }
                }
                if(sem==0)
                    rez.getElemente().add(new MonomDou(pow,coef));
            }
        }
        return rez;
    }
    public Polinom scadeD(Polinom p1,Polinom p2)
    {
        Polinom rez=new Polinom();
        int i=0,j=0;
        while(i<p1.getElemente().size() && j < p2.getElemente().size()) {
            if (p1.getElemente().get(i).getPow() == p2.getElemente().get(j).getPow()) {
                double c = p1.getElemente().get(i).getCoeficient2() - p2.getElemente().get(j).getCoeficient2();
                int pow = p1.getElemente().get(i).getPow();
                Monom m = new MonomDou(pow, c);
                rez.getElemente().add(m);
                i++;
                j++;
            } else {
                if (p1.getElemente().get(i).getPow() > p2.getElemente().get(j).getPow()) {
                    rez.getElemente().add(p1.getElemente().get(i));
                    i++;
                } else {
                    int pow=p2.getElemente().get(j).getPow();
                    double co=p2.getElemente().get(j).getCoeficient2()*(-1);
                    rez.getElemente().add(new MonomDou(pow,co));
                    j++;
                }
            }
        }
        while(j<p2.getElemente().size()){
            int pow=p2.getElemente().get(j).getPow();
            double co=p2.getElemente().get(j).getCoeficient2()*(-1);
            rez.getElemente().add(new MonomDou(pow,co));
            j++;
        }
        while(i<p1.getElemente().size())
        {
            rez.getElemente().add(p1.getElemente().get(i));
            i++;
        }
        return rez;
    }
    public Polinom deriveaza(Polinom p1)
    {
        Polinom rez=new Polinom();
        for (Monom m:p1.getElemente()) {
            int x=m.getPow();
            int co=m.getCoeficient1()*x;
            Monom m1=new MonomInt(x-1,co);
            if(m1.getCoeficient1()!=0)
                rez.getElemente().add(m1);
        }
        return rez;
    }
    public Polinom integreaza(Polinom p1)
    {
        Polinom rez=new Polinom();
        for (Monom m:p1.getElemente()) {
            int x=m.getPow();
            double co=m.getCoeficient1()*1.0/(x+1);
            Monom m1=new MonomDou(x+1,co);
            if(m1.getCoeficient2()!=0.00)
                rez.getElemente().add(m1);
        }
        return rez;
    }
    public Polinom imparte(Polinom p1, Polinom p2)
    {
        Polinom rez=new Polinom();
        Collections.sort(p1.getElemente());
        Collections.sort(p2.getElemente());
        if(p1.getElemente().get(0).getPow()<p2.getElemente().get(0).getPow()) //incercam sa impartim la un polinom de grad mai mare
        {
            rez.getElemente().add(new MonomInt(0, 0));
            return rez;
        }
        int i=0,ct=0,rep=p1.getElemente().get(0).getPow()-p2.getElemente().get(0).getPow()+1;
        do {
            Monom m = p1.getElemente().get(i++);
            Monom m2 = p2.getElemente().get(0);
            double x = m.getCoeficient2() / ((1.0) * m2.getCoeficient2());
            int pow = m.getPow() - m2.getPow();
            Monom m3 = new MonomDou(pow, x);
            rez.getElemente().add(m3);
            Polinom p3 = new Polinom();
            Polinom imp = new Polinom();
            imp.getElemente().add(m3);
            p3 = multiplicaD(p2, imp);
            p1 = scadeD(p1, p3);
            ct++;
            int nr=0;
            for(Monom j:p1.getElemente())
            {
                if(j.getCoeficient2()==0.00) nr++;
            }
            if(nr==(p1.getElemente().size()-1) && (p1.getElemente().get(p1.getElemente().size()-1).getPow()==0))
                break;
        }while(i<p1.getElemente().size() && ct<rep);
        return rez;
    }
    public String egal(Polinom rez,int integ)
    {
        String s="";
        if(integ==1) // adunare, scadere, derivare sau inmultire
        {
            s=rez.toStringI();
        }
        else
        {
            s=rez.toStringD();
        }
        return s;
    }
}
