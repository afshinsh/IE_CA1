package Main.Commands;

import Main.Interfaces.CMD;
import Main.Interfaces.EXC;
import Model.Actor;
import Storage.Storage;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

@CMD(resource = "addActor")
public class AddActor {
    @EXC
    public void addActor(String JsonInput) {

        Object obj= JSONValue.parse(JsonInput);
        JSONObject jsonObject = (JSONObject) obj;

        try{
            Actor actor = new Actor(
                    (int) jsonObject.get("id"),
                    (String) jsonObject.get("name"),
                    (String) jsonObject.get("birthDay"),
                    (String) jsonObject.get("nationality")
            );
            Storage.Database.Actors.add(actor);
        }
        catch (Exception e){
            System.out.println("Bad Input!");
        }


        System.out.println(Storage.Database.Actors.size());

    }

}
