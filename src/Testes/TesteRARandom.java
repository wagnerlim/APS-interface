package Testes;
import java.util.Random;

public class TesteRARandom {
	public static void main(String[] args) {
		
		Random gerador = new Random();
		
		int ra = 123456;
		
		System.out.println(ra);
		
		if(ra == 123456) {
			ra = gerador.nextInt(999999);
			
		}
		String raString = "" +ra;
		
		
		System.out.println(raString);
		String datanascimento = "09/10/1997" ;
		
		System.out.println(datanascimento.length());
		
	}
}
