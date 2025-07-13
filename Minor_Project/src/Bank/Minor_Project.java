package Bank;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.*;

public class Minor_Project extends JFrame  implements ActionListener {

    JButton login, signup, clr;
    JTextField accnofd, pinfd;

    Minor_Project() {

        setTitle("Simple Banking System");
        setLayout(null);

        JLabel text = new JLabel("ATM");
        text.setFont(new Font("Osward", Font.BOLD, 42));
        text.setBounds(325, 40, 450, 80);
        add(text);

        JLabel accno = new JLabel("Card Number : ");
        accno.setFont(new Font("Algeria", Font.BOLD, 28));
        accno.setBounds(100, 160, 500, 70);
        add(accno);
        accnofd = new JTextField();
        accnofd.setBounds(350, 170, 300, 50);
        add(accnofd);

        JLabel pin = new JLabel("PIN: ");
        pin.setFont(new Font("Algeria", Font.BOLD, 28));
        pin.setBounds(130, 240, 500, 70);
        add(pin);
        pinfd = new JTextField();
        pinfd.setBounds(350, 250, 300, 50);
        add(pinfd);

        clr = new JButton("CLEAR");
        clr.setBounds(200, 400, 400, 30);
        clr.setBackground(Color.BLACK);
        clr.setForeground(Color.WHITE);
        clr.addActionListener(this);
        add(clr);

        login = new JButton("SIGN IN");
        login.setBounds(200, 500, 400, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        signup = new JButton("SIGN UP");
        signup.setBounds(200, 600, 400, 30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);

        getContentPane().setBackground(Color.WHITE);
        setSize(800, 800);
        setLocation(400,0);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == clr) {
            accnofd.setText("");
        } else if (e.getSource() == login) {
            connection c = new connection();
            String cardnumber = accnofd.getText();
            String pinnumber = pinfd.getText();
            String query = "select *from login where cardnumber ='" + cardnumber + "' and pin= '" + pinnumber + "'";
            try {
                ResultSet rs = c.s.executeQuery(query);
                if (rs.next()) {
                    setVisible(false);
                    new transcations(pinnumber).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin");
                }
            } catch (Exception ex) {
                System.out.println(ex);
            }

        } else if (e.getSource() == signup) {
            setVisible(false);
            new signup().setVisible(true);
        }
    }
        public static void main(String args[]){
            new Minor_Project();
        }

}

