package regform;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Reg {

	private JFrame frameRegForm;
	private JTextField textFieldName;
	private JTextField textFieldUserName;
	private JTextField textFieldPassword;
	private JTextField textFieldConfirm;
	private JTextField textFieldEmail;
	private JTextField textFieldPhone;
	private JTextField textFieldAddress;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reg window = new Reg();
					window.frameRegForm.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Reg() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameRegForm = new JFrame();
		frameRegForm.setBounds(100, 100, 446, 492);
		frameRegForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameRegForm.getContentPane().setLayout(null);
		
		JLabel lblRegistrationForm = new JLabel("Registration Form");
		lblRegistrationForm.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblRegistrationForm.setBounds(10, 22, 205, 34);
		frameRegForm.getContentPane().add(lblRegistrationForm);
		
		JLabel lblName = new JLabel("Name :");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblName.setBounds(76, 67, 38, 14);
		frameRegForm.getContentPane().add(lblName);
		
		JLabel lblUsername = new JLabel("Username :");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUsername.setBounds(50, 105, 64, 14);
		frameRegForm.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPassword.setBounds(54, 140, 60, 14);
		frameRegForm.getContentPane().add(lblPassword);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password :");
		lblConfirmPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblConfirmPassword.setBounds(10, 178, 114, 14);
		frameRegForm.getContentPane().add(lblConfirmPassword);
		
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEmail.setBounds(76, 220, 38, 14);
		frameRegForm.getContentPane().add(lblEmail);
		
		JLabel lblPhone = new JLabel("Phone :");
		lblPhone.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPhone.setBounds(68, 255, 46, 14);
		frameRegForm.getContentPane().add(lblPhone);
		
		JLabel lblAddress = new JLabel("Address :");
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAddress.setBounds(54, 292, 60, 14);
		frameRegForm.getContentPane().add(lblAddress);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(124, 67, 296, 20);
		frameRegForm.getContentPane().add(textFieldName);
		textFieldName.setColumns(10);
		
		textFieldUserName = new JTextField();
		textFieldUserName.setColumns(10);
		textFieldUserName.setBounds(124, 102, 296, 20);
		frameRegForm.getContentPane().add(textFieldUserName);
		
		textFieldPassword = new JTextField();
		textFieldPassword.setColumns(10);
		textFieldPassword.setBounds(124, 137, 296, 20);
		frameRegForm.getContentPane().add(textFieldPassword);
		
		textFieldConfirm = new JTextField();
		textFieldConfirm.setColumns(10);
		textFieldConfirm.setBounds(124, 175, 296, 20);
		frameRegForm.getContentPane().add(textFieldConfirm);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(124, 217, 296, 20);
		frameRegForm.getContentPane().add(textFieldEmail);
		
		textFieldPhone = new JTextField();
		textFieldPhone.setColumns(10);
		textFieldPhone.setBounds(124, 252, 296, 20);
		frameRegForm.getContentPane().add(textFieldPhone);
		
		textFieldAddress = new JTextField();
		textFieldAddress.setColumns(10);
		textFieldAddress.setBounds(124, 289, 296, 20);
		frameRegForm.getContentPane().add(textFieldAddress);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				class RegistrationForm {
				    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
				    static final String DB_URL = "jdbc:mysql://localhost/users";
				    static final String USER = "root";
				    static final String PASS = "root1234.";

				    public static void main(String[] args) {
				        Connection conn = null;
				        PreparedStatement stmt = null;

				        try {
				            Class.forName(JDBC_DRIVER);

				            System.out.println("Connecting to database...");
				            conn = DriverManager.getConnection(DB_URL, USER, PASS);

				            String sql = "INSERT INTO registration (name, username, password, email, phone, address) VALUES (?, ?, ?, ?, ?, ?)";
				            stmt = conn.prepareStatement(sql);

				            String name = "John Doe";
				            String username = "jd";
				            String password = "1234";
				            String email = "johndoe@gmail.com";
				            String phone = "1234567";
				            String address = "3 Nairobi";
				            
				            stmt.setString(1, name);
				            stmt.setString(2, username);
				            stmt.setString(3, password);
				            stmt.setString(4, email);
				            stmt.setString(5, phone);
				            stmt.setString(6, address);

				            int rowsAffected = stmt.executeUpdate();

				            if (rowsAffected > 0) {
				                System.out.println("Registration successful!");
				            } else {
				                System.out.println("Registration failed.");
				            }
				        } catch (SQLException se) {

				            se.printStackTrace();
				        } catch (Exception e) {
				            e.printStackTrace();
				        } finally {
				            try {
				                if (stmt != null) stmt.close();
				            } catch (SQLException se) {
				                se.printStackTrace();
				            }
				            try {
				                if (conn != null) conn.close();
				            } catch (SQLException se) {
				                se.printStackTrace();
				            }
				        }
				    }
				}

			}
		});
		btnSubmit.setBounds(76, 361, 89, 23);
		frameRegForm.getContentPane().add(btnSubmit);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldName.setText("");
				textFieldUserName.setText("");
				textFieldPassword.setText("");
				textFieldConfirm.setText("");
				textFieldEmail.setText("");
				textFieldPhone.setText("");
				textFieldAddress.setText("");
			}
		});
		btnReset.setBounds(187, 361, 75, 23);
		frameRegForm.getContentPane().add(btnReset);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Exit the program");
				frameRegForm.setVisible(false);
			}
		});
		btnClose.setBounds(290, 361, 89, 23);
		frameRegForm.getContentPane().add(btnClose);
	}
}
