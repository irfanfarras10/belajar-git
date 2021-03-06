package frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Cursor;

import java.io.File;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class TestFrame extends JFrame{
	
	private JPanel mainPanel;
	
	private JPanel timerPanel;
	private JPanel buttonPanel; 
	private JPanel countPanel; 
	private JPanel statPanel; 
	
	private JLabel timerLabel;
	private JButton timerButton;
	private JLabel countLabel1;
	private JLabel countLabel2;
	private JLabel countLabel3;
	private JLabel countLabel4;
	private JLabel statLabel;
	
	private Font customFont;
	
	private GraphicsEnvironment ge;
	
	public TestFrame() {
	
		//import font
		try {
			customFont = Font.createFont(Font.TRUETYPE_FONT, new File("res/Lato-Regular.ttf"));
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("res/LatoRegular.ttf")));
		} catch (Exception e) {
			
		} 
		
		timerLabel = new JLabel("25:00");
		timerLabel.setFont(customFont.deriveFont(50F));
		timerLabel.setForeground(Color.BLACK);
		
		countLabel1 = new JLabel(new ImageIcon("res/twotone_dot.png"));
		countLabel2 = new JLabel(new ImageIcon("res/outline_dot.png"));
		countLabel3 = new JLabel(new ImageIcon("res/outline_dot.png"));
		countLabel4 = new JLabel(new ImageIcon("res/outline_dot.png"));
		
		statLabel = new JLabel("view stats");
		statLabel.setFont(customFont.deriveFont(12F));
		statLabel.setForeground(Color.BLACK);
	
		timerButton = new JButton(new ImageIcon("res/Pause.png"));
		timerButton.setBackground(null);
		timerButton.setBorder(null);
		timerButton.setContentAreaFilled(false);
		timerButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		mainPanel.setBackground(new Color(229, 80, 57));

		timerPanel = new JPanel();
		timerPanel.setLayout(new FlowLayout());
		timerPanel.add(timerLabel);
		timerPanel.setBackground(null);
		
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		buttonPanel.add(timerButton);
		buttonPanel.setBackground(null);
		
		countPanel = new JPanel();
		countPanel.setLayout(new FlowLayout());
		countPanel.setBackground(null);
		countPanel.add(countLabel1);
		countPanel.add(countLabel2);
		countPanel.add(countLabel3);
		countPanel.add(countLabel4);
	
		statPanel = new JPanel();
		statPanel.setLayout(new BorderLayout(250, 0));
		statPanel.setBackground(null);
		statPanel.add(statLabel, BorderLayout.EAST);
		
		mainPanel.add(timerPanel);
		mainPanel.add(buttonPanel);
		mainPanel.add(countPanel);
		mainPanel.add(statPanel);
		
		add(mainPanel);
		setTitle("Pomodoro");
		setIconImage(new ImageIcon("res/tomato.png").getImage());
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		pack();
		
		//play pause action listener
		timerButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				timerButton.setIcon(new ImageIcon("res/play.png"));
			}
		});
	}
	
}
