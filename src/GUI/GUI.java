package GUI;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.MatteBorder;


public class GUI extends JFrame implements KeyListener{
	Color [] palett = {Color.white, Color.black, Color.green, Color.orange, Color.blue, Color.red, Color.pink, Color.yellow, Color.cyan};
	private JPanel boardPanel, instructionPanel;
	private JPanel [][] board;
	private JButton first, next, previous, last, goTo;
	private JTextField goToField;
	private ArrayList<int[][]> iterations;
	private int pointer = 0;
	private boolean isOneDim = false;
	private JLabel pointerLab = new JLabel("state number : " + (pointer));
	private int printCounter =0;

	public static final KeyStroke SAVEIMG = KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK);
	public static final KeyStroke SAVEAllIMG = KeyStroke.getKeyStroke(KeyEvent.VK_S, (KeyEvent.CTRL_DOWN_MASK + KeyEvent.ALT_DOWN_MASK));


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
		goToField.addKeyListener(this);
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
		if(e.getKeyCode() == KeyEvent.VK_RIGHT&&e.getComponent()!=goToField){
			next.doClick();
		}		

		if(e.getKeyCode() == KeyEvent.VK_LEFT&&e.getComponent()!=goToField){
			previous.doClick();
		}

		if(((e.getModifiersEx()  | e.getModifiers())==SAVEIMG.getModifiers()&&/**/(e.getKeyCode()==SAVEIMG.getKeyCode()))){
			printImg("flag");
		}
		/*
		 * generates all images
		 */
		if(((e.getModifiersEx()  | e.getModifiers())==SAVEAllIMG.getModifiers()&&/**/(e.getKeyCode()==SAVEAllIMG.getKeyCode()))){
			pointer = 0;
			update();
			String name = "norflag";
			printImg(name);
			for (int i = 0; i < iterations.size()-1; i++) {
				next.doClick();
				printImg(name);
			}
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
	/*
	 * prints a image of the board and puts it into the src folder
	 */
	public void printImg(String filename) {
		try {
			ImageIO.write(
					getScreenShot(this.boardPanel),
					"png",
					new File(filename + printCounter + ".png"));
			printCounter++;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*
	 * Returns a image file of the component.
	 */
	public static BufferedImage getScreenShot(
			Component component) {

		BufferedImage image = new BufferedImage(
				component.getWidth(),
				component.getHeight(),
				BufferedImage.TYPE_INT_RGB
				);
		// call the Component's paint method, using
		// the Graphics object of the image.
		component.paint( image.getGraphics() ); // alternately use .printAll(..)
		return image;
	}


}
