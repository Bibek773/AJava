package Ch3Swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SwingJframe  extends JFrame implements ActionListener{

    //Part1 defining
    JLabel nameL, genL, CouL, timeL, setL;
    JTextField nameT;
    JRadioButton mr, fr;
    JCheckBox javac, cpc;
    JComboBox timeC;
    JTextArea ta;
    JButton ok;

    SwingJframe(){
        //Part 2 initialing
        nameL = new JLabel("Name");
        genL = new JLabel("Gender");
        CouL = new JLabel("Course");
        timeL = new JLabel("Time");
        setL = new JLabel("Selection");
        nameT = new JTextField(20);
        mr = new JRadioButton("Male");
        fr = new JRadioButton("Female");
        ButtonGroup grp = new ButtonGroup();
        grp.add(mr); grp.add(fr);
        javac=new JCheckBox("Java");
        cpc=new JCheckBox("C++");
        String[] time ={"Morning","Day","Evening"};
        timeC= new JComboBox(time);
        ta= new JTextArea(10,50);
        ok = new JButton("OK");
        ok.addActionListener(this);

        //part 3 layout
        setLayout(new GridLayout(5,4));
        add(nameL); add(nameT);
        add(genL); add(mr); add(fr);
        add(CouL); add(javac);add(cpc);
        add(timeL); add(timeC);
        add(setL); add(ta);
        add(ok);
        setSize(500,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);


    }
    //part 4 action


    @Override
    public void actionPerformed(ActionEvent e) {
        ta.append("Name:"+ nameT.getText() +"\n");
        String g= "Female";
        if(mr.isSelected()){
            g="Male";
        }
        ta.append("Gender:"+ g+"\n");
        String c= "";
        if(javac.isSelected()){
            c="java";

        }
        if(cpc.isSelected()){
            c+=", c++";
        }


        String t= (String) timeC.getSelectedItem();
        ta.append("Course:"+ c+ "\n");
        ta.append("Time:"+t);

    }
    public static void main(String[] args){
        new SwingJframe();
    }
}
