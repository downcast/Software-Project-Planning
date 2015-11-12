import java.awt.EventQueue;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLayeredPane;
import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JProgressBar;

public class WelcomeScreen {
	JDialog input1 = new javax.swing.JDialog();
	

	private JFrame frmProjectManager;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
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
		
		//aboutFrame.setLocationRelativeTo(this.frmProjectManager);
	}

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
		
		JLayeredPane RecentProjectPane = new JLayeredPane();
		JLayeredPane NewProjectPane = new JLayeredPane();
		RecentProjectPane.setVisible(true);
		NewProjectPane.setVisible(false);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(0, 0, 200, 541);
		frmProjectManager.getContentPane().add(panel);
		panel.setLayout(null);
		
		//-------------New Project-------------------
		JButton btnNewProject = new JButton("New Project");
		btnNewProject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RecentProjectPane.setVisible(false);
				NewProjectPane.setVisible(true);
				CreateNewProject();
			}
		});
		btnNewProject.setBounds(35, 50, 130, 65);
		panel.add(btnNewProject);
		
		JButton btnNewButton = new JButton("Open Project");
		btnNewButton.setBounds(35, 220, 130, 65);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("About");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoadAbout();
			}
		});
		btnNewButton_1.setBounds(35, 390, 130, 65);
		panel.add(btnNewButton_1);

		NewProjectPane.setVisible(false);
		
		NewProjectPane.setBounds(200, 0, 815, 541);
		frmProjectManager.getContentPane().add(NewProjectPane);
		NewProjectPane.setLayout(null);
		
		
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		JLabel lblEnterWhatYou = new JLabel("Enter What You Know");
		lblEnterWhatYou.setBounds(0, 0, 815, 60);
		lblEnterWhatYou.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEnterWhatYou.setHorizontalAlignment(SwingConstants.CENTER);
		NewProjectPane.add(lblEnterWhatYou);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(29, 69, 609, 356);
		NewProjectPane.add(panel_1);
		panel_1.setVisible(true);
		
		JButton EnterInfoButton = new JButton("Enter Information");
		EnterInfoButton.setBounds(20, 470, 160, 65);
		NewProjectPane.add(EnterInfoButton);
		panel_1.setLayout(null);
		panel_1.setPreferredSize(new Dimension(609, 2000));
		
		
		JLabel lblprojectName = new JLabel("*Project Name:");
		lblprojectName.setBounds(0, 50, 215, 33);
		panel_1.add(lblprojectName);
		lblprojectName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		textField = new JTextField();
		textField.setBounds(137, 50, 239, 26);
		panel_1.add(textField);
		textField.setToolTipText("tool tip text sample");
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane(panel_1);
		
		textField_1 = new JTextField();
		textField_1.setToolTipText("tool tip text sample");
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_1.setColumns(10);
		textField_1.setBounds(147, 98, 239, 26);
		panel_1.add(textField_1);
		
		JLabel lblCustomerName = new JLabel("Customer Name:");
		lblCustomerName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCustomerName.setBounds(10, 95, 215, 33);
		panel_1.add(lblCustomerName);
		
		textField_2 = new JTextField();
		textField_2.setToolTipText("tool tip text sample");
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_2.setColumns(10);
		textField_2.setBounds(147, 141, 239, 26);
		panel_1.add(textField_2);
		
		JLabel lblStakeholders = new JLabel("Stakeholders:");
		lblStakeholders.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblStakeholders.setBounds(10, 141, 215, 33);
		panel_1.add(lblStakeholders);
		
		JLabel lblProjectDescription = new JLabel("Project Description:");
		lblProjectDescription.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblProjectDescription.setBounds(10, 185, 215, 33);
		panel_1.add(lblProjectDescription);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(174, 185, 212, 78);
		panel_1.add(textPane);
		
		scrollPane.setBounds(0, 0, 810, 460);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		NewProjectPane.add(scrollPane);
		
		
		RecentProjectPane.setBounds(200, 0, 815, 541);
		frmProjectManager.getContentPane().add(RecentProjectPane);
		
		RecentProjectPane.setVisible(true);
	}
	
	
	void CreateNewProject()
	{
		
		
	}
}
