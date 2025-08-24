import java.sql.SQLException;
import java.util.List;

//import java.util.List;
public class Userservice {
    DbOperation db = null;
    public Userservice() throws SQLException {
        db = new DbOperation(DBConnection.getConnection());
    }

    public void getUser() throws Exception{
        List<StudentDTO> userList = db.getUser();
        for (StudentDTO obj : userList ){
            System.out.println(obj.getFirstName());
            System.out.println("_______");
        }
    }

    public void signUp(StudentDTO studentDTO) throws Exception {
         db.addStudent(studentDTO);
    }
public boolean login(String Email,String Password) throws Exception{
        return db.login(Email,Password);
}
public void update(StudentDTO studentDTO) throws Exception{
     db.update(studentDTO);
}
}