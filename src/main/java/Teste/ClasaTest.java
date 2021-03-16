package Teste;

import Model.*;
import View.*;
import Controller.*;

import org.junit.Test;

import static org.junit.Assert.*;

public class ClasaTest {
    Operatii o=new Operatii();
    View v=new View(o);
    Controller c=new Controller(o,v);


    @Test
    public void addTest()
    {
        Polinom p1=new Polinom();
        Monom m1=new MonomInt(5,4);
        Monom m2=new MonomInt(4,-3);
        Monom m3=new MonomInt(2,1);
        Monom m4=new MonomInt(1,-8);
        Monom m5=new MonomInt(0,1);
        p1.getElemente().add(m1);
        p1.getElemente().add(m2);
        p1.getElemente().add(m3);
        p1.getElemente().add(m4);
        p1.getElemente().add(m5);


        Polinom p2=new Polinom();
        Monom m21=new MonomInt(4,3);
        Monom m22=new MonomInt(3,-1);
        Monom m23=new MonomInt(2,1);
        Monom m24=new MonomInt(1,2);
        Monom m25=new MonomInt(0,-1);
        p2.getElemente().add(m21);
        p2.getElemente().add(m22);
        p2.getElemente().add(m23);
        p2.getElemente().add(m24);
        p2.getElemente().add(m25);

        Polinom rez=new Polinom();
        Monom m31=new MonomInt(5,4);
        Monom m32=new MonomInt(3,-1);
        Monom m33=new MonomInt(2,2);
        Monom m34=new MonomInt(1,-6);
        rez.getElemente().add(m31);
        rez.getElemente().add(m32);
        rez.getElemente().add(m33);
        rez.getElemente().add(m34);

        Polinom rezT=new Polinom();
        rezT=o.aduna(p1,p2);
        assertEquals(rezT,rez);
    }

    @Test
    public void subTest()
    {
        Polinom p1=new Polinom();
        Monom m1=new MonomInt(5,4);
        Monom m2=new MonomInt(4,-3);
        Monom m3=new MonomInt(2,1);
        Monom m4=new MonomInt(1,-8);
        Monom m5=new MonomInt(0,1);
        p1.getElemente().add(m1);
        p1.getElemente().add(m2);
        p1.getElemente().add(m3);
        p1.getElemente().add(m4);
        p1.getElemente().add(m5);

        Polinom p2=new Polinom();
        Monom m21=new MonomInt(4,3);
        Monom m22=new MonomInt(3,-1);
        Monom m23=new MonomInt(2,1);
        Monom m24=new MonomInt(1,2);
        Monom m25=new MonomInt(0,-1);
        p2.getElemente().add(m21);
        p2.getElemente().add(m22);
        p2.getElemente().add(m23);
        p2.getElemente().add(m24);
        p2.getElemente().add(m25);

        Polinom rez=new Polinom();
        Monom m31=new MonomInt(5,4);
        Monom m32=new MonomInt(4,-6);
        Monom m33=new MonomInt(3,1);
        Monom m34=new MonomInt(1,-10);
        Monom m35=new MonomInt(0,2);
        rez.getElemente().add(m31);
        rez.getElemente().add(m32);
        rez.getElemente().add(m33);
        rez.getElemente().add(m34);
        rez.getElemente().add(m35);

        Polinom rezT=new Polinom();
        rezT=o.scade(p1,p2);
        assertEquals(rezT,rez);
    }


    @Test
    public void mulTest()
    {
        Polinom p1=new Polinom();
        Monom m1=new MonomInt(2,3);
        Monom m2=new MonomInt(1,-1);
        Monom m3=new MonomInt(0,1);
        p1.getElemente().add(m1);
        p1.getElemente().add(m2);
        p1.getElemente().add(m3);

        Polinom p2=new Polinom();
        Monom m21=new MonomInt(1,1);
        Monom m22=new MonomInt(0,-2);
        p2.getElemente().add(m21);
        p2.getElemente().add(m22);

        Polinom rez=new Polinom();
        Monom m31=new MonomInt(3,3);
        Monom m32=new MonomInt(2,-7);
        Monom m33=new MonomInt(1,3);
        Monom m34=new MonomInt(0,-2);

        rez.getElemente().add(m31);
        rez.getElemente().add(m32);
        rez.getElemente().add(m33);
        rez.getElemente().add(m34);

        Polinom rezT=new Polinom();
        rezT=o.multiplica(p1,p2);
        assertEquals(rezT,rez);
    }

    @Test
    public void divTest()
    {
        Polinom p1=new Polinom();
        Monom m1=new MonomInt(3,1);
        Monom m2=new MonomInt(2,-2);
        Monom m3=new MonomInt(1,6);
        Monom m4=new MonomInt(0,-5);

        p1.getElemente().add(m1);
        p1.getElemente().add(m2);
        p1.getElemente().add(m3);
        p1.getElemente().add(m4);

        Polinom p2=new Polinom();
        Monom m21=new MonomInt(2,1);
        Monom m22=new MonomInt(0,-1);
        p2.getElemente().add(m21);
        p2.getElemente().add(m22);

        Polinom rez=new Polinom();
        Monom m31=new MonomDou(1,1.0);
        Monom m32=new MonomDou(0,-2.0);

        rez.getElemente().add(m31);
        rez.getElemente().add(m32);

        Polinom rezT=new Polinom();
        rezT=o.imparte(p1,p2);
        assertEquals(rezT,rez);

        Polinom rest=new Polinom();
        rest=c.getRest(p1,p2,rez);

        Polinom rest2=new Polinom();
        Monom m41=new MonomDou(1,7.0);
        Monom m42=new MonomDou(0,-7.0);
        rest2.getElemente().add(m41);
        rest2.getElemente().add(m42);

        assertEquals(rest,rest2);


    }

    @Test
    public void derTest()
    {
        Polinom p1=new Polinom();
        Monom m1=new MonomInt(3,1);
        p1.getElemente().add(m1);
        Monom m2=new MonomInt(2,-2);
        Monom m3=new MonomInt(1,6);
        Monom m4=new MonomInt(0,-5);
        p1.getElemente().add(m2);
        p1.getElemente().add(m3);
        p1.getElemente().add(m4);

        Polinom rez=new Polinom();
        Monom mr1=new MonomInt(2,3);
        Monom mr2=new MonomInt(1,-4);
        Monom mr3=new MonomInt(0,6);

        rez.getElemente().add(mr1);
        rez.getElemente().add(mr2);
        rez.getElemente().add(mr3);

        Polinom rezT=new Polinom();
        rezT=o.deriveaza(p1);
        assertEquals(rezT,rez);
    }


    @Test
    public void intTest()
    {
        Polinom p1=new Polinom();
        Monom m1=new MonomInt(3,1);
        p1.getElemente().add(m1);
        Monom m2=new MonomInt(2,4);
        Monom m3=new MonomInt(0,5);
        p1.getElemente().add(m2);
        p1.getElemente().add(m3);


        Polinom rez=new Polinom();
        Monom mr1=new MonomDou(4,0.25);
        Monom mr2=new MonomDou(3,1.3333333333333333);
        Monom mr3=new MonomDou(1,5.00);

        rez.getElemente().add(mr1);
        rez.getElemente().add(mr2);
        rez.getElemente().add(mr3);

        Polinom rezT=new Polinom();
        rezT=o.integreaza(p1);
        assertEquals(rezT,rez);
    }


}
