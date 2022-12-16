package br.com.mildevs.carro;

import java.util.List;
import java.util.Scanner;

import br.com.mildevs.carro.dao.CarroDao;
import br.com.mildevs.carro.entity.Carro;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


public class Program {

	public static void main(String[] args) {
		
		//cria tabela com nome carros
		/*
		 * EntityManagerFactory entityManager =
		 * Persistence.createEntityManagerFactory("carros"); entityManager.close();
		 */
		
		
		
		  CarroDao carroDao = new CarroDao(); Scanner teclado = new Scanner(System.in);
		  
		  System.out.println("Digite a placa a ser inserida: "); String placa =
		  teclado.nextLine();
		  
		  Carro carroInserido = new Carro(placa, "PRETO", "VW", "GOL", 160.0);
		  carroDao.insereCarro(carroInserido);
		  
		  List<Carro> carros = carroDao.listaCarros(); for (Carro carro : carros) {
		  System.out.println(carro); }
		  
		  System.out.println(carroDao.consultaCarro("XPTO321"));
		  carroDao.removeCarro("XPTO321");
		  
		  carros = carroDao.listaCarros(); for (Carro carro : carros) {
		  System.out.println(carro); }
		  
		  teclado.close();
		 
		 

	}

}
