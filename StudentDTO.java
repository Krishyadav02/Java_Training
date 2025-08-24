public class StudentDTO {
    private String Firstname;
    private String Lastname;
    private String Email;
    private String Password;
    private String Contact;
    public StudentDTO(String Firstname, String Lastname, String Email, String Password, String Contact){
        this.Firstname = Firstname;
        this.Lastname = Lastname;
        this.Email = Email;
        this.Password = Password;
        this.Contact = Contact;
    }

    public StudentDTO(String Firstname, String Lastname, String Email){
        this.Firstname = Firstname;
        this.Lastname = Lastname;
        this.Email = Email;
    }

    public void setfirstName(String Firstname){
        this.Firstname= Firstname;
    }
    public void setlastName(String Lastname){
        this.Lastname = Lastname;
}
public void setEmail(String Email){
    this.Email = Email;
}
public void setPassword(String Password) {
        this.Password = Password;
}
public void setContact(String Contact){
        this.Contact = Contact;
}
 public String getFirstName(){
        return Firstname;
 }
    public String getLastname(){
        return Lastname;
    }
    public String getEmail(){
        return Email;
    }
    public String getPassword(){
        return Password;
    }
    public String getContact(){
        return Contact;
    }

}
