import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class MealPlan {

	private JFrame frame;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MealPlan window = new MealPlan();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MealPlan() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 1000, 820);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel mainPanel = new JPanel();
		
		btnNewButton = new JButton("Window!");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				microDialogue();
			}
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(6)
					.addComponent(btnNewButton)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(mainPanel, GroupLayout.DEFAULT_SIZE, 772, Short.MAX_VALUE)
					.addGap(113))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(mainPanel, GroupLayout.DEFAULT_SIZE, 763, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(158)
							.addComponent(btnNewButton)))
					.addContainerGap())
		);
		frame.getContentPane().setLayout(groupLayout);
		
		
		String[][] tableData = new String[30][5];
		String[] columnNames = new String[] {"Item Name", "Carbs", "Fat", 
				"Protein", "Calories"};
        TableModel dataModel = new DefaultTableModel(tableData, columnNames);
		table = new JTable(dataModel);
		mainPanel.add(table);
		
		scrollPane = new JScrollPane(table);
		mainPanel.add(scrollPane);
		
	}
	
	private void microDialogue() {
		frame.setVisible(false);
		macroCollector.run(new String[] {});
	}
}
