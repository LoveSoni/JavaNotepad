import java.awt.event.*;
import javax.swing.*;
class Rep extends JDialog implements ActionListener
{	int inc=-1;
	JLabel lb1,lb2;
	JTextField tft1,tft2;
	JButton btn1,btn2,btn3,btn4;
	public Rep()
	{
		lb1=new JLabel("Find what:");lb1.setBounds(10,10,70,15);
		lb2=new JLabel("Replace with:");lb2.setBounds(10,40,80,15);
		tft1=new JTextField();tft1.setBounds(95,10,155,20);
		tft2=new JTextField();tft2.setBounds(95,40,155,20);
		btn1=new JButton("Find Next");btn1.setBounds(255,7,105,20);
		btn2=new JButton("Replace All");btn2.setBounds(255,40,105,20);
		btn4=new JButton("Cancel");btn4.setBounds(255,73,105,20);
		add(lb1);add(lb2);add(tft1);add(tft2);add(btn1);add(btn2);add(btn4);
		// actionListener
		btn1.addActionListener(this);btn2.addActionListener(this);
		btn4.addActionListener(this);
		setTitle("Replace");
		setLayout(null);
		setVisible(true);
		setSize(375,170);
		setResizable(false);
		setLocation(400,100);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e)
	{	String tofind=tft1.getText();
		JButton temp=(JButton)e.getSource();
		if(temp==btn4)
		{	
			dispose();
		}
		else if(temp==btn1)
		{try{
			inc=inc+1;
			finddNext(inc);
		}catch(Exception ex)
		{}
		}
		else if(temp==btn2)
		{try{
			Notepad.ta.setText(Notepad.ta.getText().replaceAll(tft1.getText(),tft2.getText()));
		 }catch(Exception ex)
		 {
		 	JOptionPane.showMessageDialog(this,"Can not Replace");
		 }	
		}
		
	}
	String st=Notepad.ta.getText();
	int a[]=new int[st.length()];
	public void findNext()
	{
		int pos=st.indexOf(tft1.getText());
		int i=0;
		if(pos==-1)
		{
			JOptionPane.showMessageDialog(this,"Can not found "+tft1.getText(),"Notepad",JOptionPane.ERROR_MESSAGE);
		}
		pos=-1;
		while(true)
		{	pos=st.indexOf(tft1.getText(),pos+1);
			if(pos==-1){a[i]=-1;break;}
			a[i]=pos;
			i++;
		}
		for(int j=0;j<a.length;j++)
		{
			if(a[j]==-1){break;}
		}
		
	}
	public void finddNext(int incr)
	{
		findNext();
		if(a[incr]==-1)
		{
			//JOptionPane.showMessageDialog(this,"Can not found "+tft1.getText());
			inc=-1;
		}
		else{
		Notepad.ta.setCaretPosition(a[incr]);
		Notepad.ta.select(Notepad.ta.getCaretPosition(),tft1.getText().length()+Notepad.ta.getCaretPosition());
		}
		
	}

}