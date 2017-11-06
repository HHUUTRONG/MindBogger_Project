package maingame;
import java.awt.Color;

import javax.swing.*; 

public class Buttons extends JFrame {
	public JButton button;
//	public Icon img;
	
//	public Buttons()
//	{
//		button = new JButton();
//	}
	public void ChangeRedColorIcon()
	{
//		img = new ImageIcon("img/RedButton.png");
		button.setBackground(Color.red);
		button.setOpaque(true);
	}
	public void ChangeGreenColorIcon()
	{
//		img = new ImageIcon("img/GreenButton.png");
		button.setBackground(Color.green);
		button.setOpaque(true);
	}
}
