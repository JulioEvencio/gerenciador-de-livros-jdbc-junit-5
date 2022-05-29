package gerenciador.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class UpdateBook extends JDialog {

	private static final long serialVersionUID = 1L;

	private JPanel panel;
	private JPanel panelBorder;

	private JPanel panelTitle;
	private JLabel lblTitle;

	private JPanel panelId;
	private JComboBox<String> txtId;

	private JPanel panelName;
	private JLabel lblName;
	private JTextField txtName;

	private JPanel panelAuthor;
	private JLabel lblAuthor;
	private JTextField txtAuthor;

	private JPanel panelUpdate;
	private JButton btnUpdate;

	public UpdateBook(JFrame frame) {
		super(frame, true);

		this.initComponent();
	}

	private void initComponent() {
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle("Gerenciador de Livros");
		this.setSize(400, 350);
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

		lblTitle = new JLabel("Editar Livro");
		lblTitle.setFont(fontTitle);
		panelTitle.add(lblTitle);

		panelId = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panelBorder.add(panelId);

		txtId = new JComboBox<>();
		txtId.addItem("Selecione o ID do livro");
		this.addItensComboBox();
		txtId.setFont(fontField);
		txtId.setPreferredSize(new Dimension(365, 20));
		txtId.addActionListener(ActionListener -> {
			this.updateItemSelected();
		});
		panelId.add(txtId);

		panelName = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panelBorder.add(panelName);

		lblName = new JLabel("Novo Nome:");
		lblName.setFont(fontText);
		panelName.add(lblName);

		txtName = new JTextField();
		txtName.setFont(fontField);
		txtName.setPreferredSize(new Dimension(365, 20));
		panelName.add(txtName);

		panelAuthor = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panelBorder.add(panelAuthor);

		lblAuthor = new JLabel("Novo Autor:");
		lblAuthor.setFont(fontText);
		panelAuthor.add(lblAuthor);

		txtAuthor = new JTextField();
		txtAuthor.setFont(fontField);
		txtAuthor.setPreferredSize(new Dimension(365, 20));
		panelAuthor.add(txtAuthor);

		panelUpdate = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		panelBorder.add(panelUpdate);

		btnUpdate = new JButton("Editar");
		btnUpdate.setFont(fontButton);
		btnUpdate.addActionListener(ActionListener -> {
			this.updateBook();
		});
		panelUpdate.add(btnUpdate);
	}

	private void addItensComboBox() {
		// Code
	}

	private void updateItemSelected() {
		// Code
	}

	private void updateBook() {
		// Code
	}

}
