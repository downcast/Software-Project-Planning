//import java.awt.EventQueue;
import java.awt.*;
//import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.text.BadLocationException;
import java.awt.event.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.*;


public class WelcomeScreen {  
	JDialog input1 = new javax.swing.JDialog();
	

	private JFrame frmProjectManager;
	private JTextField projectNameField;
	private JTextField customerNameField;
	private JTextField stakeholderField;
	private JTextPane projectDescriptionPane;
	private JTextArea description;
	private JTextArea teamMembers;
	
	public boolean serializedComplete = false;
	
	ProjectData projData;
	
	String projectName;
	String customerName;
	String stakeholders;
	String projectDescription;
	String textArea;
	String teamMembersText;

	/**
	 * Launch the application.
	 */
	public static project currentProject;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WelcomeScreen window = new WelcomeScreen();
					window.frmProjectManager.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public WelcomeScreen() {
		initialize();
	}
	
	void LoadAbout(){
		
		float versionNum = 1.0f;
		JFrame af = new JFrame("About");
		af.setVisible(true);
		af.setResizable(false);
		af.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		af.setBounds(300, 400, 450, 300);
		af.setLocationRelativeTo(frmProjectManager);
		
		JLabel lblNewLabel = new JLabel("Version Number " + versionNum + ".");
		lblNewLabel.setBounds(12, 13, 247, 16);
		af.getContentPane().add(lblNewLabel);
		
		JLabel lblGroup = new JLabel("Group 4: ");
		lblGroup.setHorizontalAlignment(SwingConstants.CENTER);
		lblGroup.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblGroup.setVerticalAlignment(SwingConstants.TOP);
		lblGroup.setBounds(136, 47, 123, 25);
		af.getContentPane().add(lblGroup);
		
		JLabel lblPatrickMiller = new JLabel("Patrick Miller");
		lblPatrickMiller.setHorizontalAlignment(SwingConstants.CENTER);
		lblPatrickMiller.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPatrickMiller.setBounds(136, 75, 110, 16);
		af.getContentPane().add(lblPatrickMiller);
		
		JLabel lblNoorMasood = new JLabel("Noor Masood");
		lblNoorMasood.setHorizontalAlignment(SwingConstants.CENTER);
		lblNoorMasood.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNoorMasood.setBounds(136, 104, 110, 16);
		af.getContentPane().add(lblNoorMasood);
		
		JLabel lblVishalPatel = new JLabel("Vishal Patel");
		lblVishalPatel.setHorizontalAlignment(SwingConstants.CENTER);
		lblVishalPatel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblVishalPatel.setBounds(136, 133, 110, 16);
		af.getContentPane().add(lblVishalPatel);
		
		JLabel lblEthanMitchell = new JLabel("Ethan Mitchell");
		lblEthanMitchell.setHorizontalAlignment(SwingConstants.CENTER);
		lblEthanMitchell.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEthanMitchell.setBounds(136, 162, 110, 16);
		af.getContentPane().add(lblEthanMitchell);
		
		JLabel lblMarcusSmith = new JLabel("Marcus Smith");
		lblMarcusSmith.setHorizontalAlignment(SwingConstants.CENTER);
		lblMarcusSmith.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMarcusSmith.setBounds(136, 191, 110, 16);
		af.getContentPane().add(lblMarcusSmith);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(146, 224, 56, 16);
		af.getContentPane().add(lblNewLabel_1);
		
		description.getDocument().putProperty("filterNewlines", true);

		
		//aboutFrame.setLocationRelativeTo(this.frmProjectManager);
	}

