package br.com.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {

	public DataSource dataSource;

	public ConnectionFactory() {
		ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
		comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost/aps_interface?useTimezone=true&serverTimezone=UTC");
		comboPooledDataSource.setUser("root");
		comboPooledDataSource.setPassword("20285495");

		this.dataSource = comboPooledDataSource;
	}

	public Connection recuperarConexao(){
		
		try	{	
			return this.dataSource.getConnection();
		} catch (SQLException e){
			throw new RuntimeException(e);
		}
	}
}