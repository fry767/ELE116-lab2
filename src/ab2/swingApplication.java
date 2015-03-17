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


public class swingApplication extends JFrame implements ActionListener{

	public String pathfile;
    private JFrame f = new JFrame("Laboratoire 2");
    private JEditorPane editor = new JEditorPane("text/html","");
    
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
		    JMenuItem newMenuItem2 = new JMenuItem("table des matières", KeyEvent.VK_N);
		    newMenuItem2.addActionListener(this);
		    fileMenu.add(newMenuItem2);


//			        "<HTML><HEAD><TITLE>The document title</TITLE></HEAD><BODY><H1>Main heading</H1><P>A paragraph.</P><P>Another paragraph.</P><UL><LI>A list item.</LI><LI>Another list item.</LI></UL></BODY></HTML>");
				    editor.setEditable(false);
		    JScrollPane scrollPane = new JScrollPane(editor);
		    f.add(scrollPane, BorderLayout.CENTER);
		    f.setVisible(true);
		    f.setJMenuBar(menuBar);
		    f.setSize(500, 500);
		    f.setVisible(true);
		  }
		  
		  
		  public  void    actionPerformed(ActionEvent e)
		  {
			  
				System.out.println("Livre");
				Frame yourJFrame = null;
				FileDialog fd = new FileDialog(yourJFrame, "Choose a file", FileDialog.LOAD);
				  fd.setDirectory("C:\\");
				  fd.setFile("*.xml");
				  fd.setVisible(true);
				  String pathfile = fd.getDirectory()+fd.getFile();
				  Livre livre = new Livre(pathfile);
				  BookElementPrintVisitor visitor = new BookElementPrintVisitor();
				  
				if (e.getActionCommand().equals("livre")){

			  
				  if (fd.getDirectory() == null)
				    System.out.println("You cancelled the choice");
				  else
					  {
					    System.out.println("You chose " + pathfile);
					  
						//ReadXmlFiles xmlFile = new ReadXmlFiles(pathfile);
						livre.accept(visitor);
						editor.setText("<HTML><HEAD></HEAD><BODY>"+visitor.get_html()+"</BODY></HTML>");

					  }
				}
				
				else if (e.getActionCommand().equals("table des matières")){

				}
				
		  }


		
		}