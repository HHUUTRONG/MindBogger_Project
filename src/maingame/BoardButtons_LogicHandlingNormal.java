package maingame;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import maingame.BoardButtons_LogicHandlingEasy.AcButton;

public class BoardButtons_LogicHandlingNormal {
	public Buttons[][] board;
	Clock c;
	public void addBoardofButtonsExpert(JPanel boardPanel) {
		// panel contains board
				boardPanel.setLayout(new GridLayout(10,10,5,5));
				board = new Buttons[10][10];
				int lbl = 1; // lbl is the number displayed on each button
				
				for(int i = 0; i < 10; i++)
				{
					for(int j = 0; j < 10; j++)
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
				
				c = new Clock();
	}
	
	class AcButton implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String actionCommand = e.getActionCommand();
			JButton btn = (JButton) e.getSource();
			String name = btn.getName();
			
			GameLogicNormal(actionCommand, btn, name);
		}
	}
	
	public void VictoryCriteriaNormal() {
		int win = 1;
		for(int i = 0; i < 10; i++)
		{
			for(int j = 0; j < 10; j++)
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
		
		MarkAnalyzeNormal(c);
	}
	
	public void handlingAffectedButton(Buttons _button) {
		if(_button.button.getActionCommand().equals("Green")) // consider if the color of this button is red or green to change color
		{
			_button.ChangeRedColorIcon();
			_button.button.setActionCommand("Red");
		}else{
			_button.ChangeGreenColorIcon();
			_button.button.setActionCommand("Green");
		}
	}
	
	public void GameLogicNormal(String actionCommand, JButton btn, String name) {
		//Logic of the game
		for(int i = 0; i < 10; i++)
		{
			for(int j = 0; j < 10; j++)
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
								handlingAffectedButton(board[1][0]);
								// 0 1
								handlingAffectedButton(board[0][1]);
								// 9 0
								handlingAffectedButton(board[9][0]);
								// 0 9
								handlingAffectedButton(board[0][9]);
							}
							if(j == 9) // top right button
							{
								// 0 8
								handlingAffectedButton(board[0][8]);
								// 1 9
								handlingAffectedButton(board[1][9]);
								// 0 0
								handlingAffectedButton(board[0][0]);
								// 9 9
								handlingAffectedButton(board[9][9]);
							}
							if(j >= 1) // top row0 column between 1 and 8
							{
								if(j <= 8)
								{
									// 0 j-1
									handlingAffectedButton(board[0][j-1]);
									// 0 j+1
									handlingAffectedButton(board[0][j+1]);
									// 1 j
									handlingAffectedButton(board[1][j]);
									// 9 j
									handlingAffectedButton(board[9][j]);
								}
							}
						}
						if(i == 9)
						{
							if(j == 0) // bottom left button
							{
								// 8 0
								handlingAffectedButton(board[8][0]);
								// 9 1
								handlingAffectedButton(board[9][1]);
								// 0 0
								handlingAffectedButton(board[0][0]);
								// 9 9
								handlingAffectedButton(board[9][9]);
							}
							if(j == 9) // bottom right button
							{
								// 8 9
								handlingAffectedButton(board[8][9]);
								// 9 8
								handlingAffectedButton(board[9][8]);
								// 0 9	
								handlingAffectedButton(board[0][9]);
								// 9 0
								handlingAffectedButton(board[9][0]);
							}
							// handling buttons of row bottom column from 1 to 8
							if(j >= 1)
							{
								if(j <= 8)
								{
									// 9 j-1
									handlingAffectedButton(board[9][j-1]);
									// 9 j+1
									handlingAffectedButton(board[9][j+1]);
									// 8 j
									handlingAffectedButton(board[8][1]);
									// 0 j
									handlingAffectedButton(board[0][j]);
								}
							}
						}
						if(i >= 1)
						{
							if(i <= 8) // row between 1 and 8
							{
								if(j == 0)
								{
									// i-1 0
									handlingAffectedButton(board[i-1][0]);
									// i+1 0
									handlingAffectedButton(board[i+1][0]);
									// i j+1
									handlingAffectedButton(board[i][j+1]);
									// i 9
									handlingAffectedButton(board[i][9]);
								}
								if(j == 9)
								{
									// i-1 9
									handlingAffectedButton(board[i-1][9]);
									// i+1 9
									handlingAffectedButton(board[i+1][9]);
									// i 8
									handlingAffectedButton(board[i][8]);
									// i 0
									handlingAffectedButton(board[i][0]);
								}
								if(j >= 1)
								{
									if(j <= 8)
									{
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
					else // red
					{
						board[i][j].ChangeGreenColorIcon();
						board[i][j].button.setActionCommand("Green");
						//hadling event of affected buttons
						if(i == 0)
						{
							if(j == 0) //top left button
							{
								// 1 0
								handlingAffectedButton(board[1][0]);
								// 0 1
								handlingAffectedButton(board[0][1]);
								// 9 0
								handlingAffectedButton(board[9][0]);
								// 0 9
								handlingAffectedButton(board[0][9]);
							}
							if(j == 9) // top right button
							{
								// 0 8
								handlingAffectedButton(board[0][8]);
								// 1 9
								handlingAffectedButton(board[1][9]);
								// 0 0
								handlingAffectedButton(board[0][0]);
								// 9 9
								handlingAffectedButton(board[9][9]);
							}
							if(j >= 1) // top row0 column between 1 and 8
							{
								if(j <= 8)
								{
									// 0 j-1
									handlingAffectedButton(board[0][j-1]);
									// 0 j+1
									handlingAffectedButton(board[0][j+1]);
									// 1 j
									handlingAffectedButton(board[1][j]);
									// 9 j
									handlingAffectedButton(board[9][j]);
								}
							}
						}
						if(i == 9)
						{
							if(j == 0) // bottom left button
							{
								// 8 0
								handlingAffectedButton(board[8][0]);
								// 9 1
								handlingAffectedButton(board[9][1]);
								// 0 0
								handlingAffectedButton(board[0][0]);
								// 9 9
								handlingAffectedButton(board[9][9]);
							}
							if(j == 9) // bottom right button
							{
								// 8 9
								handlingAffectedButton(board[8][9]);
								// 9 8
								handlingAffectedButton(board[9][8]);
								// 0 9	
								handlingAffectedButton(board[0][9]);
								// 9 0
								handlingAffectedButton(board[9][0]);
							}
							// handling buttons of row bottom column from 1 to 8
							if(j >= 1)
							{
								if(j <= 8)
								{
									// 9 j-1
									handlingAffectedButton(board[9][j-1]);
									// 9 j+1
									handlingAffectedButton(board[9][j+1]);
									// 8 j
									handlingAffectedButton(board[8][1]);
									// 0 j
									handlingAffectedButton(board[0][j]);
								}
							}
						}
						if(i >= 1)
						{
							if(i <= 8) // row between 1 and 8
							{
								if(j == 0)
								{
									// i-1 0
									handlingAffectedButton(board[i-1][0]);
									// i+1 0
									handlingAffectedButton(board[i+1][0]);
									// i j+1
									handlingAffectedButton(board[i][j+1]);
									// i 9
									handlingAffectedButton(board[i][9]);
								}
								if(j == 9)
								{
									// i-1 9
									handlingAffectedButton(board[i-1][9]);
									// i+1 9
									handlingAffectedButton(board[i+1][9]);
									// i 8
									handlingAffectedButton(board[i][8]);
									// i 0
									handlingAffectedButton(board[i][0]);
								}
								if(j >= 1)
								{
									if(j <= 8)
									{
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
		// win criteria
		VictoryCriteriaNormal();
	}
	
	public void MarkAnalyzeNormal(Clock c) {
		if(c.count2 <= 15) {
			if(c.count1 < 1) {
				System.out.println("100");
			}
			else if(c.count1 < 2) {
				System.out.println("50");
			}
		}else {
			System.out.println("10");
		}
	}
}
