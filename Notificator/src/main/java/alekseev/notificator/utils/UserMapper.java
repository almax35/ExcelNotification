package alekseev.notificator.utils;

import alekseev.notificator.dto.UserDto;
import java.lang.reflect.Type;

import alekseev.notificator.entity.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;


public class UserMapper {
    public static ArrayList<UserDto> parseJsonToUserDto(String json){
        Type listType = new TypeToken<ArrayList<UserDto>>() {}.getType();
        Gson gson = new Gson();
        return gson.fromJson(json, listType);
    }
    public static ArrayList<UserDto> parseUserToUserDto(ArrayList<User> users){
        ArrayList<UserDto> usersDto=new ArrayList<>();
        for (User user: users){
            usersDto.add(new UserDto(user.getName(), user.getSurname(),user.getEmail(), user.getType()));
        }
        return usersDto;
    }
}
