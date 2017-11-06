package maingame;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.util.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class GameInterface extends JFrame {
	LocaleLanguage l;
	static String LevelActionCommand;
	Clock c;
	public GameInterface() {
		LevelActionCommand = null;
		
		setTitle("Mind Boggle");
		
		l = new LocaleLanguage();
		
		getContentPane().setBackground(Color.WHITE);
		setBackground(Color.WHITE);
		setResizable(false);
		getContentPane().setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("Choose a Language");
		lblNewLabel.setFont(new Font("Gabriola", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel.setBounds(22, 23, 241, 28);
		getContentPane().add(lblNewLabel);
		
		JButton btnVietnamese = new JButton("Vietnamese");
		btnVietnamese.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				l.Vietnamese();
				StartScreen s = new StartScreen();
				setVisible(false);
			}
		});
		btnVietnamese.setFont(new Font("Gabriola", Font.ITALIC, 18));
		btnVietnamese.setBackground(Color.WHITE);
		btnVietnamese.setBounds(75, 79, 107, 23);
		getContentPane().add(btnVietnamese);
		
		JButton btnEnglish = new JButton("English");
		btnEnglish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				l.English();
				StartScreen s = new StartScreen();
				setVisible(false);
			}
		});
		btnEnglish.setFont(new Font("Gabriola", Font.ITALIC, 18));
		btnEnglish.setBackground(Color.WHITE);
		btnEnglish.setBounds(75, 113, 107, 23);
		getContentPane().add(btnEnglish);
		
		JButton btnDeuch = new JButton("Deuch");
		btnDeuch.setFont(new Font("Gabriola", Font.ITALIC, 18));
		btnDeuch.setBackground(Color.WHITE);
		btnDeuch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				l.German();
				StartScreen s = new StartScreen();
				setVisible(false);
			}
		});
		btnDeuch.setBounds(75, 147, 107, 23);
		getContentPane().add(btnDeuch);
		
		JLabel lblNewLabel_1 = new JLabel("Copy Right 2017 by 3Ts Studio");
		lblNewLabel_1.setFont(new Font("Gabriola", Font.BOLD | Font.ITALIC, 17));
		lblNewLabel_1.setBounds(44, 205, 190, 14);
		getContentPane().add(lblNewLabel_1);
		
		setSize(277, 272);
		setVisible(true);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	class StartScreen extends JFrame{
		private JPanel contentPane;
		
		public StartScreen() {
			setResizable(false);
			setTitle("Mind Bogger Game");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 450, 300);
			contentPane = new JPanel();
			contentPane.setBackground(Color.GRAY);
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(new BorderLayout(0, 0));
			
			JPanel panel = new JPanel();
			panel.setBackground(Color.WHITE);
			contentPane.add(panel, BorderLayout.NORTH);
			
			JLabel lblNewLabel = new JLabel(l.bundle.getString("title"));
			lblNewLabel.setForeground(Color.BLACK);
			lblNewLabel.setFont(new Font("Gabriola", Font.BOLD, 35));
			panel.add(lblNewLabel);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBackground(Color.WHITE);
			contentPane.add(panel_1, BorderLayout.CENTER);
			panel_1.setLayout(null);
			
			JButton btnPlay = new JButton(l.bundle.getString("btnPlay"));
			btnPlay.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					LevelBox levelBox = new LevelBox();
					setVisible(false);
				}
			});
			btnPlay.setFont(new Font("Tahoma", Font.BOLD, 11));
			btnPlay.setForeground(Color.WHITE);
			btnPlay.setBackground(Color.BLACK);
			btnPlay.setBounds(155, 25, 89, 23);
			panel_1.add(btnPlay);
			
			JButton btnExit = new JButton(l.bundle.getString("btnExit"));
			btnExit.setFont(new Font("Tahoma", Font.BOLD, 11));
			btnExit.setBackground(Color.BLACK);
			btnExit.setForeground(Color.WHITE);
			btnExit.setBounds(155, 93, 89, 23);
			panel_1.add(btnExit);
			
			JButton btnSetting = new JButton(l.bundle.getString("btnSetting"));
			btnSetting.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					SettingForm s = new SettingForm();
				}
			});
			btnSetting.setFont(new Font("Tahoma", Font.BOLD, 11));
			btnSetting.setBackground(Color.BLACK);
			btnSetting.setForeground(Color.WHITE);
			btnSetting.setBounds(155, 59, 89, 23);
			panel_1.add(btnSetting);
			
			JPanel panel_2 = new JPanel();
			panel_2.setBackground(Color.WHITE);
			contentPane.add(panel_2, BorderLayout.SOUTH);
			
			JLabel lblCoppyRight = new JLabel("Copy Right 2017 by 3Ts Studio ");
			lblCoppyRight.setFont(new Font("Gabriola", Font.BOLD, 15));
			lblCoppyRight.setForeground(Color.BLACK);
			panel_2.add(lblCoppyRight);
			
			setVisible(true);
		}
	}
	
	class LevelBox extends JFrame{
		private JPanel contentPane;
		
		public LevelBox() {
			setResizable(false);
			setTitle("Level");
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setBounds(100, 100, 192, 243);
			contentPane = new JPanel();
			contentPane.setBackground(Color.WHITE);
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JLabel lblNewLabel = new JLabel(l.bundle.getString("LevelsLabel"));
			lblNewLabel.setFont(new Font("Gabriola", Font.BOLD, 40));
			lblNewLabel.setForeground(Color.BLACK);
			lblNewLabel.setBounds(43, 23, 88, 28);
			contentPane.add(lblNewLabel);
			
			JButton btnEasy = new JButton(l.bundle.getString("EasyLevel"));
			btnEasy.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					LevelActionCommand = e.getActionCommand();
					GameFrame g = new GameFrame();
					System.out.println(LevelActionCommand);
					setVisible(false);
				}
			});
			btnEasy.setActionCommand("easy");
			btnEasy.setBackground(Color.WHITE);
			btnEasy.setFont(new Font("Gabriola", Font.BOLD | Font.ITALIC, 20));
			btnEasy.setForeground(Color.BLACK);
			btnEasy.setBounds(42, 72, 89, 23);
			contentPane.add(btnEasy);
			
			JButton btnNormal = new JButton(l.bundle.getString("NormalLevel"));
			btnNormal.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					LevelActionCommand = e.getActionCommand();
					GameFrame g = new GameFrame();
					System.out.println(LevelActionCommand);
				}
			});
			btnNormal.setActionCommand("Normal");
			btnNormal.setBackground(Color.WHITE);
			btnNormal.setForeground(Color.BLACK);
			btnNormal.setFont(new Font("Gabriola", Font.BOLD | Font.ITALIC, 20));
			btnNormal.setBounds(42, 106, 89, 23);
			contentPane.add(btnNormal);
			
			JButton btnExpert = new JButton(l.bundle.getString("ExpertLevel"));
			btnExpert.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					LevelActionCommand = e.getActionCommand();
					GameFrame g = new GameFrame();
					System.out.println(LevelActionCommand);
				}
			});
			btnExpert.setActionCommand("Expert");
			btnExpert.setBackground(Color.WHITE);
			btnExpert.setForeground(Color.BLACK);
			btnExpert.setFont(new Font("Gabriola", Font.BOLD | Font.ITALIC, 20));
			btnExpert.setBounds(42, 140, 89, 23);
			contentPane.add(btnExpert);
			
			setVisible(true);
		}
	}
	
	class GameFrame extends JFrame {
		JPanel boardPanel;
		BoardButtons_LogicHandlingEasy boardButtons_Logichandling;
		BoardButtons_LogicHandlingNormal boardButtons_LogichandlingNormal;
		BoardButtons_LogicHandlingExpert boardButtons_LogichandlingExpert;
		JMenuBar menuBar;
		JMenu fileMnenu, helpMenu;
		JMenuItem newgameMenuItem, ScoredMenuItem, instructionMenuItem;
		public GameFrame()
		{
			setLayout(new BorderLayout());
			//Menu in game
			menuBar = new JMenuBar();
			menuBar.setBackground(Color.WHITE);
			fileMnenu = new JMenu(l.bundle.getString("fileMnenu"));
			fileMnenu.setFont(new Font("Gabriola", Font.ITALIC , 17));
			helpMenu = new JMenu(l.bundle.getString("helpMenu"));
			helpMenu.setFont(new Font("Gabriola", Font.ITALIC, 17));
			newgameMenuItem = new JMenuItem(l.bundle.getString("newgameMenuItem"));
			newgameMenuItem.setBackground(Color.WHITE);
			newgameMenuItem.setFont(new Font("Gabriola", Font.ITALIC, 17));
			ScoredMenuItem = new JMenuItem(l.bundle.getString("ScoredMenuItem"));
			ScoredMenuItem.setBackground(Color.WHITE);
			ScoredMenuItem.setFont(new Font("Gabriola", Font.ITALIC, 17));
			instructionMenuItem = new JMenuItem(l.bundle.getString("instructionMenuItem"));
			instructionMenuItem.setBackground(Color.WHITE);
			instructionMenuItem.setFont(new Font("Gabriola", Font.ITALIC, 17));
			
			menuBar.add(fileMnenu);
			menuBar.add(helpMenu);
			fileMnenu.add(newgameMenuItem);
			fileMnenu.add(ScoredMenuItem);
			helpMenu.add(instructionMenuItem);
			getContentPane().add(menuBar, BorderLayout.NORTH);
			//add board of buttons in game
			boardPanel = new JPanel(); 
			//select suitable board of buttons to attach on game frame 
			if(LevelActionCommand.equals("easy")) {
				boardButtons_Logichandling = new BoardButtons_LogicHandlingEasy();
				boardButtons_Logichandling.addBoardofButtonsEasy(boardPanel);
				setSize(300,300);
				
				System.out.println("easy");
			}else if(LevelActionCommand.equals("Normal")){
				boardButtons_LogichandlingNormal = new BoardButtons_LogicHandlingNormal();
				boardButtons_LogichandlingNormal.addBoardofButtonsExpert(boardPanel);
				setSize(650,650);
			}else if(LevelActionCommand.equals("Expert")) {
				boardButtons_LogichandlingExpert = new BoardButtons_LogicHandlingExpert();
				boardButtons_LogichandlingExpert.addBoardofButtonsExpert(boardPanel);
				setSize(950,950);
			}
			
			getContentPane().add(boardPanel, BorderLayout.CENTER);
			
			setTitle("Mind Bogger Game");
			setVisible(true);
			
			setDefaultCloseOperation(EXIT_ON_CLOSE);
		}
	}
	
	class SettingForm extends JFrame{
		
		private JPanel contentPane;
		
		public SettingForm() {
			setResizable(false);
			setForeground(Color.WHITE);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 260, 300);
			contentPane = new JPanel();
			contentPane.setBackground(Color.WHITE);
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JLabel lblSetting = new JLabel(l.bundle.getString("lblSetting"));
			lblSetting.setHorizontalAlignment(SwingConstants.CENTER);
			lblSetting.setFont(new Font("Gabriola", Font.ITALIC, 45));
			lblSetting.setBounds(0, 12, 238, 57);
			contentPane.add(lblSetting);
			
			JButton btnMusic = new JButton("Music");
			btnMusic.setFont(new Font("Gabriola", Font.ITALIC, 20));
			btnMusic.setBackground(Color.WHITE);
			btnMusic.setForeground(Color.BLACK);
			btnMusic.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				}
			});
			btnMusic.setBounds(58, 80, 129, 23);
			contentPane.add(btnMusic);
			
			JButton btnHowToPlay = new JButton("How to play");
			btnHowToPlay.setFont(new Font("Gabriola", Font.ITALIC, 20));
			btnHowToPlay.setBackground(Color.WHITE);
			btnHowToPlay.setBounds(58, 114, 129, 23);
			contentPane.add(btnHowToPlay);
			
			JButton btnLanguages = new JButton("Languages");
			btnLanguages.setFont(new Font("Gabriola", Font.ITALIC, 20));
			btnLanguages.setBackground(Color.WHITE);
			btnLanguages.setBounds(58, 148, 129, 23);
			contentPane.add(btnLanguages);
			
			JButton btnAboutUs = new JButton("About Us");
			btnAboutUs.setFont(new Font("Gabriola", Font.ITALIC, 20));
			btnAboutUs.setBackground(Color.WHITE);
			btnAboutUs.setBounds(58, 182, 129, 23);
			contentPane.add(btnAboutUs);
			
			JLabel lblNewLabel = new JLabel("Copy right 2017 by 3Ts Studio");
			lblNewLabel.setFont(new Font("Gabriola", Font.ITALIC, 17));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(22, 235, 216, 26);
			contentPane.add(lblNewLabel);
			
			setVisible(true);
		}
	}
}
