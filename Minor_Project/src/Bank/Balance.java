package Bank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Balance extends JFrame implements ActionListener {
    String pinnumber;
    JButton back;
    Balance(String pinnumber){
        this.pinnumber=pinnumber;

        back=new JButton("BACK");
        back.setBounds(150,350,200,30);
        back.addActionListener(this);
        add(back);

        connection c=new connection();
        int balance=0;
        int b=0;
        int b2=0;
        try{
            ResultSet rs=c.s.executeQuery("select *from bank where pin= '"+pinnumber+"' ");
            while(rs.next()){
                if (rs.getString("type").equals("Deposit")) {
                    b=b+Integer.parseInt(rs.getString("amount"));
//                    JOptionPane.showMessageDialog(null,b);
                } else {
                    b2 =b2-( Integer.parseInt(rs.getString("amount")));
                    b2=b-b2;
//                    JOptionPane.showMessageDialog(null,b2);

                }

            }
            balance=b2;
            if(balance<0){
                balance=-(balance);
            }

        }
        catch (Exception ex) {
            System.out.println(ex);
        }

        JLabel text=new JLabel("Your current account balance is Rs. "+balance);
        text.setForeground(Color.BLACK);
        text.setFont(new Font("Raleway", Font.BOLD,20));
        text.setBounds(60,200,400,30);
        add(text);

        setLayout(null);
        setSize(500,500);
        setLocation(500,200);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new transcations(pinnumber).setVisible(true);

    }
    public static void main(String args[]){
        new Balance("").setVisible(true);
    }
}


