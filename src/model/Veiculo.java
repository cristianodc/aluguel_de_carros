package model;

import util.Contador;

public class Veiculo {
	public enum Segmento{CARRO,MOTO,CAMINHAO}
	
	private Integer id;
	private String marca;
	private String modelo;
	private String cor;
	private String palca;
	private Segmento segmento;
	
	
	public Veiculo(String marca, String modelo, String cor, String palca, Segmento segmento) {
		this.id = Contador.proximo();
		this.marca = marca;
		this.modelo = modelo;
		this.cor = cor;
		this.palca = palca;
		this.segmento = segmento;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public String getPalca() {
		return palca;
	}
	public void setPalca(String palca) {
		this.palca = palca;
	}
	public Segmento getSegmento() {
		return segmento;
	}
	public void setSegmento(Segmento segmento) {
		this.segmento = segmento;
	}
	
}
