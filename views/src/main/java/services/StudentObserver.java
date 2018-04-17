package services;

import java.util.Observable;
import java.util.Observer;

import org.json.JSONException;
import org.json.JSONObject;
import static services.Requester.post;

import tableItems.Student;

public class StudentObserver implements Observer{

	@Override
	public void update(Observable observable, Object update) {
		
		System.out.println("here");
		Student s = (Student)observable;
		try {
			JSONObject jo = new JSONObject()
					.put("address", s.getAddress())
					.put("phoneNumber", s.getPhoneNumber())
					.put("email", s.getEmail());
			
			post("http://localhost:8083/asgn2/teacher/1/updateStudent", jo.toString());
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
	}

}
