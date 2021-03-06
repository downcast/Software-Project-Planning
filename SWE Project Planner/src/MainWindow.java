import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Window.Type;
import javax.swing.JPanel;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import java.awt.Toolkit;
import javax.swing.JLayeredPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import java.io.*;
import javax.swing.JTextPane;
import javax.swing.KeyStroke;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;

public class MainWindow implements FocusListener{
	
	String fileToLoad;
	JFrame frmProjectManager;
	private JTextField projectNameField;
	private JTextField mainCustomerNameField;
	private JTextField stakeholdersField;
	private JTextPane descriptionPane;
	private JTextArea description;
	private JTextArea teamMembers;
	/** Holds the Requirement component that is current selected **/
	private JTextArea focusedRequirement;
	String state = "Edit";
	private int funIndex, nonIndex = 0;
	
	private JPanel nonFunctionalScrollPanePanel;
	private JPanel functionalScrollPanePanel;
	private project currentProject;
	private JButton newGeneralButton;
	private JButton saveButton;
	private JTextField designingEditField;
	private JTextField codingEditField;
	private JTextField testingEditField;
	private JTextField projectManagementField;
	private JTextField designingCurrentField;
	private JTextField codingCurrentField;
	private JTextField testingCurrentField;
	private JTextField projectManagementCurrentField;
	private JTextField userTotalCurrentField;
	private JTextField projectTotalCurrentField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow("New Serialization.pjm");
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
	public MainWindow(String fileName)
	{
		fileToLoad = fileName;
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		frmProjectManager = new JFrame();
		frmProjectManager.setResizable(false);
		frmProjectManager.setTitle("Project Manager 2016");

		frmProjectManager.setBounds(100, 100, 1024, 576);
		frmProjectManager.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmProjectManager.getContentPane().setLayout(null);
		frmProjectManager.setVisible(true);
		//Code for icon
		try {
			frmProjectManager.setIconImage(ImageIO.read(new File("src/PMLogo.png")));
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		JLayeredPane Requirements = new JLayeredPane();
		JLayeredPane saveTempPane = new JLayeredPane();
		JLayeredPane General = new JLayeredPane();
		
		Requirements.setVisible(false);
		saveTempPane.setVisible(false);  
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 200, 541);
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, null, null, null));
		frmProjectManager.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton WelcomeScreenBtnSide = new JButton("Welcome Screen");
		WelcomeScreenBtnSide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmProjectManager.dispose();
				WelcomeScreen ws = new WelcomeScreen();
			}
		});
		WelcomeScreenBtnSide.setBounds(0, 0, 199, 80);
		panel.add(WelcomeScreenBtnSide);
		
		
		Requirements.setVisible(false);
		JLayeredPane EffortMonitoring = new JLayeredPane();
		EffortMonitoring.setBounds(200, 0, 815, 541);
		frmProjectManager.getContentPane().add(EffortMonitoring);
		EffortMonitoring.setVisible(false);
		EffortMonitoring.setLayout(null);
		
		JLabel lblEffortMonitoringandTracking = new JLabel("Effort Monitoring and Tracking");
		lblEffortMonitoringandTracking.setHorizontalAlignment(SwingConstants.CENTER);
		lblEffortMonitoringandTracking.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEffortMonitoringandTracking.setBounds(298, 41, 250, 22);
		EffortMonitoring.add(lblEffortMonitoringandTracking);
		Requirements.setBounds(200, 0, 815, 541);
		frmProjectManager.getContentPane().add(Requirements);
		Requirements.setLayout(null);
		
		JButton btnNewButton_1;
		newGeneralButton = new JButton("General");
		newGeneralButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Requirements.setVisible(false);
				EffortMonitoring.setVisible(false);
				saveTempPane.setVisible(false);
				General.setVisible(true);
			}
		});
		
		newGeneralButton.setBounds(0, 115, 199, 80);
		panel.add(newGeneralButton);
		saveButton = new JButton("Save");
		
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveDataEntered();
			}
		});
		
		saveButton.setBounds(0, 460, 199, 80);
		panel.add(saveButton);
		
		JButton btnEffortMonitoringAnd = new JButton("Effort Monitoring");
		btnEffortMonitoringAnd.setBounds(0, 460, 199, 80);
		//This line caused effort monitoring issue. Leaving here in case needed.
		//panel.add(btnEffortMonitoringAnd);
		
		General.setVisible(true);

		JLabel lblDesigning = new JLabel("Designing");
		lblDesigning.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDesigning.setBounds(25, 165, 139, 25);
		EffortMonitoring.add(lblDesigning);
		
		JLabel lblCoding = new JLabel("Coding");
		lblCoding.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCoding.setBounds(25, 210, 71, 25);
		EffortMonitoring.add(lblCoding);
		
		JLabel lblTesting = new JLabel("Testing");
		lblTesting.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTesting.setBounds(25, 255, 71, 25);
		EffortMonitoring.add(lblTesting);
		
		JLabel lblProjectManagement = new JLabel("Project Management");
		lblProjectManagement.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblProjectManagement.setBounds(25, 300, 181, 25);
		EffortMonitoring.add(lblProjectManagement);
		
		JLabel lblUserTotal = new JLabel("User Total");
		lblUserTotal.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUserTotal.setBounds(26, 385, 95, 25);
		EffortMonitoring.add(lblUserTotal);
		
		JLabel lblNewLabel_1 = new JLabel("Project Total");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(26, 435, 119, 25);
		EffortMonitoring.add(lblNewLabel_1);
		
		JLabel lblEditHours = new JLabel("Edit Hours");
		lblEditHours.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEditHours.setBounds(275, 95, 101, 32);
		EffortMonitoring.add(lblEditHours);
		
		JLabel lblCurrentHours = new JLabel("Current Hours");
		lblCurrentHours.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCurrentHours.setBounds(558, 95, 148, 32);
		EffortMonitoring.add(lblCurrentHours);
		
		designingEditField = new JTextField();
		designingEditField.setHorizontalAlignment(SwingConstants.CENTER);
		designingEditField.setBounds(260, 165, 116, 22);
		EffortMonitoring.add(designingEditField);
		designingEditField.setColumns(10);
		
		codingEditField = new JTextField();
		codingEditField.setHorizontalAlignment(SwingConstants.CENTER);
		codingEditField.setBounds(260, 210, 116, 22);
		EffortMonitoring.add(codingEditField);
		codingEditField.setColumns(10);
		
		testingEditField = new JTextField();
		testingEditField.setHorizontalAlignment(SwingConstants.CENTER);
		testingEditField.setBounds(260, 255, 116, 22);
		EffortMonitoring.add(testingEditField);
		testingEditField.setColumns(10);
		
		projectManagementField = new JTextField();
		projectManagementField.setHorizontalAlignment(SwingConstants.CENTER);
		projectManagementField.setBounds(260, 300, 116, 22);
		EffortMonitoring.add(projectManagementField);
		projectManagementField.setColumns(10);
		
		designingCurrentField = new JTextField();
		designingCurrentField.setText("5");
		designingCurrentField.setEditable(false);
		designingCurrentField.setHorizontalAlignment(SwingConstants.CENTER);
		designingCurrentField.setBounds(558, 165, 116, 22);
		EffortMonitoring.add(designingCurrentField);
		designingCurrentField.setColumns(10);
		
		codingCurrentField = new JTextField();
		codingCurrentField.setText("3");
		codingCurrentField.setEditable(false);
		codingCurrentField.setHorizontalAlignment(SwingConstants.CENTER);
		codingCurrentField.setBounds(558, 210, 116, 22);
		EffortMonitoring.add(codingCurrentField);
		codingCurrentField.setColumns(10);
		
		testingCurrentField = new JTextField();
		testingCurrentField.setText("2");
		testingCurrentField.setEditable(false);
		testingCurrentField.setHorizontalAlignment(SwingConstants.CENTER);
		testingCurrentField.setBounds(558, 255, 116, 22);
		EffortMonitoring.add(testingCurrentField);
		testingCurrentField.setColumns(10);
		
		projectManagementCurrentField = new JTextField();
		projectManagementCurrentField.setText("5");
		projectManagementCurrentField.setEditable(false);
		projectManagementCurrentField.setHorizontalAlignment(SwingConstants.CENTER);
		projectManagementCurrentField.setBounds(558, 300, 116, 22);
		EffortMonitoring.add(projectManagementCurrentField);
		projectManagementCurrentField.setColumns(10);
		
		userTotalCurrentField = new JTextField();
		userTotalCurrentField.setText("15");
		userTotalCurrentField.setEditable(false);
		userTotalCurrentField.setHorizontalAlignment(SwingConstants.CENTER);
		userTotalCurrentField.setBounds(558, 385, 116, 22);
		EffortMonitoring.add(userTotalCurrentField);
		userTotalCurrentField.setColumns(10);
		
		projectTotalCurrentField = new JTextField();
		projectTotalCurrentField.setText("42");
		projectTotalCurrentField.setEditable(false);
		projectTotalCurrentField.setHorizontalAlignment(SwingConstants.CENTER);
		projectTotalCurrentField.setBounds(558, 435, 116, 22);
		EffortMonitoring.add(projectTotalCurrentField);
		projectTotalCurrentField.setColumns(10);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(25, 483, 200, 45);
		EffortMonitoring.add(btnAdd);
		
		JButton btnSubtract = new JButton("Subtract");
		btnSubtract.setBounds(224, 483, 200, 45);
		EffortMonitoring.add(btnSubtract);
		Requirements.setBounds(200, 0, 815, 541);
		frmProjectManager.getContentPane().add(Requirements);
		Requirements.setLayout(null);

		
		
		JLabel lblRequirements = new JLabel("Requirements");
		lblRequirements.setHorizontalAlignment(SwingConstants.CENTER);
		lblRequirements.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRequirements.setBounds(351, 41, 168, 22);
		Requirements.add(lblRequirements);
		
		JPanel functionalPane = new JPanel();
		functionalPane.setLayout(null);
		functionalPane.setBounds(407, 70, 407, 471);
		Requirements.add(functionalPane);
		
		JScrollPane functionalScrollPane = new JScrollPane();
		functionalScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		functionalScrollPane.setBounds(0, 70, 407, 401);
		functionalPane.add(functionalScrollPane);
		
		functionalScrollPanePanel = new JPanel();
		functionalScrollPane.setViewportView(functionalScrollPanePanel);
		
		// Makes it so that when a textField is added, it adds it underneath the previous one like in a stack
		functionalScrollPanePanel.setLayout(new BoxLayout(functionalScrollPanePanel, BoxLayout.Y_AXIS));
		
		JLabel functionalLabel = new JLabel("Functional");
		functionalLabel.setBounds(165, 5, 77, 14);
		functionalPane.add(functionalLabel);
		
		JButton functionalAdd = new JButton("Add");
		functionalAdd.setVisible(false);
		
		functionalAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTextArea f = new JTextArea("Fun Requirement " + funIndex);
				f.setLineWrap(true);
				f.setWrapStyleWord(true);
				f.addFocusListener(MainWindow.this);
				funIndex++;
				functionalScrollPanePanel.add(f);
				functionalScrollPanePanel.revalidate();
			}
		});
		
		functionalAdd.setBounds(10, 35, 89, 23);
		functionalPane.add(functionalAdd);
		
		JButton functionalRemove = new JButton("Remove");
		functionalRemove.setVisible(false);
		functionalRemove.setBounds(109, 35, 89, 23);
		functionalPane.add(functionalRemove);
		
		functionalRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (focusedRequirement != null){
					functionalScrollPanePanel.remove(focusedRequirement);
					functionalScrollPanePanel.revalidate();
					functionalScrollPanePanel.repaint();
				}
			}
		});
		
		JButton functionalEdit = new JButton(state);
		functionalEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (functionalEdit.getText().equalsIgnoreCase("View")){
					state = "Edit";
					functionalEdit.setText(state);
					functionalAdd.setVisible(false);
					functionalRemove.setVisible(false);
					
					for (Component j : functionalScrollPanePanel.getComponents()){
						j.setEnabled(false);
					}
				} else {
					state = "View";
					functionalEdit.setText(state);
					functionalAdd.setVisible(true);
					functionalRemove.setVisible(true);
					for (Component j : functionalScrollPanePanel.getComponents()){
						j.setEnabled(true);
					}
				}
			}
		});
		functionalEdit.setBounds(308, 35, 89, 23);
		functionalPane.add(functionalEdit);
		
		JPanel nonFunctionalPane = new JPanel();
		nonFunctionalPane.setBounds(0, 70, 407, 471);
		Requirements.add(nonFunctionalPane);
		nonFunctionalPane.setLayout(null);
		
		JScrollPane nonFunctionalScrollPane = new JScrollPane();
		nonFunctionalScrollPane.setBounds(0, 70, 407, 401);
		nonFunctionalScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		nonFunctionalPane.add(nonFunctionalScrollPane);
		
		nonFunctionalScrollPanePanel = new JPanel();
		nonFunctionalScrollPane.setViewportView(nonFunctionalScrollPanePanel);
		
		// Makes it so that when a textField is added, it adds it underneath the previous one like in a stack
		nonFunctionalScrollPanePanel.setLayout(new BoxLayout(nonFunctionalScrollPanePanel, BoxLayout.Y_AXIS));
		
		JLabel lblNonfuncctional = new JLabel("Non-Functional");
		lblNonfuncctional.setBounds(165, 5, 134, 14);
		nonFunctionalPane.add(lblNonfuncctional);
		
		JButton nonFunctionalAdd = new JButton("Add");
		nonFunctionalAdd.setVisible(false);
		nonFunctionalAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JTextArea f = new JTextArea("Non Requirement " + nonIndex);
				f.setLineWrap(true);
				f.setWrapStyleWord(true);
				f.addFocusListener(MainWindow.this);
				nonIndex++;
				nonFunctionalScrollPanePanel.add(f);
				nonFunctionalScrollPanePanel.revalidate();
			}
		});
		
		nonFunctionalAdd.setBounds(10, 35, 89, 23);
		nonFunctionalPane.add(nonFunctionalAdd);
		
		JButton nonFunctionalRemove = new JButton("Remove");
		nonFunctionalRemove.setVisible(false);
		nonFunctionalRemove.setBounds(109, 35, 89, 23);
		nonFunctionalPane.add(nonFunctionalRemove);
		
		nonFunctionalRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (focusedRequirement != null){
					nonFunctionalScrollPanePanel.remove(focusedRequirement);
					nonFunctionalScrollPanePanel.revalidate();
					nonFunctionalScrollPanePanel.repaint();
				}
			}
		});
		
		JButton nonFunctionalEdit = new JButton(state);
		nonFunctionalEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (nonFunctionalEdit.getText().equalsIgnoreCase("View")){
					state = "Edit";
					nonFunctionalEdit.setText(state);
					nonFunctionalAdd.setVisible(false);
					nonFunctionalRemove.setVisible(false);
					
					for (Component j : nonFunctionalScrollPanePanel.getComponents()){
						j.setEnabled(false);
					}
				} else {
					state = "View";
					nonFunctionalEdit.setText(state);
					nonFunctionalAdd.setVisible(true);
					nonFunctionalRemove.setVisible(true);
					
					for (Component j : nonFunctionalScrollPanePanel.getComponents()){
						j.setEnabled(true);
					}
				}
			}
		});
		nonFunctionalEdit.setBounds(308, 35, 89, 23);
		nonFunctionalPane.add(nonFunctionalEdit);
		
		btnNewButton_1 = new JButton("Main Menu ");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Requirements.setVisible(false);
				EffortMonitoring.setVisible(false);
				saveTempPane.setVisible(false);
				General.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(0, 115, 199, 80);
		panel.add(btnNewButton_1);
		
		
		btnEffortMonitoringAnd = new JButton("Effort Monitoring");
		btnEffortMonitoringAnd.setBounds(0, 345, 199, 80);
		panel.add(btnEffortMonitoringAnd);
		
		General.setVisible(true);
		
		// ------------------Main Menu-----------------------------------
		General.setBounds(200, 0, 815, 541);
		frmProjectManager.getContentPane().add(General);
		General.setLayout(null);
		
		JLabel lblnewGeneral = new JLabel("General");
		lblnewGeneral.setHorizontalAlignment(SwingConstants.CENTER);
		lblnewGeneral.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblnewGeneral.setBounds(351, 41, 168, 22);
		General.add(lblnewGeneral);
		
		JLabel lblProjectName = new JLabel("Project Name:");
		lblProjectName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblProjectName.setBounds(40, 140, 150, 25);
		General.add(lblProjectName);
		
		JLabel lblNewLabel = new JLabel("Main Customer's Name:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(40, 180, 217, 25);
		General.add(lblNewLabel);
		
		projectNameField = new JTextField();
		projectNameField.setText("Project Name goes here");
		projectNameField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		projectNameField.setBounds(174, 140, 524, 25);
		General.add(projectNameField);
		projectNameField.setColumns(10);
		
		mainCustomerNameField = new JTextField();
		mainCustomerNameField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		mainCustomerNameField.setBounds(251, 180, 447, 25);
		General.add(mainCustomerNameField);
		mainCustomerNameField.setColumns(10);
		
		JLabel lblStakeholders = new JLabel("Stakeholders:");
		lblStakeholders.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblStakeholders.setBounds(40, 220, 217, 25);
		General.add(lblStakeholders);
		
		stakeholdersField = new JTextField();
		stakeholdersField.setText((String) null);
		stakeholdersField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		stakeholdersField.setColumns(10);
		stakeholdersField.setBounds(161, 220, 537, 25);
		General.add(stakeholdersField);
		
		JLabel lblDescription = new JLabel("Description:");
		lblDescription.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDescription.setBounds(40, 260, 217, 25);
		General.add(lblDescription);
		
		description = new JTextArea();
		description.setWrapStyleWord(true);
		description.setLineWrap(true);
		description.setBounds(161, 260, 537, 146);
		General.add(description);
		
		JLabel lblTeamMembers = new JLabel("Team Members:");
		lblTeamMembers.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTeamMembers.setBounds(40, 419, 217, 25);
		General.add(lblTeamMembers);
		
		teamMembers = new JTextArea();
		teamMembers.setWrapStyleWord(true);
		teamMembers.setText((String) null);
		teamMembers.setLineWrap(true);
		teamMembers.setBounds(185, 422, 537, 106);
		General.add(teamMembers);
		
		//----------------------------------------------------------------
		
		
		
		
		//-------------------General--------------------------------------
		saveTempPane.setBounds(200, 0, 815, 541);
		frmProjectManager.getContentPane().add(saveTempPane);
		saveTempPane.setLayout(null);
		
		JLabel lblGeneral = new JLabel("General");
		lblGeneral.setHorizontalAlignment(SwingConstants.CENTER);
		lblGeneral.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblGeneral.setBounds(351, 41, 168, 22);
		saveTempPane.add(lblGeneral);
		
		
		
		
		//-----------------------------------------------------------------

		
		Requirements.setBounds(200, 0, 815, 541);
		frmProjectManager.getContentPane().add(Requirements);
		Requirements.setLayout(null);
		
		lblRequirements = new JLabel("Requirements");
		lblRequirements.setHorizontalAlignment(SwingConstants.CENTER);
		lblRequirements.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRequirements.setBounds(351, 41, 168, 22);
		Requirements.add(lblRequirements);
		
		btnEffortMonitoringAnd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Requirements.setVisible(false);
				General.setVisible(false);
				saveTempPane.setVisible(false);
				EffortMonitoring.setVisible(true);
			}
		});
		
		JButton btnRequirements = new JButton("Requirements");
		btnRequirements.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				General.setVisible(false);
				EffortMonitoring.setVisible(false);
				saveTempPane.setVisible(false);
				Requirements.setVisible(true);
				
				/*ArrayList<Component> temp = new ArrayList<>();
				for (Component j : nonFunctionalScrollPanePanel.getComponents()){
					temp.add(j);
				}
				currentProject.setNonFunRequirements(temp);
				
				ArrayList<Component> temp2 = new ArrayList<>();
				for (Component j : functionalScrollPanePanel.getComponents()){
					temp2.add(j);
				}
				currentProject.setFunRequirements(temp2);
				ProjectData.saveData(currentProject);
				*/
			}
		});
		btnRequirements.setBounds(0, 230, 199, 80);
		panel.add(btnRequirements);
		
		//loadProject(fileToLoad);
		currentProject = ProjectData.loadData(fileToLoad);
		
		// -----------Main Menu content being populated -----------------
		projectNameField.setText(currentProject.getTitle());
		mainCustomerNameField.setText(currentProject.getCustomer());
		stakeholdersField.setText(currentProject.getStakeholder());
		description.setText(currentProject.getDescription());
		teamMembers.setText(currentProject.getTeamMembers());
		
		// ------------ Requirement content being populated -----------
		for (Component j : currentProject.getNonFunRequirements()){
			j.addFocusListener(this);
			j.setEnabled(false);
			nonFunctionalScrollPanePanel.add((JTextArea)j);
		}
		nonFunctionalScrollPanePanel.revalidate();
		nonFunctionalScrollPanePanel.repaint();
		
		for (Component j : currentProject.getFunRequirements()){
			j.addFocusListener(this);
			j.setEnabled(false);
			functionalScrollPanePanel.add((JTextArea)j);
		}
		functionalScrollPanePanel.revalidate();
		functionalScrollPanePanel.repaint();
	}
	
	public void loadProject(String fileName)
	{
		/*File temp = new File(fileToLoad);
		Scanner fileScan = new Scanner(temp);
		projectNameField.setText(fileScan.nextLine());
		mainCustomerNameField.setText(fileScan.nextLine());
		stakeholdersField.setText(fileScan.nextLine());
		/*for (int i = 0; i < fileScan.nextInt(); i++)
		{
			description.setText(fileScan.nextLine());
		} */
		/*
		description.setText(fileScan.nextLine());
		teamMembers.setText(fileScan.nextLine());
		*/	
	}
	
	private void saveDataEntered(){
		
		/** Main Menu */
		currentProject.setTitle(projectNameField.getText());
		currentProject.setCustomer(mainCustomerNameField.getText());
		currentProject.setStakeholders(stakeholdersField.getText());
		currentProject.setDescription(description.getText());
		currentProject.setTeamMembers(teamMembers.getText());
		
		/** Requirments */
		ArrayList<Component> temp = new ArrayList<>();
		for (Component j : nonFunctionalScrollPanePanel.getComponents()){
			temp.add(j);
		}
		currentProject.setNonFunRequirements(temp);
		
		ArrayList<Component> temp2 = new ArrayList<>();
		for (Component j : functionalScrollPanePanel.getComponents()){
			temp2.add(j);
		}
		currentProject.setFunRequirements(temp2);
		
		ProjectData.saveData(currentProject);
	}

	@Override
	public void focusGained(FocusEvent event) {
		focusedRequirement = (JTextArea) event.getComponent();
	}

	@Override
	public void focusLost(FocusEvent arg0) {
		// Used by the Requirements
		// Does nothing on purpose.
		// Here call arg0.getComponent() to find out who has lost focus
	}
}
