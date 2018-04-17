package services;

import java.util.List;

public interface Converter<T> {
	
	public List<T> convertList(String data);
	
	public T convert(String data);
}
