import net.proteanit.sql.DbUtils;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class ViewStudents extends JFrame implements ActionListener {

    JTable table;
    Choice studentId;
    JButton search , print, update, back;
    ViewStudents(){
        getContentPane().setBackground(Color.gray);
        setLayout(null);

        JLabel IDsearch = new JLabel("Search by Student_id");
        IDsearch.setBounds(20,20,150,20);
        add(IDsearch);

        studentId =new Choice();
        studentId.setBounds(180,20,150,20);
        add(studentId);

        try{
            conn c=new conn();
            ResultSet rs=c.s.executeQuery("select * from students");
            while (rs.next()){
                studentId.add(rs.getString("Student_id"));
            }

        }catch(Exception e){

        }

        table =new JTable();

        try{
            conn c=new conn();
            ResultSet rs=c.s.executeQuery("select * from students");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            while (rs.next()){
                studentId.add(rs.getString("Student_id"));
            }

        }catch(Exception e){

        }

        JScrollPane jsp=new JScrollPane(table);
        jsp.setBounds(0,100,900,600);
        add(jsp);

        search = new JButton("Search");
        search.setBounds(20,70,80,20);
        search.setBackground(Color.black);
        search.setForeground(Color.white);
        search.addActionListener(this);
        add(search);

        print = new JButton("Print");
        print.setBounds(120,70,80,20);
        print.setBackground(Color.black);
        print.setForeground(Color.white);
        print.addActionListener(this);
        add(print);

        update = new JButton("Update");
        update.setBounds(220,70,80,20);
        update.setBackground(Color.black);
        update.setForeground(Color.white);
        update.addActionListener(this);
        add(update);

        back = new JButton("Back");
        back.setBounds(320,70,80,20);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);

        setSize(900,700);
        setLocation(300,100);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==search){
            String query ="select * from students where student_id='"+studentId.getSelectedItem()+"'";
            try {
                conn c=new conn();
                ResultSet rs =c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));

            }catch (Exception e){
                e.printStackTrace();
            }

        }else if(ae.getSource()==print){
            try {
                table.print();
            }catch (Exception e){
                e.printStackTrace();
            }

        }else if(ae.getSource()==update){
            setVisible(false);
            new UpdateStudent(studentId.getSelectedItem());

        }
        else{
            setVisible(false);
            new home();
        }
    }

    public static void main(String[] args) {
        new ViewStudents();
    }
}
