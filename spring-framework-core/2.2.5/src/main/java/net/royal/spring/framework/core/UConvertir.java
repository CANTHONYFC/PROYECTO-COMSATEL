package net.royal.spring.framework.core;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UConvertir {
	public static byte[] objectToByteArray(Object obj) {
		try {
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
			objectOutputStream.writeObject(obj);
			return byteArrayOutputStream.toByteArray();
		} catch (Exception e) {

			e.printStackTrace();
		}
		return null;
	}

	public static Object byteArrayToObject(byte[] data) {
		try {
			ByteArrayInputStream in = new ByteArrayInputStream(data);
			ObjectInputStream is = new ObjectInputStream(in);
			return is.readObject();
		} catch (Exception e) {
			return null;
		}
	}

	public static <T> T toClass(String body, Class<T> valueType) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.readValue(body, valueType);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
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
