package Main;

import org.json.simple.JSONValue;

import java.util.HashMap;
import java.util.Map;

public class Response {

    public static void CreateMessageResponse(boolean success, String message){
        Map obj=new HashMap();
        obj.put("success", new Boolean(success));
        obj.put("message", message);
        System.out.println(JSONValue.toJSONString(obj));
    }

    public static void CreateDataResponse(boolean success, String jsonData){
        Map obj=new HashMap();
        obj.put("success", new Boolean(success));
        obj.put("message", jsonData);
        System.out.println(JSONValue.toJSONString(obj));
    }
}
