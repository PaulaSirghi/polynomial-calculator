package View;

import Model.Operatii;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class View extends JFrame {
    private JTextField polinom = new JTextField(20);
    private JLabel l1= new JLabel("Dati polinomul 1");
    private JTextField polinom2 = new JTextField(20);
    private JLabel l2= new JLabel("Dati polinomul 2");
    private JTextField polinomR = new JTextField(10);
    private JLabel l22=new JLabel("Restul:");
    private JTextField rest=new JTextField(10);
    private JButton b1= new JButton("*");
    private JButton b2= new JButton("/");
    private JButton b3= new JButton("+");
    private JButton b4= new JButton("-");
    private JButton b5= new JButton("'");
    private JButton b6= new JButton("∫");
    private JButton b7= new JButton("=");
    private JLabel l3=new JLabel("       Polinomul rezultat:");
    private Operatii o;
    private JLabel l4=new JLabel("Polinoamele introduse trebuie sa aiba forma: 1*x^0+6*x^2+...");

    public JTextField getPolinom() {
        return polinom;
    }

    public JTextField getPolinom2() {
        return polinom2;
    }

    public void setPolinomR(String s) {
        this.polinomR.setText(s);
    }

    public void initBut()
    {

        Color cul2=new Color(254,189,255);
        b1.setBackground(cul2);
        b2.setBackground(cul2);
        b3.setBackground(cul2);
        b4.setBackground(cul2);
        b5.setBackground(cul2);
        b6.setBackground(cul2);
        b7.setBackground(cul2);
    }
    public void initLab()
    {
        l1.setForeground(Color.WHITE);
        l2.setForeground(Color.WHITE);
        l22.setForeground(Color.WHITE);
        l3.setForeground(Color.WHITE);
        l4.setForeground(Color.red);

    }
    public JPanel panouBut()
    {
        Color cul1=new Color(141,166,249);
        JPanel p2=new JPanel();
        p2.setLayout(new GridLayout(3,3));
        p2.setBorder(BorderFactory.createLineBorder(Color.white));
        p2.add(b1);
        p2.add(b2);
        p2.add(b3);
        p2.add(b4);
        p2.add(b5);
        p2.add(b6);
        p2.add(b7);
        p2.add(l3);
        p2.add(polinomR);
        p2.setBackground(cul1);
        return p2;
    }
    public JPanel panouSus1()
    {
        Color cul1=new Color(141,166,249);
        JPanel content = new JPanel();
        content.setLayout(new FlowLayout());
        content.add(l1);
        content.add(polinom);
        content.setBackground(cul1);
        return content;
    }
    public JPanel panouSus2()
    {
        Color cul1=new Color(141,166,249);
        JPanel content2 = new JPanel();
        content2.setLayout(new FlowLayout());
        content2.add(l2);content2.add(polinom2);
        content2.setBackground(cul1);
        return content2;
    }
    public JPanel panouSus()
    {
        Color cul1=new Color(141,166,249);
        JPanel content3 = new JPanel();
        content3.setLayout(new FlowLayout());
        l4.setForeground(Color.red);
        content3.add(l4);
        content3.setBackground(cul1);
        return content3;
    }
    public JPanel panouPrincipal(JPanel content3, JPanel content, JPanel content2, JPanel p2, JPanel spp)
    {
        JPanel contentP = new JPanel();
        contentP.setLayout(new GridLayout(5,1));
        contentP.add(content3);
        contentP.add(content);
        contentP.add(content2);
        contentP.add(p2);
        contentP.add(spp);
        return contentP;
    }
    public JPanel panouJos()
    {
        Color cul1=new Color(141,166,249);
        JPanel spp=new JPanel();
        spp.setLayout(new FlowLayout(FlowLayout.RIGHT));
        spp.add(l22);
        spp.add(rest);
        spp.setBackground(cul1);
        return spp;
    }
    public View(Operatii o)
    {
        initBut();
        initLab();
        this.o=o;
        JPanel content = panouSus1();
        JPanel content2 = panouSus2();
        JPanel content3 = panouSus();
        JPanel p2=panouBut();
        JPanel spp=panouJos();
        JPanel contentP=panouPrincipal(content3, content, content2,p2,spp);
        this.setContentPane(contentP);
        this.pack();
        this.setTitle("Tema1 - Calculator de polinoame");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void mul(ActionListener mal) {
        b1.addActionListener(mal);
    }
    public void div(ActionListener mal) {
        b2.addActionListener(mal);
    }
    public void add(ActionListener mal) {
        b3.addActionListener(mal);
    }
    public void sub(ActionListener mal) {
        b4.addActionListener(mal);
    }
    public void derivata(ActionListener mal) {
        b5.addActionListener(mal);
    }
    public void integrala(ActionListener mal) {
        b6.addActionListener(mal);
    }
    public void equ(ActionListener mal) {
        b7.addActionListener(mal);
    }
    public void setRest(String s2) {
        rest.setText(s2);
    }
}
