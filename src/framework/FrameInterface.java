package framework;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public interface FrameInterface {
	
	public JButton getMoveButton0();
	public JButton getMoveButton1();
	public JButton getMoveButton2();
	public JButton getMoveButton3();
	
	public JButton getSwitchButton();
	public JButton getRunButton();
	public JButton getBagButton();
	
	public JLabel getHpBar1();
	public JLabel getHpBar2();
	public JLabel getLevelBar();
	public JLabel getSprite1();
	public JLabel getSprite2();
	public JLabel getHpLabel();
	public JLabel getLevelLabel1();
	public JLabel getLevelLabel2();
	public JLabel getNameLabel1();
	public JLabel getNameLabel2();
	public JLabel getInfoLabel();
	
	public JPanel getStatPanel1();
	public JPanel getStatPanel2();
	public JPanel getButtonPanel();
	
	public void setVisible(boolean b);

}
