import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
public class login extends JFrame implements ActionListener {

    JTextField Tusername, Tpassword;
    login(){
        getContentPane().setBackground(Color.gray);
        setLayout(null);

        JLabel username = new JLabel("Username");
        username.setBounds(40,20,100,30);
        add(username);

        Tusername = new JTextField();
        Tusername.setBounds(150,20,150,30);
        add(Tusername);

        JLabel password = new JLabel("Password");
        password.setBounds(40,60,100,30);
        add(password);

        Tpassword = new JTextField();
        Tpassword.setBounds(150,70,150,30);
        add(Tpassword);

        JButton login = new JButton("Login");
        login.setBounds(150,140,150,30);
        login.setBackground(Color.black);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);


        setSize(600,300);
        setLocation(450,200);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        try{
            String username=Tusername.getText();
            String password=Tpassword.getText();

            conn c = new conn();
            String query= "Select * from login where username ='"+username+"'and password= '"+password+"' ";
            ResultSet rs = c.s.executeQuery(query);

            if(rs.next()){
                setVisible(false);
                new home();
            }
            else {
                JOptionPane.showMessageDialog(null,"Invalid username or password");
                setVisible(false);
            }

        }catch (Exception e){
            e.printStackTrace();

        }

    }


    public static void main(String[] args) {
        new login();
    }
}
