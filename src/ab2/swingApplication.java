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

//Gestion de la fen�tre

public class swingApplication extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String pathfile;
	private JFrame f = new JFrame("Laboratoire 2");
	private JEditorPane editor = new JEditorPane("text/html", "");

	public swingApplication() {

		
		//http://www.java2s.com/Code/Java/Swing-JFC/EditorPaneSample.htm
		//http://www.java2s.com/Tutorial/Java/0240__Swing/AddingMnemonicandAcceleratortoMenuitem.htm
		
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar menuBar = new JMenuBar(); // cr�ation de la barre de menu

		// File Menu, F - Mnemonic
		JMenu fileMenu = new JMenu("File"); // cr�ation du bouton file
		fileMenu.setMnemonic(KeyEvent.VK_F);
		menuBar.add(fileMenu);

		// File->New, N - Mnemonic
		JMenuItem newMenuItem = new JMenuItem("livre", KeyEvent.VK_N); //cr�ation du bouton livre
		newMenuItem.addActionListener(this);
		fileMenu.add(newMenuItem);
		JMenuItem newMenuItem2 = new JMenuItem("table des mati�res",KeyEvent.VK_N); //cr�ation du bouton table des mati�res
		newMenuItem2.addActionListener(this);
		fileMenu.add(newMenuItem2);

		editor.setEditable(false); // on ne peut pas �diter le texte html
		JScrollPane scrollPane = new JScrollPane(editor); // cr�ation de la fen�tre
		f.add(scrollPane, BorderLayout.CENTER);
		f.setVisible(true);
		f.setJMenuBar(menuBar);
		f.setSize(500, 500);
		f.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) // action lorsqu'un bouton du
												// menu est appuiy�
	{
		Boolean flagLivreTable = null; // flag pour d�terminer si on cr�e une
										// table des mati�re ou un livre
		String htmlHeader = "";

		// http://stackoverflow.com/questions/7211107/how-to-use-filedialog
		///////////////////////////////////////////////////////////////////
		Frame yourJFrame = null; //
		FileDialog fd = new FileDialog(yourJFrame, "Choose a file",FileDialog.LOAD); // on cr�e une nouvelle fen�tre pour choisir le fichier
		fd.setDirectory("C:\\");
		fd.setFile("*.xml");
		fd.setVisible(true);
		String pathfile = fd.getDirectory() + fd.getFile();
		///////////////////////////////////////////////////////////////////
		
		if (e.getActionCommand().equals("livre")) {
			flagLivreTable = true;
			htmlHeader = "<HTML><HEAD></HEAD><BODY>";

		}

		else if (e.getActionCommand().equals("table des mati�res")) {
			flagLivreTable = false;
			htmlHeader = "<HTML><HEAD></HEAD><BODY> <H1>Table des mati�res :</H1>";
		}

		if (fd.getDirectory() == null)
			System.out.println("You cancelled the choice");
		
		else {
			System.out.println("You chose " + pathfile);
			Livre livre = new Livre(pathfile);
			BookElementPrintVisitor visitor = new BookElementPrintVisitor(flagLivreTable); // on cr�e un nouvel �l�ment livre
			// ReadXmlFiles xmlFile = new ReadXmlFiles(pathfile);
			livre.accept(visitor);
			editor.setText(htmlHeader + visitor.get_html() + "</BODY></HTML>"); // on undate la string html affich� dans la fen�tre
		}

	}

}