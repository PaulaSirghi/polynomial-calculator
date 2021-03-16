package Controller;
import Model.*;
import View.View;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import javax.swing.*;

public class Controller {
    private Operatii o;
    private View m_view;
    private String pol1, pol2;
    private Polinom rez=new Polinom();
    private int integ=0;
    private Polinom p1=new Polinom();
    private Polinom p2=new Polinom();
    private Polinom rest=new Polinom();
    private int d=0;
    private int inte=0;
    public Controller(Operatii o, View v) {
        this.o=o;
        m_view = v;
        m_view.add(new AddListener());
        m_view.equ(new EquListener());
        m_view.sub(new SubListener());
        m_view.derivata(new DerListener());
        m_view.integrala(new IntListener());
        m_view.mul(new MulListener());
        m_view.div(new DivListener());
    }
    public void extrage()
    {
        pol1=m_view.getPolinom().getText();
        pol2=m_view.getPolinom2().getText();
        p1=new Polinom();
        p1.splitInput(pol1);
        p2=new Polinom();
        p2.splitInput(pol2);
    }
    public Polinom getRest(Polinom p1,Polinom p2,Polinom rez)
    {
        if(rez.getElemente().size()==1 && rez.getElemente().get(0).getPow()==0 && rez.getElemente().get(0).getCoeficient1()==0)
            rest=p1;
        else
            rest=o.scadeD(p1,o.multiplicaD(p2,rez));
        int i=0;
        while(i<rest.getElemente().size())
        {
            if(rest.getElemente().get(i).getCoeficient2()==0.00)
                rest.getElemente().remove(i--);
            i++;

        }
        return rest;
    }
    class AddListener implements ActionListener {  //luam polinoamele in stringuri si luam coeficientii si ii punem in p1 si p2
       // @Override
        public void actionPerformed(ActionEvent e) {
            integ=1;
            extrage();
            rez=o.aduna(p1,p2);
            m_view.setPolinomR("");
        }
    }
    class SubListener implements ActionListener {  //luam polinoamele in stringuri si luam coeficientii si ii punem in p1 si p2
       // @Override
        public void actionPerformed(ActionEvent e) {
            extrage();
            integ = 1;
            rez=o.scade(p1,p2);
            m_view.setPolinomR("");
        }
    }
    class DerListener implements ActionListener {  //luam polinoamele in stringuri si luam coeficientii si ii punem in p1 si p2
       // @Override
        public void actionPerformed(ActionEvent e) {
            integ=1;
            extrage();
            rez=o.deriveaza(p1);
            m_view.setPolinomR("");
        }
    }
    class IntListener implements ActionListener {  //luam polinoamele in stringuri si luam coeficientii si ii punem in p1 si p2
        //@Override
        public void actionPerformed(ActionEvent e) {
            integ=0;
            extrage();
            rez=o.integreaza(p1);
            m_view.setPolinomR("");
            inte=1;
        }
    }
    class MulListener implements ActionListener {  //luam polinoamele in stringuri si luam coeficientii si ii punem in p1 si p2
       // @Override
        public void actionPerformed(ActionEvent e) {
            extrage();
            integ=1;
            rez=o.multiplica(p1,p2);
            m_view.setPolinomR("");
        }
    }
    class DivListener implements ActionListener {  //luam polinoamele in stringuri si luam coeficientii si ii punem in p1 si p2
       // @Override
        public void actionPerformed(ActionEvent e) {
            m_view.setPolinomR("");
            extrage();
            Collections.sort(p2.getElemente());
            if(p2.getElemente().get(0).getCoeficient1()==0)
            {
                JOptionPane.showMessageDialog(null, "NU SE POATE IMPARTI LA 0", "EROARE", JOptionPane.ERROR_MESSAGE);
                rez=new Polinom();
            }
            else {
                rez = o.imparte(p1, p2);
                integ = 0;
                d = 1;
            }
        }
    }

    class EquListener implements ActionListener {  //luam polinoamele in stringuri si luam coeficientii si ii punem in p1 si p2
       // @Override
        public void actionPerformed(ActionEvent e) {
            String s="";
            m_view.setRest(" ");
            if(d==1) //am realizat o impartire
            {
                rest=getRest(p1,p2,rez);
                Collections.sort(p1.getElemente());
                Collections.sort(p2.getElemente());
                String s2;
                if(p1.getElemente().get(0).getPow()<p2.getElemente().get(0).getPow())
                    s2=o.egal(rest,1);
                else
                {
                    Collections.sort(rez.getElemente());
                    s2=o.egal(rest,integ);
                }
                m_view.setRest(s2);
            }
            s=o.egal(rez,integ);
            if(inte==1)
                s=s+"+ C";
            m_view.setPolinomR(s);
            d=0;
            rest=new Polinom();
            rez=new Polinom();
            inte=0;
        }
    }
}
