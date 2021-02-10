package Testes;

import br.com.UsuarioController.UsuarioController;


public class TesteSalvar {
		
		public static void main(String[] args) {
			
//			ConnectionFactory connectionFactory = new ConnectionFactory();
//			Connection connection = connectionFactory.recuperarConexao();
			
//			Usuarios wagner = new Usuarios("otario", "1234");
//				
//			UsuarioDAO teste = new UsuarioDAO(connection);
			UsuarioController teste2 = new UsuarioController();
			
//			teste.salvar("otario", "1235");
			teste2.Salvar("Teste2", "1235");
		}

}
