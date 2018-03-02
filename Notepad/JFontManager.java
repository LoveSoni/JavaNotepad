import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class JFontManager extends JFrame implements ActionListener,ItemListener
{
	JLabel lb1,lb2,lb3;
	int x=Font.PLAIN;
	JTextArea taa;
	JTextField tft,tft2,tft4,tft6;
	JButton btn1,btn2;
	List list1,list2,list3;
	public JFontManager(JTextArea taa)
	{this.taa=taa;init();}
	public JFontManager()
	{
		init();
	}
	public void init()
	{
		list1=new List();
		list1.add("Agency FB");list1.add("ALGERIAN");list1.add("Arial");
		list1.add("Arial Rounded MT");list1.add("Arial Unicode MS");
		list1.add("Baskerville Old Face");list1.add("Bauhaus 93");
		list1.add("Bell MT");list1.add("Berlin Sans FB");list1.add("Bernard MT");
		list1.add("Blackadder ITC");list1.add("Bodoni MT");
		list1.add("Bodoni MT Poster");list1.add("Book Antiqua");list1.add("Bookman Old Style");
		list1.add("Bookshelf Symbol 7");list1.add("Bradley Hand ITC");list1.add("Britannic");
		list1.add("Broadway");list1.add("Brush Script MT");
		list1.add("Calibri");list1.add("Californian FB");
		list1.add("Calisto MT");list1.add("Cambria");list1.add("Cambria Math");
		list1.add("Candara");list1.add("Castellar");list1.add("Centaurr");
		list1.add("Century");list1.add("Century Gothic");list1.add("Century Schoolbook");list1.add("Chiller");
		list1.add("Colonna MT");list1.add("Comic Sans MS");list1.add("Consolas");
		list1.add("Constantia");list1.add("Cooper");list1.add("Copperplate Gothic");
		list1.add("Corbel");list1.add("Courier");list1.add("Courier New");list1.add("Curlz MT");
		list1.add("Edwardian Script ITC");list1.add("Elephant");list1.add("Engravers MT");
		list1.add("Eras ITC");list1.add("Felix Titling");list1.add("Fixedsys");list1.add("Footlight MT");
		list1.add("Forte");list1.add("Franklin Gothic");list1.add("Franklin Gothic Book");
		list1.add("Freestyle Script");list1.add("French Script MT");list1.add("Gabriola");
		list1.add("Garamond");list1.add("Georgia");list1.add("Gigi");list1.add("Gill Sans");list1.add("Gill Sans MT");
		list1.add("Gloucester MT");list1.add("Goudy Old Style");list1.add("Goudy Stout");
		list1.add("Haettenschweiler");list1.add("Harlow Solid");list1.add("Harrington");
		list1.add("High Tower Text");list1.add("Impact");list1.add("Imprint MT Shadow");list1.add("Informal Roman");
		list1.add("Jokerman");list1.add("Juice ITC");list1.add("Kristen ITC");list1.add("Kunstler Script");
		list1.add("Latin");list1.add("Lucida Bright");list1.add("Lucida Calligraphy");list1.add("Lucida Console");
		list1.add("Lucida Fax");list1.add("Lucida Handwriting");list1.add("Lucida Sans");
		list1.add("Lucida Sans Typewriter");list1.add("Lucida Sans Unicode");
		list1.add("Magneto");list1.add("Maiandra GD");list1.add("Matura MT Script Capitals");
		list1.add("Microsoft Sans Serif");list1.add("Mistral");list1.add("Modern");list1.add("Modern No. 20");
		list1.add("Monotype Corsiva");list1.add("MS Outlook");list1.add("MS Reference Sans Serif");list1.add("MS Reference Specialty");
		list1.add("MS Sans Serif");list1.add("MS Serif");list1.add("MT Extra");list1.add("Niagara Engraved");
		list1.add("Niagara Solid");list1.add("OCR A");list1.add("Old English Text MT");list1.add("Onyx");
		list1.add("Open Sans");list1.add("Palace Script MT");list1.add("Palatino Linotype");list1.add("Papyrus");list1.add("Parchment");
		list1.add("Perpetua");list1.add("Perpetua Titling MT");list1.add("Playbill");
		list1.add("Poor Richard");list1.add("Pristina");list1.add("Rage");list1.add("Ravie");list1.add("Rockwell");
		list1.add("Roman");list1.add("Script");list1.add("Script MT");list1.add("Segoe MDL2 Assets");
		list1.add("Segoe Print");list1.add("Segoe Script");list1.add("Segoe UI");list1.add("Segoe UI Emoji");
		list1.add("Segoe UI Symbol");list1.add("Showcard Gothic");list1.add("Sitka Banner");
		list1.add("Sitka Display");list1.add("Sitka Heading");list1.add("Sitka Small");list1.add("Sitka Subheading");
		list1.add("Sitka Text");list1.add("Small Fonts");list1.add("Snap ITC");list1.add("Stencil");
		list1.add("Symbol");list1.add("System");list1.add("Tahoma");list1.add("Tempus Sans ITC");list1.add("Terminal");
		list1.add("Times New Roman");list1.add("Trebuchet MS");list1.add("Tw Cen MT");list1.add("Verdana");
		list1.add("Viner Hand ITC");list1.add("Vivaldi");list1.add("Vladimir Script");
		add(list1);list1.addItemListener(this);
		list1.setBounds(15,63,169,120);	
		list2=new List();
		list2.add("BOLD");list2.add("ITALIC");list2.add("PLAIN");
		list2.addItemListener(this);
		list3=new List();
		list3.add("8");list3.add("9");list3.add("10");list3.add("12");list3.add("14");list3.add("16");list3.add("18");list3.add("20");list3.add("22");
		list3.add("22");list3.add("24");list3.add("26");list3.add("28");list3.add("36");list3.add("48");list3.add("72");
		list3.addItemListener(this);
		lb1=new JLabel("Font:");
		lb1.setBounds(15,20,30,10);
		add(lb1);
		tft=new JTextField();
		tft.setBounds(15,35,170,30);
		tft.setText("Arial");
		tft.setEditable(false);
		add(tft);
		lb2=new JLabel("Font style:");
		lb2.setBounds(200,20,60,13);
		add(lb2);
		tft2=new JTextField();
		tft2.setBounds(200,35,130,30);
		tft2.setText("PLAIN");
		tft2.setEditable(false);
		add(tft2);
		list2.setBounds(200,64,129,120);
		add(list2);
		lb3=new JLabel("Size:");
		lb3.setBounds(345,20,30,10);
		add(lb3);
		tft4=new JTextField();
		tft4.setText("14");
		tft4.setEditable(false);
		tft4.setBounds(345,35,70,30);
		add(tft4);
		list3.setBounds(345,63,70,120);
		add(list3);
		tft6=new JTextField("ABCDEFGHabcdefgh");
		tft6.setBounds(20,230,360,90);
		add(tft6);
		tft6.setEditable(false);
		btn1=new JButton("OK");
		btn1.setBounds(200,325,80,30);
		add(btn1);
		btn2=new JButton("Cancel");
		btn2.setBounds(315,325,80,30);
		add(btn2);
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		setLayout(null);
		setVisible(true);
		setSize(430,400);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocation(400,100);
	}
	public void itemStateChanged(ItemEvent e)
	{
			List temp=(List)e.getSource();
		if(temp==list1)
		{
			tft.setText(list1.getSelectedItem());
			tft6.setFont(new Font(list1.getSelectedItem(),x,Integer.parseInt(tft4.getText())));
		
		}
		else if(temp==list2)
		{
			tft2.setText(list2.getSelectedItem());	
			if(tft2.getText().equalsIgnoreCase("BOLD"))
			{
				x=Font.BOLD;
			}
			else if(tft2.getText().equalsIgnoreCase("ITALIC"))
			{
				x=Font.ITALIC;	
			}
			else if(tft2.getText().equalsIgnoreCase("PLAIN"))
			{
				x=Font.PLAIN;
				//tft6.setFont(new Font(list1.getSelectedItem(),Font.PLAIN,Integer.parseInt(tft4.getText())));	
			}
			tft6.setFont(new Font(list1.getSelectedItem(),x,Integer.parseInt(tft4.getText())));
		}
		else if(temp==list3)
		{
			tft4.setText(list3.getSelectedItem());
			tft6.setFont(new Font(list1.getSelectedItem(),x,Integer.parseInt(tft4.getText())));
		}
		
	}
	public void actionPerformed(ActionEvent e)
	{
		JButton temp=(JButton)e.getSource();
		if(temp==btn1)
		{
			taa.setFont(new Font(list1.getSelectedItem(),x,Integer.parseInt(tft4.getText())));
			dispose();
		}
		else if(temp==btn2)
		{
			dispose();
		}
	}
	
}
