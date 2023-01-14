package model;

public class Vendedor extends Pessoa {

	private double salario;
	private double comissao;
	public Vendedor( String nome, String cpf, String senha, String endereco,double salario) {
		super(nome, cpf, senha, endereco);
		this.salario = salario;
		// TODO Auto-generated constructor stub
	}
	
	
}
