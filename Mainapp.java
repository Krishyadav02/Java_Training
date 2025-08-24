import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class Mainapp {
    public static void main(String args[]) {
        try {
            StudentDTO obj = new StudentDTO( "Krish", "Yadav","krish@gmail.com","123456","7909790370");
            Userservice service = new Userservice();
            service.signUp(obj);
            StudentDTO updateUER = new StudentDTO( "KrishNEW", "Yadav","krish123@gmail.com");
            service.update(updateUER);
            service.getUser();
            boolean islogin = service.login("krish@gmail.com","12345");
            if (islogin){
                System.out.println("Login Successful");
            } else {
                System.out.println("Invlid email or password.");
            }
            }
         catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