	//comment
	/**
	 * Initialize the contents of the frame.
	 */
	void initialize() {
		frmProjectManager = new JFrame();
		frmProjectManager.setTitle("Project Manager 2016 Welcome Screen");
		frmProjectManager.setResizable(false);
		frmProjectManager.setBounds(100, 100, 1024, 576);
		frmProjectManager.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//DISPOSE_ON_CLOSE);
		frmProjectManager.getContentPane().setLayout(null);
		frmProjectManager.setVisible(true);
		
		//description.getInputMap().put(KeyStroke.getKeyStroke("ENTER"), "doNothing");
		
		JLayeredPane RecentProjectPane = new JLayeredPane();
		JLayeredPane NewProjectPane = new JLayeredPane();
		RecentProjectPane.setVisible(true);
		NewProjectPane.setVisible(false);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(0, 0, 200, 541);
		frmProjectManager.getContentPane().add(panel);
		panel.setLayout(null);
		
		projData = new ProjectData();
		
		//-------------New Project-------------------
		JButton btnNewProject = new JButton("New Project");
		btnNewProject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RecentProjectPane.setVisible(false);
				NewProjectPane.setVisible(true);
			}
		});
		btnNewProject.setBounds(35, 50, 130, 65);
		panel.add(btnNewProject);
		
		JButton openProjectButton = new JButton("Open Project");
		openProjectButton.setBounds(35, 220, 130, 65);
		panel.add(openProjectButton);
		openProjectButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OpenFile();
			}
		});
		
		JButton aboutButton = new JButton("About");
		aboutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoadAbout();
			}
		});
		aboutButton.setBounds(35, 390, 130, 65);
		panel.add(aboutButton);

		NewProjectPane.setVisible(false);
		
		NewProjectPane.setBounds(200, 0, 815, 541);
		frmProjectManager.getContentPane().add(NewProjectPane);
		NewProjectPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(29, 69, 609, 356);
		NewProjectPane.add(panel_1);
		panel_1.setVisible(true);
		
		JButton EnterInfoButton = new JButton("Enter Information");
		EnterInfoButton.setBounds(20, 470, 160, 65);
		NewProjectPane.add(EnterInfoButton);
		panel_1.setLayout(null);
		panel_1.setPreferredSize(new Dimension(609, 2000));
		
		EnterInfoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					EnterInformation();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		
		
		JLabel lblprojectName = new JLabel("*Project Name:");
		lblprojectName.setBounds(0, 50, 215, 33);
		panel_1.add(lblprojectName);
		lblprojectName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		projectNameField = new JTextField();
		projectNameField.setBounds(137, 50, 469, 26);
		panel_1.add(projectNameField);
		projectNameField.setToolTipText("tool tip text sample");
		projectNameField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		projectNameField.setColumns(10);
		
		
		
		
		JScrollPane scrollPane = new JScrollPane(panel_1);
		
		customerNameField = new JTextField();
		customerNameField.setToolTipText("tool tip text sample");
		customerNameField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		customerNameField.setColumns(10);
		customerNameField.setBounds(147, 98, 459, 26);
		panel_1.add(customerNameField);
		
		JLabel lblCustomerName = new JLabel("Customer Name:");
		lblCustomerName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCustomerName.setBounds(10, 95, 215, 33);
		panel_1.add(lblCustomerName);
		
		stakeholderField = new JTextField();
		stakeholderField.setToolTipText("tool tip text sample");
		stakeholderField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		stakeholderField.setColumns(10);
		stakeholderField.setBounds(147, 141, 459, 26);
		panel_1.add(stakeholderField);
		
		JLabel lblStakeholders = new JLabel("Stakeholders:");
		lblStakeholders.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblStakeholders.setBounds(10, 141, 215, 33);
		panel_1.add(lblStakeholders);
		
		JLabel lblProjectDescription = new JLabel("Project Description:");
		lblProjectDescription.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblProjectDescription.setBounds(10, 185, 215, 33);
		panel_1.add(lblProjectDescription);
		
		description = new JTextArea();
		description.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) 
			{
				if (e.getKeyCode() == KeyEvent.VK_ENTER)
				{
					e.consume();
				}
			}
			
			@Override
			public void keyReleased(KeyEvent e) 
			{
				if (e.getKeyCode() == KeyEvent.VK_ENTER)
				{
					e.consume();
				}
			}
		});
		description.setWrapStyleWord(true);
		description.setLineWrap(true);
		description.setFont(new Font("Tahoma", Font.PLAIN, 13));
		description.setText("Description text");
		description.setBounds(183, 187, 423, 230);
		panel_1.add(description);
		
		JLabel lblTeamMembers = new JLabel("Team Members:");
		lblTeamMembers.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTeamMembers.setBounds(10, 454, 215, 33);
		panel_1.add(lblTeamMembers);
		
		teamMembers = new JTextArea();
		teamMembers.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) 
			{
				if (e.getKeyCode() == KeyEvent.VK_ENTER)
				{
					e.consume();
				}
			}
			
			@Override
			public void keyReleased(KeyEvent e) 
			{
				if (e.getKeyCode() == KeyEvent.VK_ENTER)
				{
					e.consume();
				}
			}
		});
		teamMembers.setWrapStyleWord(true);
		teamMembers.setText("Team Members Text");
		teamMembers.setLineWrap(true);
		teamMembers.setFont(new Font("Tahoma", Font.PLAIN, 13));
		teamMembers.setBounds(183, 454, 423, 176);
		panel_1.add(teamMembers);
		
		
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		JLabel lblEnterWhatYou = new JLabel("Enter What You Know");
		lblEnterWhatYou.setBounds(0, 0, 815, 60);
		panel_1.add(lblEnterWhatYou);
		lblEnterWhatYou.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEnterWhatYou.setHorizontalAlignment(SwingConstants.CENTER);
		
		scrollPane.setBounds(0, 0, 810, 460);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		NewProjectPane.add(scrollPane);
		
		JTextArea txtrProjectManager = new JTextArea();
		txtrProjectManager.setBounds(370, 0, 532, 64);
		frmProjectManager.getContentPane().add(txtrProjectManager);
		txtrProjectManager.setEditable(false);
		txtrProjectManager.setFont(new Font("Tahoma", Font.PLAIN, 49));
		txtrProjectManager.setText("Project Manager 2016");
		txtrProjectManager.setBackground(SystemColor.menu);
		
		JTextArea txtrWelcomeLetsCreate = new JTextArea();
		txtrWelcomeLetsCreate.setBackground(SystemColor.menu);
		txtrWelcomeLetsCreate.setBounds(350, 70, 545, 26);
		frmProjectManager.getContentPane().add(txtrWelcomeLetsCreate);
		txtrWelcomeLetsCreate.setText("Welcome! Let's create a new project or open an existing project.");
		txtrWelcomeLetsCreate.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JTextArea txtrPleaseStartFrom = new JTextArea();
		txtrPleaseStartFrom.setText("Please start from the sidebar on the left to begin managing your software project.");
		txtrPleaseStartFrom.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtrPleaseStartFrom.setBackground(SystemColor.menu);
		txtrPleaseStartFrom.setBounds(269, 100, 676, 26);
		frmProjectManager.getContentPane().add(txtrPleaseStartFrom);
		
		
		RecentProjectPane.setBounds(200, 0, 815, 541);
		frmProjectManager.getContentPane().add(RecentProjectPane);
		
		RecentProjectPane.setVisible(true);
	}
	
	void OpenFile()
	{
		JFileChooser chooser = new JFileChooser();
		// Puts it at the project directory
		chooser.setCurrentDirectory(new File("."));
		// Looks only at txt files
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Project files (*.txt)", "txt");
		chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		
		chooser.setFileFilter(filter);
		int returnVal = chooser.showOpenDialog(null);
		
		if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            
            try {
				MainWindow loadedWindow = new MainWindow(file.getName());
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
        } 
		
	}
	
	void EnterInformation() throws IOException
	{
		project p = new project();
		p.setTitle("Your mother");
		
		projData.saveData(p);
		
		
		projectName = projectNameField.getText();
		customerName = customerNameField.getText();
		stakeholders = stakeholderField.getText();
		//projectDescription = projectDescriptionPane.getText();
		int len = description.getDocument().getLength();
		teamMembersText = teamMembers.getText();
		
		try {
			textArea = description.getText(0, len);
		} catch (BadLocationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		//projectDescription = projectDescriptionField.getText();
		
		/*
		project project = new project();
		project.setTitle(projectName);
		project.setCustomer(customerName);  
		*/
		
		if (!serializedComplete)
		{
			File file = new File("" + projectName + ".txt");
		
		 FileWriter writer = null;
	    	try {
	        	writer = new FileWriter(file);
	        
	        	writer.write(projectName);
	        	writer.write(String.format("%n"));
	        	writer.write(customerName);
	        	writer.write(String.format("%n"));
	        	writer.write(stakeholders);
	        	writer.write(String.format("%n"));
	        	//writer.write(projectDescription);
	        	//writer.write(String.format("%n"));
	        	writer.write(textArea);
	        	writer.write(String.format("%n"));
	        	writer.write(teamMembersText);
	        	
	        	//line needed to push
	        
	    	} catch (IOException e) {
	        	e.printStackTrace(); // I'd rather declare method with throws IOException and omit this catch.
	    	} finally {
	        	if (writer != null) try { writer.close(); } catch (IOException ignore) {}
	    	}
	    	System.out.printf("File is located at %s%n", file.getAbsolutePath());  
	    	
			frmProjectManager.dispose();
			MainWindow mw = new MainWindow(projectName + ".txt");
		}
	}
}
