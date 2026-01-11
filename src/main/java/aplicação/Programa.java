package aplicação;

import java.util.Locale;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;


public class Programa {
	public static void main (String [] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner (System.in);
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		
		System.out.println("Quantas pessoas serão adicionadas no banco de dados?");
		int n = sc.nextInt();
		
		for(int i = 0; i<n;i++) {
			System.out.println("Nome: ");
			sc.nextLine();
			String nome = sc.nextLine();
			System.out.println("Email: ");
			sc.nextLine();
			String email= sc.nextLine();
			Pessoa p1 = new Pessoa (null, nome, email);
			em.persist(p1);
			}
			Pessoa p = em.find(Pessoa.class, 10);
			System.out.println(p);
		
		em.getTransaction().commit();
		
		System.out.println("FEITO!");
		em.close();
		emf.close();
		sc.close();
	}
}
