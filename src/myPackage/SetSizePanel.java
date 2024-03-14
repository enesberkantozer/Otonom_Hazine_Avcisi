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
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class SetSizePanel extends JPanel implements KeyListener {

	private static final long serialVersionUID = 1L;

	public static AltinAvcisi oyun;
	private JLabel lblCaution;
	private JTextField textFieldSizeWidth;
	private JTextField textFieldSizeHeight;
	private JButton btnConfirm;
	private JSlider sliderWidth;
	private JSlider sliderHeight;
	private JFrame frame;
	private int enterCount = 0;

	public SetSizePanel(JFrame frame) {
		this.frame = frame;
		setLayout(null);
		requestFocus();
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		addKeyListener(this);
		btnConfirm = new JButton("Onayla");
		btnConfirm.setToolTipText("Oyunu başlatmak onaylayın");
		btnConfirm.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnConfirm.setBounds(239, 274, 211, 64);
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				shutdown();
			}
		});
		add(btnConfirm);

		lblCaution = new JLabel("Boyut Seçiniz");
		lblCaution.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblCaution.setBounds(10, 30, 653, 75);
		lblCaution.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblCaution);

		JLabel lblSize1 = new JLabel("Genişlik:");
		lblSize1.setBounds(10, 115, 105, 75);
		add(lblSize1);
		lblSize1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblSize1.setHorizontalAlignment(SwingConstants.RIGHT);

		sliderWidth = new JSlider();
		sliderWidth.setToolTipText("Kaydırarak genişlik seçimi yapınız");
		sliderWidth.setBounds(125, 115, 464, 75);
		add(sliderWidth);
		sliderWidth.setPaintLabels(true);
		sliderWidth.setPaintTicks(true);
		sliderWidth.setSnapToTicks(true);
		sliderWidth.setMinimum(50);
		sliderWidth.setMaximum(1000);

		textFieldSizeWidth = new JTextField();
		textFieldSizeWidth.setToolTipText("Genişlik seçiminizi belirtin");
		textFieldSizeWidth.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) {
				textfieldSliderRelationship(textFieldSizeWidth, sliderWidth);
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				textfieldSliderRelationship(textFieldSizeWidth, sliderWidth);
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				textfieldSliderRelationship(textFieldSizeWidth, sliderWidth);
			}
		});
		textFieldSizeWidth.setText("50");
		textFieldSizeWidth.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldSizeWidth.setFont(new Font("Times New Roman", Font.BOLD, 18));
		textFieldSizeWidth.setBounds(586, 126, 77, 53);
		add(textFieldSizeWidth);

		JLabel lblSize2 = new JLabel("Yükseklik:");
		lblSize2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSize2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblSize2.setBounds(10, 189, 105, 75);
		add(lblSize2);

		sliderHeight = new JSlider();
		sliderHeight.setToolTipText("Kaydırarak yükseklik seçimi yapınız");
		sliderHeight.setSnapToTicks(true);
		sliderHeight.setPaintTicks(true);
		sliderHeight.setPaintLabels(true);
		sliderHeight.setMinimum(50);
		sliderHeight.setMaximum(1000);
		sliderHeight.setBounds(125, 189, 464, 75);
		add(sliderHeight);

		textFieldSizeHeight = new JTextField("50");
		textFieldSizeHeight.setToolTipText("Yükseklik seçiminizi belirtin");
		textFieldSizeHeight.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				textfieldSliderRelationship(textFieldSizeHeight, sliderHeight);
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				textfieldSliderRelationship(textFieldSizeHeight, sliderHeight);
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				textfieldSliderRelationship(textFieldSizeHeight, sliderHeight);
			}
		});
		textFieldSizeHeight.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldSizeHeight.setFont(new Font("Times New Roman", Font.BOLD, 18));
		textFieldSizeHeight.setBounds(586, 200, 77, 53);
		add(textFieldSizeHeight);

		sliderWidth.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				textFieldSizeWidth.setText(String.valueOf(sliderWidth.getValue()));
			}
		});
		sliderHeight.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				textFieldSizeHeight.setText(String.valueOf(sliderHeight.getValue()));
			}
		});

	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		JSlider slider = new JSlider();
		String str = new String();
		JTextField textField = new JTextField();
		if (enterCount == 0) {
			slider = sliderWidth;
			str = textFieldSizeWidth.getText();
			textField = textFieldSizeWidth;
		} else if (enterCount == 1) {
			slider = sliderHeight;
			str = textFieldSizeHeight.getText();
			textField = textFieldSizeHeight;
		}
		int c = e.getKeyCode();

		if (str == "0")
			str = "";

		if (c == KeyEvent.VK_0 || c == KeyEvent.VK_NUMPAD0)
			str += "0";
		else if (c == KeyEvent.VK_1 || c == KeyEvent.VK_NUMPAD1)
			str += "1";
		else if (c == KeyEvent.VK_2 || c == KeyEvent.VK_NUMPAD2)
			str += "2";
		else if (c == KeyEvent.VK_3 || c == KeyEvent.VK_NUMPAD3)
			str += "3";
		else if (c == KeyEvent.VK_4 || c == KeyEvent.VK_NUMPAD4)
			str += "4";
		else if (c == KeyEvent.VK_5 || c == KeyEvent.VK_NUMPAD5)
			str += "5";
		else if (c == KeyEvent.VK_6 || c == KeyEvent.VK_NUMPAD6)
			str += "6";
		else if (c == KeyEvent.VK_7 || c == KeyEvent.VK_NUMPAD7)
			str += "7";
		else if (c == KeyEvent.VK_8 || c == KeyEvent.VK_NUMPAD8)
			str += "8";
		else if (c == KeyEvent.VK_9 || c == KeyEvent.VK_NUMPAD9)
			str += "9";
		else if (c == KeyEvent.VK_BACK_SPACE) {
			if (textField.getText().length() == 1)
				str = "0";
			else
				str = textField.getText().substring(0, textField.getText().length() - 1);
		} else if (c == KeyEvent.VK_ENTER) {
			enterCount++;
			if (enterCount == 2)
				btnConfirm.doClick();
		}

		if (Integer.parseInt(str) > 1000)
			str = "1000";
		textField.setText(str);

		if (c == KeyEvent.VK_RIGHT)
			slider.setValue(slider.getValue() + 5);
		else if (c == KeyEvent.VK_LEFT)
			slider.setValue(slider.getValue() - 5);
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	public void shutdown() {
		oyun = new AltinAvcisi(sliderWidth.getValue(), sliderHeight.getValue());
		JScrollPane scrollPane = new JScrollPane(oyun);
		frame.setSize(900, 900);
		frame.getContentPane().remove(this);
		frame.getContentPane().add(scrollPane);
		frame.setLocationRelativeTo(null);
		scrollPane.requestFocus();
		scrollPane.addKeyListener(oyun);
		scrollPane.setFocusable(true);
		scrollPane.setFocusTraversalKeysEnabled(false);

	}

	private void textfieldSliderRelationship(JTextField textField, JSlider slider) {
		try {
			if(Integer.parseInt(textField.getText())>=50 || Integer.parseInt(textField.getText())<=1000) {
				slider.setValue(Integer.parseInt(textField.getText()));
				lblCaution.setText("Boyut seçiniz");
			}
			else if(Integer.parseInt(textField.getText())>1000){
				textField.setText("1000");
				lblCaution.setText("Max 1000 olabilir");
			}
			else if(Integer.parseInt(textField.getText())<50){
				textField.setText("50");
				lblCaution.setText("Min 50 olabilir");
			}
		}catch(NumberFormatException e1) {
			lblCaution.setText("Sayı biçimi hatası");
		}catch(Exception e2) {
			lblCaution.setText("Hata");
		}
	}
}
