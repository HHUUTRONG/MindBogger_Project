package maingame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
//import maingame.Board.AcButton;

public class BoardButtons_LogicHandlingExpert{
	public Buttons[][] board;
	public void addBoardofButtonsExpert(JPanel boardPanel) {
		// panel contains board
		boardPanel.setLayout(new GridLayout(15,15,5,5));
		board = new Buttons[15][15];
		int lbl = 1; // lbl is the number displayed on each button
		
		for(int i = 0; i < 15; i++)
		{
			for(int j = 0; j < 15; j++)
			{
				board[i][j] = new Buttons();
				board[i][j].button = new JButton(""+lbl);
				board[i][j].button.setBackground(Color.green);
				board[i][j].button.setSize(50, 50);
				boardPanel.add(board[i][j].button);
				board[i][j].button.addActionListener( new AcButton());
				board[i][j].button.setActionCommand("Green");
				board[i][j].button.setName(""+i+j);
				lbl++; // increase the number
			}
		}
	}
	
	class AcButton implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String actionCommand = e.getActionCommand();
			JButton btn = (JButton) e.getSource();
			String name = btn.getName();
			
			System.out.println("here 1:"+name);
			
			GameLogicExpert(actionCommand, btn, name);
		}
	}
	
	public void VictoryCriteriaExpert() {
		int win = 1;
		for(int i = 0; i < 15; i++)
		{
			for(int j = 0; j < 15; j++)
			{
				if(!board[i][j].button.getActionCommand().equals("Red"))
				{
					win = 2;
				}
			}
		}
		if(win == 1)
		{
			JOptionPane.showMessageDialog(null, "Congrat !!! you win the game");
		}
	}
	
	
	public void handlingAffectedButton(Buttons _button) {
		
		System.out.println("here 2: "+_button.button.getName() +"/"+ _button.getName());
		if(_button.button.getActionCommand().equals("Green")) // consider if the color of this button is red or green to change color
		{
			_button.ChangeRedColorIcon();
			_button.button.setActionCommand("Red");
		}else{
			_button.ChangeGreenColorIcon();
			_button.button.setActionCommand("Green");
		}
		
		
		
		
	}
	
	public void GameLogicExpert(String actionCommand, JButton btn, String name) {
		
		System.out.println("here 3:" + name);
		// Logic of game
			for(int i = 0; i < 15; i++)
			{
				for(int j = 0; j < 15; j++)
				{
					if(name.equals(""+i+j))
					{
						if(actionCommand.equals("Green"))
						{
							board[i][j].ChangeRedColorIcon();
							board[i][j].button.setActionCommand("Red");
							//hadling event of affected buttons
							
							if(i == 0)
							{
								if(j == 0) //top left button
								{
									// 1 0
									handlingAffectedButton(board[1][0]);// consider if the color of this button is red or green to change color
									// 0 1
									handlingAffectedButton(board[0][1]);
									// 14 0
									handlingAffectedButton(board[14][0]);
									// 0 14
									handlingAffectedButton(board[0][14]);
									
									System.out.println("i=0, j=0");
								}
								if(j == 14) // top right button
								{
									// 0 13
									handlingAffectedButton(board[0][13]);
									// 1 14
									handlingAffectedButton(board[1][14]);
									// 0 0
									handlingAffectedButton(board[0][0]);
									// 14 14
									handlingAffectedButton(board[14][14]);
									System.out.println("i=0, j=14");
								}
								if(j >= 1) // top row0, column between 1 and 13
								{
									if(j <= 13)
									{
										
										
										// 0 j-1
										handlingAffectedButton(board[0][j-1]);
										// 0 j+1
										handlingAffectedButton(board[0][j+1]);
										// 1 j
										handlingAffectedButton(board[1][j]);
										// 14 j
										handlingAffectedButton(board[14][j]);
										System.out.println("i=0, j=1/13");
									}
								}
							}//end i=0
							
							
							if(i == 14)
							{
								if(j == 0) // bottom left button
								{
									// 13 0
									handlingAffectedButton(board[13][0]);
									// 14 1
									handlingAffectedButton(board[14][1]);
									// 0 0
									handlingAffectedButton(board[0][0]);
									// 14 14
									handlingAffectedButton(board[14][14]);
									System.out.println("i=14, j=0");
								}
								if(j == 14) // bottom right button
								{
									// 13 14
									handlingAffectedButton(board[13][14]);
									// 14 13
									handlingAffectedButton(board[14][13]);
									// 0 14	
									handlingAffectedButton(board[0][14]);
									// 14 0
									handlingAffectedButton(board[14][0]);
									System.out.println("i=14, j=14");
								}
								// handling buttons of row bottom, column from 1 to 3
								if(j >= 1)
								{
									if(j <= 13)
									{
										// 14 j-1
										handlingAffectedButton(board[14][j-1]);
										// 14 j+1
										handlingAffectedButton(board[14][j+1]);
										// 13 j
										handlingAffectedButton(board[13][j]);
										// 0 j
										handlingAffectedButton(board[0][j]);
										
										System.out.println("i=14, j=1/13");
									}
								}
							}//end i=14
							
							if(i >= 1)
							{
								if(i <= 13) // row between 1 and 13
								{
									if(j == 0) // row between 1 and 13, column 0 (left)
									{
										// i-1 0
										handlingAffectedButton(board[i-1][0]);
										// i+1 0
										handlingAffectedButton(board[i+1][0]);
										// i j+1
										handlingAffectedButton(board[i][j+1]);
										// i 14
										handlingAffectedButton(board[i][14]);
										System.out.println("13>i>=1, j=0");
									}
									else
									if(j == 14) // row between 1 and 13, column 14 (right)
									{
										// i-1 14
										handlingAffectedButton(board[i-1][14]);
										// i+1 14
										handlingAffectedButton(board[i+1][14]);
										// i 13
										handlingAffectedButton(board[i][13]);
										// i 0
										handlingAffectedButton(board[i][0]);
										System.out.println("13>i>=1, j=14");
									}
									
									else
									if(j >= 1)
									{
										if(j <= 13)
										{
//										
											System.out.println("13>i>=1, j=1/13");
											System.out.println("here 4: i=" + i+ "j=" +j);
											//center buttons
											// i-1 j
											handlingAffectedButton(board[i-1][j]);
											System.out.println("here 4 1:" +board[i-1][j].button.getName());
											// i+1 j
											handlingAffectedButton(board[i+1][j]);
											System.out.println("here 4 2:" +board[i-1][j].button.getName());
											// i j-1
											handlingAffectedButton(board[i][j-1]);
											System.out.println("here 4 3:" +board[i-1][j].button.getName());
											// i j+1
											handlingAffectedButton(board[i][j+1]);
											System.out.println("here 4 4:" + board[i-1][j].button.getName());
											
											System.out.println("end here 4:j=" +j);
											break;
										}
									}
								}
							}
							break;
						}
						else // red
						{
							
							System.out.println("here 5");
							
							board[i][j].ChangeGreenColorIcon();
							board[i][j].button.setActionCommand("Green");
							//hadling event of affected buttons
							if(i == 0)
							{
								if(j == 0) //top left button
								{
									// 1 0
									handlingAffectedButton(board[1][0]);// consider if the color of this button is red or green to change color
									// 0 1
									handlingAffectedButton(board[0][1]);
									// 14 0
									handlingAffectedButton(board[14][0]);
									// 0 14
									handlingAffectedButton(board[0][14]);
								}
								if(j == 14) // top right button
								{
									// 0 13
									handlingAffectedButton(board[0][13]);
									// 1 14
									handlingAffectedButton(board[1][14]);
									// 0 0
									handlingAffectedButton(board[0][0]);
									// 14 14
									handlingAffectedButton(board[14][14]);
								}
								if(j >= 1) // top row0, column between 1 and 13
								{
									if(j <= 13)
									{
										// 0 j-1
										handlingAffectedButton(board[0][j-1]);
										// 0 j+1
										handlingAffectedButton(board[0][j+1]);
										// 1 j
										handlingAffectedButton(board[1][j]);
										// 14 j
										handlingAffectedButton(board[14][j]);
									}
								}
							}
							if(i == 14)
							{
								if(j == 0) // bottom left button
								{
									// 13 0
									handlingAffectedButton(board[13][0]);
									// 14 1
									handlingAffectedButton(board[14][1]);
									// 0 0
									handlingAffectedButton(board[0][0]);
									// 14 14
									handlingAffectedButton(board[14][14]);
								}
								if(j == 14) // bottom right button
								{
									// 13 14
									handlingAffectedButton(board[13][14]);
									// 14 13
									handlingAffectedButton(board[14][13]);
									// 0 14	
									handlingAffectedButton(board[0][14]);
									// 14 0
									handlingAffectedButton(board[14][0]);
								}
								// handling buttons of row bottom, column from 1 to 3
								if(j >= 1)
								{
									if(j <= 13)
									{
										// 14 j-1
										handlingAffectedButton(board[14][j-1]);
										// 14 j+1
										handlingAffectedButton(board[14][j+1]);
										// 13 j
										handlingAffectedButton(board[13][j]);
										// 0 j
										handlingAffectedButton(board[0][j]);
									}
								}
							}
							if(i >= 1)
							{
								if(i <= 13) // row between 1 and 13
								{
									if(j == 0) // row between 1 and 13, column 0 (left)
									{
										// i-1 0
										handlingAffectedButton(board[i-1][0]);
										// i+1 0
										handlingAffectedButton(board[i+1][0]);
										// i j+1
										handlingAffectedButton(board[i][j+1]);
										// i 14
										handlingAffectedButton(board[i][14]);
									}
									if(j == 14) // row between 1 and 13, column 14 (right)
									{
										// i-1 14
										handlingAffectedButton(board[i-1][14]);
										// i+1 14
										handlingAffectedButton(board[i+1][14]);
										// i 13
										handlingAffectedButton(board[i][13]);
										// i 0
										handlingAffectedButton(board[i][0]);
									}
									if(j >= 1)
									{
										if(j <= 13)
										{
//											if(i == 1) {
//												if(j == 10) {
//													handlingAffectedButton(board[0][10]);
//													handlingAffectedButton(board[2][10]);
//													handlingAffectedButton(board[1][9]);
//													handlingAffectedButton(board[1][11]);
//												}
//												else if(j == 11) {
//													handlingAffectedButton(board[0][11]);
//													handlingAffectedButton(board[2][11]);
//													handlingAffectedButton(board[1][10]);
//													handlingAffectedButton(board[1][12]);
//												}
//												else if(j == 12) {
//													handlingAffectedButton(board[0][12]);
//													handlingAffectedButton(board[2][12]);
//													handlingAffectedButton(board[1][11]);
//													handlingAffectedButton(board[1][13]);
//												}
//												else if(j == 13) {
//													handlingAffectedButton(board[0][13]);
//													handlingAffectedButton(board[2][13]);
//													handlingAffectedButton(board[1][12]);
//													handlingAffectedButton(board[1][14]);
//												}
//												else if(j == 14) {
//													handlingAffectedButton(board[0][14]);
//													handlingAffectedButton(board[2][14]);
//													handlingAffectedButton(board[1][13]);
//													handlingAffectedButton(board[1][0]);
//												}
//											}
											//center buttons
											// i-1 j
											handlingAffectedButton(board[i-1][j]);
											// i+1 j
											handlingAffectedButton(board[i+1][j]);
											// i j-1
											handlingAffectedButton(board[i][j-1]);
											// i j+1
											handlingAffectedButton(board[i][j+1]);
										}
									}
								}
							}
						}
					}
				}
			}
			// win the game criteria
			VictoryCriteriaExpert();
	}
}
