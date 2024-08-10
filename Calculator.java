import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Calculator implements ActionListener
{
    JFrame f = new JFrame();
    JButton b[] = new JButton[16];
    String[] caption = {"7","8","9","+","4","5","6","-","1","2","3","*","0",".","=","/"};
    JLabel l = new JLabel();
    JPanel p = new JPanel();
    String digits="1234567890"; 
    String operators ="+-*/";
    int k=0;
    String op1 , op2 , op; 
    Calculator()
    {
        
        l.setFont(new Font("arial" , 1 , 30));  
        p.setLayout(new GridLayout(4,4));
        for(int i=0;i<16;i++)
        {
             b[i]=new JButton(caption[i]);
             p.add(b[i]);
             b[i].setFont(new Font("arial" , 1 , 30));
             b[i].addActionListener(this);
        }
        f.add(l,BorderLayout.NORTH);
        f.add(p);
        f.setSize(700,700);
        f.setVisible(true);
    }
    public static void main(String[] args) {
        Calculator c = new Calculator();
    }
    public void actionPerformed(ActionEvent e )
    {
        JButton bt=(JButton)e.getSource();
        String text=bt.getText();
        if(digits.contains(text))
        {
            if(k==0)
            {
                l.setText(text);
                k=1;
            }
            else
            {
                l.setText(l.getText()+text);
            }
        }
        else
        {
            if(operators.contains(text))
            {
                op1=l.getText();
                op=text;
                k=0;
            }
            else
            {
                op2=l.getText();
                calc();
            }
        }
    }
    void calc()
    { 
        float x,y,z;
        x=Float.parseFloat(op1);
        y=Float.parseFloat(op2);
        if(op.equals("+"))
        z=x+y;
        else if(op.equals("-"))
        z=x-y;
        else if(op.equals("*"))
        z=x*y;
        else
        z=x/y;
        l.setText(""+z); 
    }
}