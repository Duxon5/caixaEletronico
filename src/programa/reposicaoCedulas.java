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

public class reposicaoCedulas extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JLabel lblN2;
	private JTextField tfN2;
	private JLabel lblQtdDisp;
	private JLabel lblN5;
	private JLabel lblN10;
	private JLabel lblN20;
	private JLabel lblN50;
	private JLabel lblN100;
	private JButton btnLimpar;

	private JLabel lbl11;
	private JLabel lbl21;
	private JTextField tfN2rep;
	private JLabel lbl12;
	private JTextField tfN5;
	private JLabel lbl22;
	private JTextField tfN5rep;
	private JLabel lbl13;
	private JTextField tfN10;
	private JLabel lbl23;
	private JTextField tfN10rep;
	private JLabel lbl14;
	private JTextField tfN20;
	private JLabel lbl24;
	private JTextField tfN20rep;
	private JLabel lbl15;
	private JTextField tfN50;
	private JLabel lbl25;
	private JTextField tfN50rep;
	private JLabel lbl16;
	private JTextField tfN100;
	private JLabel lbl26;
	private JTextField tfN100rep;
	private JButton btnConfirmar;
	private JButton btnVoltar;
	
	private String qtdN2;
	private String qtdN5;
	private String qtdN10;
	private String qtdN20;
	private String qtdN50;
	private String qtdN100;

	private int qtdN2oldInt;
	private int qtdN5oldInt;
	private int qtdN10oldInt;
	private int qtdN20oldInt;
	private int qtdN50oldInt;
	private int qtdN100oldInt;	
	
	private String qtdN2old;
	private String qtdN5old;
	private String qtdN10old;
	private String qtdN20old;
	private String qtdN50old;
	private String qtdN100old;
	
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
	public reposicaoCedulas() {
////////////////////////
		BD bd = new BD();
		
		if (bd.getConnection()) {
			
			try {
				
				String sql = "SELECT idnota, qtd FROM notas;";
				PreparedStatement stmt = bd.con.prepareStatement(sql);
				
				ResultSet rs = stmt.executeQuery();
				
				///MOSTRA QUANTIDADE DE CEDULAS
				while (rs.next()) {
					String idnota = rs.getString("idnota");
					String qtd = rs.getString("qtd");
					
					int idnotaInt = Integer.parseInt(idnota);
					int qtdInt = Integer.parseInt(qtd);

					if(idnotaInt==2) {
						qtd = String.valueOf(qtdInt);
						qtdN2 = qtd;
					}
					if(idnotaInt==5) {
						qtd = String.valueOf(qtdInt);
						qtdN5 = qtd;
					}
					if(idnotaInt==10) {
						qtd = String.valueOf(qtdInt);
						qtdN10 = qtd;
					}
					if(idnotaInt==20) {
						qtd = String.valueOf(qtdInt);
						qtdN20 = qtd;
					}
					if(idnotaInt==50) {
						qtd = String.valueOf(qtdInt);
						qtdN50 = qtd;
					}
					if(idnotaInt==100) {
						qtd = String.valueOf(qtdInt);
						qtdN100 = qtd;
					}
					
				}
				///REPOSICAO DE CEDULAS

				rs.close();
				stmt.close();
				bd.close();
				
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, e.toString());
			}
		} else {
			JOptionPane.showMessageDialog(null, "Erro ao conectar");
		}
