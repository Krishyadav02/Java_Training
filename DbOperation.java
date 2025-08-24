import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class DbOperation {
    private Connection connection;

    public DbOperation(Connection connection) {
        this.connection = connection;
    }

    public void addStudent(StudentDTO request, Connection conn) throws Exception {
        String query = "INSERT INTO user(firstname,lastname,email,password,contact) VALUES(?, ?, ?, ?, ?)";

                PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, request.getFirstName());
            pstmt.setString(2, request.getLastname());
            pstmt.setString(3, request.getEmail());
            pstmt.setString(4, request.getPassword());
            pstmt.setString(5, request.getContact());
            pstmt.executeUpdate();
        }

        public void addStudent(StudentDTO request) throws Exception {
            String query = "INSERT INTO user(firstname, lastname,email,password,contact) VALUES(?, ?, ?, ?, ?)";

            PreparedStatement pstmt = connection.prepareStatement(query);
                pstmt.setString(1, request.getFirstName());
                pstmt.setString(2, request.getLastname());
                pstmt.setString(3, request.getEmail());
                pstmt.setString(4, request.getPassword());
                pstmt.setString(5, request.getContact());
                pstmt.executeUpdate();

        }


    public List<StudentDTO> getUser(Connection conn) throws Exception {
        List<StudentDTO> User = new ArrayList<>();
        String query = "SELECT *  FROM user";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            User.add(new StudentDTO(rs.getString("firstname"), rs.getString("lastname"), rs.getString("email"), rs.getString("password"), rs.getString("contact")));
        }
        return User;
    }
    public List<StudentDTO> getUser() throws Exception {
                List<StudentDTO> User = new ArrayList<>();
                String query = "SELECT *  FROM user";
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()) {
                    User.add(new StudentDTO(rs.getString("firstname"), rs.getString("lastname"), rs.getString("email"), rs.getString("password"), rs.getString("contact")));
                }
                return User;
            }
    public boolean login(StudentDTO request, Connection conn) throws Exception{
        String query = "SELECT email,password FROM User where email = ? AND password = ?";
        try(PreparedStatement pstmt = conn.prepareStatement(query)){
           pstmt.setString(1,request.getEmail());
            pstmt.setString(2,request.getPassword());
            ResultSet rs = pstmt.executeQuery();
            return rs.next();
        }
    }
    public boolean login(String Email,String Password) throws Exception{
        String query = "SELECT email,password FROM User where email = ? AND password = ?";
        try(PreparedStatement pstmt = connection.prepareStatement(query)){
            pstmt.setString(1,Email);
            pstmt.setString(2,Password);
            ResultSet rs = pstmt.executeQuery();
            return rs.next();
        }
    }
    public void update(StudentDTO request,Connection conn) throws Exception{
        String query = "UPDATE user SET firstname = ?, lastname = ?,email = ?";
        PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1,request.getFirstName());
            pstmt.setString(2,request.getLastname());
            pstmt.setString(3,request.getEmail());
            pstmt.executeUpdate();

    }
    public void update(StudentDTO request) throws Exception{
        String query = "UPDATE user SET firstname = ?, lastname = ?,email = ?";
        PreparedStatement pstmt = connection.prepareStatement(query);
        pstmt.setString(1,request.getFirstName());
        pstmt.setString(2,request.getLastname());
        pstmt.setString(3,request.getEmail());
        int row = pstmt.executeUpdate();
        if(row>0){
            System.out.println("Update Successfully");
        }
        else{
            System.out.println("Not Update");
        }
    }

}


