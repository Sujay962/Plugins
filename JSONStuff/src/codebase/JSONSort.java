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
			/**
			 * Here we checked if the keyelement is present in the data or not.  
			 * If it would not be present it will skip it.
			 * */
			if(job.has(sortOn))
				listJsonObj.put(job.getString(sortOn), job);
	    }
		/**
		 * TreeMap is sorted according to the natural ordering of its keys, 
		 * or by a Comparator provided at map creation time, 
		 * depending on which constructor is used.
		 * Sorting is done here.
		 * 
		 * */
		TreeMap<String, JSONObject> sorted = new TreeMap<>();
		sorted.putAll(listJsonObj);
		
		/**
		 * Repushed the sorted data to the JSONArray
		 * */
		for (Entry<String, JSONObject> entry : sorted.entrySet()) {
			jsonarray.put(entry.getValue());
		}
		return jsonarray;
		
	}
}
