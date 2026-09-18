package in.ashokit.bean;

import java.util.Base64;
import java.util.Base64.Encoder;

public class EncoderService {

	public String getEncoder(String text) {
		Encoder encoder = Base64.getEncoder();

		byte[] bytes = text.getBytes();

		return bytes.toString();
	}

}
