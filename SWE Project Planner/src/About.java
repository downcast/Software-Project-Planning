import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class About extends JDialog {
	float versionNum = 1.0f;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					About dialog = new About();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public About() {
		setTitle("About Project Manager 2016");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Version Number " + versionNum + ".");
		lblNewLabel.setBounds(12, 13, 247, 16);
		getContentPane().add(lblNewLabel);
		
		JLabel lblGroup = new JLabel("Group 4: ");
		lblGroup.setHorizontalAlignment(SwingConstants.CENTER);
		lblGroup.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblGroup.setVerticalAlignment(SwingConstants.TOP);
		lblGroup.setBounds(136, 47, 123, 25);
		getContentPane().add(lblGroup);
		
		JLabel lblPatrickMiller = new JLabel("Patrick Miller");
		lblPatrickMiller.setHorizontalAlignment(SwingConstants.CENTER);
		lblPatrickMiller.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPatrickMiller.setBounds(136, 75, 110, 16);
		getContentPane().add(lblPatrickMiller);
		
		JLabel lblNoorMasood = new JLabel("Noor Masood");
		lblNoorMasood.setHorizontalAlignment(SwingConstants.CENTER);
		lblNoorMasood.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNoorMasood.setBounds(136, 104, 110, 16);
		getContentPane().add(lblNoorMasood);
		
		JLabel lblVishalPatel = new JLabel("Vishal Patel");
		lblVishalPatel.setHorizontalAlignment(SwingConstants.CENTER);
		lblVishalPatel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblVishalPatel.setBounds(136, 133, 110, 16);
		getContentPane().add(lblVishalPatel);
		
		JLabel lblEthanMitchell = new JLabel("Ethan Mitchell");
		lblEthanMitchell.setHorizontalAlignment(SwingConstants.CENTER);
		lblEthanMitchell.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEthanMitchell.setBounds(136, 162, 110, 16);
		getContentPane().add(lblEthanMitchell);
		
		JLabel lblMarcusSmith = new JLabel("Marcus Smith");
		lblMarcusSmith.setHorizontalAlignment(SwingConstants.CENTER);
		lblMarcusSmith.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMarcusSmith.setBounds(136, 191, 110, 16);
		getContentPane().add(lblMarcusSmith);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(146, 224, 56, 16);
		getContentPane().add(lblNewLabel_1);

	}
}
