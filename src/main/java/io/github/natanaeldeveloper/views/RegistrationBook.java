package io.github.natanaeldeveloper.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import io.github.natanaeldeveloper.controllers.BookController;
import io.github.natanaeldeveloper.models.Book;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class RegistrationBook extends JFrame {
	
	private BookController bookController = new BookController();
	
	private JPanel contentPane;
	private JTextField titleField;
	private JTextField authorField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		try {
			UIManager.setLookAndFeel("com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatAtomOneDarkIJTheme");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			System.out.println("Failed to initialized Laf");
		}
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {				
					RegistrationBook frame = new RegistrationBook();
					frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
					frame.setLocationRelativeTo(null);
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
	public RegistrationBook() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				if (JOptionPane.showConfirmDialog(null, 
		            "Deseja mesmo encerrar o programa?", "Fechar", 
		            JOptionPane.YES_NO_OPTION,
		            JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
					bookController.exit();
		            System.exit(0);
		        }
			}
		});
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registation Book");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(26, 32, 375, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Títle:");
		lblNewLabel_1.setBounds(26, 83, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		titleField = new JTextField();
		titleField.setBounds(26, 104, 375, 20);
		contentPane.add(titleField);
		titleField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Author:");
		lblNewLabel_2.setBounds(26, 135, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		authorField = new JTextField();
		authorField.setBounds(26, 154, 375, 20);
		contentPane.add(authorField);
		authorField.setColumns(10);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registrateBook();
			}
		});
		btnSave.setBounds(312, 206, 89, 23);
		contentPane.add(btnSave);
	}
	
	public void registrateBook() {
		try {
			Book newBook = bookController.createBook(titleField.getText(), authorField.getText());
			JOptionPane.showMessageDialog(null, "O livro "+newBook.getTitle()+" foi registrado com sucesso");
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
	}
}
