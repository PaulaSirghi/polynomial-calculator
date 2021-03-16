package Calculator;
import Controller.Controller;
import View.View;
import Model.Operatii;
public class CalculatorMVC {
    public static void main(String[] args) {

        Operatii o      = new Operatii();
        View view       = new View(o);
        Controller controller = new Controller(o, view);
        view.setVisible(true);
    }
}
