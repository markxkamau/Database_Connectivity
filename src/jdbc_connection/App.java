package jdbc_connection;

import java.sql.*;
import java.util.Scanner;

public class App {
    Scanner scan = new Scanner(System.in);
    
    private final String url = "jdbc:postgresql://localhost/security";
    private final String user = "postgres";
    private final String password = "password";
    
    public Connection connect(){
        Connection conn = null;
        
        try{
            conn= DriverManager.getConnection(url,user,password);
            System.out.println("Connected to postgreSQL successfully");
            
            try (Statement stat = conn.createStatement()) {
                System.out.println("Reading Med records...");
//                System.out.println("Name\t"+"age\t"+"condition\t"+"doctor\t"+"day\t"+"IntakeTime\t"+"Drug");
                
                try (ResultSet set = stat.executeQuery("select person_name,\n" +
"	age,condition_name,\n" +
"	doctor_name,\n" +
"	drug_name\n" +
"from (((Person inner join \"condition\"\n" +
"	 on person.condition_id = \"condition\".condition_id)inner join drugs\n" +
"	 on person.drug_id = drugs.drug_id) inner join doctor\n" +
"	 on person.doctor_id = doctor.doctor_id)")) {
                    while(set.next()){
                        System.out.print(set.getString("person_name")+"\t"+set.getInt("age")+"\t"+set.getString("condition_name")+"\t");
                        System.out.print(set.getString("doctor_name")+"\t");
                        System.out.println(set.getString("drug_name"));
                    }
                }  
                ResultSet s = stat.executeQuery("Select * from Person");
                
                while(s.next()){
                    System.out.println(s.getInt("person_id")+"\t"+s.getString("person_name"));
                
            }
            }
            conn.close();
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return conn;
    }
    
}
