package alekseev.notificator.utils;

import alekseev.notificator.dto.UserDto;
import java.lang.reflect.Type;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;


public class UserMapper {
    public static ArrayList<UserDto> parseToUserDto(String json){
        Type listType = new TypeToken<ArrayList<UserDto>>() {}.getType();
        Gson gson = new Gson();
        return gson.fromJson(json, listType);
    }
}
