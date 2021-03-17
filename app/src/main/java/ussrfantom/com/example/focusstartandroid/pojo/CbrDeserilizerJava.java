package ussrfantom.com.example.focusstartandroid.pojo;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CbrDeserilizerJava implements JsonDeserializer<EmployeeResponse> {
    Gson gson = new Gson();

    private List<Valute> parseValuteList(JsonObject json) {
        List<Valute> valuteList = new ArrayList<Valute>();
        for (Map.Entry<String, JsonElement> entry : json.entrySet()) {
            Valute val = gson.fromJson(entry.getValue(), Valute.class);
            valuteList.add(val);
        }
        return valuteList;
    }

    @Override
    public EmployeeResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();

        JsonElement valuteElement = jsonObject.get("Valute");
        List<Valute> valuteList = parseValuteList(valuteElement.getAsJsonObject());
        return new EmployeeResponse(valuteList);
    }
}
