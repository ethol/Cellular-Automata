package GUI;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.MatteBorder;


public class GUI extends JFrame implements KeyListener{
	Color [] palett = {Color.white, Color.black, Color.blue, Color.green, Color.red, Color.orange, Color.pink, Color.yellow, Color.cyan};
	private JPanel boardPanel, instructionPanel;
	private JPanel [][] board;
	private JButton first, next, previous, last, goTo;
	private JTextField goToField;
	private ArrayList<int[][]> iterations;
	private int pointer = 0;
	private boolean isOneDim = false;
	private JLabel pointerLab = new JLabel("state number : " + (pointer));


	public GUI(int x, int y, ArrayList<int[][]> states){
		iterations = states;
		board = new JPanel[x][y];
		boardPanel = new JPanel();
		instructionPanel = new JPanel();
		boardPanel.setLayout(new GridBagLayout());
		instructionPanel.setLayout(new GridBagLayout());
		this.setLayout(new GridBagLayout());

		if(y==1){
			isOneDim = true;
			board = new JPanel[x][states.size()];
		}

		GridBagConstraints c = new GridBagConstraints();
		JPanel temp;
		if(isOneDim){
			JScrollPane scrollPane = new JScrollPane(boardPanel);
			scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
			int width = board.length*11 + 50;
			scrollPane.setBounds(50, 30, width, 900);


			for (int i = 0; i < board.length; i++) {
				for (int j=0; j < iterations.size(); j++) {
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
			JPanel contentPane = new JPanel(null);
	        contentPane.setPreferredSize(new Dimension(width+100, 1000));
	        contentPane.add(scrollPane);
			this.getContentPane().add(contentPane, c);
		}else{
			this.add(pointerLab, c);
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
		}

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
		goToField = new JTextField();
		goToField.setColumns(6);
		goToField.setHorizontalAlignment(JTextField.RIGHT);

		instructionPanel.add(goToField);

		goTo = new JButton("Go To");
		goTo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try{
					pointer = Integer.parseInt(goToField.getText());
					if(pointer>(iterations.size()-1)){
						JOptionPane.showMessageDialog(null, "Number too big(set to max)");
						pointer= iterations.size()-1;
						goToField.setText(pointer+ "");
					}else if(pointer<0){
						JOptionPane.showMessageDialog(null, "Realy... you want to got to a negative number? How about no...");
						pointer= 0;
						goToField.setText(pointer+ "");
					}

					update();
				}catch(NumberFormatException ex){
					JOptionPane.showMessageDialog(null, "Numbers you fool");
					goToField.setText("");
				}
			}
		});
		instructionPanel.add(goTo);

		c.gridy = 2;
		this.add(instructionPanel, c);


		first.addKeyListener(this);
		previous.addKeyListener(this);
		next.addKeyListener(this);
		last.addKeyListener(this);
		goTo.addKeyListener(this);
		this.addKeyListener(this);
		this.setFocusable(true);
		update();

		if(isOneDim){
			instructionPanel.removeAll();
		}

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
		if(isOneDim){
			int [][] current;
			for (int i = 0; i < iterations.size(); i++) {

				current = iterations.get(i);
				for (int j = 0; j < board.length; j++) {
					int color = current[j][0];
					board[j][i].setBackground(palett[color]);
				}
			}

		}else{

			int [][] current = iterations.get(pointer);
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board[0].length; j++) {
					int color = current[i][j];
					board[i][j].setBackground(palett[color]);
				}
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
