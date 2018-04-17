package services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;

import com.fasterxml.jackson.databind.ObjectMapper;

import tableItems.Group;

public class GroupConverter implements Converter<Group>{

	@Override
	public List<Group> convertList(String jsonData) {
		
		List<Group> groups = new ArrayList<Group>(0);

		try {
			JSONArray json = new JSONArray(jsonData);

			for (int i = 0; i < json.length(); i++) {
				String obj = json.getString(i);
				groups.add(new ObjectMapper().readValue(obj, Group.class));
			}

		} catch (JSONException | IOException e1) {
			e1.printStackTrace();
		}
		return groups;
	}

	@Override
	public Group convert(String data) {
		try {
			return new ObjectMapper().readValue(data, Group.class);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	
}
