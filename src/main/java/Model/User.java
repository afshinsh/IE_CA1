package Model;

import java.util.Date;

public class User {
    public User(String email, String password, String nickName, String name, String birthDate){
        Email = email;
        Password = password;
        NickName = nickName;
        Name = name;
        BirthDate = birthDate;
    }
    public int Id;
    public String Email;
    public String Password;
    public String NickName;
    public String Name;
    public String BirthDate;
}
