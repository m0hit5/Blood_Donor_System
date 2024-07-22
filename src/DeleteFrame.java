import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class DeleteFrame extends JFrame{
Container c;
JButton btnSave,btnBack;
JLabel lblId;
JTextField txtId;
JPanel p1,p2;

DeleteFrame()
{
c=getContentPane();
c.setLayout(new BoxLayout(c,BoxLayout.Y_AXIS));

p1=new JPanel();
lblId=new JLabel("Id");
txtId=new JTextField(5);
p1.add(lblId);
p1.add(txtId);
c.add(p1);


p2=new JPanel();
btnSave=new JButton("Delete");
btnBack=new JButton("Back");
p2.add(btnSave);
p2.add(btnBack);
c.add(p2);

btnSave.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae){

try{

String id=txtId.getText();

if(id==null){
JOptionPane.showMessageDialog(c,"Id is empty");
txtId.requestFocus();
}

int Rollno=Integer.parseInt(id);

new Db().deleteDonor(Integer.parseInt(id));

} //end of try

catch(NumberFormatException e){
JOptionPane.showMessageDialog(c,"Please enter a number");
txtId.setText("");
txtId.requestFocus();
} catch (ClassNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}


txtId.setText("");
txtId.requestFocus();
}});

btnBack.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae){
HomeFrame h=new HomeFrame();
dispose();
}});

setSize(350,200);
setTitle("Delete Donor");
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);

}//end of constructor
}//end of class UpdateFrame
