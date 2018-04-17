package services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;

import com.fasterxml.jackson.databind.ObjectMapper;

import tableItems.Student;

public class StudentConverter implements Converter{
	
	public List<Student> convert(String jsonData) {
		
		List<Student> students = new ArrayList<Student>(0);

		try {
			JSONArray json = new JSONArray(jsonData);

			for (int i = 0; i < json.length(); i++) {
				String obj = json.getString(i);
				students.add(new ObjectMapper().readValue(obj, Student.class));
			}

		} catch (JSONException | IOException e1) {
			e1.printStackTrace();
		}
		return students;
	}
}
