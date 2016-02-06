package App.Console;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;

import com.cedarsoftware.util.io.*;

public class json {
	public static void main(String[] args) 
	throws IOException
	{
		String resumeJson = getJson(args[0]);
		String resumeDescription = getResumeDescription(resumeJson);
		System.out.println(resumeDescription);
	}
	
	static String getJson(String path)
	{
		try
		{
			byte[] resumeBytes = Files.readAllBytes(Paths.get(path));
			return new String(resumeBytes, "UTF-8");
		}
		catch (Exception ex)
		{
			return null;
		}
	}
	
	static String getResumeDescription(String resumeJson)
	{
		Map jsonArgs = new HashMap();
		jsonArgs.put(JsonReader.USE_MAPS, true);
		Map obj = (Map)JsonReader.jsonToJava(resumeJson, jsonArgs);
		Map profile = (Map) obj.get("profile");
		String name = profile.get("name").toString();
        Object[] educations = (Object[]) obj.get("education");
        Map education = (Map) educations[0];
        String major = education.get("major").toString();
        String institution = education.get("institution").toString();
		return (name.toString() + " studied " + major.toString() + " at " + institution.toString() + ".");
	}
}
