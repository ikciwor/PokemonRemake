package framework;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
//import com.jgoodies.forms.layout.FormLayout;
//import com.jgoodies.forms.layout.ColumnSpec;
//import com.jgoodies.forms.layout.RowSpec;
//import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrameBuilt implements FrameInterface {
	private JFrame frame;
	private JButton moveButton0;
	private JButton moveButton1;
	private JButton moveButton2;
	private JButton moveButton3;
	private JButton switchButton;
	private JButton runButton;
	private JButton bagButton;

	/**
	 * Launch the application.
	 */
	// public static void main(String[] args) {
	// EventQueue.invokeLater(new Runnable() {
	// public void run() {
	// try {
	// FrameBuilt window = new FrameBuilt();
	// window.frame.setVisible(true);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
	// });
	// }

	/**
	 * Create the application.
	 */
	public FrameBuilt() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setLayout(null);

		JLabel pokemonSprite1 = new JLabel("SPRITE");
		pokemonSprite1.setBounds(10, 99, 128, 128);
		frame.getContentPane().add(pokemonSprite1);

		JLabel label = new JLabel("SPRITE");
		label.setBounds(246, 10, 128, 128);
		frame.getContentPane().add(label);

		JLabel infoLabel = new JLabel("");
		infoLabel.setBounds(0, 0, 0, 0);
		frame.getContentPane().add(infoLabel);
		infoLabel.setBackground(Color.LIGHT_GRAY);

		JPanel panel = new JPanel();
		panel.setBounds(184, 155, 190, 72);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel nameLabel1 = new JLabel("Name");
		nameLabel1.setBounds(10, 10, 114, 21);
		panel.add(nameLabel1);

		JLabel levelLabel1 = new JLabel("lvl: ");
		levelLabel1.setBounds(134, 9, 46, 23);
		panel.add(levelLabel1);

		JLabel hpBar1 = new JLabel("hp");
		hpBar1.setBounds(10, 37, 114, 9);
		panel.add(hpBar1);

		JLabel hpLabel = new JLabel("HP: ");
		hpLabel.setBounds(134, 34, 46, 14);
		panel.add(hpLabel);

		JLabel levelBar = new JLabel("lvl");
		levelBar.setBounds(10, 52, 164, 9);
		panel.add(levelBar);

		JLabel label_1 = new JLabel("hp");
		label_1.setBounds(312, 191, 46, 14);
		frame.getContentPane().add(label_1);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(10, 10, 190, 58);
		frame.getContentPane().add(panel_1);

		JLabel nameLabel2 = new JLabel("Name");
		nameLabel2.setBounds(10, 10, 114, 21);
		panel_1.add(nameLabel2);

		JLabel lvlLabel2 = new JLabel("lvl: ");
		lvlLabel2.setBounds(134, 9, 46, 23);
		panel_1.add(lvlLabel2);

		JLabel hpBar2 = new JLabel("hp");
		hpBar2.setBounds(10, 37, 114, 9);
		panel_1.add(hpBar2);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 238, 364, 72);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);

		moveButton3 = new JButton("");
		moveButton3.setBounds(89, 36, 89, 36);
		panel_2.add(moveButton3);

		moveButton1 = new JButton("");
		moveButton1.setBounds(89, 0, 89, 36);
		panel_2.add(moveButton1);

		moveButton0 = new JButton("");
		moveButton0.setBounds(0, 0, 89, 36);
		panel_2.add(moveButton0);

		moveButton2 = new JButton("");
		moveButton2.setBounds(0, 36, 89, 36);
		panel_2.add(moveButton2);

		runButton = new JButton("RUN");
		runButton.setBounds(241, 36, 62, 36);
		panel_2.add(runButton);

		switchButton = new JButton("PkMn");
		switchButton.setBounds(302, 0, 62, 72);
		panel_2.add(switchButton);

		bagButton = new JButton("BAG");
		bagButton.setBounds(241, 0, 62, 36);
		panel_2.add(bagButton);
		frame.setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 400, 360);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public JButton getMoveButton0() {
		// TODO Auto-generated method stub
		return moveButton0;
	}

	@Override
	public JButton getMoveButton1() {
		// TODO Auto-generated method stub
		return moveButton1;
	}

	@Override
	public JButton getMoveButton2() {
		// TODO Auto-generated method stub
		return moveButton2;
	}

	@Override
	public JButton getMoveButton3() {
		// TODO Auto-generated method stub
		return moveButton3;
	}

	@Override
	public JButton getSwitchButton() {
		// TODO Auto-generated method stub
		return switchButton;
	}

	@Override
	public JButton getRunButton() {
		// TODO Auto-generated method stub
		return runButton;
	}

	@Override
	public JButton getBagButton() {
		// TODO Auto-generated method stub
		return bagButton;
	}
}
