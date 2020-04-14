package com.ats.webapi.util;

import java.io.IOException;
import java.text.SimpleDateFormat;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ats.webapi.model.User;
import com.fasterxml.jackson.databind.SerializationFeature;

public class JsonUtil {

	public static String javaToJson(Object obj) {
		String jsonStr = "{}";
		ObjectMapper mapper = new ObjectMapper();
		mapper.setDateFormat(new SimpleDateFormat("dd-MM-yyyy"));
		//mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
		try {
			jsonStr = mapper.writeValueAsString(obj);
		}

		catch (IOException e) {
			e.printStackTrace();
		}

		return jsonStr;
	}

}
