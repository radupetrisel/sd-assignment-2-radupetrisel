package bll;

import java.io.IOException;
import java.time.LocalDateTime;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.node.IntNode;

public class DateTimeDeserializer extends StdDeserializer<LocalDateTime> {
	
	private LocalDateTime date;
	
	public DateTimeDeserializer() {
		this(null);
		date = LocalDateTime.now();
	}
	public DateTimeDeserializer(Class<?> vc) {
		super(vc);
	}


	@Override
	public LocalDateTime deserialize(JsonParser jp, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		
		JsonNode node = jp.getCodec().readTree(jp);
		date.withDayOfMonth((int)((IntNode)node.get("dayOfMonth")).asInt())
		.withDayOfYear((int)((IntNode)node.get("dayOfYear")).asInt())
		.withHour((int)((IntNode)node.get("hour")).asInt())
		.withMinute((int)((IntNode)node.get("minute")).asInt())
		.withMonth((int)((IntNode)node.get("monthValue")).asInt())
		.withNano((int)((IntNode)node.get("nano")).asInt())
		.withSecond((int)((IntNode)node.get("second")).asInt())
		.withYear((int)((IntNode)node.get("year")).asInt());
		
		return date;
	}
	


}
