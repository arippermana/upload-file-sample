package my.upload.system.shared;

/**
*
* @author Arip Permana <rest.arip06022016@gmail.com>
*
*/
public class UploadFileException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public UploadFileException(String message){
		super(message);
	}
	
	public UploadFileException(String message, Throwable cause){
		super(message, cause);
	}

}
