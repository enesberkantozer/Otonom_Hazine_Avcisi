package myPackage;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GameDialog extends JDialog {
	private static final long serialVersionUID = 1L;

	public static JLabel totalDistanceLabel;
	public static JSlider gameSpeedSlider;
	public static DefaultListModel<String> list=new DefaultListModel<String>();
	private JList<String> treasureList;
	private boolean tiklandiTiklanmadi=false;

	public GameDialog(AltinAvcisi game, int fogWidth, int fogHeight) {
		setBounds(100, 100, 524, 367);
		getContentPane().setLayout(null);
		
		treasureList = new JList<String>(list);
		
		JScrollPane scrollPane = new JScrollPane(treasureList);
		scrollPane.setBounds(10, 136, 488, 144);
		getContentPane().add(scrollPane);
		
		gameSpeedSlider = new JSlider();
		gameSpeedSlider.setValue(game.timer.getDelay());
		gameSpeedSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				game.timer.setDelay(gameSpeedSlider.getValue());
				gameSpeedSlider.setToolTipText("Oyun Hızı: "+gameSpeedSlider.getValue()+"ms");
			}
		});
		gameSpeedSlider.setToolTipText("Oyun Hızı: "+gameSpeedSlider.getValue()+"ms");
		gameSpeedSlider.setMaximum(2000);
		gameSpeedSlider.setMinimum(10);
		gameSpeedSlider.setBounds(10, 39, 488, 26);
		getContentPane().add(gameSpeedSlider);
		
		JButton btnNewButton = new JButton("Sis Kaldır");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!tiklandiTiklanmadi) {
					tiklandiTiklanmadi=true;
					btnNewButton.setText("Sis Ekle");
					for(int i=0;i<fogWidth;i++) {
						for(int j=0;j<fogHeight;j++) {
							AltinAvcisi.sis[i][j]=false;
						}
					}
				}
				else {
					tiklandiTiklanmadi=false;
					btnNewButton.setText("Sis Kaldır");
					for(int i=0;i<fogWidth;i++) {
						for(int j=0;j<fogHeight;j++) {
							AltinAvcisi.sis[i][j]=true;
						}
					}
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(176, 75, 159, 21);
		getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Oyun Hızı");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 10, 488, 19);
		getContentPane().add(lblNewLabel);
		
		JLabel lblToplananHazineler = new JLabel("Toplanan Hazineler");
		lblToplananHazineler.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblToplananHazineler.setHorizontalAlignment(SwingConstants.CENTER);
		lblToplananHazineler.setBounds(10, 106, 488, 20);
		getContentPane().add(lblToplananHazineler);
		
		totalDistanceLabel = new JLabel("Toplam Adım Sayısı: 0");
		totalDistanceLabel.setHorizontalAlignment(SwingConstants.CENTER);
		totalDistanceLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		totalDistanceLabel.setBounds(20, 290, 478, 29);
		getContentPane().add(totalDistanceLabel);
		
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setVisible(true);
	}
}
