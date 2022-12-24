import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class splash extends JFrame implements ActionListener {

    splash(){
        getContentPane().setBackground(Color.gray);
        setLayout(null);

        JLabel heading = new JLabel("Student Management System");
        heading.setBounds(500,3,1400,500);
        heading.setFont(new Font("serif",Font.PLAIN,50));
        add(heading);

        JButton clickhere = new JButton("Click Here To Continue");
        clickhere.setBounds(700,300,170,80);
        clickhere.setBackground(Color.black);
        clickhere.setForeground(Color.white);
        clickhere.addActionListener(this);
        add(clickhere);


        setSize(1160,650);
        setLocation(200,50);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new login();

    }
    public static void main(String[] args) {
        new splash();
    }
}
