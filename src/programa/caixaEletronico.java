package programa;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class caixaEletronico extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JFrame frmCaixaEletrnico;
	private JButton btnEfetuarSaque;
	private JButton btnRelatorioDeCedulas;
	private JButton btnValorTotalDisponivel;
	private JButton btnReposicaodeCedulas;
	private JButton btnCotaMinima;
	private JButton btnSair;
	private JLabel lblModuloDoCliente;
	private JLabel lblModuloDoAdministrador;
	private JLabel lblModuloDeAmbos;
	private JLabel lblAviso;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					caixaEletronico window = new caixaEletronico();
					window.frmCaixaEletrnico.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public caixaEletronico() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	int a;
	int qtdN2inicio = 0, qtdN5inicio = 0, qtdN10inicio = 0, qtdN20inicio = 0, qtdN50inicio = 0, qtdN100inicio = 0;
	int qtdN2fim = 0, qtdN5fim = 0, qtdN10fim = 0, qtdN20fim = 0, qtdN50fim = 0, qtdN100fim = 0;
	int qtd2 = 0, qtd5 = 0, qtd10 = 0, qtd20 = 0, qtd50 = 0, qtd100 = 0;
	private void initialize() {
		
		BD bd = new BD();
		
		if (bd.getConnection()) {
			
			try {
				String sql = "SELECT idnota, qtd FROM notas;";
				PreparedStatement stmt = bd.con.prepareStatement(sql);
					
				ResultSet rs = stmt.executeQuery();					
				
				while (rs.next()) {
		
					int idnotaInt = Integer.parseInt(rs.getString("idnota"));
		
					if (idnotaInt == 2) {
						qtd2 = Integer.parseInt(rs.getString("qtd"));
						qtdN2inicio = qtd2;
					}
		
					if (idnotaInt == 5) {
						qtd5 = Integer.parseInt(rs.getString("qtd"));
						qtdN5inicio = qtd5;
					}
		
					if (idnotaInt == 10) {
						qtd10 = Integer.parseInt(rs.getString("qtd"));
						qtdN10inicio = qtd10;
					}
		
					if (idnotaInt == 20) {
						qtd20 = Integer.parseInt(rs.getString("qtd"));
						qtdN20inicio = qtd20;
					}
		
					if (idnotaInt == 50) {
						qtd50 = Integer.parseInt(rs.getString("qtd"));
						qtdN50inicio = qtd50;
					}
		
					if (idnotaInt == 100) {
						qtd100 = Integer.parseInt(rs.getString("qtd"));
						qtdN100inicio = qtd100;
					}
				}
				rs.close();
				stmt.close();
				bd.close();
			}catch(SQLException e){
				JOptionPane.showMessageDialog(null, e.toString());
			}
		}else{
			JOptionPane.showMessageDialog(null, "Erro ao conectar");
		}
		
		if(qtd2<20 || qtd5<=30 || qtd10<=40 || qtd20<=50 || qtd50<=60 || qtd100<=70) {
			JOptionPane.showMessageDialog(null, "Checar a tela de cota mínima. \nUm ou mais valores estão abaixo da quantidade recomendada.");
		}

		frmCaixaEletrnico = new JFrame();
		this.frmCaixaEletrnico.setResizable(false);
		frmCaixaEletrnico.setTitle("Caixa");
		frmCaixaEletrnico.setBounds(100, 100, 211, 360);
		frmCaixaEletrnico.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCaixaEletrnico.getContentPane().setLayout(null);

		
		btnEfetuarSaque = new JButton("Efetuar Saque");
		btnEfetuarSaque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				saque s = new saque();
				try {
					s.sacar();
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnEfetuarSaque.setFont(new Font("Century Gothic", Font.BOLD, 14));
		btnEfetuarSaque.setBounds(10, 32, 183, 32);
		frmCaixaEletrnico.getContentPane().add(btnEfetuarSaque);

		btnRelatorioDeCedulas = new JButton("Relatorio de Cedulas");
		btnRelatorioDeCedulas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new relatorioCedulas().setVisible(true);

			}
		});
		btnRelatorioDeCedulas.setFont(new Font("Century Gothic", Font.BOLD, 14));
		btnRelatorioDeCedulas.setBounds(10, 105, 183, 32);
		frmCaixaEletrnico.getContentPane().add(btnRelatorioDeCedulas);

		btnValorTotalDisponivel = new JButton("Valor total disponivel");
		btnValorTotalDisponivel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				valorDisponivel r = new valorDisponivel();
				r.relatorio();
			}
		});
		btnValorTotalDisponivel.setFont(new Font("Century Gothic", Font.BOLD, 14));
		btnValorTotalDisponivel.setBounds(10, 143, 183, 32);
		frmCaixaEletrnico.getContentPane().add(btnValorTotalDisponivel);

		btnReposicaodeCedulas = new JButton("Reposicao de Cedulas");
		btnReposicaodeCedulas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new reposicaoCedulas().setVisible(true);
			}
		});
		btnReposicaodeCedulas.setFont(new Font("Century Gothic", Font.BOLD, 13));
		btnReposicaodeCedulas.setBounds(10, 179, 183, 32);
		frmCaixaEletrnico.getContentPane().add(btnReposicaodeCedulas);

		btnCotaMinima = new JButton("Cota Minima");
		this.btnCotaMinima.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new cotaMinima().setVisible(true);
			}
		});
		btnCotaMinima.setFont(new Font("Century Gothic", Font.BOLD, 14));
		btnCotaMinima.setBounds(10, 217, 183, 32);
		frmCaixaEletrnico.getContentPane().add(btnCotaMinima);

		btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BD bd = new BD();
				
				if (bd.getConnection()) {
					
					try {
						String sql = "SELECT idnota, qtd FROM notas;";
						PreparedStatement stmt = bd.con.prepareStatement(sql);
							
						ResultSet rs = stmt.executeQuery();					
						
						while (rs.next()) {
				
							int idnotaInt = Integer.parseInt(rs.getString("idnota"));
				
							if (idnotaInt == 2) {
								qtd2 = Integer.parseInt(rs.getString("qtd"));
								qtdN2fim = qtd2;
							}
				
							if (idnotaInt == 5) {
								qtd5 = Integer.parseInt(rs.getString("qtd"));
								qtdN5fim = qtd5;
							}
				
							if (idnotaInt == 10) {
								qtd10 = Integer.parseInt(rs.getString("qtd"));
								qtdN10fim = qtd10;
							}
				
							if (idnotaInt == 20) {
								qtd20 = Integer.parseInt(rs.getString("qtd"));
								qtdN20fim = qtd20;
							}
				
							if (idnotaInt == 50) {
								qtd50 = Integer.parseInt(rs.getString("qtd"));
								qtdN50fim = qtd50;
							}
				
							if (idnotaInt == 100) {
								qtd100 = Integer.parseInt(rs.getString("qtd"));
								qtdN100fim = qtd100;
							}
						}
						rs.close();
						stmt.close();
						bd.close();
					}catch(SQLException e){
						JOptionPane.showMessageDialog(null, e.toString());
					}
				}else{
					JOptionPane.showMessageDialog(null, "Erro ao conectar");
				}
				JOptionPane.showMessageDialog(null, "R$ |     Inicio Dia     |     Fim Dia\n" +
													"2                "     + qtdN2inicio   + "                " + qtdN2fim +
													"\n5              "     + qtdN5inicio   + "                 " + qtdN5fim +
													"\n10            "    + qtdN10inicio  + "                 " + qtdN10fim +
													"\n20            "   + qtdN20inicio  + "                  " + qtdN20fim +
													"\n50            "   + qtdN50inicio  + "                  " + qtdN50fim +
													"\n100          "  + qtdN100inicio + "                     " + qtdN100fim);
				System.exit(0);
			}
		});
		btnSair.setFont(new Font("Century Gothic", Font.BOLD, 14));
		btnSair.setBounds(10, 286, 183, 32);
		frmCaixaEletrnico.getContentPane().add(btnSair);

		lblModuloDoCliente = new JLabel("Modulo do cliente");
		lblModuloDoCliente.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblModuloDoCliente.setBounds(10, 6, 134, 19);
		frmCaixaEletrnico.getContentPane().add(lblModuloDoCliente);

		lblModuloDoAdministrador = new JLabel("Modulo do Administrador");
		lblModuloDoAdministrador.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblModuloDoAdministrador.setBounds(10, 79, 183, 19);
		frmCaixaEletrnico.getContentPane().add(lblModuloDoAdministrador);

		lblModuloDeAmbos = new JLabel("Modulo de Ambos");
		lblModuloDeAmbos.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblModuloDeAmbos.setBounds(10, 260, 183, 19);
		frmCaixaEletrnico.getContentPane().add(lblModuloDeAmbos);
		
		this.lblAviso = new JLabel("Aviso:");
		this.lblAviso.setFont(new Font("Century Gothic", Font.BOLD, 12));
		this.lblAviso.setBounds(10, 329, 183, 24);
		this.frmCaixaEletrnico.getContentPane().add(this.lblAviso);
		
	}
}
