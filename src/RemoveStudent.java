import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class RemoveStudent extends JFrame implements ActionListener {
    Choice cstudent_id;
    JButton delete, back;

    RemoveStudent(){
        getContentPane().setBackground(Color.gray);
        setLayout(null);

        JLabel stuID = new JLabel("Student_Id");
        stuID.setBounds(50,50,100,30);
        add(stuID);

        cstudent_id=new Choice();
        cstudent_id.setBounds(200,50,150,30);
        add(cstudent_id);

        try{
            conn c=new conn();
            String query="select * from students";
            ResultSet rs =c.s.executeQuery(query);
            while (rs.next()){
                cstudent_id.add(rs.getString("student_id"));
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel std = new JLabel("standard");
        std.setBounds(50,100,100,30);
        add(std);
        JLabel Lstu_std = new JLabel();
        Lstu_std.setBounds(200,50,100,30);
        add(Lstu_std);

        JLabel Stu_div = new JLabel("division");
        Stu_div.setBounds(50,150,100,30);
        add(Stu_div);
        JLabel LStu_div  = new JLabel();
        LStu_div.setBounds(200,150,100,30);
        add(LStu_div);

        JLabel Stu_roll = new JLabel("roll no");
        Stu_roll.setBounds(50,200,100,30);
        add(Stu_roll);
        JLabel LStu_roll  = new JLabel();
        LStu_roll.setBounds(200,200,100,30);
        add(LStu_roll);


        try{
            conn c=new conn();
            String query="select * from students where student_id  ='"+cstudent_id.getSelectedItem()+"'";
            ResultSet rs =c.s.executeQuery(query);
            while (rs.next()){
                Lstu_std.setText(rs.getString("student_std"));
                LStu_div.setText(rs.getString("student_div"));
                LStu_roll.setText(rs.getString("student_Roll"));

            }

        }catch (Exception e){
            e.printStackTrace();
        }
        cstudent_id.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
                try{
                    conn c=new conn();
                    String query="select * from students where student_id  ='"+cstudent_id.getSelectedItem()+"'";
                    ResultSet rs =c.s.executeQuery(query);
                    while (rs.next()){
                        Lstu_std.setText(rs.getString("student_std"));
                        LStu_div.setText(rs.getString("student_div"));
                        LStu_roll.setText(rs.getString("student_Roll"));

                    }

                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        });

        delete=new JButton("Delete");
        delete.setBounds(80,300,100,30);
        delete.setBackground(Color.black);
        delete.setForeground(Color.white);
        delete.addActionListener(this);
        add(delete);

        back=new JButton("Back");
        back.setBounds(220,300,100,30);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);

        setSize(1000,400);
        setLocation(300,150);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==delete){
            try {
                conn c=new conn();
                String query="delete from students where student_id='"+cstudent_id.getSelectedItem()+"'";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Student details deleteed successfully");
                setVisible(false);
                new home();
            }catch (Exception e){
                e.printStackTrace();
            }
        }else{
            setVisible(false);
            new home();
        }

    }
    public static void main(String[] args) {
        new RemoveStudent();
    }
}
