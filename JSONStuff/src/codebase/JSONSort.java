package codebase;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.json.JSONArray;
import org.json.JSONObject;

public class JSONSort {
	
	public static void main(String cp[]) {
	JSONArray jsonarr = new JSONArray("[\r\n" + 
			"  {\r\n" + 
			"    \"id\": 1,\r\n" + 
			"    \"name\": \"James Bond\",\r\n" + 
			"    \"email\": \"..@gmail.com\",\r\n" + 
			"    \"city\": \"London\"\r\n" + 
			"  },\r\n" + 
			"  {\r\n" + 
			"    \"id\": 2,\r\n" + 
			"    \"name\": \" Natalya Simonova\",\r\n" + 
			"    \"email\": \"natalyasimonova@gmail.com\",\r\n" + 
			"    \"city\": \"Moscow\"\r\n" + 
			"  },\r\n" + 
			"  {\r\n" + 
			"    \"id\": 3,\r\n" + 
			"    \"name\": \"Xenia Onatopp\",\r\n" + 
			"    \"email\": \"Xenia@gmail.com\",\r\n" + 
			"    \"city\": \"Las Vegas\"\r\n" + 
			"  },\r\n" + 
			"]");
	
		    System.out.println(JSONSort.sortMyJSONOnject(jsonarr, "city").toString());
	}
	
	public static JSONArray sortMyJSONOnject(JSONArray jsonarr, String sortOn)	{
		JSONArray jsonarray = new JSONArray();
		
		Map<String, JSONObject> listJsonObj = new HashMap<String, JSONObject>();
		
		for (int i = 0; i < jsonarr.length(); i++) {
			
			JSONObject job = (JSONObject) jsonarr.get(i);
			if(i==52)	{
				System.out.println(job.has(sortOn));
			}
			if(job.has(sortOn))
				listJsonObj.put(job.getString(sortOn), job);
	    }
		TreeMap<String, JSONObject> sorted = new TreeMap<>();
		sorted.putAll(listJsonObj);
		for (Entry<String, JSONObject> entry : sorted.entrySet()) {
			jsonarray.put(entry.getValue());
		}
		return jsonarray;
		
	}
}
