package App.Console;

import java.io.IOException;

public class app {

	public static void main(String[] args) throws IOException {
		JSON.Serialization mySerializationClass = new JSON.Serialization();
		mySerializationClass.SerializeMe();
		System.in.read();
	}
}
