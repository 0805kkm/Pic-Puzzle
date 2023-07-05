package puzzle;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Start extends JFrame{


	public void start() {
		JFrame frame = new JFrame("시원한 바다 퍼즐 게임");
		ImageIcon ori_image = new ImageIcon("Horder.jpg");
		Image _image = ori_image.getImage().getScaledInstance(500, 500, 0);
		ImageIcon image = new ImageIcon(_image);
		frame.setPreferredSize(new Dimension(600, 600));
		frame.setLocation(500, 100);
		Container contentPane = frame.getContentPane();
		frame.setDefaultCloseOperation(JFrame .EXIT_ON_CLOSE);
		JTextField text = new JTextField(10);
		JButton button = new JButton("퍼즐 만들기");
		JPanel panel = new JPanel();
		JLabel imgLbl = new JLabel(image);
	    panel.setLayout(new FlowLayout());   
		panel.add(text, BorderLayout.NORTH);
		panel.add(button, BorderLayout.EAST);
		panel.add(imgLbl,BorderLayout.SOUTH);
		contentPane.add(panel, BorderLayout.CENTER);
		button.addActionListener(new ActionListener() {            
			public void actionPerformed(ActionEvent e) {
				String str1 = text.getText();
				int n = Integer.parseInt(str1);
				new PicPuzzle(n);
			}});
		frame.pack();
		frame.setVisible(true);
	}
}
