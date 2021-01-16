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
import javax.swing.Timer;

public class MainFrame extends JFrame{
	
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
	
	private int minute = 25;
	private int second = 0;
	
	private boolean isPause = false;
	
	private Timer pomodoroTimer;
	
	public MainFrame() {
	
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
		statLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
	
		timerButton = new JButton(new ImageIcon("res/Pause.png"));
		timerButton.setBackground(null);
		timerButton.setBorder(null);
		timerButton.setContentAreaFilled(false);
		timerButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		mainPanel.setBackground(Color.white);

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
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		
		//play timer
		setTimer();

		
		//play pause action listener
		timerButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				if(isPause) {
					isPause = false;
					timerButton.setIcon(new ImageIcon("res/play.png"));
					pomodoroTimer.stop();
				}
				else if (!isPause){
					isPause = true;
					timerButton.setIcon(new ImageIcon("res/pause.png"));
					pomodoroTimer.start();
				}
			}
		});
	}
	
	public void setTimer() {
		pomodoroTimer = new Timer(1000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String secondTimer = String.format("%02d", second);
				String minuteTimer = String.format("%02d", minute);
				
				//if work time end
				if(minute == 0 && second == 0) {
					pomodoroTimer.stop();
				}
				
				if(second == 0) {
					second = 60;
					minute--;
				}
				
				second--;	
				timerLabel.setText(minuteTimer + ":" + secondTimer);
			}
		});
		
		pomodoroTimer.start();
	}
	
}
