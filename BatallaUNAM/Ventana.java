import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.io.Serializable;
import java.text.StringCharacterIterator;
import java.util.*;


public class Ventana extends JFrame implements Serializable{

	public JPanel titleNamePanel, titleButtonPanel, mainTextPanel, choiceButtonPanel, playerStatusPanel, inventoryPanel;
	public JPanel characterPanel, characterImagePanel, characterButtonPanel, titleImagePanel;
	public JLabel titleNameLabel, nameLabel, hpLabel, attackLabel, magicLabel, weaponLabel, characterSelectionLabel;
	public JLabel imageLabel1, imageLabel2, imageLabel3, imageLabel;
	public JButton startButton, c1, c2, c3, c4, inventoryButton, item1, item2, item3, item4, item5;
	public JButton estudiante, maestro, reportero;
	public JTextArea mainTextArea;
	public ImageIcon img1, img2, img3, img;

	public JMenu menu;
	public JMenuBar menuBar;
	public JMenuItem saveM, loadM;

	private Font titleFont = new Font("Comic Sans MS", Font.PLAIN, 60);
	private Font statusFont = new Font("Comic Sans MS", Font.PLAIN, 18);
	private Font normalFont = new Font("Comic Sans MS", Font.PLAIN, 24);
	
	ChoiceHandler choiceHandler = new ChoiceHandler();
	VisibilityManager visibilityManager = new VisibilityManager(this);
	Story story = new Story(this, visibilityManager);
	ImageIcon imageIcon = new ImageIcon(".//assets//unam.png");

	public String position1, position2, position3, position4;

