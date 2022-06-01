package gerenciador.view;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import gerenciador.exception.ConnectionFailedException;
import gerenciador.exception.FindBookFailedException;
import gerenciador.model.Book;
import gerenciador.service.BookService;

public class Main extends JFrame {

	private BookService service;

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
		service = new BookService();

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
		try {
			DefaultTableModel tableAux = (DefaultTableModel) table.getModel();
			tableAux.setRowCount(0);

			List<Book> list = service.findAll();
			Object[] data = new Object[4];

			for (Book book : list) {
				data[0] = book.getId();
				data[1] = book.getName();
				data[2] = book.getAuthor();

				tableAux.addRow(data);
			}
		} catch (ConnectionFailedException e) {
			String message = "Erro ao conectar com o banco de dados!";
			JOptionPane.showMessageDialog(this, message, "Gerenciador de Livros", JOptionPane.ERROR_MESSAGE);
		} catch (FindBookFailedException e) {
			String message = "Erro ao carregar dos dados!";
			JOptionPane.showMessageDialog(this, message, "Gerenciador de Livros", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void addBook() {
		new AddBook(this, service).setVisible(true);
		this.updateTable();
	}

	private void updateBook() {
		new UpdateBook(this, service).setVisible(true);
		this.updateTable();
	}

	private void deleteBoook() {
		new DeleteBook(this, service).setVisible(true);
		this.updateTable();
	}

	private void showInfo() {
		String message = "Gerenciador de livros - versão 1.0\n\nDesenvolvido por Júlio Evêncio";
		JOptionPane.showMessageDialog(this, message, "Sobre", JOptionPane.INFORMATION_MESSAGE);
	}

	public static void main(String[] args) {
		new Main().setVisible(true);
	}

}
