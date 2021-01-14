package frame;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class MainFrame extends JFrame{
	
	private JPanel mainPanel;
	private JPanel buttonPanel;
	private JLabel timerLabel;
	private JLabel statLabel;
	private JButton playPauseButton;
	private JLabel pomodoro1;
	private JLabel pomodoro2;
	private JLabel pomodoro3;
	private JLabel pomodoro4;
	
	private Timer timer;
	
	private int minute = 1;
	private int second = 0;
	
	String ddSecond, ddMinute;
	DecimalFormat dFormat = new DecimalFormat("00");
	
	private boolean isPause = false;

	
	public MainFrame() {
		
		ddSecond = dFormat.format(second);
		ddMinute = dFormat.format(minute);
		
		mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout(0, 0, 0));
		
		timerLabel = new JLabel();
		timerLabel.setFont(new Font("res/Lato-Regular.ttf", Font.PLAIN , 58));
		timerLabel.setText(ddMinute + ":" + ddSecond);
		timerLabel.setHorizontalAlignment(JLabel.CENTER);
		timerLabel.setForeground(Color.BLACK);
		
		statLabel = new JLabel();
		statLabel.setFont(new Font("res/Lato-Regular.ttf", Font.PLAIN, 16));
		statLabel.setText("view stats");
		statLabel.setHorizontalAlignment(JLabel.RIGHT);
		statLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		pomodoro1 = new JLabel(new ImageIcon("res/twotone_dot.png"));
		pomodoro2 = new JLabel(new ImageIcon("res/outline_dot.png"));
		pomodoro3 = new JLabel(new ImageIcon("res/outline_dot.png"));
		pomodoro4 = new JLabel(new ImageIcon("res/outline_dot.png"));
		
		playPauseButton = new JButton(new ImageIcon("res/pause.png"));
		playPauseButton.setContentAreaFilled(false);
		playPauseButton.setBorder(null);
		playPauseButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			
		buttonPanel.add(playPauseButton);
		buttonPanel.add(pomodoro1);
		buttonPanel.add(pomodoro2);
		buttonPanel.add(pomodoro3);
		buttonPanel.add(pomodoro4);
		
		
		mainPanel.add(timerLabel, BorderLayout.NORTH);
		mainPanel.add(buttonPanel, BorderLayout.CENTER);
		mainPanel.add(statLabel, BorderLayout.SOUTH);
			
		buttonPanel.setBackground(new Color(229, 80, 57));
		mainPanel.setBackground(new Color(229, 80, 57));
		
		playPauseButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
		
				if(isPause == true) {
					playPauseButton.setIcon(new ImageIcon("res/pause.png"));
					timer.start();
					isPause = false;
				}
				else if(isPause == false) {
					playPauseButton.setIcon(new ImageIcon("res/play.png"));
					timer.stop();
					isPause = true;
				}
				
			}
		});
		
		setTimer();
		
		add(mainPanel);
		setTitle("Pomodoro");
		setIconImage(new ImageIcon("res/tomato.png").getImage());
		setLocationRelativeTo(null);
		setResizable(false);
		setSize(300, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	
	}
	
	private void setTimer() {
		
		timer = new Timer(1000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				timerLabel.setText(ddMinute + ":" + ddSecond);
				
				if(second == 0) {
					minute--;
					second = 60;
				}
			
				second--;
				
				if(minute == 0 && second == 0 ) {
					minute = 25;
					second = 0;
				}
				
				ddSecond = dFormat.format(second);
				ddMinute = dFormat.format(minute);
			
			}
		});
		
		timer.start();
	}
}	
