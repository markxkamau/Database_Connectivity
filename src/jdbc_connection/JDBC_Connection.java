package jdbc_connection;

public class JDBC_Connection {
    public static void main(String[] args) {
        App app = new App();
        app.connect();
        
        Data_Input data = new Data_Input();
//        data.connect();
        System.out.println(data.properCase("tHIS iS tHE acTOR lISt"));
//        System.out.println(data.getDetail("Hello World"));
    }
    
}
