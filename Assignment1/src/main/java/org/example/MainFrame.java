package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainFrame extends JFrame {
    private JLabel titlu;
    private JLabel poli1;
    private JLabel poli2;
     private JTextField polinom1;
    private JTextField polinom2;

    private JButton buttonAdd, buttonSubstract, buttonMultiply, buttonDivide, buttonEqual, buttonClear;

   public MainFrame(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        titlu=new JLabel();
        titlu.setText("Polinoame");
       titlu.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
       titlu.setBounds(350, 50, 2000, 20);
       getContentPane().add(titlu);

       polinom1=new JTextField();
       getContentPane().add(polinom1);

        polinom2=new JTextField();
       getContentPane().add(polinom2);

        buttonAdd.setBackground(Color.PINK);
        buttonSubstract.setBackground(Color.PINK);
        buttonMultiply.setBackground(Color.PINK);
        buttonDivide.setBackground(Color.PINK);
        buttonEqual.setBackground(Color.PINK);
        buttonClear.setBackground(Color.PINK);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){

    }

}
