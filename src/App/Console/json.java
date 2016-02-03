package App.Console;

import java.io.IOException;

import com.google.gson.JsonParser;
import com.google.gson.JsonObject;

public class json {
	public static void main(String[] args) throws IOException {
		JsonParser parser = new JsonParser();
		JsonObject person = parser.parse("{\"name\": \"catherine\"}").getAsJsonObject();
		System.out.println(person.get("name"));
	}
}
