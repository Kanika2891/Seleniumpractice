package pg.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Sql_query {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		String UserName="dev_user";
		String Password="s3gQd36TiyqK4jw@QR3RDAQF!TK!N47J";
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String DB_URL ="jdbc:sqlserver://tcp:hydrogen-dev.database.windows.net,1433;databaseName=qa-db-payment-gateway-service";
		//OR by using ip
	//	DB_URL ="jdbc:sqlserver://192.168.0.10:3324\\<instance_name>;databaseName=sample";
		Connection con = DriverManager.getConnection(DB_URL, UserName, Password);
			
		String selectQuery = "select * from [dbo].[Transactions] where Id='d91e0000-12dc-e6ea-87dc-08dc5302664b'";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(selectQuery);
		while (rs.next()) {
		        System.out.println("transref"+rs.getInt("ClnxTransactionRef"));
			System.out.println("Age: "+rs.getInt("EmpAge"));
			System.out.println("Sal: "+rs.getInt("EmpSal"));
		}
		stmt.close();
		con.close();
		
		
	}

}
