package Ch3Swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UiButton extends JFrame implements ActionListener {

    JLabel Num1, Num2, Num3;
    JTextField a, b, c;
    JButton ok;

    UiButton() {

        Num1 = new JLabel("First Number:");
        Num2 = new JLabel("Second Number:");
        Num3 = new JLabel("Result:");
        a = new JTextField(20);
        b = new JTextField(20);
        c = new JTextField(20);
        ok = new JButton("OK");

        ok.addActionListener(this);


        setLayout(new GridLayout(4, 2, 10, 10));

        add(Num1);
        add(a);
        add(Num2);
        add(b);
        add(Num3);
        add(c);
        add(new JLabel());
        add(ok);


        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        int n1 = Integer.parseInt(a.getText());
        int n2 = Integer.parseInt(b.getText());
        int sum = n1 + n2;
        c.setText(String.valueOf(sum));

    }


    public static void main(String[] args) {
        new UiButton();
    }

}