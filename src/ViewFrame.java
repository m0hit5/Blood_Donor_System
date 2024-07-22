import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class ViewFrame extends JFrame{
Container c;
JButton btnBack;
TextArea txtData;
JPanel p1,p2;

ViewFrame()
{
c=getContentPane();
c.setLayout(new BoxLayout(c,BoxLayout.Y_AXIS));

p1=new JPanel();
txtData=new TextArea(0,40);
p1.add(txtData);
c.add(p1);


p2=new JPanel();
btnBack=new JButton("Back");
p2.add(btnBack);
c.add(p2);

try {
	txtData.setText(new Db().viewDonor());
} catch (ClassNotFoundException e) {
	e.printStackTrace();
}

btnBack.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae){
HomeFrame h=new HomeFrame();
dispose();
}});

setSize(500,600);
setTitle("View Donors");
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);

}//end of constructor
}//end of class ViewFrame
