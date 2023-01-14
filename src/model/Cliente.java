package model;

import java.util.List;

public class Cliente extends Pessoa {
 
public enum TipoPessoa{PJ , PF}
 private TipoPessoa tipo;
 private List<Veiculo> veiculosAlugados;
 
 public Cliente(Integer id, String nome, String cpf, String senha, String endereco,TipoPessoa tipo) {
		super(id, nome, cpf, senha, endereco);
		this.tipo = tipo;
		// TODO Auto-generated constructor stub
	}
public TipoPessoa getTipo() {
	return tipo;
}
public void setTipo(TipoPessoa tipo) {
	this.tipo = tipo;
}
public List<Veiculo> getVeiculosAlugados() {
	return veiculosAlugados;
}
public void setVeiculosAlugados(List<Veiculo> veiculosAlugados) {
	this.veiculosAlugados = veiculosAlugados;
}
 
 
}