////////////////////////
		
		setResizable(false);
		setTitle("Reposi\u00E7\u00E3o de C\u00E9dulas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 884, 634);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		this.contentPane.setLayout(null);
		
		this.lblQtdDisp = new JLabel("Digite a quantidade de c\u00E9dulas que ser\u00E3o repostas");
		this.lblQtdDisp.setFont(new Font("Century Gothic", Font.BOLD, 20));
		this.lblQtdDisp.setBounds(169, 0, 517, 52);
		this.contentPane.add(this.lblQtdDisp);
		
		this.lblN2 = new JLabel("");
		this.lblN2.setIcon(new ImageIcon("n2.jpg"));
		this.lblN2.setBounds(28, 49, 240, 128);
		this.contentPane.add(this.lblN2);
		
		this.lbl11 = new JLabel("Quantidade  atual:");
		this.lbl11.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		this.lbl11.setBounds(21, 188, 173, 29);
		this.contentPane.add(this.lbl11);
		
		this.tfN2 = new JTextField();
		this.tfN2.setEditable(false);
		this.tfN2.setFont(new Font("Century Gothic", Font.BOLD, 16));
		this.tfN2.setColumns(10);
		this.tfN2.setBounds(198, 188, 76, 30);
		this.contentPane.add(this.tfN2);
////////////////////////
		this.tfN2.setText(qtdN2);
		
		this.lbl21 = new JLabel("Quantidade a repor:");
		this.lbl21.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		this.lbl21.setBounds(21, 228, 173, 38);
		this.contentPane.add(this.lbl21);
		
		this.tfN2rep = new JTextField();
		this.tfN2rep.setText((String) null);
		this.tfN2rep.setFont(new Font("Century Gothic", Font.BOLD, 16));
		this.tfN2rep.setColumns(10);
		this.tfN2rep.setBounds(198, 233, 76, 30);
		this.contentPane.add(this.tfN2rep);
		tfN2rep.setDocument(new teclas()); //Chama classe teclas
		
		this.lblN5 = new JLabel("");
		this.lblN5.setIcon(new ImageIcon("n5.jpg"));
		this.lblN5.setBounds(315, 49, 240, 128);
		this.contentPane.add(this.lblN5);
		
		this.lbl12 = new JLabel("Quantidade atual:");
		this.lbl12.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		this.lbl12.setBounds(308, 188, 173, 29);
		this.contentPane.add(this.lbl12);
		
		this.tfN5 = new JTextField();
		this.tfN5.setEditable(false);
		this.tfN5.setText((String) null);
		this.tfN5.setFont(new Font("Century Gothic", Font.BOLD, 16));
		this.tfN5.setColumns(10);
		this.tfN5.setBounds(485, 188, 76, 30);
		this.contentPane.add(this.tfN5);
////////////////////////
		this.tfN5.setText(qtdN5);
		
		this.lbl22 = new JLabel("Quantidade a repor:");
		this.lbl22.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		this.lbl22.setBounds(308, 228, 173, 38);
		this.contentPane.add(this.lbl22);
		
		this.tfN5rep = new JTextField();
		this.tfN5rep.setText((String) null);
		this.tfN5rep.setFont(new Font("Century Gothic", Font.BOLD, 16));
		this.tfN5rep.setColumns(10);
		this.tfN5rep.setBounds(485, 233, 76, 30);
		this.contentPane.add(this.tfN5rep);
		tfN5rep.setDocument(new teclas()); //Chama classe teclas
		
		this.lblN10 = new JLabel("");
		this.lblN10.setIcon(new ImageIcon("n10.jpg"));
		this.lblN10.setBounds(612, 49, 240, 128);
		this.contentPane.add(this.lblN10);
		
		this.lbl13 = new JLabel("Quantidade atual:");
		this.lbl13.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		this.lbl13.setBounds(605, 188, 173, 29);
		this.contentPane.add(this.lbl13);
		
		this.tfN10 = new JTextField();
		this.tfN10.setEditable(false);
		this.tfN10.setText((String) null);
		this.tfN10.setFont(new Font("Century Gothic", Font.BOLD, 16));
		this.tfN10.setColumns(10);
		this.tfN10.setBounds(782, 188, 76, 30);
		this.contentPane.add(this.tfN10);
////////////////////////
		this.tfN10.setText(qtdN10);
		
		this.lbl23 = new JLabel("Quantidade a repor:");
		this.lbl23.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		this.lbl23.setBounds(605, 228, 173, 38);
		this.contentPane.add(this.lbl23);
		
		this.tfN10rep = new JTextField();
		this.tfN10rep.setText((String) null);
		this.tfN10rep.setFont(new Font("Century Gothic", Font.BOLD, 16));
		this.tfN10rep.setColumns(10);
		this.tfN10rep.setBounds(782, 233, 76, 30);
		this.contentPane.add(this.tfN10rep);
		tfN10rep.setDocument(new teclas()); //Chama classe teclas
		
		this.lblN20 = new JLabel("");
		this.lblN20.setIcon(new ImageIcon("n20.jpg"));
		this.lblN20.setBounds(28, 298, 240, 128);
		this.contentPane.add(this.lblN20);
		
		this.lbl14 = new JLabel("Quantidade atual:");
		this.lbl14.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		this.lbl14.setBounds(21, 450, 173, 29);
		this.contentPane.add(this.lbl14);
		
		this.tfN20 = new JTextField();
		this.tfN20.setEditable(false);
		this.tfN20.setText((String) null);
		this.tfN20.setFont(new Font("Century Gothic", Font.BOLD, 16));
		this.tfN20.setColumns(10);
		this.tfN20.setBounds(198, 450, 76, 30);
		this.contentPane.add(this.tfN20);
////////////////////////
		this.tfN20.setText(qtdN20);
		
		
		this.lbl24 = new JLabel("Quantidade a repor:");
		this.lbl24.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		this.lbl24.setBounds(21, 490, 173, 38);
		this.contentPane.add(this.lbl24);
		
		this.tfN20rep = new JTextField();
		this.tfN20rep.setText((String) null);
		this.tfN20rep.setFont(new Font("Century Gothic", Font.BOLD, 16));
		this.tfN20rep.setColumns(10);
		this.tfN20rep.setBounds(198, 495, 76, 30);
		this.contentPane.add(this.tfN20rep);
		tfN20rep.setDocument(new teclas()); //Chama classe teclas
		
		this.lblN50 = new JLabel("");
		this.lblN50.setIcon(new ImageIcon("n50.jpg"));
		this.lblN50.setBounds(315, 298, 240, 128);
		this.contentPane.add(this.lblN50);
		
		this.lbl15 = new JLabel("Quantidade atual:");
		this.lbl15.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		this.lbl15.setBounds(308, 450, 173, 29);
		this.contentPane.add(this.lbl15);
		
		this.tfN50 = new JTextField();
		this.tfN50.setEditable(false);
		this.tfN50.setText((String) null);
		this.tfN50.setFont(new Font("Century Gothic", Font.BOLD, 16));
		this.tfN50.setColumns(10);
		this.tfN50.setBounds(485, 450, 76, 30);
		this.contentPane.add(this.tfN50);
////////////////////////
		this.tfN50.setText(qtdN50);
		
		this.lbl25 = new JLabel("Quantidade a repor:");
		this.lbl25.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		this.lbl25.setBounds(308, 490, 173, 38);
		this.contentPane.add(this.lbl25);
		
		this.tfN50rep = new JTextField();
		this.tfN50rep.setText((String) null);
		this.tfN50rep.setFont(new Font("Century Gothic", Font.BOLD, 16));
		this.tfN50rep.setColumns(10);
		this.tfN50rep.setBounds(485, 495, 76, 30);
		this.contentPane.add(this.tfN50rep);
		tfN50rep.setDocument(new teclas()); //Chama classe teclas
		
		this.lblN100 = new JLabel("");
		this.lblN100.setIcon(new ImageIcon("n100.jpg"));
		this.lblN100.setBounds(612, 298, 240, 128);
		this.contentPane.add(this.lblN100);
		
		this.btnLimpar = new JButton("Limpar");
		this.btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tfN2rep.setText("");
				tfN5rep.setText("");
				tfN10rep.setText("");
				tfN20rep.setText("");
				tfN50rep.setText("");
				tfN100rep.setText("");
			}
		});
		
		this.lbl16 = new JLabel("Quantidade atual:");
		this.lbl16.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		this.lbl16.setBounds(605, 450, 173, 29);
		this.contentPane.add(this.lbl16);
		
		this.tfN100 = new JTextField();
		this.tfN100.setEditable(false);
		this.tfN100.setText((String) null);
		this.tfN100.setFont(new Font("Century Gothic", Font.BOLD, 16));
		this.tfN100.setColumns(10);
		this.tfN100.setBounds(782, 450, 76, 30);
		this.contentPane.add(this.tfN100);
