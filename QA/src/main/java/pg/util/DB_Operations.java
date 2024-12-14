package pg.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.HashMap;

public class DB_Operations {
	public synchronized HashMap<String, String> getSqlResultInMap(String sql) {  
        HashMap<String, String> data_map = new HashMap<>();

		try{  
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
			Connection con=DriverManager.getConnection(  
					"jdbc:sqlserver://tcp:hydrogen-dev.database.windows.net,1433;Databases=hydrogen-dev.database.windows.net,1433\\qa-db-payment-gateway-service","dev_user","s3gQd36TiyqK4jw@QR3RDAQF!TK!N47J"); 		

			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery(sql);  
            ResultSetMetaData md = rs.getMetaData();

            while (rs.next()) {            
                for (int i = 1; i <= md.getColumnCount(); i++) {
                    data_map.put(md.getColumnName(i), rs.getString(i));
                }
            }
            System.out.println(data_map);
			con.close();  
		}catch(Exception e){ System.out.println(e);}
		return data_map;  
	}  

}
