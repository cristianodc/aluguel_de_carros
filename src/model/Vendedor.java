package model;

public class Vendedor extends Pessoa {

	private double salario;
	private double comissao;
	public Vendedor(Integer id, String nome, String cpf, String senha, String endereco,double salario) {
		super(id, nome, cpf, senha, endereco);
		this.salario = salario;
		// TODO Auto-generated constructor stub
	}
	
	
}
