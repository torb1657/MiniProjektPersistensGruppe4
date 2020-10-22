package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JScrollBar;

public class MainGui extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGui frame = new MainGui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainGui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 553, 395);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 535, 348);
		contentPane.add(tabbedPane);
		
		JPanel startOrderPanel = new JPanel();
		tabbedPane.addTab("Start ordre", null, startOrderPanel, null);
		startOrderPanel.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(12, 66, 334, 122);
		startOrderPanel.add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 334, 122);
		panel_2.add(scrollPane);
		
		JList list = new JList();
		scrollPane.setViewportView(list);
		
		JLabel lblNewLabel = new JLabel("Navn                            Addresse                    Tlf.");
		scrollPane.setColumnHeaderView(lblNewLabel);
		
		JButton btnNewButton = new JButton("Start Ordre");
		btnNewButton.setBounds(406, 264, 97, 25);
		startOrderPanel.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(12, 23, 116, 22);
		startOrderPanel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("S\u00F8g Kunde");
		lblNewLabel_1.setBounds(12, 0, 116, 16);
		startOrderPanel.add(lblNewLabel_1);
		
		JPanel buyWarePanel = new JPanel();
		tabbedPane.addTab("K\u00F8b varer", null, buyWarePanel, null);
		buyWarePanel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("S\u00F8g...");
		lblNewLabel_2.setBounds(12, 13, 56, 16);
		buyWarePanel.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(12, 33, 116, 22);
		buyWarePanel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Kurv");
		lblNewLabel_3.setBounds(12, 174, 56, 16);
		buyWarePanel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Total pris:");
		lblNewLabel_4.setBounds(12, 289, 74, 16);
		buyWarePanel.add(lblNewLabel_4);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(12, 80, 345, 93);
		buyWarePanel.add(panel_3);
		panel_3.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 0, 345, 93);
		panel_3.add(scrollPane_1);
		
		JList list_1 = new JList();
		scrollPane_1.setViewportView(list_1);
		
		JLabel lblNewLabel_5 = new JLabel("Navn                           Addresse                      Tlf.");
		scrollPane_1.setColumnHeaderView(lblNewLabel_5);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(12, 203, 345, 84);
		buyWarePanel.add(panel_4);
		panel_4.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(0, 0, 345, 84);
		panel_4.add(scrollPane_2);
		
		JList list_2 = new JList();
		scrollPane_2.setViewportView(list_2);
		
		JLabel lblNewLabel_6 = new JLabel("Navn                                Antal                     Pris");
		scrollPane_2.setColumnHeaderView(lblNewLabel_6);
		
		JButton btnNewButton_1 = new JButton("Tilf\u00F8j til kurv");
		btnNewButton_1.setBounds(369, 80, 149, 25);
		buyWarePanel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Slet fra kurv");
		btnNewButton_2.setBounds(366, 203, 110, 25);
		buyWarePanel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("K\u00F8b");
		btnNewButton_3.setBounds(313, 285, 97, 25);
		buyWarePanel.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Afbryd");
		btnNewButton_4.setBounds(421, 285, 97, 25);
		buyWarePanel.add(btnNewButton_4);
	}
}
