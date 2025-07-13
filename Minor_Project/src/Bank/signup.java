
package Bank;

import com.toedter.calendar.JDateChooser;

import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.*;
import java.lang.String;


public class signup extends JFrame implements ActionListener {
    long random;
    JTextField nametf, Fnametf, emtf, addtf, citytf, statetf, pintf,adhtf,pantf;
    JRadioButton male, female, married, unmarried ;
    JComboBox rel,eatf;
    JDateChooser dateChooser;

    signup() {
        setLayout(null);

        Random ran = new Random();
        random = Math.abs((ran.nextLong() % 9000L) + 10000L);
        JLabel formno = new JLabel("APPLICATION FORM NO. " + random);
        formno.setFont(new Font("Raleway", Font.BOLD, 38));
        formno.setBounds(130, 60, 600, 30);
        add(formno);

        JLabel pd = new JLabel("PERSONAL DETAILS: ");
        pd.setFont(new Font("Raleway", Font.BOLD, 28));
        pd.setBounds(250, 120, 400, 30);
        add(pd);

        JLabel name = new JLabel("Name:");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(180, 190, 300, 30);
        add(name);
        nametf = new JTextField();
        nametf.setFont(new Font("Raleway", Font.BOLD, 15));
        nametf.setBounds(350, 190, 300, 30);
        add(nametf);

        JLabel fname = new JLabel("Father's Name:");
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(180, 220, 300, 30);
        add(fname);
        Fnametf = new JTextField();
        Fnametf.setFont(new Font("Raleway", Font.BOLD, 15));
        Fnametf.setBounds(350, 220, 300, 30);
        add(Fnametf);

        JLabel dob = new JLabel("Date Of Birth:");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(180, 250, 300, 30);
        add(dob);
        dateChooser=new JDateChooser();
        dateChooser.setForeground(Color.WHITE);
        dateChooser.setBounds(350, 250, 300, 30);
        add(dateChooser);

        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(180, 280, 300, 30);
        add(gender);
        male = new JRadioButton("Male");
        male.setBounds(350, 280, 60, 30);
        male.setBackground(Color.WHITE);
        add(male);
        female = new JRadioButton("Female");
        female.setBounds(420, 280, 80, 30);
        female.setBackground(Color.WHITE);
        add(female);
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);

        JLabel email = new JLabel("Email:");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(180, 310, 300, 30);
        add(email);
        emtf = new JTextField();
        emtf.setFont(new Font("Raleway", Font.BOLD, 15));
        emtf.setBounds(350, 310, 300, 30);
        add(emtf);

        JLabel maritial = new JLabel("Maritial Status:");
        maritial.setFont(new Font("Raleway", Font.BOLD, 20));
        maritial.setBounds(180, 340, 300, 30);
        add(maritial);
        married = new JRadioButton("Married");
        married.setBounds(350, 340, 80, 30);
        married.setBackground(Color.WHITE);
        add(married);
        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(430, 340, 100, 30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);
        ButtonGroup mdGroup = new ButtonGroup();
        mdGroup.add(married);
        mdGroup.add(unmarried);

        JLabel address = new JLabel("Address:");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(180, 370, 300, 30);
        add(address);
        addtf = new JTextField();
        addtf.setFont(new Font("Raleway", Font.BOLD, 15));
        addtf.setBounds(350, 370, 300, 30);
        add(addtf);

        JLabel city = new JLabel("City:");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(180, 400, 300, 30);
        add(city);
        citytf = new JTextField();
        citytf.setFont(new Font("Raleway", Font.BOLD, 15));
        citytf.setBounds(350, 400, 300, 30);
        add(citytf);

        JLabel state = new JLabel("State:");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(180, 430, 300, 30);
        add(state);
        statetf = new JTextField();
        statetf.setFont(new Font("Raleway", Font.BOLD, 15));
        statetf.setBounds(350, 430, 300, 30);
        add(statetf);

        JLabel pincode = new JLabel("Pincode:");
        pincode.setFont(new Font("Raleway", Font.BOLD, 20));
        pincode.setBounds(180, 460, 300, 30);
        add(pincode);
        pintf = new JTextField();
        pintf.setFont(new Font("Raleway", Font.BOLD, 15));
        pintf.setBounds(350, 460, 300, 30);
        add(pintf);

         JLabel religion = new JLabel("Religion:");
         religion.setFont(new Font("Raleway", Font.BOLD, 20));
         religion.setBounds(180, 490, 300, 30);
         add(religion);
         String valReligion[]={"","Hindu","Muslims","Sikh","Christians","Others"};
         rel=new JComboBox(valReligion);
         rel.setBounds(350,490,300,30);
         rel.setBackground(Color.WHITE);
         add(rel);

         JLabel aadhar = new JLabel("Aadhar Number:");
         aadhar.setFont(new Font("Raleway", Font.BOLD, 20));
         aadhar.setBounds(180, 525, 300, 30);
         add(aadhar);
         adhtf = new JTextField();
         adhtf.setFont(new Font("Raleway", Font.BOLD, 15));
         adhtf.setBounds(350, 525, 300, 30);
         add(adhtf);

        JLabel pan = new JLabel("PAN Number:");
        pan.setFont(new Font("Raleway", Font.BOLD, 20));
        pan.setBounds(180, 555, 300, 30);
        add(pan);
        pantf = new JTextField();
        pantf.setFont(new Font("Raleway", Font.BOLD, 15));
        pantf.setBounds(350, 555, 300, 30);
        add(pantf);

        JLabel ea = new JLabel("Existing Account:");
        ea.setFont(new Font("Raleway", Font.BOLD, 20));
        ea.setBounds(180, 585, 300, 30);
        add(ea);
        String valea[]={"","Yes","No"};
        eatf=new JComboBox(valea);
        eatf.setBackground(Color.WHITE);
        eatf.setBounds(350, 585, 300, 30);
        add(eatf);

        JButton submit =new JButton("Next");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(450,660,200,30);
        submit.addActionListener(this);
        add(submit);

        getContentPane().setBackground(Color.WHITE);
        setSize(800, 800);
        setLocation(400,0);
        setLocation(350, 10);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        String formno= " "+ random;
        String name=nametf.getText();
        String fname=Fnametf.getText();
        String dob=((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender=null;
        if(male.isSelected()){
            gender="Male";
        }else if(female.isSelected()){
            gender="Female";
        }
        String email=emtf.getText();
        String maritial=null;
        if(married.isSelected()){
            maritial="married";
        }else if(unmarried.isSelected()){
            maritial="unmarried";
        }
        String address=addtf.getText();
        String city=citytf.getText();
        String state=statetf.getText();
        String pin=pintf.getText();
        String religion=(String) rel.getSelectedItem();
        String aadhar=adhtf.getText();
        String pan=pantf.getText();
        String ea=(String) eatf.getSelectedItem();


        try{
            if(name.equals("")){
                JOptionPane.showMessageDialog(null,"Name is required");
            }else{
                connection c=new connection();
                String query="insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+maritial+"','"+address+"','"+city+"','"+state+"','"+pin+"','"+religion+"','"+aadhar+"','"+pan+"','"+ea+"')";
                c.s.executeUpdate(query);
                setVisible(false);
                new signuptwo(formno).setVisible(true);
            }

        }catch(Exception e){
            System.out.println(e);
        }

    }

    public static void main(String args[]) {

        new signup();
    }
}
