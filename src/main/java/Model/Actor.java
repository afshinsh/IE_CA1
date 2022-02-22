package Model;

import Storage.Storage;

import java.util.Date;

public class Actor {
    public Actor(int id, String name, String birthday, String nationality){
        Id = id;
        Name = name;
        BirthDate = birthday;
        Nationality = nationality;
    }
    public int Id;
    public String Name;
    public String BirthDate;
    public String Nationality;
}
