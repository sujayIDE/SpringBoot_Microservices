package in.ashokit.bean;

public class UserService {
	private EncoderService encoderService;

	public UserService(EncoderService encoderService) {
		this.encoderService = encoderService;
	}

	public void print(String text) {
		String codedText = encoderService.getEncoder(text);
		
		System.out.println("Encoded text : "+codedText);
	}
}
