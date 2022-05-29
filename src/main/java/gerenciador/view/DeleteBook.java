package gerenciador.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import gerenciador.exception.DeleteBookFailedException;
import gerenciador.model.Book;
import gerenciador.service.BookService;

public class DeleteBook extends JDialog {

	private BookService service;

	private static final long serialVersionUID = 1L;

	private JPanel panel;
	private JPanel panelBorder;

	private JPanel panelTitle;
	private JLabel lblTitle;

	private JPanel panelId;
	private JComboBox<String> txtId;

	private JPanel panelDelete;
	private JButton btnDelete;

	public DeleteBook(JFrame frame, BookService service) {
		super(frame, true);

		this.service = service;

		this.initComponent();
	}

	private void initComponent() {
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle("Gerenciador de Livros");
		this.setSize(400, 200);
		this.setLocationRelativeTo(null);
		this.setResizable(false);

		Font fontTitle = new Font("Sans Serif", Font.BOLD, 25);
		Font fontField = new Font("Sans Serif", Font.PLAIN, 15);
		Font fontButton = new Font("Sans Serif", Font.BOLD, 15);

		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBorder(new EmptyBorder(10, 10, 10, 10));
		this.add(panel);

		panelBorder = new JPanel();
		panelBorder.setLayout(new BoxLayout(panelBorder, BoxLayout.Y_AXIS));
		panelBorder.setBorder(new LineBorder(Color.black));
		panel.add(panelBorder);

		panelTitle = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panelBorder.add(panelTitle);

		lblTitle = new JLabel("Remover Livro");
		lblTitle.setFont(fontTitle);
		panelTitle.add(lblTitle);

		panelId = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panelBorder.add(panelId);

		txtId = new JComboBox<>();
		txtId.addItem("Selecione o ID do livro");
		this.addItensComboBox();
		txtId.setFont(fontField);
		txtId.setPreferredSize(new Dimension(365, 20));
		panelId.add(txtId);

		panelDelete = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		panelBorder.add(panelDelete);

		btnDelete = new JButton("Remover");
		btnDelete.setFont(fontButton);
		btnDelete.addActionListener(ActionListener -> {
			this.deleteBook();
		});
		panelDelete.add(btnDelete);
	}

	private void addItensComboBox() {
		List<Book> list = service.findByAll();

		for (Book book : list)
			txtId.addItem(String.valueOf(book.getId()));
	}

	private void deleteBook() {
		try {
			String book = txtId.getSelectedItem().toString();

			String deleteMessage = "Deseja realmente remover o livro?";
			Integer delete = JOptionPane.showConfirmDialog(this, deleteMessage, "Gerenciador de Livros",
					JOptionPane.WARNING_MESSAGE);

			if (delete != 0)
				return;

			service.delete(Integer.valueOf(book));

			String message = "Livro removido com sucesso!";
			JOptionPane.showMessageDialog(this, message, "Gerenciador de Livros", JOptionPane.INFORMATION_MESSAGE);

			this.dispose();
		} catch (DeleteBookFailedException | NumberFormatException e) {
			String message = "Erro ao remover o livro!";
			JOptionPane.showMessageDialog(this, message, "Gerenciador de Livros", JOptionPane.ERROR_MESSAGE);
		}
	}

}
