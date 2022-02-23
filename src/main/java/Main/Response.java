package Main;

import org.json.simple.JSONValue;

import java.util.HashMap;
import java.util.Map;

public class Response {

    public static void CreateResponse(boolean success, String data){
        Map obj=new HashMap();
        obj.put("success", success);
        obj.put("data", data);
        System.out.println(JSONValue.toJSONString(obj));
    }

}
