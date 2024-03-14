package myPackage;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JSlider;
import java.awt.Font;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class SetSizePanel extends JPanel implements KeyListener {

	private static final long serialVersionUID = 1L;
	
	public static AltinAvcisi oyun;
	private JLabel lblNewLabel_1_1;
	private JButton btnNewButton;
	private JSlider slider;
	private JLabel lblNewLabel_2;
	private JFrame frame;

	public SetSizePanel(JFrame frame) {
		this.frame=frame;
		setLayout(null);
		requestFocus();
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		addKeyListener(this);
		btnNewButton = new JButton("Onayla");
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnNewButton.setBounds(224, 200, 211, 64);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				shutdown();
			}
		});
		add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Boyut Seçiniz");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 30, 630, 75);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Boyut :");
		lblNewLabel_1.setBounds(10, 115, 82, 75);
		add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		
		slider = new JSlider();
		slider.setBounds(102, 115, 464, 75);
		add(slider);
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		slider.setSnapToTicks(true);
		slider.setMinimum(50);
		slider.setMaximum(1000);
		
		lblNewLabel_1_1 = new JLabel("50");
		lblNewLabel_1_1.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				if(Integer.parseInt(lblNewLabel_1_1.getText())>=50 || Integer.parseInt(lblNewLabel_1_1.getText())<=1000)
					slider.setValue(Integer.parseInt(lblNewLabel_1_1.getText()));
			}
		});
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(576, 115, 64, 64);
		add(lblNewLabel_1_1);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(10, 85, 630, 20);
		add(lblNewLabel_2);
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				lblNewLabel_1_1.setText(String.valueOf(slider.getValue()));
			}
		});
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int c=e.getKeyCode();
		String str=lblNewLabel_1_1.getText();
		if(str=="0")
			str="";
		
		if(c==KeyEvent.VK_0 || c==KeyEvent.VK_NUMPAD0)
			str+="0";
		else if(c==KeyEvent.VK_1 || c==KeyEvent.VK_NUMPAD1)
			str+="1";
		else if(c==KeyEvent.VK_2 || c==KeyEvent.VK_NUMPAD2)
			str+="2";
		else if(c==KeyEvent.VK_3 || c==KeyEvent.VK_NUMPAD3)
			str+="3";
		else if(c==KeyEvent.VK_4 || c==KeyEvent.VK_NUMPAD4)
			str+="4";
		else if(c==KeyEvent.VK_5 || c==KeyEvent.VK_NUMPAD5)
			str+="5";
		else if(c==KeyEvent.VK_6 || c==KeyEvent.VK_NUMPAD6)
			str+="6";
		else if(c==KeyEvent.VK_7 || c==KeyEvent.VK_NUMPAD7)
			str+="7";
		else if(c==KeyEvent.VK_8 || c==KeyEvent.VK_NUMPAD8)
			str+="8";
		else if(c==KeyEvent.VK_9 || c==KeyEvent.VK_NUMPAD9)
			str+="9";
		else if(c==KeyEvent.VK_BACK_SPACE) {
			if(lblNewLabel_1_1.getText().length()==1)
				str="0";
			else
				str=lblNewLabel_1_1.getText().substring(0, lblNewLabel_1_1.getText().length()-1);
		}
		else if(c==KeyEvent.VK_ENTER)
			btnNewButton.doClick();
		
		if(Integer.parseInt(str)>1000)
			str="1000";
		lblNewLabel_1_1.setText(str);
		
		if(c==KeyEvent.VK_RIGHT)
			slider.setValue(slider.getValue()+5);
		else if(c==KeyEvent.VK_LEFT)
			slider.setValue(slider.getValue()-5);
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}
	
	public void shutdown() {
		oyun = new AltinAvcisi(slider.getValue());
		JScrollPane scrollPane=new JScrollPane(oyun);
		frame.setSize(900,900);
		frame.getContentPane().remove(this);
		frame.getContentPane().add(scrollPane);
		frame.setLocationRelativeTo(null);
		
	}
}
