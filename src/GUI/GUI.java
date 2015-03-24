package GUI;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;


public class GUI extends JFrame implements KeyListener{
	Color [] palett = {Color.white, Color.black, Color.blue, Color.green};
	private JPanel boardPanel, instructionPanel;
	private JPanel [][] board;
	private JButton first, next, previous, last;
	private ArrayList<int[][]> iterations;
	private int pointer = 0;
	private JLabel pointerLab = new JLabel("state number : " + (pointer));
	
	
	public GUI(int x, int y, ArrayList<int[][]> states){
		iterations = states;
		board = new JPanel[x][y];
		boardPanel = new JPanel();
		instructionPanel = new JPanel();
		boardPanel.setLayout(new GridBagLayout());
		instructionPanel.setLayout(new GridBagLayout());
		this.setLayout(new GridBagLayout());
		
		
		GridBagConstraints c = new GridBagConstraints();
		this.add(pointerLab, c);
		JPanel temp;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				c.gridx=i;
				c.gridy=j;
				temp = new JPanel();
				temp.setBackground(Color.white);
				temp.setPreferredSize(new Dimension(10, 10));
				temp.setBorder(new MatteBorder(1,1,1,1, Color.gray));
				board[i][j] = temp;
				boardPanel.add(temp, c);
			}
		}
		c.gridx = 0;
		c.gridy = 1;
		this.add(boardPanel, c);		
		
		first = new JButton(new ImageIcon("src\\GUI\\img\\first.jpg"));
		first.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				pointer = 0;
				update();
				
			}
		});
		instructionPanel.add(first);
		previous = new JButton(new ImageIcon("src\\GUI\\img\\previous.jpg"));
		previous.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				pointer--;
				update();
				
			}
		});
		instructionPanel.add(previous);
		next = new JButton(new ImageIcon("src\\GUI\\img\\next.jpg"));
		next.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				pointer++;
				update();
				
			}
		});
		instructionPanel.add(next);
		last = new JButton(new ImageIcon("src\\GUI\\img\\last.jpg"));
		last.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				pointer = iterations.size()-1;
				update();
				
			}
		});
		instructionPanel.add(last);
		
		c.gridy = 2;
		this.add(instructionPanel, c);
		
		
		first.addKeyListener(this);
		previous.addKeyListener(this);
		next.addKeyListener(this);
		last.addKeyListener(this);
		this.addKeyListener(this);
		this.setFocusable(true);
		update();
		
	}
	private void update(){
		if (pointer==iterations.size()-1) {
			next.setEnabled(false);
			last.setEnabled(false);
		}else{
			next.setEnabled(true);
			last.setEnabled(true);
		}
		
		if(pointer==0){
			previous.setEnabled(false);
			first.setEnabled(false);
		}else{
			previous.setEnabled(true);
			first.setEnabled(true);
		}
	
		pointerLab.setText("state number : " + (pointer));
		int [][] current = iterations.get(pointer);
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				board[i][j].setBackground(palett[current[i][j]]);
			}
		}
		

	}
	
	
	
	

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			next.doClick();
		}		
		
		if(e.getKeyCode() == KeyEvent.VK_LEFT){
			previous.doClick();
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}