	public Ventana() {
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.white);
		setLayout(null);
		setIconImage(imageIcon.getImage());
		initComponents();
		visibilityManager.showTitleScreen();
		setVisible(true);
	}

	public void initComponents() {

		menuBar = new JMenuBar();
		menu = new JMenu("Archivo");
		saveM = new JMenuItem("Guardar historia");
		saveM.addActionListener(new GuardarHistoria());
		loadM = new JMenuItem("Cargar historia");
		loadM.addActionListener(new CargarHistoria());
		menu.add(saveM);
		menu.add(loadM);
		menuBar.add(menu);
		setJMenuBar(menuBar);

		titleNamePanel = new JPanel();
		titleNamePanel.setBounds(100, 50, 600, 100);
		titleNamePanel.setBackground(Color.white);
		titleNameLabel = new JLabel("Batalla UNAM");
		titleNameLabel.setForeground(Color.black);
		titleNameLabel.setFont(titleFont);
		titleNamePanel.add(titleNameLabel);
		add(titleNamePanel);

		titleImagePanel = new JPanel();
		titleImagePanel.setBounds(100, 150, 600, 300);
		titleImagePanel.setBackground(Color.white);
		add(titleImagePanel);

		imageLabel = new JLabel();
		img = new ImageIcon(".//assets//libro.png");
		imageLabel.setIcon(img);
		titleImagePanel.add(imageLabel);
		
		titleButtonPanel = new JPanel();
		titleButtonPanel.setBounds(300, 450, 200, 100);
		titleButtonPanel.setBackground(Color.white);
		startButton = new JButton("Comenzar");
		startButton.setBackground(Color.white);
		startButton.setForeground(Color.black);
		startButton.setFont(normalFont);
		startButton.setFocusPainted(false);
		startButton.addActionListener(choiceHandler);
		startButton.setActionCommand("start");
		titleButtonPanel.add(startButton);
		add(titleButtonPanel);

		characterPanel = new JPanel();
		characterPanel.setBounds(100, 100, 600, 50);
		characterPanel.setBackground(Color.white);
		characterSelectionLabel = new JLabel("Escoge tu clase:");
		characterSelectionLabel.setForeground(Color.black);
		characterSelectionLabel.setFont(normalFont);
		characterPanel.add(characterSelectionLabel);
		add(characterPanel);

		characterImagePanel = new JPanel();
		characterImagePanel.setBounds(140, 300, 600, 200);
		characterImagePanel.setBackground(Color.white);
		characterImagePanel.setLayout(new GridLayout(1, 3));
		add(characterImagePanel);

		imageLabel1 = new JLabel();
		img1 = new ImageIcon(".//assets//ash.png");
		imageLabel1.setIcon(img1);
		characterImagePanel.add(imageLabel1);
		imageLabel2 = new JLabel();
		img2 = new ImageIcon(".//assets//oak.png");
		imageLabel2.setIcon(img2);
		characterImagePanel.add(imageLabel2);
		imageLabel3 = new JLabel();
		img3 = new ImageIcon(".//assets//gary.png");
		imageLabel3.setIcon(img3);
		characterImagePanel.add(imageLabel3);

		characterButtonPanel = new JPanel();
		characterButtonPanel.setBounds(100, 200, 600, 100);
		characterButtonPanel.setBackground(Color.white);
		estudiante = new JButton("Estudiante");
		estudiante.setBackground(Color.white);
		estudiante.setForeground(Color.black);
		estudiante.setFont(normalFont);
		estudiante.setFocusPainted(false);
		estudiante.addActionListener(choiceHandler);
		estudiante.setActionCommand("estudiante");
		maestro = new JButton("Maestro");
		maestro.setBackground(Color.white);
		maestro.setForeground(Color.black);
		maestro.setFont(normalFont);
		maestro.setFocusPainted(false);
		maestro.addActionListener(choiceHandler);
		maestro.setActionCommand("maestro");
		reportero = new JButton("Reportero");
		reportero.setBackground(Color.white);
		reportero.setForeground(Color.black);
		reportero.setFont(normalFont);
		reportero.setFocusPainted(false);
		reportero.addActionListener(choiceHandler);
		reportero.setActionCommand("reportero");
		characterButtonPanel.add(estudiante);
		characterButtonPanel.add(maestro);
		characterButtonPanel.add(reportero);
		add(characterButtonPanel);

		mainTextPanel = new JPanel();
		mainTextPanel.setBounds(100, 100, 600, 250);
		mainTextPanel.setBackground(Color.white);
		add(mainTextPanel);
		mainTextArea = new JTextArea();
		mainTextArea.setBounds(100, 100, 600, 250);
		mainTextArea.setBackground(Color.white);
		mainTextArea.setForeground(Color.black);
		mainTextArea.setFont(normalFont);
		mainTextArea.setLineWrap(true);
		mainTextArea.setWrapStyleWord(true);
		mainTextPanel.add(mainTextArea);

		choiceButtonPanel = new JPanel();
		choiceButtonPanel.setBounds(250, 350, 300, 200);
		choiceButtonPanel.setBackground(Color.white);
		choiceButtonPanel.setLayout(new GridLayout(5, 1));
		add(choiceButtonPanel);

		c1 = new JButton();
		c1.setBackground(Color.white);
		c1.setForeground(Color.black);
		c1.setFont(normalFont);
		c1.setFocusPainted(false);
		c1.addActionListener(choiceHandler);
		c1.setActionCommand("c1");
		choiceButtonPanel.add(c1);
		c2 = new JButton();
		c2.setBackground(Color.white);
		c2.setForeground(Color.black);
		c2.setFont(normalFont);
		c2.setFocusPainted(false);
		c2.addActionListener(choiceHandler);
		c2.setActionCommand("c2");
		choiceButtonPanel.add(c2);
		c3 = new JButton();
		c3.setBackground(Color.white);
		c3.setForeground(Color.black);
		c3.setFont(normalFont);
		c3.setFocusPainted(false);
		c3.addActionListener(choiceHandler);
		c3.setActionCommand("c3");
		choiceButtonPanel.add(c3);
		c4 = new JButton();
		c4.setBackground(Color.white);
		c4.setForeground(Color.black);
		c4.setFont(normalFont);
		c4.setFocusPainted(false);
		c4.addActionListener(choiceHandler);
		c4.setActionCommand("c4");
		choiceButtonPanel.add(c4);

		playerStatusPanel = new JPanel();
		playerStatusPanel.setBounds(100, 15, 600, 50);
		playerStatusPanel.setBackground(Color.white);
		playerStatusPanel.setLayout(new GridLayout(1, 5));
		add(playerStatusPanel);

		hpLabel = new JLabel();
		hpLabel.setForeground(Color.black);
		hpLabel.setFont(statusFont);
		playerStatusPanel.add(hpLabel);
		attackLabel = new JLabel();
		attackLabel.setForeground(Color.black);
		attackLabel.setFont(statusFont);
		playerStatusPanel.add(attackLabel);
		magicLabel = new JLabel();
		magicLabel.setForeground(Color.black);
		magicLabel.setFont(statusFont);
		playerStatusPanel.add(magicLabel);
		nameLabel = new JLabel();
		nameLabel.setForeground(Color.black);
		nameLabel.setFont(statusFont);
		playerStatusPanel.add(nameLabel);
		weaponLabel = new JLabel();
		weaponLabel.setForeground(Color.black);
		weaponLabel.setFont(statusFont);
		playerStatusPanel.add(weaponLabel);

		inventoryButton = new JButton("[Mochila]");
		inventoryButton.setBackground(Color.white);
		inventoryButton.setForeground(Color.black);
		inventoryButton.setFont(normalFont);
		inventoryButton.setFocusPainted(false);
		inventoryButton.addActionListener(new InventoryHandler());
		inventoryButton.setActionCommand("inventoryButton");
		choiceButtonPanel.add(inventoryButton);

		inventoryPanel = new JPanel();
		inventoryPanel.setBounds(550, 350, 200, 200);
		inventoryPanel.setBackground(Color.white);
		inventoryPanel.setLayout(new GridLayout(5, 1));
		add(inventoryPanel);
	
		item1 = new JButton();
		item1.setBackground(Color.white);
		item1.setForeground(Color.black);
		item1.setFont(normalFont);
		item1.setFocusPainted(false);
		item1.addActionListener(new InventoryHandler());
		item1.setActionCommand("item1");
		item2 = new JButton();
		item2.setBackground(Color.white);
		item2.setForeground(Color.black);
		item2.setFont(normalFont);
		item2.setFocusPainted(false);
		item2.addActionListener(new InventoryHandler());
		item2.setActionCommand("item2");
		item3 = new JButton();
		item3.setBackground(Color.white);
		item3.setForeground(Color.black);
		item3.setFont(normalFont);
		item3.setFocusPainted(false);
		item3.addActionListener(new InventoryHandler());
		item3.setActionCommand("item3");
		item4 = new JButton();
		item4.setBackground(Color.white);
		item4.setForeground(Color.black);
		item4.setFont(normalFont);
		item4.setFocusPainted(false);
		item4.addActionListener(new InventoryHandler());
		item4.setActionCommand("item4");
		item5 = new JButton();
		item5.setBackground(Color.white);
		item5.setForeground(Color.black);
		item5.setFont(normalFont);
		item5.setFocusPainted(false);
		item5.addActionListener(new InventoryHandler());
		item5.setActionCommand("item5");
		inventoryPanel.add(item1);
		inventoryPanel.add(item2);
		inventoryPanel.add(item3);
		inventoryPanel.add(item4);
		inventoryPanel.add(item5);
	}

	public class ChoiceHandler implements ActionListener, Serializable{
		public void actionPerformed(ActionEvent e) {

			String yourChoice = e.getActionCommand();
			switch(yourChoice) {
				case "start": visibilityManager.showCharacterSelectionScreen(); break;
				case "estudiante": visibilityManager.showGameScreen(); story.defaultPlayer(1); break;
				case "maestro": visibilityManager.showGameScreen(); story.defaultPlayer(2); break;
				case "reportero": visibilityManager.showGameScreen(); story.defaultPlayer(3); break;
				case "c1": story.selectPosition(position1); break;
				case "c2": story.selectPosition(position2); break;
				case "c3": story.selectPosition(position3); break;
				case "c4": story.selectPosition(position4); break;
			}
		}
	}

	public class InventoryHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			String yourChoice = e.getActionCommand();
			switch(yourChoice) {
				case "inventoryButton":
					if(story.inventoryStatus.equals("closed")) {
						c1.setVisible(false);
						c2.setVisible(false);
						c3.setVisible(false);
						c4.setVisible(false);
						inventoryPanel.setVisible(true);
						item1.setText(story.mochila[0].name);
						item2.setText(story.mochila[1].name);
						item3.setText(story.mochila[2].name);
						item4.setText(story.mochila[3].name);
						item5.setText(story.mochila[4].name);
						story.inventoryStatus = "open";
					} else {
						c1.setVisible(true);
						c2.setVisible(true);
						c3.setVisible(true);
						c4.setVisible(true);
						inventoryPanel.setVisible(false);
						story.inventoryStatus = "closed";
					}
				break;
				case "item1": story.itemUsed(0); break;
				case "item2": story.itemUsed(1); break;
				case "item3": story.itemUsed(2); break;
				case "item4": story.itemUsed(3); break;
				case "item5": story.itemUsed(4); break;
			}
		}
	}

	public class GuardarHistoria implements ActionListener{
		public void actionPerformed(ActionEvent e){
			try{
				FileOutputStream fos = new FileOutputStream("story.rest");
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(story);
				oos.close();
			}catch(IOException e1){
				e1.printStackTrace();
			}
		}
	}

	public class CargarHistoria implements ActionListener{
		public void actionPerformed(ActionEvent e){
			try{
				FileInputStream fis = new FileInputStream("story.rest");
				ObjectInputStream ois = new ObjectInputStream(fis);
				story = (Story)ois.readObject();
			}catch(IOException | ClassNotFoundException e1){
				e1.printStackTrace();
			}
		}
	}




}