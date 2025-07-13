package Bank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class deposit extends JFrame implements ActionListener {
   JButton deposit,back;
   JTextField amount;
    String pinnumber;

    deposit(String pinnumber){
        this.pinnumber=pinnumber;
        JLabel text=new JLabel("Enter the amount you want to deposit");
        text.setForeground(Color.BLACK);
        text.setFont(new Font("Raleway",Font.BOLD,20));
        text.setBounds(70,100,400,30);
        add(text);

         amount=new JTextField();
        amount.setFont(new Font("Raleway",Font.BOLD,25));
        amount.setBounds(50,170,400,30);
        add(amount);

        deposit=new JButton("Deposit");
        deposit.setBounds(150,280,200,30);
        deposit.addActionListener(this);
        add(deposit);

       back=new JButton("Back");
        back.setBounds(150,350,200,30);
        back.addActionListener(this);
        add(back);



        setLayout(null);
        setSize(500,500);
        setLocation(500,200);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==deposit){
            String number=amount.getText();
            Date date= new Date();
            if(number.equals("")){
                JOptionPane.showMessageDialog(null,"Please enter the amount you want to deposit");

            }else {
                try {
                    connection c = new connection();
                    String query = "insert into bank values ('" + pinnumber + "','" + date + "',' Deposit ','" + number + "')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Rs "+number+" Deposited Successfully");
                    setVisible(false);
                    new transcations(pinnumber).setVisible(true);
                }catch(Exception ex){
                    System.out.print(ex);
                }
            }


        } else if (e.getSource()==back) {
            setVisible(false);
            new transcations(pinnumber).setVisible(true);
        }

    }
    public static void main(String args[]){
        new deposit("");
    }

}
