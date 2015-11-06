import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Window.Type;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.JPasswordField;
import java.awt.Toolkit;
import javax.swing.JLayeredPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
 
//marcus is the high today

public class MainWindow {

	private JFrame frmProjectManager;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
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
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmProjectManager = new JFrame();
		frmProjectManager.setResizable(false);
		frmProjectManager.setTitle("Project Manager 2016");

		frmProjectManager.setBounds(100, 100, 1024, 576);
		frmProjectManager.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmProjectManager.getContentPane().setLayout(null);
		
		
		JLayeredPane Requirements = new JLayeredPane();
		JLayeredPane General = new JLayeredPane();
		JLayeredPane MainMenu = new JLayeredPane();
		JLayeredPane EffortMonitoring = new JLayeredPane();

		
		Requirements.setVisible(false);
		General.setVisible(false);  
		EffortMonitoring.setVisible(false);
		MainMenu.setVisible(true);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 200, 541);
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, null, null, null));
		frmProjectManager.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(0, 0, 199, 80);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Main Menu ");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Requirements.setVisible(false);
				EffortMonitoring.setVisible(false);
				General.setVisible(false);
				MainMenu.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(0, 115, 199, 80);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("General");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Requirements.setVisible(false);
				MainMenu.setVisible(false);
				EffortMonitoring.setVisible(false);
				General.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(0, 230, 199, 80);
		panel.add(btnNewButton_2);
		
		
		JButton btnEffortMonitoringAnd = new JButton("Effort Monitoring");
		btnEffortMonitoringAnd.setBounds(0, 460, 199, 80);
		panel.add(btnEffortMonitoringAnd);
		
		EffortMonitoring.setBounds(200, 0, 815, 541);
		frmProjectManager.getContentPane().add(EffortMonitoring);
		EffortMonitoring.setLayout(null);
		
		JLabel lblEffortMonitoringandTracking = new JLabel("Effort Monitoring and Tracking");
		lblEffortMonitoringandTracking.setHorizontalAlignment(SwingConstants.CENTER);
		lblEffortMonitoringandTracking.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEffortMonitoringandTracking.setBounds(298, 41, 250, 22);
		EffortMonitoring.add(lblEffortMonitoringandTracking);
		
		
		MainMenu.setBounds(200, 0, 815, 541);
		frmProjectManager.getContentPane().add(MainMenu);
		MainMenu.setLayout(null);
		
		JLabel lblMainMenu = new JLabel("Main Menu");
		lblMainMenu.setHorizontalAlignment(SwingConstants.CENTER);
		lblMainMenu.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMainMenu.setBounds(351, 41, 168, 22);
		MainMenu.add(lblMainMenu);
		
		General.setBounds(200, 0, 815, 541);
		frmProjectManager.getContentPane().add(General);
		General.setLayout(null);
		
		JLabel lblGeneral = new JLabel("General");
		lblGeneral.setHorizontalAlignment(SwingConstants.CENTER);
		lblGeneral.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblGeneral.setBounds(351, 41, 168, 22);
		General.add(lblGeneral);
		
		
		Requirements.setBounds(200, 0, 815, 541);
		frmProjectManager.getContentPane().add(Requirements);
		Requirements.setLayout(null);
		
		JLabel lblRequirements = new JLabel("Requirements");
		lblRequirements.setHorizontalAlignment(SwingConstants.CENTER);
		lblRequirements.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRequirements.setBounds(351, 41, 168, 22);
		Requirements.add(lblRequirements);
		
		btnEffortMonitoringAnd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Requirements.setVisible(false);
				MainMenu.setVisible(false);
				General.setVisible(false);
				EffortMonitoring.setVisible(true);
			}
		});
		
		JButton btnRequirements = new JButton("Requirements");
		btnRequirements.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainMenu.setVisible(false);
				EffortMonitoring.setVisible(false);
				General.setVisible(false);
				Requirements.setVisible(true);
			}
		});
		btnRequirements.setBounds(0, 345, 199, 80);
		panel.add(btnRequirements);
	}
}
