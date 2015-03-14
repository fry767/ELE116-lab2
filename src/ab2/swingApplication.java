package ab2;


import java.awt.BorderLayout;
import java.awt.FileDialog;
import java.awt.Frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;



import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class swingApplication extends JFrame implements ActionListener {

	
    JFrame f = new JFrame("JEditorPane Sample");
    
	  public swingApplication() {
			

			  
//		    JFrame f = new JFrame("JEditorPane Sample");
		    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    
		    JMenuBar menuBar = new JMenuBar();

		    // File Menu, F - Mnemonic
		    JMenu fileMenu = new JMenu("File");
		    fileMenu.setMnemonic(KeyEvent.VK_F);
		    menuBar.add(fileMenu);

		    // File->New, N - Mnemonic
		    JMenuItem newMenuItem = new JMenuItem("livre", KeyEvent.VK_N);
		    newMenuItem.addActionListener(this);
		    fileMenu.add(newMenuItem);
		    JMenuItem newMenuItem2 = new JMenuItem("table des mati�res", KeyEvent.VK_N);
		    newMenuItem2.addActionListener(this);
		    fileMenu.add(newMenuItem2);

		    f.setJMenuBar(menuBar);
		    
	
		    f.setSize(500, 500);
		    f.setVisible(true);
		  }
		  
		  
		  public  void    actionPerformed(ActionEvent e)
		  {
				if (e.getActionCommand().equals("livre")){
				System.out.println("Livre");
				Frame yourJFrame = null;
				FileDialog fd = new FileDialog(yourJFrame, "Choose a file", FileDialog.LOAD);
				  fd.setDirectory("C:\\");
				  fd.setFile("*.xml");
				  fd.setVisible(true);
				  String filename = fd.getFile();
				  if (filename == null)
				    System.out.println("You cancelled the choice");
				  else
					  {  System.out.println("You chose " + filename);
					  
					  
					    JEditorPane editor = new JEditorPane(
						        "text/html",
						        "<H1>CACA</H1><center>www.java2s.com</center><li>One<li><i>Two</i><li><u>Three</u>");
							    editor.setEditable(false);
					    JScrollPane scrollPane = new JScrollPane(editor);
					    f.add(scrollPane, BorderLayout.CENTER);
					    f.setVisible(true);
					  }
				}
				
				else if (e.getActionCommand().equals("table des mati�res")){
				System.out.println("table des mati�res");
				Frame yourJFrame = null;
				FileDialog fd = new FileDialog(yourJFrame, "Choose a file", FileDialog.LOAD);
				  fd.setDirectory("C:\\");
				  fd.setFile("*.xml");
				  fd.setVisible(true);
				  String filename = fd.getFile();
				  if (filename == null)
				    System.out.println("You cancelled the choice");
				  else
				    System.out.println("You chose " + filename);
				}
				
		  }
		}