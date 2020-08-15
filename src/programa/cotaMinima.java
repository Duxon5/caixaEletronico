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

public class cotaMinima extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JLabel lblN2;
	private JTextField tfN2;
	private JLabel lblN5;
	private JLabel lblN10;
	private JLabel lblN20;
	private JLabel lblN50;
	private JLabel lblN100;
	private JButton btnLimpar;

	private JLabel lbl2a;
	private JLabel lbl2m;
	private JTextField tfN2min;
	private JButton btnConfirmar;
	private JButton btnVoltar;
	
	private String qtdN2;
	private String qtdN5;
	private String qtdN10;
	private String qtdN20;
	private String qtdN50;
	private String qtdN100;
	
	/*private String qtdN2rep;
	private String qtdN5rep;
	private String qtdN10rep;
	private String qtdN20rep;
	private String qtdN50rep;
	private String qtdN100rep;*/

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
	private JLabel lbl2r;
	private JTextField tfN2rep;
	private JLabel lbl5a;
	private JTextField tfN5;
	private JTextField tfN5min;
	private JLabel lbl5m;
	private JLabel lbl5r;
	private JTextField tfN5rep;
	private JTextField tfN10rep;
	private JLabel lbl10r;
	private JLabel lbl10m;
	private JTextField tfN10min;
	private JTextField tfN10;
	private JLabel lbl10a;
	private JLabel lbl20a;
	private JTextField tfN20;
	private JLabel lbl50a;
	private JTextField tfN50;
	private JLabel lbl100a;
	private JTextField tfN100;
	private JLabel lbl100m;
	private JTextField tfN100min;
	private JTextField tfN100rep;
	private JLabel lbl100r;
	private JTextField tfN50rep;
	private JTextField tfN50min;
	private JLabel lbl50m;
	private JLabel lbl50r;
	private JTextField tfN20min;
	private JLabel lbl20m;
	private JLabel lbl20r;
	private JTextField tfN20rep;
	
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
	public cotaMinima() {
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
		setTitle("Cota M\u00EDnima");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 884, 637);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		this.contentPane.setLayout(null);
		
		this.lblN2 = new JLabel("");
		this.lblN2.setIcon(new ImageIcon("n2.jpg"));
		this.lblN2.setBounds(22, 11, 240, 128);
		this.contentPane.add(this.lblN2);
		
		this.lbl2a = new JLabel("Atual:");
		this.lbl2a.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		this.lbl2a.setBounds(47, 150, 76, 29);
		this.contentPane.add(this.lbl2a);
		
		this.tfN2 = new JTextField();
		this.tfN2.setHorizontalAlignment(SwingConstants.CENTER);
		this.tfN2.setEditable(false);
		this.tfN2.setFont(new Font("Century Gothic", Font.BOLD, 16));
		this.tfN2.setColumns(10);
		this.tfN2.setBounds(150, 150, 76, 30);
		this.contentPane.add(this.tfN2);
