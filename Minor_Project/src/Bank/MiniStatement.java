package Bank;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class MiniStatement extends JFrame implements ActionListener {

    JButton b1, b2;
    JLabel l1;
    String pinnumber;

    MiniStatement(String pinnumber) {
        super("Mini Statement");
        this.pinnumber=pinnumber;
        getContentPane().setBackground(Color.WHITE);
        setSize(400, 600);
        setLocation(20, 20);

        l1 = new JLabel();
        add(l1);

        JLabel l2 = new JLabel("ABC Bank");
        l2.setBounds(150, 20, 100, 20);
        add(l2);

        JLabel l3 = new JLabel();
        l3.setBounds(20, 80, 300, 20);
        add(l3);

        JLabel l4 = new JLabel();
        l4.setBounds(20, 400, 300, 20);
        add(l4);

        try {
            connection c = new connection();
            ResultSet rs = c.s.executeQuery("select * from login where pin = '" + pinnumber + "'");
            while (rs.next()) {
                l3.setText("Card Number:    " + rs.getString("cardnumber").substring(0, 4) + "XXXXXXXX" + rs.getString("cardnumber").substring(12));
            }
        } catch (Exception e) {
            System.out.println(e);
        }


        try {
            int balance = 0;
            int b=0;
            int b2=0;
            connection c1 = new connection();
            ResultSet rs = c1.s.executeQuery("SELECT * FROM bank where pin = '" + pinnumber + "'");
            while (rs.next()) {
                l1.setText(l1.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
                if (rs.getString("type").equals("Deposit")) {
                    b=b+Integer.parseInt(rs.getString("amount"));
                } else {
                    b2 =b2-( Integer.parseInt(rs.getString("amount")));
                    b2=b-b2;
                }
            }
            balance=b2;
            if(balance<0){
                balance=-(balance);
            }

            l4.setText("Your total Balance is Rs " + balance);
        } catch (Exception e) {
            e.printStackTrace();
        }

        setLayout(null);
        b1 = new JButton("Exit");
        add(b1);

        b1.addActionListener(this);

        l1.setBounds(20, 140, 400, 200);
        b1.setBounds(20, 500, 100, 25);
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new transcations(pinnumber).setVisible(true);
    }

    public static void main(String[] args) {
        new MiniStatement("").setVisible(true);
    }
}


