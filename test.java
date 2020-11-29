import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class test extends JFrame implements ActionListener {

    private JButton[] jbtNum = new JButton[10];
    private JButton jbtAdd;
    private JButton jbtSubtract;
    private JButton jbtMultiply;
    private JButton jbtDivide;
    private JButton jbtConvert;
    private JButton jbtSolve;
    private JButton jbtClear;
    private double TEMP;
    private double SolveTEMP;
    private JTextField jtfResult;


    Boolean addBool = false;
    Boolean subBool = false;
    Boolean divBool = false;
    Boolean mulBool = false;

    String display = "";

    public test() {

        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(4, 5));

        p1.add(jbtNum[7] = new JButton("7"));
        p1.add(jbtNum[8]= new JButton("8"));
        p1.add(jbtNum[9]= new JButton("9"));

        p1.add(jbtAdd = new JButton("+"));

        p1.add(jbtNum[4]= new JButton("4"));
        p1.add(jbtNum[5]= new JButton("5"));
        p1.add(jbtNum[6]= new JButton("6"));

        p1.add(jbtSubtract = new JButton("-"));

        p1.add(jbtNum[1]= new JButton("1"));
        p1.add(jbtNum[2]= new JButton("2"));
        p1.add(jbtNum[3]= new JButton("3"));

        p1.add(jbtMultiply = new JButton("*"));
        p1.add(jbtNum[0]= new JButton("0"));
        p1.add(jbtConvert = new JButton("+/-"));
        p1.add(jbtDivide = new JButton("/"));
        p1.add(jbtSolve = new JButton("="));

        for (JButton jButton: jbtNum)
            jButton.addActionListener(this);

        JPanel p2 = new JPanel();
        p2.setLayout(new FlowLayout());
        p2.add(jtfResult = new JTextField(20));
        jtfResult.setHorizontalAlignment(JTextField.LEFT);
        jtfResult.setEditable(false);

        JPanel p3 = new JPanel();
        p3.setLayout(new FlowLayout());
        p3.add(jbtClear = new JButton("C"));


        JPanel p = new JPanel();
        p.setLayout(new BorderLayout());
        p.add(p2, BorderLayout.NORTH);
        p.add(p1, BorderLayout.CENTER);
        p.add(p3, BorderLayout.SOUTH);

        add(p);

        jbtAdd.addActionListener(this);
        jbtSubtract.addActionListener(this);
        jbtMultiply.addActionListener(this);
        jbtDivide.addActionListener(this);
        jbtSolve.addActionListener(this);
        jbtClear.addActionListener(this);
    }

    public void actionPerformed(ActionEvent actionEvent) {

        if (actionEvent.getSource() == jbtNum[1])
            jtfResult.setText(jtfResult.getText() + "1");

        else if (actionEvent.getSource() == jbtNum[2])
            jtfResult.setText(jtfResult.getText() + "2");

        else if (actionEvent.getSource() == jbtNum[3])
            jtfResult.setText(jtfResult.getText() + "3");

        else if (actionEvent.getSource() == jbtNum[4])
            jtfResult.setText(jtfResult.getText() + "4");

        else if (actionEvent.getSource() == jbtNum[5])
            jtfResult.setText(jtfResult.getText() + "5");

        else if (actionEvent.getSource() == jbtNum[6])
            jtfResult.setText(jtfResult.getText() + "6");

        else if (actionEvent.getSource() == jbtNum[7])
            jtfResult.setText(jtfResult.getText() + "7");

        else if (actionEvent.getSource() == jbtNum[8])
            jtfResult.setText(jtfResult.getText() + "8");

        else if (actionEvent.getSource() == jbtNum[9])
            jtfResult.setText(jtfResult.getText() + "9");

        else if (actionEvent.getSource() == jbtNum[0])
            jtfResult.setText(jtfResult.getText() + "0");

        else if (actionEvent.getSource() == jbtClear) {
            jtfResult.setText("");
            addBool = false;
            subBool = false;
            mulBool = false;
            divBool = false;

            TEMP = 0.0;
            SolveTEMP = 0.0;
        }

        else if (actionEvent.getSource() == jbtAdd ||
                 actionEvent.getSource() == jbtSubtract ||
                 actionEvent.getSource() == jbtMultiply ||
                 actionEvent.getSource() == jbtDivide) {

            TEMP = Double.parseDouble(jtfResult.getText());
            jtfResult.setText("");

            if (actionEvent.getSource() == jbtAdd)
                addBool = true;

            else if (actionEvent.getSource() == jbtSubtract)
                subBool = true;

            else if (actionEvent.getSource() == jbtMultiply)
                mulBool = true;

            else if (actionEvent.getSource() == jbtDivide)
                divBool = true;
        }

        else if (actionEvent.getSource() == jbtSolve) {
            SolveTEMP = Double.parseDouble(jtfResult.getText());

            if ( addBool )
                SolveTEMP = SolveTEMP + TEMP;

            else if ( subBool )
                SolveTEMP = SolveTEMP - TEMP;

            else if ( mulBool )
                SolveTEMP = SolveTEMP * TEMP;

            else if ( divBool )
                SolveTEMP = SolveTEMP / TEMP;

            jtfResult.setText(Double.toString(SolveTEMP));

            addBool = false;
            subBool = false;
            mulBool = false;
            divBool = false;
        }
    }

    public static void main(String[] args) {
        test calc = new test();
        calc.pack();
        calc.setLocationRelativeTo(null);
        calc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        calc.setVisible(true);
    }

}