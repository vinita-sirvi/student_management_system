import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateStudent extends JFrame implements ActionListener{


    JTextField TStudent_id, TStudent_fname, TStudent_lname, TStudent_std, TStudent_div, TStudent_bloodGroup,TStudent_rollno;
    JButton Add, back;
    String student_id;
    UpdateStudent(String student_id){
        this.student_id=student_id;
        getContentPane().setBackground(Color.gray);
        setLayout(null);

        JLabel heading = new JLabel("Update Student Detail");
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

        JLabel lblStudent_fname = new JLabel();
        lblStudent_fname.setBounds(150,150,150,30);
        add(lblStudent_fname);

        JLabel Student_lname = new JLabel("Last name");
        Student_lname.setBounds(40,200,100,30);
        add(Student_lname);

        JLabel lblStudent_lname = new JLabel();
        lblStudent_lname.setBounds(150,200,150,30);
        add(lblStudent_lname);

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

        JLabel lblStudent_bloodGroup = new JLabel();
        lblStudent_bloodGroup.setBounds(150,350,150,30);
        add(lblStudent_bloodGroup);

        JLabel Student_rollno = new JLabel("Roll Number");
        Student_rollno.setBounds(40,400,100,30);
        add(Student_rollno);

        TStudent_rollno = new JTextField();
        TStudent_rollno.setBounds(150,400,150,30);
        add(TStudent_rollno);

        try {
            conn c = new conn();
            String query ="select * from students where student_id ='"+student_id+"'";
            ResultSet rs =c.s.executeQuery(query);
            while (rs.next()){
                TStudent_id.setText(rs.getString("student_id"));
                lblStudent_fname.setText(rs.getString("student_fname"));
                lblStudent_lname.setText(rs.getString("student_sname"));
                TStudent_std.setText(rs.getString("student_std"));
                TStudent_div.setText(rs.getString("student_div"));
                lblStudent_bloodGroup.setText(rs.getString("student_bloodgroup"));
                TStudent_rollno.setText(rs.getString("student_roll"));


            }
        }catch (Exception e){
            e.printStackTrace();
        }


        Add = new JButton("Update Details");
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
            String Student_std=TStudent_std.getText();
            String Student_div=TStudent_div.getText();
            String Student_rollno=TStudent_rollno.getText();

            try{
                conn conn=new conn();
                String query="update students set student_std='"+Student_std+"',student_div='"+Student_div+"',student_roll='"+Student_rollno+"'where student_id='"+Student_id+"'";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Details Updated Successfully");
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
         new UpdateStudent("");
    }
}
