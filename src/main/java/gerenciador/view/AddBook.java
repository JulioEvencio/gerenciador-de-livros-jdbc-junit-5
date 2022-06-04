package gerenciador.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import gerenciador.exception.ConnectionFailedException;
import gerenciador.exception.SaveBookFailedException;
import gerenciador.model.Book;
import gerenciador.service.BookService;

public class AddBook extends JDialog {

	private BookService service;

	private static final long serialVersionUID = 1L;

	private JPanel panel;
	private JPanel panelBorder;

	private JPanel panelTitle;
	private JLabel lblTitle;

	private JPanel panelName;
	private JLabel lblName;
	private JTextField txtName;

	private JPanel panelAuthor;
	private JLabel lblAuthor;
	private JTextField txtAuthor;

	private JPanel panelAdd;
	private JButton btnAdd;

	public AddBook(JFrame frame, BookService service) {
		super(frame, true);

		this.service = service;

		this.initComponent();
	}

	private void initComponent() {
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle("Gerenciador de Livros");
		this.setSize(400, 300);
		this.setLocationRelativeTo(null);
		this.setResizable(false);

		Font fontTitle = new Font("Sans Serif", Font.BOLD, 25);
		Font fontText = new Font("Sans Serif", Font.BOLD, 15);
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

		lblTitle = new JLabel("Adicionar Livro");
		lblTitle.setFont(fontTitle);
		panelTitle.add(lblTitle);

		panelName = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panelBorder.add(panelName);

		lblName = new JLabel("Nome:");
		lblName.setFont(fontText);
		panelName.add(lblName);

		txtName = new JTextField();
		txtName.setFont(fontField);
		txtName.setPreferredSize(new Dimension(300, 20));
		panelName.add(txtName);

		panelAuthor = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panelBorder.add(panelAuthor);

		lblAuthor = new JLabel("Autor:");
		lblAuthor.setFont(fontText);
		panelAuthor.add(lblAuthor);

		txtAuthor = new JTextField();
		txtAuthor.setFont(fontField);
		txtAuthor.setPreferredSize(new Dimension(300, 20));
		panelAuthor.add(txtAuthor);

		panelAdd = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		panelBorder.add(panelAdd);

		btnAdd = new JButton("Adicionar");
		btnAdd.setFont(fontButton);
		btnAdd.addActionListener(ActionListener -> this.addBook());
		panelAdd.add(btnAdd);
	}

	private void addBook() {
		try {
			service.save(new Book(null, txtName.getText(), txtAuthor.getText()));

			String message = "Livro adicionado com sucesso!";
			JOptionPane.showMessageDialog(this, message, "Gerenciador de Livros", JOptionPane.INFORMATION_MESSAGE);

			this.dispose();
		} catch (ConnectionFailedException | SaveBookFailedException e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Gerenciador de Livros", JOptionPane.ERROR_MESSAGE);
		}
	}

}
