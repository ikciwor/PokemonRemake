package framework;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;

public class FrameBuilt implements FrameInterface {
	private JFrame frame;
	private JButton moveButton0;
	private JButton moveButton1;
	private JButton moveButton2;
	private JButton moveButton3;
	private JButton switchButton;
	private JButton runButton;
	private JButton bagButton;
	
	private JLabel hpBar1;
	private JLabel hpBar2;
	private JLabel levelBar;
	private JLabel sprite1;
	private JLabel sprite2;
	private JLabel hpLabel;
	private JLabel levelLabel1;
	private JLabel levelLabel2;
	private JLabel nameLabel1;
	private JLabel nameLabel2;
	private JLabel infoLabel;
	
	private JPanel statPanel1;
	private JPanel statPanel2;
	private JPanel buttonPanel;
	


	/**
	 * Create the application.
	 */
	public FrameBuilt() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setLayout(null);

		sprite1 = new JLabel("SPRITE");
		sprite1.setBounds(10, 99, 128, 128);
		frame.getContentPane().add(sprite1);

		sprite2 = new JLabel("SPRITE");
		sprite2.setBounds(246, 10, 128, 128);
		frame.getContentPane().add(sprite2);

		infoLabel = new JLabel("");
		infoLabel.setFont(new Font("Dialog", Font.PLAIN, 10));
		infoLabel.setBounds(0, 0, 0, 0);
		frame.getContentPane().add(infoLabel);
		infoLabel.setBackground(Color.LIGHT_GRAY);

		statPanel1 = new JPanel();
		statPanel1.setBounds(184, 155, 190, 72);
		frame.getContentPane().add(statPanel1);
		statPanel1.setLayout(null);

		nameLabel1 = new JLabel("Name");
		nameLabel1.setFont(new Font("Dialog", Font.PLAIN, 10));
		nameLabel1.setBounds(10, 10, 100, 21);
		statPanel1.add(nameLabel1);

		levelLabel1 = new JLabel("lvl: ");
		levelLabel1.setFont(new Font("Dialog", Font.PLAIN, 10));
		levelLabel1.setBounds(108, 10, 72, 14);
		statPanel1.add(levelLabel1);

		hpBar1 = new JLabel("hp");
		hpBar1.setBounds(10, 37, 168, 9);
		statPanel1.add(hpBar1);

		hpLabel = new JLabel("HP: ");
		hpLabel.setFont(new Font("Dialog", Font.PLAIN, 10));
		hpLabel.setBounds(108, 24, 72, 14);
		statPanel1.add(hpLabel);

		levelBar = new JLabel("lvl");
		levelBar.setBounds(10, 52, 170, 9);
		statPanel1.add(levelBar);

		statPanel2 = new JPanel();
		statPanel2.setLayout(null);
		statPanel2.setBounds(10, 10, 190, 58);
		frame.getContentPane().add(statPanel2);

		nameLabel2 = new JLabel("Name");
		nameLabel2.setFont(new Font("Dialog", Font.PLAIN, 10));
		nameLabel2.setBounds(10, 10, 114, 21);
		statPanel2.add(nameLabel2);

		levelLabel2 = new JLabel("lvl: ");
		levelLabel2.setFont(new Font("Dialog", Font.PLAIN, 10));
		levelLabel2.setBounds(134, 9, 46, 23);
		statPanel2.add(levelLabel2);

		hpBar2 = new JLabel("hp");
		hpBar2.setBounds(10, 37, 168, 9);
		statPanel2.add(hpBar2);

		buttonPanel = new JPanel();
		buttonPanel.setBounds(10, 238, 364, 72);
		frame.getContentPane().add(buttonPanel);
		buttonPanel.setLayout(null);

		moveButton3 = new JButton("");
		moveButton3.setFont(new Font("Dialog", Font.PLAIN, 10));
		moveButton3.setBackground(Color.LIGHT_GRAY);
		moveButton3.setForeground(Color.BLACK);
		moveButton3.setBounds(89, 36, 89, 36);
		buttonPanel.add(moveButton3);

