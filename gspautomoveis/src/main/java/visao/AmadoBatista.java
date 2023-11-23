package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controle.CarroDAO;
import controle.EnderecoDAO;
import controle.FornecedorDAO;
import controle.FuncionarioDAO;
import controle.VendaDAO;
import modelo.Carro;
import modelo.Endereco;
import modelo.Fornecedor;
import modelo.Funcionario;
import modelo.Venda;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AmadoBatista extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblFuncionario;
	private JLabel lblCliente;
	private JLabel lblNewLabel_2;
	private VendaDAO vendadao = VendaDAO.getInstancia();
	private CarroDAO carrodao = CarroDAO.getInstancia();
	private FuncionarioDAO funcdao = FuncionarioDAO.getInstancia();
	private FornecedorDAO forndao = FornecedorDAO.getInstancia();
	private EnderecoDAO enddao = EnderecoDAO.getInstancia();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AmadoBatista frame = new AmadoBatista();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param linha 
	 */
	public AmadoBatista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 893, 741);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setUndecorated(true);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		lblNewLabel_3.setIcon(new ImageIcon(AmadoBatista.class.getResource("/visao/imagens/voltar.png")));
		lblNewLabel_3.setBounds(784, 21, 42, 53);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(AmadoBatista.class.getResource("/visao/imagens/Logo sem fundo.png")));
		lblNewLabel_2.setBounds(311, 0, 190, 183);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(AmadoBatista.class.getResource("/visao/imagens/bgcima.png")));
		lblNewLabel_1.setBounds(0, 0, 893, 172);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel = new JLabel("CARRO");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel.setBounds(20, 183, 78, 17);
		contentPane.add(lblNewLabel);
		
		lblFuncionario = new JLabel("FUNCIONÁRIO");
		lblFuncionario.setHorizontalAlignment(SwingConstants.LEFT);
		lblFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblFuncionario.setBounds(311, 177, 156, 28);
		contentPane.add(lblFuncionario);
		
		lblCliente = new JLabel("CLIENTE");
		lblCliente.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblCliente.setBounds(667, 177, 108, 23);
		contentPane.add(lblCliente);
		
		JLabel lblModelo = new JLabel("edit");
		lblModelo.setHorizontalAlignment(SwingConstants.LEFT);
		lblModelo.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblModelo.setBounds(10, 211, 235, 28);
		contentPane.add(lblModelo);
		
		JLabel lblMarca = new JLabel("edit");
		lblMarca.setHorizontalAlignment(SwingConstants.LEFT);
		lblMarca.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblMarca.setBounds(10, 249, 235, 28);
		contentPane.add(lblMarca);
		
		JLabel lblAno = new JLabel("edit");
		lblAno.setHorizontalAlignment(SwingConstants.LEFT);
		lblAno.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblAno.setBounds(10, 285, 235, 28);
		contentPane.add(lblAno);
		
		JLabel lblNovo = new JLabel("edit");
		lblNovo.setHorizontalAlignment(SwingConstants.LEFT);
		lblNovo.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNovo.setBounds(10, 323, 235, 28);
		contentPane.add(lblNovo);
		
		JLabel lblTipo = new JLabel("edit");
		lblTipo.setHorizontalAlignment(SwingConstants.LEFT);
		lblTipo.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblTipo.setBounds(10, 362, 235, 28);
		contentPane.add(lblTipo);
		
		JLabel lblCombustivel = new JLabel("edit");
		lblCombustivel.setHorizontalAlignment(SwingConstants.LEFT);
		lblCombustivel.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblCombustivel.setBounds(10, 399, 235, 28);
		contentPane.add(lblCombustivel);
		
		JLabel lblPotencia = new JLabel("edit");
		lblPotencia.setHorizontalAlignment(SwingConstants.LEFT);
		lblPotencia.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblPotencia.setBounds(10, 438, 235, 28);
		contentPane.add(lblPotencia);
		
		JLabel lblCor = new JLabel("edit");
		lblCor.setHorizontalAlignment(SwingConstants.LEFT);
		lblCor.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblCor.setBounds(10, 472, 235, 28);
		contentPane.add(lblCor);
		
		JLabel lblABS = new JLabel("edit");
		lblABS.setHorizontalAlignment(SwingConstants.LEFT);
		lblABS.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblABS.setBounds(10, 508, 235, 28);
		contentPane.add(lblABS);
		
		JLabel lblPreco = new JLabel("edit");
		lblPreco.setHorizontalAlignment(SwingConstants.LEFT);
		lblPreco.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblPreco.setBounds(10, 547, 235, 28);
		contentPane.add(lblPreco);
		
		JLabel lblQuilometragem = new JLabel("edit");
		lblQuilometragem.setHorizontalAlignment(SwingConstants.LEFT);
		lblQuilometragem.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblQuilometragem.setBounds(10, 581, 235, 28);
		contentPane.add(lblQuilometragem);
		
		JLabel lblPromocao = new JLabel("edit");
		lblPromocao.setHorizontalAlignment(SwingConstants.LEFT);
		lblPromocao.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblPromocao.setBounds(10, 620, 235, 28);
		contentPane.add(lblPromocao);
		
		JLabel lblFornecedor = new JLabel("edit");
		lblFornecedor.setHorizontalAlignment(SwingConstants.LEFT);
		lblFornecedor.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblFornecedor.setBounds(10, 659, 235, 28);
		contentPane.add(lblFornecedor);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(AmadoBatista.class.getResource("/visao/imagens/bglateral.png")));
		lblNewLabel_5.setForeground(new Color(68, 116, 157));
		lblNewLabel_5.setBackground(new Color(68, 116, 157));
		lblNewLabel_5.setBounds(271, 188, 4, 473);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_5_1 = new JLabel("");
		lblNewLabel_5_1.setIcon(new ImageIcon(AmadoBatista.class.getResource("/visao/imagens/bglateral.png")));
		lblNewLabel_5_1.setForeground(new Color(68, 116, 157));
		lblNewLabel_5_1.setBackground(new Color(68, 116, 157));
		lblNewLabel_5_1.setBounds(619, 189, 4, 473);
		contentPane.add(lblNewLabel_5_1);
		
		JLabel lblNome = new JLabel("edit");
		lblNome.setHorizontalAlignment(SwingConstants.LEFT);
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNome.setBounds(294, 211, 235, 28);
		contentPane.add(lblNome);
		
		JLabel lblUsuario = new JLabel("edit");
		lblUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblUsuario.setBounds(294, 250, 235, 28);
		contentPane.add(lblUsuario);
		
		JLabel lbltelefone = new JLabel("edit");
		lbltelefone.setHorizontalAlignment(SwingConstants.LEFT);
		lbltelefone.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lbltelefone.setBounds(294, 288, 235, 28);
		contentPane.add(lbltelefone);
		
		JLabel lblEmail = new JLabel("edit");
		lblEmail.setHorizontalAlignment(SwingConstants.LEFT);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblEmail.setBounds(294, 327, 235, 28);
		contentPane.add(lblEmail);
		
		JLabel lblNomeCliente = new JLabel("edit");
		lblNomeCliente.setHorizontalAlignment(SwingConstants.LEFT);
		lblNomeCliente.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNomeCliente.setBounds(633, 211, 235, 28);
		contentPane.add(lblNomeCliente);
		
		JLabel lblTelCliente = new JLabel("edit");
		lblTelCliente.setHorizontalAlignment(SwingConstants.LEFT);
		lblTelCliente.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblTelCliente.setBounds(633, 249, 235, 28);
		contentPane.add(lblTelCliente);
		
		JLabel lblEnderecoCliente = new JLabel("edit");
		lblEnderecoCliente.setHorizontalAlignment(SwingConstants.LEFT);
		lblEnderecoCliente.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblEnderecoCliente.setBounds(633, 285, 235, 28);
		contentPane.add(lblEnderecoCliente);
		
		JLabel lblDataVenda = new JLabel("edit");
		lblDataVenda.setHorizontalAlignment(SwingConstants.LEFT);
		lblDataVenda.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblDataVenda.setBounds(633, 323, 235, 28);
		contentPane.add(lblDataVenda);
		
		JLabel lblFormaPagamento = new JLabel("edit");
		lblFormaPagamento.setHorizontalAlignment(SwingConstants.LEFT);
		lblFormaPagamento.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblFormaPagamento.setBounds(633, 362, 235, 28);
		contentPane.add(lblFormaPagamento);
		
		JLabel lblNivelCargo = new JLabel("edit");
		lblNivelCargo.setHorizontalAlignment(SwingConstants.LEFT);
		lblNivelCargo.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNivelCargo.setBounds(294, 362, 235, 28);
		contentPane.add(lblNivelCargo);
		
		JLabel lblEndereco = new JLabel("Cor: <dynamic>");
		lblEndereco.setHorizontalAlignment(SwingConstants.LEFT);
		lblEndereco.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblEndereco.setBounds(294, 396, 235, 28);
		contentPane.add(lblEndereco);
		
		JLabel lblCidade = new JLabel("Estado: <dynamic>");
		lblCidade.setHorizontalAlignment(SwingConstants.LEFT);
		lblCidade.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblCidade.setBounds(294, 438, 235, 28);
		contentPane.add(lblCidade);
		
		JLabel lblBairro = new JLabel("Estado: <dynamic>");
		lblBairro.setHorizontalAlignment(SwingConstants.LEFT);
		lblBairro.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblBairro.setBounds(294, 472, 235, 28);
		contentPane.add(lblBairro);
		
		try {
			Carro carro = new Carro();
			Funcionario funcionario = new Funcionario();
			Venda venda = new Venda();
			Fornecedor forn = new Fornecedor();
			Endereco end =new Endereco();
			
			venda = vendadao.procuraVendaPorID(vendadao.vendaS);
			carro = carrodao.clicado(venda.getCarro().getIdCarro());
			funcionario = funcdao.clicado(venda.getFunc().getMatricula());
			
			lblModelo.setText("Modelo: "+carro.getModelo());
			lblMarca.setText("Marca: "+carro.getMarca());
			lblAno.setText("Ano: "+String.valueOf(carro.getAno()));
			if(carro.getNovo()) {
				lblNovo.setText("Novo: Sim");
			}else {
				lblNovo.setText("Novo: Não");
			}
			
			lblTipo.setText("Tipo: "+carro.getTipo());
			lblCombustivel.setText("Combutivel: "+carro.getCombustivel());
			lblPotencia.setText("Potencia: "+carro.getPotencia());
			lblCor.setText("Cor: "+carro.getCor());
			if(carro.getAbs()) {
				lblABS.setText("ABS: Sim");
			}else {
				lblABS.setText("ABS: Não");
			}
			
			lblPreco.setText("Preço: "+carro.getPrecoCarro());
			lblQuilometragem.setText("Quilometragem: "+carro.getQuilometragem());
			if(carro.getPromocao()) {
				lblPromocao.setText("Promoção: Sim");
			}else {
				lblPromocao.setText("Promoção: Não");
			}
			forn.setIdFornecedor(carro.getFornecedor().getIdFornecedor());
			forn = forndao.buscaFornecedor(forn);
			lblFornecedor.setText("Fornecedor: "+forn.getNomeFornecedor());
			
			lblNome.setText("Nome: "+funcionario.getNome());
			lblUsuario.setText("Usuario: "+funcionario.getUsuario());
			lbltelefone.setText("Telefone: "+funcionario.getTelefone());
			lblEmail.setText("Email: "+funcionario.getEmail());
			lblNivelCargo.setText("Cargo: "+funcionario.getNivelCargo());
			
			end = enddao.buscaEndereco(funcionario.getEndereco().getIdEndereco());
			
			lblEndereco.setText("Estado: "+end.getEstado());
			lblCidade.setText("Cidade: "+end.getCidade());
			lblBairro.setText("Bairro: "+end.getBairro());
			
			lblNomeCliente.setText("Nome: "+venda.getNomeCliente());
			lblTelCliente.setText("Telefone: "+venda.getTelefoneCliente());
			lblEnderecoCliente.setText(venda.getEnderecoCliente());
			String[] partes = String.valueOf(venda.getDataVenda()).split("-");

			String primeiroParte = partes[0];
			String segundaParte = partes[1];
			String terceiroParte = partes[2];

			String resultado = terceiroParte + "/" + segundaParte + "/" + primeiroParte;
			lblDataVenda.setText("Venda: "+resultado);
			lblFormaPagamento.setText("Pagamento: "+venda.getFormaPagamento());
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
