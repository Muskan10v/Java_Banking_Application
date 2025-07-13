package Bank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PinChange extends JFrame implements ActionListener {
    JPasswordField pin,repin;
    JButton change,back;
    String pinnumber;
    PinChange(String pinnumber){
      this.pinnumber=pinnumber;
        JLabel text=new JLabel("CHANGE YOUR PIN");
        text.setFont(new Font("Raleway", Font.BOLD,20));
        text.setForeground(Color.BLACK);
        text.setBounds(140,80,300,30);
        add(text);

        JLabel pintext=new JLabel("New PIN:");
        pintext.setFont(new Font("Raleway", Font.BOLD,17));
        pintext.setForeground(Color.BLACK);
        pintext.setBounds(60,150,150,30);
        add(pintext);

         pin=new JPasswordField();
        pin.setFont(new Font("Raleway", Font.BOLD,15));
        pin.setForeground(Color.BLACK);
        pin.setBounds(250,150,200,30);
        add(pin);

        JLabel repintext=new JLabel("Re-Enter New PIN:");
        repintext.setFont(new Font("Raleway", Font.BOLD,17));
        repintext.setForeground(Color.BLACK);
        repintext.setBounds(60,225,150,30);
        add(repintext);

      repin=new JPasswordField();
        repin.setFont(new Font("Raleway", Font.BOLD,15));
        repin.setForeground(Color.BLACK);
        repin.setBounds(250,225,200,30);
        add(repin);

       change=new JButton("CHANGE");
        change.setBounds(150,300,200,30);
        change.addActionListener(this);
        add(change);

        back=new JButton("BACK");
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
        if(e.getSource()==change){
        try{
            String npin=pin.getText();
            String rpin=repin.getText();
            if(!npin.equals(rpin)){
                JOptionPane.showMessageDialog(null,"Entered PIN does not match");
                return;
            }
            if(npin.equals("")){
                JOptionPane.showMessageDialog(null,"Please enter PIN");
                return;
            }
            if(rpin.equals("")){
                JOptionPane.showMessageDialog(null,"Please re-enter new PIN");
                return;
            }
            connection c=new connection();
            String query1="Update bank set pin='"+rpin+"' where pin='"+pinnumber+"' ";
            String query2="Update login set pin='"+rpin+"' where pin='"+pinnumber+"' ";
            String query3="Update signuptwo set pin='"+rpin+"' where pin='"+pinnumber+"' ";
            c.s.executeUpdate(query1);
            c.s.executeUpdate(query2);
            c.s.executeUpdate(query3);

            JOptionPane.showMessageDialog(null," PIN changed successfully");
            setVisible(false);
            new transcations(rpin).setVisible(true);
        }catch (Exception ex){
            System.out.println(ex);
        }
        }
        else{
            setVisible(false);
            new transcations(pinnumber).setVisible(true);
        }
    }


    public static void main(String args[]){
        new PinChange("").setVisible(true);
    }
}
