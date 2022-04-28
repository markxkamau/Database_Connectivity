package jdbc_connection;

import java.sql.*;

public class Data_Input {
    
    public Connection connect(){
        Connection conn = null;
        
        try{
            conn= DriverManager.getConnection("jdbc:postgresql://localhost/security", "postgres", "Mclaren001");
            System.out.println("Connetion to server successfull");
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return conn;
    }
    
    public String properCase(String s){
        String result = s;
        try(Connection conn = this.connect(); CallableStatement proper = conn.prepareCall("{call initcap(?)}")){
            proper.registerOutParameter(1, Types.VARCHAR);
            proper.setString(1, "hELlO wORLd");
            proper.execute();
            result = proper.getString(1);
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return result;
    }
//    public String getDetail(String s){
//        String result = s;
//        String SQL = "Call getDetails()";
//        try(Connection conn = this.connect(); CallableStatement cstmt = conn.prepareCall(SQL)){
//            cstmt.registerOutParameter(SQL, Types.JAVA_OBJECT);
//            cstmt.execute();
//            result = cstmt.getString(1);
//        }
//        catch(SQLException e){
//            System.out.println(e.getMessage());
//        }
//        return result;
//    }
    
}
