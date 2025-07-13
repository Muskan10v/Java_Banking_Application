package Bank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class transcations extends JFrame implements ActionListener {
    JButton deposit,withdrawal,balance,change,exit,mini;
    String pinnumber;
    transcations(String pinnumber){
        this.pinnumber=pinnumber;
        JLabel text=new JLabel("Please select your Transactions");
        text.setBounds(180,80,700,35);
        text.setFont(new Font("Raleway", Font.BOLD,30));
        text.setForeground(Color.BLACK);
        add(text);

         deposit=new JButton("Deposit");
        deposit.setBounds(150,150,500,50);
        deposit.addActionListener(this);
        add(deposit);

         withdrawal=new JButton("Cash Withdrawal");
        withdrawal.setBounds(150,250,500,50);
        withdrawal.addActionListener(this);
        add(withdrawal);

       balance=new JButton("Check Balance");
        balance.setBounds(150,350,500,50);
        balance.addActionListener(this);
        add(balance);

        mini=new JButton("Mini Statement");
        mini.setBounds(150,450,500,50);
        mini.addActionListener(this);
        add(mini);

        change=new JButton("Pin Change");
        change.setBounds(150,550,500,50);
        change.addActionListener(this);
        add(change);

         exit=new JButton("Exit");
        exit.setBounds(500,650,200,30);
        exit.addActionListener(this);
        add(exit);


        setLayout(null);
        setSize(800,800);
        setLocation(400,0);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==exit){
            System.exit(0);
        }else if(e.getSource()==deposit){
            setVisible(false);
            new deposit(pinnumber).setVisible(true);
        }else if(e.getSource()==withdrawal){
            setVisible(false);
            new withdrawl(pinnumber).setVisible(true);
        }else if(e.getSource()==change){
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        }
        else if(e.getSource()==balance){
            setVisible(false);
            new Balance(pinnumber).setVisible(true);
        }else if(e.getSource()==mini){
            setVisible(false);
            new MiniStatement(pinnumber).setVisible(true);
        }
    }

    public static void main(String args[]){
        new transcations("");
    }
}
