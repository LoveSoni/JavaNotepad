import java.util.Scanner;
import static java.awt.event.InputEvent.CTRL_DOWN_MASK;
import java.awt.*;
import java.io.*;
import java.awt.event.*;
import javax.swing.undo.*;
import javax.swing.*;
import javax.swing.text.*;
import javax.swing.event.*;
public class Notepad extends JFrame implements ActionListener,WindowListener
{	UndoManager undoManager;
	boolean temp1=true,temp2=true;;
	String copytext;
	JMenuBar mbar;
	JMenu File,Edit,Format,View,Help;
	JMenu backcolor,forcolor;
	JMenuItem New,Open,Save,SaveAs,Exit;
	JMenuItem Undo,Cut,Copy,Paste,Delete,Find,FindNext,Replace,GoTo,SelectAll,TimeDate;
	JMenuItem WordWrap,Font;
	JMenuItem black,red,blue;
	JMenuItem white,yellow,green,Default;
	JMenuItem About;
	static JTextArea ta;
	JScrollPane sb;
	JFileChooser jf;
	String tofind="";
	int lineCount,inc=0;	
	public Notepad()
	{setLayout(new BorderLayout());
	ta=new JTextArea();ta.setBorder( BorderFactory.createEtchedBorder() );
	undoManager= new UndoManager();
	ta.getDocument().addUndoableEditListener(new UndoableEditListener()
											 {
        										  public void undoableEditHappened(UndoableEditEvent e)
        										   {
          											 undoManager.addEdit(e.getEdit());
          										   }
          									 }
          								   );

	mbar=new JMenuBar();
	//--------------------------------------------------------------------------------------------------------------------------------------
	File=new JMenu("File");
	New=new JMenuItem("New");Open=new JMenuItem("Open");Save=new JMenuItem("Save");SaveAs=new JMenuItem("SaveAS");Exit=new JMenuItem("Exit");
	File.add(New);File.add(Open);File.add(Save);File.add(SaveAs);File.addSeparator();File.add(Exit);
	//---------------------------------------------------------------------------------------------------------------------------------------
	Edit=new JMenu("Edit");
	Undo=new JMenuItem("Undo");Cut=new JMenuItem("Cut");Copy=new JMenuItem("Copy");Paste=new JMenuItem("Paste");Delete=new JMenuItem("Delete");
	Find=new JMenuItem("Find...");FindNext=new JMenuItem("Find Next");Replace=new JMenuItem("Replace...");GoTo=new JMenuItem("Go To...");
	SelectAll=new JMenuItem("Select All");TimeDate=new JMenuItem("Time/Date");
	Edit.add(Undo);Edit.addSeparator();Edit.add(Cut);Edit.add(Copy);Edit.add(Paste);Edit.add(Delete);Edit.addSeparator();Edit.add(Find);
	Edit.add(FindNext);Edit.add(Replace);Edit.add(GoTo);Edit.addSeparator();Edit.add(SelectAll);Edit.add(TimeDate);
	//---------------------------------------------------------------------------------------------------------------------------------------	
	Format=new JMenu("Format");
	WordWrap=new JMenuItem("Word Wrap");	Font=new JMenuItem("Font...");
	Format.add(WordWrap);
	Format.add(Font);
	//---------------------------------------------------------------------------------------------------------------------------------------
	View=new JMenu("View");
	backcolor=new JMenu("Background");black=new JMenuItem("Black");red=new JMenuItem("Red");blue=new JMenuItem("Blue");
		white=new JMenuItem("white");yellow=new JMenuItem("yellow");green=new JMenuItem("green");
	backcolor.add(black);backcolor.add(red);backcolor.add(blue);
	forcolor=new JMenu("Text");
	forcolor.add(white);forcolor.add(yellow);forcolor.add(green);
	Default=new JMenuItem("Default");
	View.add(backcolor);View.add(forcolor);
	View.add(Default);
	//---------------------------------------------------------------------------------------------------------------------------------------
	Help=new JMenu("Help");
	About=new JMenuItem("About Notepad");
	Help.add(About);
	//---------------------------------------------------------------------------------------------------------------------------------------
	// addActionListener()
	Exit.addActionListener(this);	Save.addActionListener(this);	New.addActionListener(this); TimeDate.addActionListener(this);
	Open.addActionListener(this);	SaveAs.addActionListener(this);	Font.addActionListener(this); WordWrap.addActionListener(this);
	SelectAll.addActionListener(this); Copy.addActionListener(this); Paste.addActionListener(this); Cut.addActionListener(this);
	Delete.addActionListener(this);	GoTo.addActionListener(this); Undo.addActionListener(this); Find.addActionListener(this);
	FindNext.addActionListener(this); Replace.addActionListener(this);
	About.addActionListener(this);	
	black.addActionListener(this);red.addActionListener(this);blue.addActionListener(this);
	white.addActionListener(this);yellow.addActionListener(this);green.addActionListener(this);
	Default.addActionListener(this);
	//---------------------------------------------------------------------------------------------------------------------------------------
	sb=new JScrollPane(ta);
	add(sb);
	jf=new JFileChooser();

	mbar.add(File);mbar.add(Edit);mbar.add(Format);mbar.add(View);mbar.add(Help);
	add(mbar,BorderLayout.NORTH);
	//add(ta,BorderLayout.CENTER);
	setVisible(true);
	setSize(500,500);
	setLocation(400,50);
	//setDefaultCloseOperation(EXIT_ON_CLOSE);
	this.addWindowListener(this);
	setTitle("Notpad By Love");
	//........................................................................................................................................
	// shortcuts
	File.setMnemonic('F');Edit.setMnemonic('E');Format.setMnemonic('o');View.setMnemonic('V');Help.setMnemonic('H');
	New.setAccelerator(KeyStroke.getKeyStroke('N', CTRL_DOWN_MASK));
	Open.setAccelerator(KeyStroke.getKeyStroke('O', CTRL_DOWN_MASK));
	Save.setAccelerator(KeyStroke.getKeyStroke('S', CTRL_DOWN_MASK));
	Undo.setAccelerator(KeyStroke.getKeyStroke('Z', CTRL_DOWN_MASK));
	Cut.setAccelerator(KeyStroke.getKeyStroke('X', CTRL_DOWN_MASK));
	Copy.setAccelerator(KeyStroke.getKeyStroke('C', CTRL_DOWN_MASK));
	Paste.setAccelerator(KeyStroke.getKeyStroke('P', CTRL_DOWN_MASK));
	Find.setAccelerator(KeyStroke.getKeyStroke('F', CTRL_DOWN_MASK));
	Replace.setAccelerator(KeyStroke.getKeyStroke('R', CTRL_DOWN_MASK));
	GoTo.setAccelerator(KeyStroke.getKeyStroke('G', CTRL_DOWN_MASK));
	KeyStroke f5 = KeyStroke.getKeyStroke(KeyEvent.VK_F5, 0);
	TimeDate.setAccelerator(f5);
	KeyStroke f3=KeyStroke.getKeyStroke(KeyEvent.VK_F3,0);
	FindNext.setAccelerator(f3);
	SelectAll.setAccelerator(KeyStroke.getKeyStroke('A', CTRL_DOWN_MASK));
	//........................................................................................................................................
	}
	public void actionPerformed(ActionEvent e)
	{		
			JMenuItem temp=(JMenuItem) e.getSource();
			if(temp==Exit)
			{
				System.exit(0);
			}
			else if(temp==Open)
			{
				jf.showOpenDialog(this);
				File obj=jf.getSelectedFile();
				try{
				FileInputStream fin=new FileInputStream(obj);
				StringBuffer sb=new StringBuffer(50);
				while(true)
				{
					int x=fin.read();
					if(x==-1)
					{
						break;
					}
					sb.append((char)x);
				}
				setTitle(obj.getName());
				ta.setText(String.valueOf(sb));
				fin.close();	
				}catch(IOException ex)
				{
					ex.printStackTrace();
				}
				
			}
			else if(temp==Save)
			{
				if(temp1==true){
				jf.showSaveDialog(this);
				temp1=false;
				}
				File obj=jf.getSelectedFile();
				setTitle(obj.getName());
			try{
				FileOutputStream fout=new FileOutputStream(obj);
				PrintStream put=new PrintStream(fout);
				String st=ta.getText();
				put.print(st);
				fout.close();
			}catch(IOException es)
			{
				es.printStackTrace();
			}
	    	}
			else if(temp==SaveAs)
			{
				saave();
			}
			else if(temp==New)
			{
				int len=ta.getText().length();
		//		System.out.println(len);
				if(len!=0){
				len=JOptionPane.showConfirmDialog(this,"Do You want to save changes to Untitled?","Notepad",JOptionPane.YES_NO_CANCEL_OPTION);
					if(len==0)
					{
						saave();
						ta.setText("");
					}
					else if(len==1)
					{
						ta.setText("");
					}
					else if(len==2)
					{

					}
				
				}
			}
			else if(temp==Font)
			{
				new JFontManager(ta);
			}
			else if(temp==TimeDate)
			{
				java.util.Date dobj=new java.util.Date();
				int pos=ta.getCaretPosition();
				System.out.println(pos);
				ta.insert(dobj.toString(),pos);
			}
			else if(temp==WordWrap)
			{
				if(temp2)
				{
				WordWrap.setText(":/ Word Wrap");
				ta.setLineWrap(true);
				temp2=false;
				}
				else 
				{
				WordWrap.setText("Word Wrap");
				ta.setLineWrap(false);
				temp2=true;
				}
			}
			else if(temp==SelectAll)
			{
				ta.selectAll();
				//if(ta.getSelectedText())
				
				//{
				//	System.out.println("ddd");
						//}
			}
			else if(temp==Copy)
			{
				copytext=ta.getSelectedText();	
			}
			else if(temp==Paste)
			{
				int pos=ta.getCaretPosition();
				ta.insert(copytext,pos);
			}
			else if(temp==Cut)
			{
				
				copytext=ta.getSelectedText();
				int pos=ta.getCaretPosition();
				ta.setText(ta.getText().replace(ta.getSelectedText(),""));
				ta.setCaretPosition(pos);
			}
			else if(temp==Delete)
			{if(ta.getText().length()!=0){
				int pos=ta.getCaretPosition();
				ta.setText(ta.getText().replace(ta.getSelectedText(),""));
				ta.setCaretPosition(pos);
				}
			}
			else if(temp==GoTo)
			{
			do {
            try {
                String str = (String) JOptionPane.showInputDialog(this,"Line number:\t", "Goto line", 
                  JOptionPane.PLAIN_MESSAGE, null, null, null);
                if (str == null) {
                    break;
                }
                int lineNumber = Integer.parseInt(str);
                lineCount = getLineCount();
                System.out.println(lineCount);
                if (lineNumber > lineCount) {
                    JOptionPane.showMessageDialog(this, 
                            "Line number out of range", "EPAD Goto line", 
                            JOptionPane.ERROR_MESSAGE);
                    continue;
                }
                //  for ( int i = 0 ; i < lineCount; i++ ){
                //  if ( i+1 == lineNumber ) {
                //Rectangle rectangle = ta.modelToView(ta.getCaretPosition());
                ta.setCaretPosition(0);
                System.out.println(setcursor(lineNumber));
                ta.setCaretPosition(setcursor(lineNumber));
                return;
                //  }
                //  }
            } catch (Exception ex) {}
        } while (true);
			}
			else if(temp==Undo)
			{
				if(ta.getText().length()!=0)
			 	{try {
          			  undoManager.undo();
        		     } catch (CannotRedoException cre) 
        		      {
          				cre.printStackTrace();
        			  }
        	        }
			}
			else if(temp==black)
			{
				ta.setBackground(Color.BLACK);
			}
			else if(temp==red)
			{
				ta.setBackground(Color.RED);
			}
			else if(temp==blue)
			{
				ta.setBackground(Color.BLUE);
			}
			else if(temp==yellow)
			{
				ta.setForeground(Color.YELLOW);
			}
			else if(temp==green)
			{
				ta.setForeground(Color.GREEN);
			}
			else if(temp==white)
			{
				ta.setForeground(Color.WHITE);
			}
			else if(temp==Default)
			{
				ta.setBackground(Color.WHITE);
				ta.setForeground(Color.BLACK);
			}
			else if(temp==About)
			{
				JOptionPane.showMessageDialog(this,"For Feedback Mail me at Lovesoni607@gmail.com","About Notepad",JOptionPane.INFORMATION_MESSAGE);
			}
			else if(temp==Find)
			{try{
					findd();
		    	}catch(NullPointerException ex){tofind="";}
		    }
	 		else if(temp==FindNext)
	 		{	try{
	 				
	 				inc+=1;
	 				finddNext(inc);
				}catch(NullPointerException ex){tofind="";}
			}
			else if(temp==Replace)
			{
				try{
				new Rep();
				}catch(Exception ex){}
			}
	}
	   public int getLineCount() {
        lineCount = 0;
        Scanner sc = new Scanner(ta.getText());
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            lineCount++;
        }
        return lineCount;
    }


	public void findd()
	{
		FindNext.setEnabled(true);
		try{
			tofind=JOptionPane.showInputDialog(this,"What do you want to Find");
			String st=ta.getText();
			int pos=st.indexOf(tofind);
			if(pos==-1){JOptionPane.showMessageDialog(this,"Can not find "+tofind);}
			ta.setCaretPosition(pos);
			ta.select(ta.getCaretPosition(),tofind.length()+ta.getCaretPosition());
			}catch(IllegalArgumentException ex)
			{}
	}
	    public int setcursor(int newlineno) {
        int pos = 0;
        int i = 0;
        String line = "";
        Scanner sc = new Scanner(ta.getText());
        while (sc.hasNextLine()) {
            line = sc.nextLine();
            i++;
            if (newlineno > i) {
                pos = pos + line.length() + 1;
            }
        }
        return pos;
    }


	public void finddNext(int inc1)
	{
		if(tofind.equals(""))	
	 	{
	 		findd();
	 		inc=0;
	 	}
		else{
	 		try
	 		{
	 			int i=0;
				String st=ta.getText();
				int []a=new int[st.length()];
				int pos=st.indexOf(tofind);
			if(pos==-1)
			{
				JOptionPane.showMessageDialog(this,"Can not find "+tofind);
			}
			pos=-1;
			while(true)
			{
			pos=(st.indexOf(tofind,pos+1));
			if(pos==-1){a[i]=-1;break;}
			a[i]=pos;
			i++;
			}
			for(int j=0;j<a.length;j++)
			{
				if(a[j]==-1)
				{
					break;
				}
		//		System.out.println(a[j]);	
			}
			if(a[inc1]==-1){JOptionPane.showMessageDialog(this,"Can not find "+tofind);inc=0;FindNext.setEnabled(false);}
			else{
			ta.setCaretPosition(a[inc1]);
			ta.select(ta.getCaretPosition(),ta.getCaretPosition()+tofind.length());		
			}
		}catch(Exception ex){}
	 	}
	}
	public void saave()
	{
			jf.showSaveDialog(this);
				File obj=jf.getSelectedFile();
				setTitle(obj.getName());
			try{
				FileOutputStream fout=new FileOutputStream(obj);
				String st=ta.getText();
				if(st.length()!=0)
				{
					byte arr[]=st.getBytes();
					fout.write(arr);
				}
				fout.close();
			}catch(IOException es)
			{
				es.printStackTrace();
			}
	}
	public void windowClosing(WindowEvent e){
			int len=ta.getText().length();
			if(len!=0){
				len=JOptionPane.showConfirmDialog(this,"Do You want to save changes to Untitled?","Notepad",JOptionPane.YES_NO_CANCEL_OPTION);
				if(len==0)
					{
						saave();
						dispose();
					}
					else if(len==1)
					{	dispose();
					}
					else if(len==2)
					{setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
					}
				
				}	
				else if(len==0)
				{System.out.print("4");
					dispose();
				}
	System.out.println("closing");}
	public void windowClosed(WindowEvent e){System.out.println("closed");}
	public void windowOpened(WindowEvent e){}
	public void windowIconified(WindowEvent e){}
	public void windowDeiconified(WindowEvent e){}	
	public void windowActivated(WindowEvent e){}
	public void windowDeactivated(WindowEvent e){}		
	public static void main(String args[])
	{
	new Notepad();
	}
}