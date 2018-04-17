package services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;

import com.fasterxml.jackson.databind.ObjectMapper;

import tableItems.Grade;

public class GradeConverter implements Converter<Grade>{

	public List<Grade> convertList(String jsonData) {

		List<Grade> grades = new ArrayList<Grade>(0);

		try {
			JSONArray json = new JSONArray(jsonData);

			for (int i = 0; i < json.length(); i++) {
				String obj = json.getString(i);
				grades.add(new ObjectMapper().readValue(obj, Grade.class));
			}

		} catch (JSONException | IOException e1) {
			e1.printStackTrace();
		}
		return grades;
	}

	@Override
	public Grade convert(String data) {
		
		try {
			return new ObjectMapper().readValue(data, Grade.class);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		
	}
}
