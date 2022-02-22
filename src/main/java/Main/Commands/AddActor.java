package Main.Commands;

import Main.Interfaces.CMD;
import Main.Interfaces.EXC;
import Model.Actor;
import Storage.Storage;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

@CMD(resource = "addActor")
public class AddActor {
    @EXC
    public void addActor(String JsonInput) {
        ObjectMapper objectMapper = new ObjectMapper();
        Object obj= JSONValue.parse(JsonInput);
        JSONObject jsonObject = (JSONObject) obj;
        try{
            Actor actor = new Actor(
                    Integer.valueOf(jsonObject.get("id").toString()),
                    (String) jsonObject.get("name"),
                    (String) jsonObject.get("birthDate"),
                    (String) jsonObject.get("nationality")
            );
            int index = Storage.Database.Actors.indexOf(actor);
            if(index > 0)
                Storage.Database.Actors.set(index, actor);
            else
                Storage.Database.Actors.add(actor);

        }
        catch (Exception e){
            System.out.println("Bad Input!");
        }


        System.out.println(Storage.Database.Actors.size());

    }

}
