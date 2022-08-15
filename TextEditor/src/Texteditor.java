import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;


public class Texteditor extends JFrame implements ActionListener{
	
	JTextArea textArea;
	JScrollPane scrollPane;
	JSpinner fontSizeSpinner;
	JLabel fontLabel;
	JButton fontColorButton;
	JComboBox fontBox;
	JMenuBar menuBar;
	JMenu fileMenu;
	JMenuItem openItem, saveItem, exitItem;
	
	
	Texteditor(){
		
		textArea = new JTextArea();
		//textArea.setPreferredSize(new Dimension(450, 450));
		textArea.setLineWrap(true);// 會自動換行
		textArea.setWrapStyleWord(true);
		textArea.setFont(new Font("Arial", Font.PLAIN, 20));
		
		scrollPane  = new JScrollPane(textArea);
		scrollPane.setPreferredSize(new Dimension(450, 450));
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);// always show a scroll
		
		fontLabel = new JLabel("Font");
		fontSizeSpinner = new JSpinner();
		fontSizeSpinner.setPreferredSize(new Dimension(50,25));
		fontSizeSpinner.setValue(20);
		fontSizeSpinner.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				textArea.setFont(new Font(textArea.getFont().getFamily(), Font.PLAIN, (int)fontSizeSpinner.getValue()));
			}
			
		});
		
		fontColorButton = new JButton("Color");
		fontColorButton.setBackground(Color.black);
		fontColorButton.setForeground(Color.white);
		fontColorButton.addActionListener(this);
		
		String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();// all available font in java
		fontBox = new JComboBox(fonts);
		fontBox.addActionListener(this);
		fontBox.setSelectedItem("Arial");// textArea.getFont().getFamily()
		
		//MENUBAR~
		menuBar = new JMenuBar();
		fileMenu = new JMenu("File");
		openItem = new JMenuItem("Open");
		saveItem = new JMenuItem("Save");
		exitItem = new JMenuItem("Exit");
		openItem.addActionListener(this);
		saveItem.addActionListener(this);
		exitItem.addActionListener(this);
		   
		fileMenu.add(openItem);
		fileMenu.add(saveItem);
		fileMenu.add(exitItem);
		menuBar.add(fileMenu);
		
		fileMenu.setMnemonic(KeyEvent.VK_F);// Alt + f
		openItem.setMnemonic(KeyEvent.VK_O);// o
		saveItem.setMnemonic(KeyEvent.VK_S);// s
		exitItem.setMnemonic(KeyEvent.VK_E);// e
		
		ImageIcon icon = new ImageIcon("notebook.jpg");
		this.setIconImage(icon.getImage());
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		this.setTitle("My Text Editor");
		this.setSize(500, 600);
		this.setLocationRelativeTo(null);// always appear in the center
		this.setVisible(true);
		
		
		
		//this.add(textArea);
		// the order added affect the location
		this.setJMenuBar(menuBar);// not add
		this.add(fontLabel);
		this.add(fontSizeSpinner);
		this.add(fontColorButton);
		this.add(fontBox);
		this.add(scrollPane);
		
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == fontColorButton) {
			JColorChooser colorChooser = new JColorChooser();
			Color color = colorChooser.showDialog(null, "Pick a color", Color.black);
			textArea.setForeground(color);			
		}
		else if(e.getSource() == fontBox) {			
			textArea.setFont(new Font((String)fontBox.getSelectedItem(), Font.PLAIN, textArea.getFont().getSize()));
		}
		else if(e.getSource() ==  openItem) {
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setCurrentDirectory(new File("."));// this will begin in the project folder
			FileNameExtensionFilter filter = new FileNameExtensionFilter("Text files", "txt");
			fileChooser.setFileFilter(filter);
			
			int response = fileChooser.showOpenDialog(null);
			
			if(response == JFileChooser.APPROVE_OPTION) {
				this.setTitle(fileChooser.getSelectedFile().getName());
				File file =  new File(fileChooser.getSelectedFile().getAbsolutePath());
				Scanner fileIn = null;
				
				try {
					fileIn = new Scanner(file);
					if(file.isFile()) {
						while(fileIn.hasNextLine()) {
							String Line = fileIn.nextLine()+"\n";
							textArea.append(Line);
						}
					}
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} finally {
					fileIn.close();
				}
			}
			
			
		}
		else if(e.getSource() == saveItem) {
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setCurrentDirectory(new File("."));// this will begin in the project folder
			int response = fileChooser.showSaveDialog(null);
			if(response == JFileChooser.APPROVE_OPTION) {
				this.setTitle(fileChooser.getSelectedFile().getName());
				File file;
				PrintWriter fileOut = null;// need initiate
				
				file = new File(fileChooser.getSelectedFile().getAbsolutePath());
				try {
					fileOut = new PrintWriter(file);
					fileOut.println(textArea.getText());
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} finally {
					fileOut.close();
				}
			}
		}
		else if(e.getSource() == exitItem) {
			System.exit(0);
		}
		
	}

}
