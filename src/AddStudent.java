import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddStudent extends JFrame implements ActionListener {

    JTextField TStudent_id, TStudent_fname, TStudent_lname, TStudent_std, TStudent_div, TStudent_bloodGroup,TStudent_rollno;
    JButton Add, back;
    AddStudent(){
        getContentPane().setBackground(Color.gray);
        setLayout(null);

        JLabel heading = new JLabel("Add Student Detail");
        heading.setBounds(50,20,1000,100);
        heading.setFont(new Font("serif", Font.BOLD,30));
        add(heading);

        JLabel Student_id = new JLabel("Student_id");
        Student_id.setBounds(40,100,100,30);
        add(Student_id);

        TStudent_id = new JTextField();
        TStudent_id.setBounds(150,100,150,30);
        add(TStudent_id);


        JLabel Student_fname = new JLabel("First name");
        Student_fname.setBounds(40,150,100,30);
        add(Student_fname);

        TStudent_fname = new JTextField();
        TStudent_fname.setBounds(150,150,150,30);
        add(TStudent_fname);

        JLabel Student_lname = new JLabel("Last name");
        Student_lname.setBounds(40,200,100,30);
        add(Student_lname);

        TStudent_lname = new JTextField();
        TStudent_lname.setBounds(150,200,150,30);
        add(TStudent_lname);

        JLabel Student_std = new JLabel("Standard");
        Student_std.setBounds(40,250,100,30);
        add(Student_std);

        TStudent_std = new JTextField();
        TStudent_std.setBounds(150,250,150,30);
        add(TStudent_std);

        JLabel Student_div = new JLabel("Division");
        Student_div.setBounds(40,300,100,30);
        add(Student_div);

        TStudent_div = new JTextField();
        TStudent_div.setBounds(150,300,150,30);
        add(TStudent_div);

        JLabel Student_bloodGroup = new JLabel("Blood group");
        Student_bloodGroup.setBounds(40,350,100,30);
        add(Student_bloodGroup);

        TStudent_bloodGroup = new JTextField();
        TStudent_bloodGroup.setBounds(150,350,150,30);
        add(TStudent_bloodGroup);

        JLabel Student_rollno = new JLabel("Roll Number");
        Student_rollno.setBounds(40,400,100,30);
        add(Student_rollno);

        TStudent_rollno = new JTextField();
        TStudent_rollno.setBounds(150,400,150,30);
        add(TStudent_rollno);


        Add = new JButton("Add Details");
        Add.setBounds(70,500,150,30);
        Add.setBackground(Color.black);
        Add.setForeground(Color.white);
        Add.addActionListener(this);
        add(Add);

        back = new JButton("Back");
        back.setBounds(250,500,150,30);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);



        setSize(900,700);
        setLocation(300,50);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== Add){
            String Student_id=TStudent_id.getText();
            String Student_fname=TStudent_fname.getText();
            String Student_lname=TStudent_lname.getText();
            String Student_std=TStudent_std.getText();
            String Student_div=TStudent_div.getText();
            String Student_bloodGroup=TStudent_bloodGroup.getText();
            String Student_rollno=TStudent_rollno.getText();

            try{
                conn conn=new conn();
                String query="insert into students values('"+Student_id+"', '"+Student_fname+"', '"+Student_lname+"', '"+Student_std+"','"+Student_div+"','"+Student_bloodGroup+"','"+Student_rollno+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Details Added Successfully");
                setVisible(false);
                new home();

            }catch (Exception e){
                e.printStackTrace();
            }


        }else {
            setVisible(false);
            new home();
        }

    }


    public static void main(String[] args) {
        new AddStudent();
    }
}
