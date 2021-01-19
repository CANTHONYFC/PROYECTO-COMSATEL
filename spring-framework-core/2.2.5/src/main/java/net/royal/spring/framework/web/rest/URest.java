package net.royal.spring.framework.web.rest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class URest {
	public static <T> T toClass(String body, Class<T> valueType)
			throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(body, valueType);
	}

	public static <H> List<H> toList(String body, Class<H> valueType)
			throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(body, new TypeReference<List<H>>() {
		});
	}

	public static <T> List<T> jsonToObjectList(String json, Class<T> valueType) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		List<T> ts = mapper.readValue(json,
				mapper.getTypeFactory().constructCollectionType(ArrayList.class, valueType));
		return ts;
	}
}
