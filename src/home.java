import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class home extends JFrame implements ActionListener {
    JButton add, view, update, remove;
    home(){
        getContentPane().setBackground(Color.gray);
        JLabel heading = new JLabel("Student Management System");
        heading.setBounds(400,10,1400,500);
        heading.setFont(new Font("serif", Font.BOLD,30));
        add(heading);

        add = new JButton("Add students");
        add.setBounds(400,300,170,50);
        add.setBackground(Color.black);
        add.setForeground(Color.white);
        add.addActionListener(this);
        add(add);

        view = new JButton("view students");
        view.setBounds(600,300,170,50);
        view.setBackground(Color.black);
        view.setForeground(Color.white);
        view.addActionListener(this);
        add(view);

        update = new JButton("update students");
        update.setBounds(400,400,170,50);
        update.setBackground(Color.black);
        update.setForeground(Color.white);
        update.addActionListener(this);
        add(update);

        remove = new JButton("remove students");
        remove.setBounds(600,400,170,50);
        remove.setBackground(Color.black);
        remove.setForeground(Color.white);
        remove.addActionListener(this);
        add(remove);

        setLayout(null);
        setSize(1120,630);
        setLocation(250,100);
        setVisible(true);


    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==add){
            setVisible(false);
            new AddStudent();

        }else if(ae.getSource()==view){
            setVisible(false);
            new ViewStudents();

        }else if(ae.getSource()==update){
            setVisible(false);
            new ViewStudents();

        }else{
            setVisible(false);
            new RemoveStudent();
        }
    }

    public static void main(String[] args) {
        new home();
    }
}
