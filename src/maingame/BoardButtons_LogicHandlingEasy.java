package maingame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
//import maingame.Board.AcButton;

public class BoardButtons_LogicHandlingEasy{
	public Buttons[][] board;
	Clock c;
	public void addBoardofButtonsEasy(JPanel boardPanel) {
		// panel contains board
		boardPanel.setLayout(new GridLayout(5,5,5,5));
		board = new Buttons[5][5];
		int lbl = 1; // lbl is the number displayed on each button
		
		for(int i = 0; i < 5; i++)
		{
			for(int j = 0; j < 5; j++)
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
			
			GameLogicEasy(actionCommand, btn, name);
		}
	}
	
	public void VictoryCriteriaEasy() {
		int win = 1;
		for(int i = 0; i < 5; i++)
		{
			for(int j = 0; j < 5; j++)
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
			MarkAnalyzeEasy(c);
		}
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
	
	public void GameLogicEasy(String actionCommand, JButton btn, String name) {
		// Logic of game
			for(int i = 0; i < 5; i++)
			{
				for(int j = 0; j < 5; j++)
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
									// 4 0
									handlingAffectedButton(board[4][0]);
									// 0 4
									handlingAffectedButton(board[0][4]);
								}
								if(j == 4) // top right button
								{
									// 0 3
									handlingAffectedButton(board[0][3]);
									// 1 4
									handlingAffectedButton(board[1][4]);
									// 0 0
									handlingAffectedButton(board[0][0]);
									// 4 4
									handlingAffectedButton(board[4][4]);
								}
								if(j >= 1) // top row0 column between 1 and 3
								{
									if(j <= 3)
									{
										// 0 j-1
										handlingAffectedButton(board[0][j-1]);
										// 0 j+1
										handlingAffectedButton(board[0][j+1]);
										// 1 j
										handlingAffectedButton(board[1][j]);
										// 4 j
										handlingAffectedButton(board[4][j]);
									}
								}
							}
							if(i == 4)
							{
								if(j == 0) // bottom left button
								{
									// 3 0
									handlingAffectedButton(board[3][0]);
									// 4 1
									handlingAffectedButton(board[4][1]);
									// 0 0
									handlingAffectedButton(board[0][0]);
									// 4 4
									handlingAffectedButton(board[4][4]);
								}
								if(j == 4) // bottom right button
								{
									// 3 4
									handlingAffectedButton(board[3][4]);
									// 4 3
									handlingAffectedButton(board[4][3]);
									// 0 4	
									handlingAffectedButton(board[0][4]);
									// 4 0
									handlingAffectedButton(board[4][0]);
								}
								// handling buttons of row bottom column from 1 to 3
								if(j >= 1)
								{
									if(j <= 3)
									{
										// 4 j-1
										handlingAffectedButton(board[4][j-1]);
										// 4 j+1
										handlingAffectedButton(board[4][j+1]);
										// 3 j
										handlingAffectedButton(board[3][j]);
										// 0 j
										handlingAffectedButton(board[0][j]);
									}
								}
							}
							if(i >= 1)
							{
								if(i <= 3) // row between 1 and 3
								{
									if(j == 0)
									{
										// i-1 0
										handlingAffectedButton(board[i-1][0]);
										// i+1 0
										handlingAffectedButton(board[i+1][0]);
										// i j+1
										handlingAffectedButton(board[i][j+1]);
										// i 4
										handlingAffectedButton(board[i][4]);
									}
									if(j == 4)
									{
										// i-1 4
										handlingAffectedButton(board[i-1][4]);
										// i+1 4
										handlingAffectedButton(board[i+1][4]);
										// i 3
										handlingAffectedButton(board[i][3]);
										// i 0
										handlingAffectedButton(board[i][0]);
									}
									if(j >= 1)
									{
										if(j <= 3)
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
									// 4 0
									handlingAffectedButton(board[4][0]);
									// 0 4
									handlingAffectedButton(board[0][4]);
								}
								if(j == 4) // top right button
								{
									// 0 3
									handlingAffectedButton(board[0][3]);
									// 1 4
									handlingAffectedButton(board[1][4]);
									// 0 0
									handlingAffectedButton(board[0][0]);
									// 4 4
									handlingAffectedButton(board[4][4]);
								}
								if(j >= 1) // top row0 column between 1 and 3
								{
									if(j <= 3)
									{
										// 0 j-1
										handlingAffectedButton(board[0][j-1]);
										// 0 j+1
										handlingAffectedButton(board[0][j+1]);
										// 1 j
										handlingAffectedButton(board[1][j]);
										// 4 j
										handlingAffectedButton(board[4][j]);
									}
								}
							}
							if(i == 4)
							{
								if(j == 0) // bottom left button
								{
									// 3 0
									handlingAffectedButton(board[3][0]);
									// 4 1
									handlingAffectedButton(board[4][1]);
									// 0 0
									handlingAffectedButton(board[0][0]);
									// 4 4
									handlingAffectedButton(board[4][4]);
								}
								if(j == 4) // bottom right button
								{
									// 3 4
									handlingAffectedButton(board[3][4]);
									// 4 3
									handlingAffectedButton(board[4][3]);
									// 0 4	
									handlingAffectedButton(board[0][4]);
									// 4 0
									handlingAffectedButton(board[4][0]);
								}
								// handling buttons of row bottom column from 1 to 3
								if(j >= 1)
								{
									if(j <= 3)
									{
										// 4 j-1
										handlingAffectedButton(board[4][j-1]);
										// 4 j+1
										handlingAffectedButton(board[4][j+1]);
										// 3 j
										handlingAffectedButton(board[3][j]);
										// 0 j
										handlingAffectedButton(board[0][j]);
									}
								}
							}
							if(i >= 1)
							{
								if(i <= 3) // row between 1 and 3
								{
									if(j == 0)
									{
										// i-1 0
										handlingAffectedButton(board[i-1][0]);
										// i+1 0
										handlingAffectedButton(board[i+1][0]);
										// i j+1
										handlingAffectedButton(board[i][j+1]);
										// i 4
										handlingAffectedButton(board[i][4]);
									}
									if(j == 4)
									{
										// i-1 4
										handlingAffectedButton(board[i-1][4]);
										// i+1 4
										handlingAffectedButton(board[i+1][4]);
										// i 3
										handlingAffectedButton(board[i][3]);
										// i 0
										handlingAffectedButton(board[i][0]);
									}
									if(j >= 1)
									{
										if(j <= 3)
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
			// win the game criteria
			VictoryCriteriaEasy();
	}
	
	public void MarkAnalyzeEasy(Clock c) {
		if(c.count1 == 0 && c.count2 <= 30 ) {
			System.out.println("100");
		}else if(c.count1 >= 0 && c.count1 < 2) {
			if(c.count2 > 30) {
				System.out.println("50");
			}
		}else {
			System.out.println("10");
		}
	}
}
