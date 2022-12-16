package br.com.mildevs.carro.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Carro {
	// Vlad Mihalcea
	// https://vladmihalcea.com/
	
	@Id
	private String placa;
	
	//Não pode ser nulo nullable = false
	@Column(nullable = false)
	private String cor;
	
	@Column(nullable = false)
	private String marca;
	
	@Column(nullable = false)
	private String modelo;
	
	@Column(name = "vel_max")
	private double velMax;
	
	
	public Carro(String placa, String cor, String marca, String modelo, double velMax) {
		this.placa = placa;
		this.cor = cor;
		this.marca = marca;
		this.modelo = modelo;
		this.velMax = velMax;
	}
	
	public Carro() {
	}

	public String getPlaca() {
		return placa;
	}
	public String getCor() {
		return cor;
	}
	
	public String getMarca() {
		return marca;
	}
	
	public String getModelo() {
		return modelo;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public double getVelMax() {
		return velMax;
	}

	public void setVelMax(double velMax) {
		this.velMax = velMax;
	}

	@Override
	public String toString() {
		return "Carro [placa=" + placa + ", cor=" + cor + ", marca=" + marca + ", modelo=" + modelo + ", velMax="
				+ velMax + "]";
	}

}
