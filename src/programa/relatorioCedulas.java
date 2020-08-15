package programa;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Font;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class relatorioCedulas extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JLabel lblN2;
	private JTextField tfN2;
	private JLabel lblQtdDisp;
	private JLabel lblN5;
	private JTextField tfN5;
	private JLabel lblN10;
	private JTextField tfN10;
	private JLabel lblN20;
	private JTextField tfN20;
	private JLabel lblN50;
	private JTextField tfN50;
	private JLabel lblN100;
	private JTextField tfN100;
	private JButton btnVoltar;

	private String qtdN2;
	private String qtdN5;
	private String qtdN10;
	private String qtdN20;
	private String qtdN50;
	private String qtdN100;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					relatorioCedulas frame = new relatorioCedulas();
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
	public relatorioCedulas() {
		////////
		BD bd = new BD();
		
		if (bd.getConnection()) {
			
			try {
				int qtd2 = 0, qtd5 = 0, qtd10 = 0, qtd20 = 0, qtd50 = 0, qtd100 = 0;
				
				String sql = "SELECT idnota, qtd FROM notas;";
				PreparedStatement stmt = bd.con.prepareStatement(sql);
				
				ResultSet rs = stmt.executeQuery();
						
				while (rs.next()) {
					String idnota = rs.getString("idnota");
					String qtd = rs.getString("qtd");
					
					int idnotaInt = Integer.parseInt(idnota);
					int qtdInt = Integer.parseInt(qtd);

					if(idnotaInt==2) {
						qtd = String.valueOf(qtdInt);
						qtdN2 = qtd;
						qtd2 = Integer.parseInt(rs.getString("qtd"));
					}
					if(idnotaInt==5) {
						qtd = String.valueOf(qtdInt);
						qtdN5 = qtd;
						qtd5 = Integer.parseInt(rs.getString("qtd"));
					}
					if(idnotaInt==10) {
						qtd = String.valueOf(qtdInt);
						qtdN10 = qtd;
						qtd10 = Integer.parseInt(rs.getString("qtd"));
					}
					if(idnotaInt==20) {
						qtd = String.valueOf(qtdInt);
						qtdN20 = qtd;
						qtd20 = Integer.parseInt(rs.getString("qtd"));
					}
					if(idnotaInt==50) {
						qtd = String.valueOf(qtdInt);
						qtdN50 = qtd;
						qtd50 = Integer.parseInt(rs.getString("qtd"));
					}
					if(idnotaInt==100) {
						qtd = String.valueOf(qtdInt);
						qtdN100 = qtd;
						qtd100 = Integer.parseInt(rs.getString("qtd"));
					}
					
				}
				if(qtd2<20 || qtd5<=30 || qtd10<=40 || qtd20<=50 || qtd50<=60 || qtd100<=70) {
					JOptionPane.showMessageDialog(null, "Checar a tela de cota mínima. \nUm ou mais valores estão abaixo da quantidade recomendada.");
				}
				rs.close();
				stmt.close();
				bd.close();
				
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, e.toString());
			}
		} else {
			JOptionPane.showMessageDialog(null, "Erro ao conectar");
		}
		/////////
		
		setResizable(false);
		setTitle("Relat\u00F3rio C\u00E9dulas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 872, 620);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		this.contentPane.setLayout(null);
		
		this.lblQtdDisp = new JLabel("Quantidade dispon\u00EDvel de cada c\u00E9dula");
		this.lblQtdDisp.setFont(new Font("Century Gothic", Font.BOLD, 20));
		this.lblQtdDisp.setBounds(224, 11, 401, 52);
		this.contentPane.add(this.lblQtdDisp);
		
		this.lblN2 = new JLabel("");
		this.lblN2.setIcon(new ImageIcon("n2.jpg"));
		this.lblN2.setBounds(21, 86, 240, 128);
		this.contentPane.add(this.lblN2);
		
		this.tfN2 = new JTextField();
		this.tfN2.setHorizontalAlignment(SwingConstants.CENTER);
		this.tfN2.setFont(new Font("Century Gothic", Font.BOLD, 16));
		this.tfN2.setEditable(false);
		this.tfN2.setColumns(10);
		this.tfN2.setBounds(21, 225, 240, 30);
		this.contentPane.add(this.tfN2);
		////////
		this.tfN2.setText(qtdN2);
		
		
		this.lblN5 = new JLabel("");
		this.lblN5.setIcon(new ImageIcon("n5.jpg"));
		this.lblN5.setBounds(308, 86, 240, 128);
		this.contentPane.add(this.lblN5);
		
		this.tfN5 = new JTextField();
		this.tfN5.setHorizontalAlignment(SwingConstants.CENTER);
		this.tfN5.setFont(new Font("Century Gothic", Font.BOLD, 16));
		this.tfN5.setEditable(false);
		this.tfN5.setColumns(10);
		this.tfN5.setBounds(308, 225, 240, 30);
		this.contentPane.add(this.tfN5);
		////////
		this.tfN5.setText(qtdN5);
		
		this.lblN10 = new JLabel("");
		this.lblN10.setIcon(new ImageIcon("n10.jpg"));
		this.lblN10.setBounds(597, 86, 240, 128);
		this.contentPane.add(this.lblN10);
		
		this.tfN10 = new JTextField();
		this.tfN10.setHorizontalAlignment(SwingConstants.CENTER);
		this.tfN10.setFont(new Font("Century Gothic", Font.BOLD, 16));
		this.tfN10.setEditable(false);
		this.tfN10.setColumns(10);
		this.tfN10.setBounds(597, 225, 240, 30);
		this.contentPane.add(this.tfN10);
		////////
		this.tfN10.setText(qtdN10);
		
		this.lblN20 = new JLabel("");
		this.lblN20.setIcon(new ImageIcon("n20.jpg"));
		this.lblN20.setBounds(21, 290, 240, 128);
		this.contentPane.add(this.lblN20);
		
		this.tfN20 = new JTextField();
		this.tfN20.setHorizontalAlignment(SwingConstants.CENTER);
		this.tfN20.setFont(new Font("Century Gothic", Font.BOLD, 16));
		this.tfN20.setEditable(false);
		this.tfN20.setColumns(10);
		this.tfN20.setBounds(21, 429, 240, 30);
		this.contentPane.add(this.tfN20);
		////////
		this.tfN20.setText(qtdN20);
		
		this.lblN50 = new JLabel("");
		this.lblN50.setIcon(new ImageIcon("n50.jpg"));
		this.lblN50.setBounds(308, 290, 240, 128);
		this.contentPane.add(this.lblN50);
		
		this.tfN50 = new JTextField();
		this.tfN50.setHorizontalAlignment(SwingConstants.CENTER);
		this.tfN50.setFont(new Font("Century Gothic", Font.BOLD, 16));
		this.tfN50.setEditable(false);
		this.tfN50.setColumns(10);
		this.tfN50.setBounds(308, 429, 240, 30);
		this.contentPane.add(this.tfN50);
		////////
		this.tfN50.setText(qtdN50);
		
		this.lblN100 = new JLabel("");
		this.lblN100.setIcon(new ImageIcon("n100.jpg"));
		this.lblN100.setBounds(597, 290, 240, 128);
		this.contentPane.add(this.lblN100);
		
		this.tfN100 = new JTextField();
		this.tfN100.setHorizontalAlignment(SwingConstants.CENTER);
		this.tfN100.setFont(new Font("Century Gothic", Font.BOLD, 16));
		this.tfN100.setEditable(false);
		this.tfN100.setColumns(10);
		this.tfN100.setBounds(597, 429, 240, 30);
		this.contentPane.add(this.tfN100);
		////////
		this.tfN100.setText(qtdN100);
		
		this.btnVoltar = new JButton("Voltar");
		this.btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		this.btnVoltar.setFont(new Font("Century Gothic", Font.BOLD, 16));
		this.btnVoltar.setBounds(308, 501, 240, 58);
		this.contentPane.add(this.btnVoltar);
	}
}
