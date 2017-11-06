package maingame;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.util.*;
import java.awt.*;
public class Clock extends JFrame implements Runnable{

	private JPanel contentPane;
	private JTextField txtTimeArea;
	private Thread th;
	public int count1 = 0;
	public int count2 = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Clock frame = new Clock();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Clock() {
		// interface code
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 188, 74);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblTime = new JLabel("Time");
		contentPane.add(lblTime, BorderLayout.WEST);
		
		txtTimeArea = new JTextField();
		contentPane.add(txtTimeArea, BorderLayout.CENTER);
		txtTimeArea.setColumns(10);
		
		setVisible(true);
		// end of interface
		
		th = new Thread(this);
		th.start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while(true) {
				for(int j = 59; j >= 0; j--) {
					Thread.sleep(1000);
					count2++;
					txtTimeArea.setText(count1 + " : " + count2);
				}
				count1++;
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}

}