		moveButton1 = new JButton("");
		moveButton1.setFont(new Font("Dialog", Font.PLAIN, 10));
		moveButton1.setBackground(Color.LIGHT_GRAY);
		moveButton1.setForeground(Color.BLACK);
		moveButton1.setBounds(89, 0, 89, 36);
		buttonPanel.add(moveButton1);

		moveButton0 = new JButton("");
		moveButton0.setFont(new Font("Dialog", Font.PLAIN, 10));
		moveButton0.setBackground(Color.LIGHT_GRAY);
		moveButton0.setForeground(Color.BLACK);
		moveButton0.setBounds(0, 0, 89, 36);
		buttonPanel.add(moveButton0);

		moveButton2 = new JButton("");
		moveButton2.setFont(new Font("Dialog", Font.PLAIN, 10));
		moveButton2.setBackground(Color.LIGHT_GRAY);
		moveButton2.setForeground(Color.BLACK);
		moveButton2.setBounds(0, 36, 89, 36);
		buttonPanel.add(moveButton2);

		runButton = new JButton("RUN");
		runButton.setFont(new Font("Dialog", Font.PLAIN, 10));
		runButton.setBackground(Color.LIGHT_GRAY);
		runButton.setForeground(Color.BLACK);
		runButton.setBounds(241, 36, 62, 36);
		buttonPanel.add(runButton);

		switchButton = new JButton("PkMn");
		switchButton.setFont(new Font("Dialog", Font.PLAIN, 10));
		switchButton.setBackground(Color.LIGHT_GRAY);
		switchButton.setForeground(Color.BLACK);
		switchButton.setBounds(302, 0, 62, 72);
		buttonPanel.add(switchButton);

		bagButton = new JButton("BAG");
		bagButton.setFont(new Font("Dialog", Font.PLAIN, 10));
		bagButton.setBackground(Color.LIGHT_GRAY);
		bagButton.setForeground(Color.BLACK);
		bagButton.setBounds(241, 0, 62, 36);
		buttonPanel.add(bagButton);
		frame.setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 400, 360);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public JButton getMoveButton0() {
		return moveButton0;
	}

	@Override
	public JButton getMoveButton1() {
		return moveButton1;
	}

	@Override
	public JButton getMoveButton2() {
		return moveButton2;
	}

	@Override
	public JButton getMoveButton3() {
		return moveButton3;
	}

	@Override
	public JButton getSwitchButton() {
		return switchButton;
	}

	@Override
	public JButton getRunButton() {
		return runButton;
	}

	@Override
	public JButton getBagButton() {
		return bagButton;
	}

	public JLabel getHpBar1() {
		return hpBar1;
	}

	public JLabel getHpBar2() {
		return hpBar2;
	}

	public JLabel getLvlBar() {
		return levelBar;
	}

	public JLabel getHpLabel() {
		return hpLabel;
	}

	public JLabel getLvlLabel1() {
		return levelLabel1;
	}

	public JLabel getLvlLabel2() {
		return levelLabel2;
	}

	public JLabel getInfoLabel() {
		return infoLabel;
	}

	@Override
	public JLabel getLevelBar() {
		return levelBar;
	}

	@Override
	public JLabel getSprite1() {
		return sprite1;
	}

	@Override
	public JLabel getSprite2() {
		return sprite2;
	}

	@Override
	public JLabel getLevelLabel1() {
		return levelLabel1;
	}

	@Override
	public JLabel getLevelLabel2() {
		return levelLabel2;
	}

	@Override
	public JLabel getNameLabel1() {
		return nameLabel1;
	}

	@Override
	public JLabel getNameLabel2() {
		return nameLabel2;
	}

	public JPanel getStatPanel1() {
		return statPanel1;
	}

	public JPanel getStatPanel2() {
		return statPanel2;
	}

	public JPanel getButtonPanel() {
		return buttonPanel;
	}
	
	
	
}
