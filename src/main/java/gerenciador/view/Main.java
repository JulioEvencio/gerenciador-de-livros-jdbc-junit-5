package gerenciador.view;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Main extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel panel;

	private JMenuBar menuBar;

	private JMenu menuBook;
	private JMenuItem menuBookAdd;
	private JMenuItem menuBookUpdate;
	private JMenuItem menuBookDelete;

	private JMenu menuInfo;
	private JMenuItem menuInfoItem;

	private JScrollPane panelTable;
	private JTable table;

	public Main() {
		this.initComponent();
		this.updateTable();
	}

	private void initComponent() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Gerenciador de Livros");
		this.setSize(640, 480);
		this.setLocationRelativeTo(null);

		panel = new JPanel(new java.awt.BorderLayout());
		panel.setBorder(new javax.swing.border.EmptyBorder(10, 10, 10, 10));
		this.add(panel);

		menuBar = new JMenuBar();
		menuBar.setBorder(new javax.swing.border.EmptyBorder(0, 10, 0, 10));
		this.setJMenuBar(menuBar);

		menuBook = new JMenu("Livros");
		menuBar.add(menuBook);

		menuBookAdd = new JMenuItem("Adicionar Livro");
		menuBookAdd.addActionListener(ActionEvent -> {
			this.addBook();
		});
		menuBook.add(menuBookAdd);

		menuBookUpdate = new JMenuItem("Editar Livro");
		menuBookUpdate.addActionListener(ActionListener -> {
			this.updateBook();
		});
		menuBook.add(menuBookUpdate);

		menuBookDelete = new JMenuItem("Remover Livro");
		menuBookDelete.addActionListener(ActionListener -> {
			this.deleteBoook();
		});
		menuBook.add(menuBookDelete);

		menuInfo = new JMenu("Sobre");
		menuBar.add(menuInfo);

		menuInfoItem = new JMenuItem("Info");
		menuInfoItem.addActionListener(ActionListener -> {
			this.showInfo();
		});
		menuInfo.add(menuInfoItem);

		panelTable = new JScrollPane();
		panel.add(panelTable);

		String[] column = { "Id", "Nome", "Autor" };
		Object[][] data = {};
		table = new JTable(new DefaultTableModel(data, column)) {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return false;
			}
		};
		panelTable.setViewportView(table);
	}

	private void updateTable() {
		// Code
	}

	private void addBook() {
		// Code
	}

	private void updateBook() {
		// Code
	}

	private void deleteBoook() {
		// Code
	}

	private void showInfo() {
		String message = "Gerenciador de livros - versão 1.0\n\nDesenvolvido por Júlio Evêncio";
		JOptionPane.showMessageDialog(this, message, "Sobre", JOptionPane.INFORMATION_MESSAGE);
	}

	public static void main(String[] args) {
		new Main().setVisible(true);
	}

}