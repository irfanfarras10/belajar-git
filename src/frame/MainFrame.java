package frame;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainFrame extends JFrame{
	private ImageIcon image = new ImageIcon("res/tomato.png");
	private Color backgroundColor = new Color(229, 80, 75);
	private JLabel timerLabel = new JLabel("20:15", JLabel.CENTER);
	
	public MainFrame() {
		add(timerLabel);
		timerLabel.setFont(new Font("res/Lato-Regular.ttf", Font.PLAIN, 48));
		setIconImage(image.getImage());
		setSize(300, 200);
		getContentPane().setBackground(backgroundColor);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		showTimer();
	}

	
	private void showTimer() {
		
	}
}	
