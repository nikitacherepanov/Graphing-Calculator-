import javax.swing.*;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Calculator {

    // Declaring Calculator Components
    JPanel windowsContent;
    JTextField displayField;
    JPanel windowsContent2;
    JTextField displayField2;
    JButton button0;
    JButton button1;
    JButton button2;
    JButton button3;
    JButton button4;
    JButton button5;
    JButton button6;
    JButton button7;
    JButton button8;
    JButton button9;
    JButton buttonPoint;
    JButton buttonEqual;
    JButton buttonPlus;
    JButton buttonMinus;
    JButton buttonDivide;
    JButton buttonMultiply;
    JPanel pl;
    JPanel pl2;

    // In the designer, all the components are created and added to the frame using
    // a combination of BorderLayout and GridLayout
    Calculator() {
        windowsContent = new JPanel();
        windowsContent2 = new JPanel();
        // Define the schema for this panel
        BorderLayout bl = new BorderLayout();
        windowsContent.setLayout(bl);

        BorderLayout bl2 = new BorderLayout();
        windowsContent2.setLayout(bl2);
        // Create and display the field, then Add it to the northern part of the window
        displayField = new JTextField(30);
        windowsContent.add("North", displayField);
        // Create buttons using the constructor of the JButton class, which takes the
        // text of the button as a parameter

        button0 = new JButton("0");
        button1 = new JButton("1");
        button2 = new JButton("2");
        button3 = new JButton("3");
        button4 = new JButton("4");
        button5 = new JButton("5");
        button6 = new JButton("6");
        button7 = new JButton("7");
        button8 = new JButton("8");
        button9 = new JButton("9");
        buttonPoint = new JButton(".");
        buttonEqual = new JButton("=");
        buttonPlus = new JButton("+");
        buttonMinus = new JButton("-");
        buttonDivide = new JButton("/");
        buttonMultiply = new JButton("*");

        // Create a panel with a GridLayout that contains 12 buttons - 10 buttons with
        // numbers and 2 buttons with a period and an equal sign
        pl = new JPanel();
        pl2 = new JPanel();
        GridLayout gl = new GridLayout(4, 3);
        pl.setLayout(gl);
        GridLayout gl2 = new GridLayout(3, 1);
        pl2.setLayout(gl2);

        // Adding Buttons to the PL Panel
        pl.add(button0);
        pl.add(button1);
        pl.add(button2);
        pl.add(button3);
        pl.add(button4);
        pl.add(button5);
        pl.add(button6);
        pl.add(button7);
        pl.add(button8);
        pl.add(button9);
        pl.add(buttonPoint);
        pl.add(buttonEqual);
        pl2.add(buttonPlus);
        pl2.add(buttonMinus);
        pl2.add(buttonDivide);
        pl2.add(buttonMultiply);

        windowsContent.add("Center", pl);
        windowsContent.add("East", pl2);

        JFrame frame = new JFrame("Calculator");
        frame.setContentPane(windowsContent);

        frame.pack();

        frame.setVisible(true);

        CalculatorEngine calcEngine = new CalculatorEngine(this);
        button0.addActionListener(calcEngine);
        button1.addActionListener(calcEngine);
        button2.addActionListener(calcEngine);
        button3.addActionListener(calcEngine);
        button4.addActionListener(calcEngine);
        button5.addActionListener(calcEngine);
        button6.addActionListener(calcEngine);
        button7.addActionListener(calcEngine);
        button8.addActionListener(calcEngine);
        button9.addActionListener(calcEngine);

        buttonEqual.addActionListener(calcEngine);
        buttonPoint.addActionListener(calcEngine);
        buttonPlus.addActionListener(calcEngine);
        buttonMinus.addActionListener(calcEngine);
        buttonDivide.addActionListener(calcEngine);
        buttonMultiply.addActionListener(calcEngine);

    }

    public class CalculatorEngine implements ActionListener {
        Calculator parent;
        char selectedAction = ' ';
        double currentResult = 0;

        CalculatorEngine(Calculator parent) {
            this.parent = parent;
        }

        public void actionPerformed(ActionEvent e) {
            JButton clickedButton = (JButton) e.getSource();
            String dispFieldText = parent.displayField.getText();
            double displayValue = 0;
            if (!"".equals(dispFieldText)) {
                displayValue = Double.parseDouble(dispFieldText);
            }
            Object src = e.getSource();
            if (src == buttonPlus) {
                selectedAction = '+';
                currentResult = displayValue;
                this.parent.displayField.setText("");
            } else if (src == buttonMinus) {
                selectedAction = '-';
                currentResult = displayValue;
                this.parent.displayField.setText("");
            } else if (src == buttonDivide) {
                selectedAction = '/';
                currentResult = displayValue;
                parent.displayField.setText("");
            } else if (src == buttonMultiply) {
                selectedAction = '*';
                currentResult = displayValue;
                this.parent.displayField.setText("");
            }
            if (selectedAction == '+') {
                currentResult += displayValue;
                this.parent.displayField.setText("" + currentResult);
            } else if (selectedAction == '-') {
                currentResult -= displayValue;
                parent.displayField.setText("" + currentResult);
            } else if (selectedAction == '/') {
                currentResult /= displayValue;
                this.parent.displayField.setText("" + currentResult);
            } else if (selectedAction == '*') {
                currentResult *= displayValue;
                parent.displayField.setText("" + currentResult);
            } else {
                String clickedButtonLabel = clickedButton.getText();
                this.parent.displayField.setText(dispFieldText + clickedButtonLabel);
            }

        }
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
    }
}