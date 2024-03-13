package myPackage;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JSlider;

public class SetSizePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	public SetSizePanel() {
		setLayout(new BorderLayout(20, 25));
		
		JButton btnNewButton = new JButton("New button");
		add(btnNewButton, BorderLayout.SOUTH);
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.WEST);
		panel.setLayout(new GridLayout(3, 0, 0, 30));
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		panel.add(lblNewLabel_3);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.EAST);
		panel_1.setLayout(new GridLayout(3, 1, 50, 50));
		
		textField = new JTextField();
		panel_1.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel panel_2 = new JPanel();
		add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new GridLayout(0, 1, 50, 30));
		
		JSlider slider = new JSlider();
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		slider.setSnapToTicks(true);
		slider.setMinimum(50);
		slider.setMaximum(1000);
		panel_2.add(slider);
		
		JSlider slider_1 = new JSlider();
		slider_1.setPaintLabels(true);
		slider_1.setPaintTicks(true);
		slider_1.setSnapToTicks(true);
		slider_1.setMaximum(1000);
		slider_1.setMinimum(50);
		panel_2.add(slider_1);
		
		JSlider slider_2 = new JSlider();
		slider_2.setPaintLabels(true);
		slider_2.setPaintTicks(true);
		slider_2.setSnapToTicks(true);
		slider_2.setMinimum(50);
		slider_2.setMaximum(1000);
		panel_2.add(slider_2);
		
	}

}