////////////////////////
		this.tfN100.setText(qtdN100);
		
		this.lbl26 = new JLabel("Quantidade a repor:");
		this.lbl26.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		this.lbl26.setBounds(605, 490, 173, 38);
		this.contentPane.add(this.lbl26);
		
		this.tfN100rep = new JTextField();
		this.tfN100rep.setText((String) null);
		this.tfN100rep.setFont(new Font("Century Gothic", Font.BOLD, 16));
		this.tfN100rep.setColumns(10);
		this.tfN100rep.setBounds(782, 495, 76, 30);
		this.contentPane.add(this.tfN100rep);
		tfN100rep.setDocument(new teclas()); //Chama classe teclas
		
		this.btnConfirmar = new JButton("Confirmar");
		this.btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BD bd = new BD();

				//VALIDANDO SE EXISTE CAMPOS VAZIOS
				int aux=0; int cont=0;
				if(tfN2rep.getText().equals("")) { aux = 1; cont++; }
				if(tfN5rep.getText().equals("")) { aux = 1; cont++;	}
				if(tfN10rep.getText().equals("")){ aux = 1; cont++; }
				if(tfN20rep.getText().equals("")) { aux = 1; cont++; }
				if(tfN50rep.getText().equals("")) {	aux = 1; cont++; }
				if(tfN100rep.getText().equals("")) { aux = 1; cont++; }
				
				if(aux==1) {
					JOptionPane.showMessageDialog(null, "Existem "+ cont +" campos em branco, verifique!");
				}				
				
				int qtdN2repInt = Integer.parseInt(tfN2rep.getText());
				int qtdN5repInt = Integer.parseInt(tfN5rep.getText());
				int qtdN10repInt = Integer.parseInt(tfN10rep.getText());
				int qtdN20repInt = Integer.parseInt(tfN20rep.getText());
				int qtdN50repInt = Integer.parseInt(tfN50rep.getText());
				int qtdN100repInt = Integer.parseInt(tfN100rep.getText());

				int qtdN2Int = Integer.parseInt(qtdN2);
				int qtdN5Int = Integer.parseInt(qtdN5);
				int qtdN10Int = Integer.parseInt(qtdN10);
				int qtdN20Int = Integer.parseInt(qtdN20);
				int qtdN50Int = Integer.parseInt(qtdN50);
				int qtdN100Int = Integer.parseInt(qtdN100);
				
				int aviso=0;
				
				int qtd2 = 0, qtd5 = 0, qtd10 = 0, qtd20 = 0, qtd50 = 0, qtd100 = 0;
				
				if (bd.getConnection()) {
					try {
						
						
						String sql = "SELECT idnota, qtd FROM notas;";
						PreparedStatement stQuery = bd.con.prepareStatement(sql);
						PreparedStatement stUpdate = bd.con.prepareStatement(sql);
						
						ResultSet rs = stQuery.executeQuery();		
						
						while (rs.next()) {						

							
							String idnota = rs.getString("idnota");
							int idnotaInt = Integer.parseInt(idnota);
													
							if(idnotaInt==2) {
								qtd2 = Integer.parseInt(rs.getString("qtd"));
								if(qtdN2repInt<0) {
									aviso = aviso + 1;		
									qtdN2oldInt = qtdN2Int;
									qtdN2old = String.valueOf(qtdN2oldInt);
								}else if(qtdN2repInt>0) {
										qtdN2oldInt = qtdN2Int;
										qtdN2Int = qtdN2Int + qtdN2repInt;
										
										qtdN2 = String.valueOf(qtdN2Int);
										qtdN2old = String.valueOf(qtdN2oldInt);
										
										String sql1 = "UPDATE notas SET qtd='"+qtdN2+"' WHERE idnota=2";

										stUpdate.executeUpdate(sql1);
								}
							}
							if(idnotaInt==5) {
								qtd5 = Integer.parseInt(rs.getString("qtd"));
								if(qtdN5repInt<0) {
									aviso = aviso + 1;	
									qtdN5oldInt = qtdN5Int;
									qtdN5old = String.valueOf(qtdN5oldInt);
								}else if(qtdN5repInt>0) {
										qtdN5oldInt = qtdN5Int;
										qtdN5Int = qtdN5Int + qtdN5repInt;
										
										qtdN5 = String.valueOf(qtdN5Int);
										qtdN5old = String.valueOf(qtdN5oldInt);
										
										String sql1 = "UPDATE notas SET qtd='"+qtdN5+"' WHERE idnota=5";

										stUpdate.executeUpdate(sql1);
								}
							}	
							if(idnotaInt==10) {
								qtd10 = Integer.parseInt(rs.getString("qtd"));
								if(qtdN10repInt<0) {
									aviso = aviso + 1;	
									qtdN10oldInt = qtdN10Int;
									qtdN10old = String.valueOf(qtdN10oldInt);
								}else if(qtdN10repInt>0) {
										qtdN10oldInt = qtdN10Int;
										qtdN10Int = qtdN10Int + qtdN10repInt;
										
										qtdN10 = String.valueOf(qtdN10Int);
										qtdN10old = String.valueOf(qtdN10oldInt);
										
										String sql1 = "UPDATE notas SET qtd='"+qtdN10+"' WHERE idnota=10";

										stUpdate.executeUpdate(sql1);
								}
							}
							if(idnotaInt==20) {
								qtd20 = Integer.parseInt(rs.getString("qtd"));
								if(qtdN20repInt<0) {
									aviso = aviso + 1;	
									qtdN20oldInt = qtdN20Int;
									qtdN20old = String.valueOf(qtdN20oldInt);
								}else if(qtdN20repInt>0) {
										qtdN20oldInt = qtdN20Int;
										qtdN20Int = qtdN20Int + qtdN20repInt;
										
										qtdN20 = String.valueOf(qtdN20Int);
										qtdN20old = String.valueOf(qtdN20oldInt);
										
										String sql1 = "UPDATE notas SET qtd='"+qtdN20+"' WHERE idnota=20";

										stUpdate.executeUpdate(sql1);
								}
							}
							if(idnotaInt==50) {
								qtd50 = Integer.parseInt(rs.getString("qtd"));
								if(qtdN50repInt<0) {
									aviso = aviso + 1;	
									qtdN50oldInt = qtdN50Int;
									qtdN50old = String.valueOf(qtdN50oldInt);
								}else if(qtdN50repInt>0) {
										qtdN50oldInt = qtdN50Int;
										qtdN50Int = qtdN50Int + qtdN50repInt;
										
										qtdN50 = String.valueOf(qtdN50Int);
										qtdN50old = String.valueOf(qtdN50oldInt);
										
										String sql1 = "UPDATE notas SET qtd='"+qtdN50+"' WHERE idnota=50";

										stUpdate.executeUpdate(sql1);
								}
							}
							if(idnotaInt==100) {
								qtd100 = Integer.parseInt(rs.getString("qtd"));
								if(qtdN100repInt<0) {
									aviso = aviso + 1;	
									qtdN100oldInt = qtdN100Int;
									qtdN100old = String.valueOf(qtdN100oldInt);		
								
								}else if(qtdN100repInt>=0) {
										qtdN100oldInt = qtdN100Int;
										qtdN100Int = qtdN100Int + qtdN100repInt;
										
										qtdN100 = String.valueOf(qtdN100Int);
										qtdN100old = String.valueOf(qtdN100oldInt);
										
										String sql1 = "UPDATE notas SET qtd='"+qtdN100+"' WHERE idnota=100";

										stUpdate.executeUpdate(sql1);
								}
							}
						}

						rs.close();
						stUpdate.close();
						stQuery.close();
						bd.close();
					} catch (SQLException f) {
						JOptionPane.showMessageDialog(null, f.toString());
					}
				} else {
					JOptionPane.showMessageDialog(null, "Erro ao conectar");
				}
				
				if(aviso>0) {
					JOptionPane.showMessageDialog(null, aviso + " campo(s) estavam com valores negativos, estes campos não foram alterados.\nPressione OK para ver a lista atualizada.");
				}
				JOptionPane.showMessageDialog(null, "R$ |     Antes     |     Depois\n" +
													"2              "     + qtdN2old   + "            " + qtdN2 +
													"\n5            "     + qtdN5old   + "            " + qtdN5 +
													"\n10          "    + qtdN10old  + "            " + qtdN10 +
													"\n20          "   + qtdN20old  + "            " + qtdN20 +
													"\n50          "   + qtdN50old  + "            " + qtdN50 +
													"\n100        "  + qtdN100old + "            " + qtdN100);
				dispose();
				if(qtd2<20 || qtd5<=30 || qtd10<=40 || qtd20<=50 || qtd50<=60 || qtd100<=70) {
					JOptionPane.showMessageDialog(null, "Checar a tela de cota mínima. \nUm ou mais valores estão abaixo da quantidade recomendada.");
				}

			}
		});
		this.btnConfirmar.setFont(new Font("Century Gothic", Font.BOLD, 16));
		this.btnConfirmar.setBounds(21, 549, 253, 38);
		this.contentPane.add(this.btnConfirmar);
		this.btnLimpar.setFont(new Font("Century Gothic", Font.BOLD, 16));
		this.btnLimpar.setBounds(308, 549, 253, 38);
		this.contentPane.add(this.btnLimpar);
		
		this.btnVoltar = new JButton("Voltar");
		this.btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		this.btnVoltar.setFont(new Font("Century Gothic", Font.BOLD, 16));
		this.btnVoltar.setBounds(605, 549, 253, 38);
		this.contentPane.add(this.btnVoltar);
	}
}