////////////////////////
		this.tfN2.setText(qtdN2);
		
		this.lbl2m = new JLabel("Minimo:");
		this.lbl2m.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		this.lbl2m.setBounds(47, 190, 76, 38);
		this.contentPane.add(this.lbl2m);
		
		this.tfN2min = new JTextField();
		this.tfN2min.setHorizontalAlignment(SwingConstants.CENTER);
		this.tfN2min.setEditable(false);
		this.tfN2min.setText("20");
		this.tfN2min.setFont(new Font("Century Gothic", Font.BOLD, 16));
		this.tfN2min.setColumns(10);
		this.tfN2min.setBounds(150, 195, 76, 30);
		this.contentPane.add(this.tfN2min);
		
		this.lbl2r = new JLabel("Repor:");
		this.lbl2r.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		this.lbl2r.setBounds(47, 236, 76, 38);
		this.contentPane.add(this.lbl2r);
		
		this.tfN2rep = new JTextField();
		this.tfN2rep.setHorizontalAlignment(SwingConstants.CENTER);
		this.tfN2rep.setText((String) null);
		this.tfN2rep.setFont(new Font("Century Gothic", Font.BOLD, 16));
		this.tfN2rep.setColumns(10);
		this.tfN2rep.setBounds(150, 236, 76, 30);
		this.contentPane.add(this.tfN2rep);
		tfN2rep.setDocument(new teclas()); //Chama classe teclas
		
		this.lblN5 = new JLabel("");
		this.lblN5.setIcon(new ImageIcon("n5.jpg"));
		this.lblN5.setBounds(308, 11, 240, 128);
		this.contentPane.add(this.lblN5);
		
		this.lbl5a = new JLabel("Atual:");
		this.lbl5a.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		this.lbl5a.setBounds(346, 150, 76, 29);
		this.contentPane.add(this.lbl5a);
		
		this.tfN5 = new JTextField();
		this.tfN5.setHorizontalAlignment(SwingConstants.CENTER);
		this.tfN5.setText((String) null);
		this.tfN5.setFont(new Font("Century Gothic", Font.BOLD, 16));
		this.tfN5.setEditable(false);
		this.tfN5.setColumns(10);
		this.tfN5.setBounds(449, 150, 76, 30);
		this.contentPane.add(this.tfN5);
		this.tfN5.setText(qtdN5);
		
		this.lbl5m = new JLabel("Minimo:");
		this.lbl5m.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		this.lbl5m.setBounds(346, 190, 76, 38);
		this.contentPane.add(this.lbl5m);
		
		this.tfN5min = new JTextField();
		this.tfN5min.setHorizontalAlignment(SwingConstants.CENTER);
		this.tfN5min.setEditable(false);
		this.tfN5min.setText("30");
		this.tfN5min.setFont(new Font("Century Gothic", Font.BOLD, 16));
		this.tfN5min.setColumns(10);
		this.tfN5min.setBounds(449, 195, 76, 30);
		this.contentPane.add(this.tfN5min);
		
		this.lbl5r = new JLabel("Repor:");
		this.lbl5r.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		this.lbl5r.setBounds(346, 236, 76, 38);
		this.contentPane.add(this.lbl5r);
		
		this.tfN5rep = new JTextField();
		this.tfN5rep.setHorizontalAlignment(SwingConstants.CENTER);
		this.tfN5rep.setText((String) null);
		this.tfN5rep.setFont(new Font("Century Gothic", Font.BOLD, 16));
		this.tfN5rep.setColumns(10);
		this.tfN5rep.setBounds(449, 236, 76, 30);
		this.contentPane.add(this.tfN5rep);
		tfN5rep.setDocument(new teclas()); //Chama classe teclas
		
		this.lblN10 = new JLabel("");
		this.lblN10.setIcon(new ImageIcon("n10.jpg"));
		this.lblN10.setBounds(592, 11, 240, 128);
		this.contentPane.add(this.lblN10);
		
		this.lbl10a = new JLabel("Atual:");
		this.lbl10a.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		this.lbl10a.setBounds(624, 150, 76, 29);
		this.contentPane.add(this.lbl10a);
		
		this.tfN10 = new JTextField();
		this.tfN10.setHorizontalAlignment(SwingConstants.CENTER);
		this.tfN10.setText((String) null);
		this.tfN10.setFont(new Font("Century Gothic", Font.BOLD, 16));
		this.tfN10.setEditable(false);
		this.tfN10.setColumns(10);
		this.tfN10.setBounds(727, 150, 76, 30);
		this.contentPane.add(this.tfN10);
		this.tfN10.setText(qtdN10);
		
		this.lbl10m = new JLabel("Minimo:");
		this.lbl10m.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		this.lbl10m.setBounds(624, 190, 76, 38);
		this.contentPane.add(this.lbl10m);
		
		this.tfN10min = new JTextField();
		this.tfN10min.setHorizontalAlignment(SwingConstants.CENTER);
		this.tfN10min.setEditable(false);
		this.tfN10min.setText("40");
		this.tfN10min.setFont(new Font("Century Gothic", Font.BOLD, 16));
		this.tfN10min.setColumns(10);
		this.tfN10min.setBounds(727, 195, 76, 30);
		this.contentPane.add(this.tfN10min);
		
		this.lbl10r = new JLabel("Repor:");
		this.lbl10r.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		this.lbl10r.setBounds(624, 236, 76, 38);
		this.contentPane.add(this.lbl10r);
		
		this.tfN10rep = new JTextField();
		this.tfN10rep.setHorizontalAlignment(SwingConstants.CENTER);
		this.tfN10rep.setText((String) null);
		this.tfN10rep.setFont(new Font("Century Gothic", Font.BOLD, 16));
		this.tfN10rep.setColumns(10);
		this.tfN10rep.setBounds(727, 236, 76, 30);
		this.contentPane.add(this.tfN10rep);
		tfN10rep.setDocument(new teclas()); //Chama classe teclas
		
		this.lblN20 = new JLabel("");
		this.lblN20.setIcon(new ImageIcon("n20.jpg"));
		this.lblN20.setBounds(22, 283, 240, 128);
		this.contentPane.add(this.lblN20);
		
		this.lbl20a = new JLabel("Atual:");
		this.lbl20a.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		this.lbl20a.setBounds(47, 422, 76, 29);
		this.contentPane.add(this.lbl20a);
		
		this.tfN20 = new JTextField();
		this.tfN20.setHorizontalAlignment(SwingConstants.CENTER);
		this.tfN20.setText((String) null);
		this.tfN20.setFont(new Font("Century Gothic", Font.BOLD, 16));
		this.tfN20.setEditable(false);
		this.tfN20.setColumns(10);
		this.tfN20.setBounds(150, 422, 76, 30);
		this.contentPane.add(this.tfN20);
		this.tfN20.setText(qtdN20);
		
		this.lbl20m = new JLabel("Minimo:");
		this.lbl20m.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		this.lbl20m.setBounds(47, 462, 76, 38);
		this.contentPane.add(this.lbl20m);
		
		this.tfN20min = new JTextField();
		this.tfN20min.setHorizontalAlignment(SwingConstants.CENTER);
		this.tfN20min.setEditable(false);
		this.tfN20min.setText("50");
		this.tfN20min.setFont(new Font("Century Gothic", Font.BOLD, 16));
		this.tfN20min.setColumns(10);
		this.tfN20min.setBounds(150, 467, 76, 30);
		this.contentPane.add(this.tfN20min);
		
		this.lbl20r = new JLabel("Repor:");
		this.lbl20r.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		this.lbl20r.setBounds(47, 508, 76, 38);
		this.contentPane.add(this.lbl20r);
		
		this.tfN20rep = new JTextField();
		this.tfN20rep.setHorizontalAlignment(SwingConstants.CENTER);
		this.tfN20rep.setText((String) null);
		this.tfN20rep.setFont(new Font("Century Gothic", Font.BOLD, 16));
		this.tfN20rep.setColumns(10);
		this.tfN20rep.setBounds(150, 508, 76, 30);
		this.contentPane.add(this.tfN20rep);
		tfN20rep.setDocument(new teclas()); //Chama classe teclas
		
		this.lblN50 = new JLabel("");
		this.lblN50.setIcon(new ImageIcon("n50.jpg"));
		this.lblN50.setBounds(308, 283, 240, 128);
		this.contentPane.add(this.lblN50);
		
		this.lbl50a = new JLabel("Atual:");
		this.lbl50a.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		this.lbl50a.setBounds(346, 422, 76, 29);
		this.contentPane.add(this.lbl50a);
		
		this.tfN50 = new JTextField();
		this.tfN50.setHorizontalAlignment(SwingConstants.CENTER);
		this.tfN50.setText((String) null);
		this.tfN50.setFont(new Font("Century Gothic", Font.BOLD, 16));
		this.tfN50.setEditable(false);
		this.tfN50.setColumns(10);
		this.tfN50.setBounds(449, 422, 76, 30);
		this.contentPane.add(this.tfN50);
		this.tfN50.setText(qtdN50);
		
		this.lbl50m = new JLabel("Minimo:");
		this.lbl50m.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		this.lbl50m.setBounds(346, 462, 76, 38);
		this.contentPane.add(this.lbl50m);
		
		this.tfN50min = new JTextField();
		this.tfN50min.setHorizontalAlignment(SwingConstants.CENTER);
		this.tfN50min.setEditable(false);
		this.tfN50min.setText("60");
		this.tfN50min.setFont(new Font("Century Gothic", Font.BOLD, 16));
		this.tfN50min.setColumns(10);
		this.tfN50min.setBounds(449, 467, 76, 30);
		this.contentPane.add(this.tfN50min);
		
		this.lbl50r = new JLabel("Repor:");
		this.lbl50r.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		this.lbl50r.setBounds(346, 508, 76, 38);
		this.contentPane.add(this.lbl50r);
		
		this.tfN50rep = new JTextField();
		this.tfN50rep.setHorizontalAlignment(SwingConstants.CENTER);
		this.tfN50rep.setText((String) null);
		this.tfN50rep.setFont(new Font("Century Gothic", Font.BOLD, 16));
		this.tfN50rep.setColumns(10);
		this.tfN50rep.setBounds(449, 508, 76, 30);
		this.contentPane.add(this.tfN50rep);
		tfN50rep.setDocument(new teclas()); //Chama classe teclas
		
		this.lblN100 = new JLabel("");
		this.lblN100.setIcon(new ImageIcon("n100.jpg"));
		this.lblN100.setBounds(592, 283, 240, 128);
		this.contentPane.add(this.lblN100);
		
		this.lbl100a = new JLabel("Atual:");
		this.lbl100a.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		this.lbl100a.setBounds(624, 422, 76, 29);
		this.contentPane.add(this.lbl100a);
		
		this.tfN100 = new JTextField();
		this.tfN100.setHorizontalAlignment(SwingConstants.CENTER);
		this.tfN100.setText((String) null);
		this.tfN100.setFont(new Font("Century Gothic", Font.BOLD, 16));
		this.tfN100.setEditable(false);
		this.tfN100.setColumns(10);
		this.tfN100.setBounds(727, 422, 76, 30);
		this.contentPane.add(this.tfN100);
		this.tfN100.setText(qtdN100);
		
		this.lbl100m = new JLabel("Minimo:");
		this.lbl100m.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		this.lbl100m.setBounds(624, 462, 76, 38);
		this.contentPane.add(this.lbl100m);
		
		this.tfN100min = new JTextField();
		this.tfN100min.setHorizontalAlignment(SwingConstants.CENTER);
		this.tfN100min.setEditable(false);
		this.tfN100min.setText("70");
		this.tfN100min.setFont(new Font("Century Gothic", Font.BOLD, 16));
		this.tfN100min.setColumns(10);
		this.tfN100min.setBounds(727, 467, 76, 30);
		this.contentPane.add(this.tfN100min);
		
		this.lbl100r = new JLabel("Repor:");
		this.lbl100r.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		this.lbl100r.setBounds(624, 508, 76, 38);
		this.contentPane.add(this.lbl100r);
		
		this.tfN100rep = new JTextField();
		this.tfN100rep.setHorizontalAlignment(SwingConstants.CENTER);
		this.tfN100rep.setText((String) null);
		this.tfN100rep.setFont(new Font("Century Gothic", Font.BOLD, 16));
		this.tfN100rep.setColumns(10);
		this.tfN100rep.setBounds(727, 508, 76, 30);
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

			}
		});
		this.btnConfirmar.setFont(new Font("Century Gothic", Font.BOLD, 16));
		this.btnConfirmar.setBounds(22, 558, 253, 38);
		this.contentPane.add(this.btnConfirmar);
		
		this.btnLimpar = new JButton("Limpar");
		this.btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tfN2min.setText("");
				tfN5rep.setText("");
				tfN10rep.setText("");
				tfN20rep.setText("");
				tfN50rep.setText("");
				tfN100rep.setText("");
			}
		});
		this.btnLimpar.setFont(new Font("Century Gothic", Font.BOLD, 16));
		this.btnLimpar.setBounds(309, 558, 253, 38);
		this.contentPane.add(this.btnLimpar);
		
		this.btnVoltar = new JButton("Voltar");
		this.btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		this.btnVoltar.setFont(new Font("Century Gothic", Font.BOLD, 16));
		this.btnVoltar.setBounds(606, 558, 253, 38);
		this.contentPane.add(this.btnVoltar);
	}
}
