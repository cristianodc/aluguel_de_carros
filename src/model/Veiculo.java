package model;

import java.time.LocalDate;

import model.Veiculo.Segmento;
import model.Veiculo.Status;
import util.Contador;

public class Veiculo {
	public enum Segmento{CARRO,MOTO,CAMINHAO}
	public enum Status {LIVRE, ALUGADO}
	private Integer id;
	private String marca;
	private String modelo;
	private String cor;
	private String ano;
	private String placa;
	double valor;
	private Segmento segmento;
	private Status status;
	private LocalDate dataEntrega;
	
	
	public Veiculo( String marca, String modelo, String placa, String cor, 
			String ano, Segmento segmento, double valor) {
					
					this.id = Contador.proximo();
					
					this.marca = marca;
					this.modelo = modelo;
					this.placa = placa;
					this.cor = cor;
					this.ano = ano;
					this.segmento = segmento;
					this.valor = valor;
					this.status = Status.LIVRE;
					
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
		return placa;
	}
	public void setPalca(String palca) {
		this.placa = palca;
	}
	public Segmento getSegmento() {
		return segmento;
	}
	public void setSegmento(Segmento segmento) {
		this.segmento = segmento;
	}
	
	
	public String getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public LocalDate getDataEntrega() {
		return dataEntrega;
	}
	public void setDataEntrega(LocalDate dataEntrega) {
		this.dataEntrega = dataEntrega;
	}
	public String toString() {
		return this.id + " - " + this.marca + " - " + this.modelo + " - " + this.ano + " - " + this.cor + " - " +  this.valor +" - "; 
	}
	
	
}
