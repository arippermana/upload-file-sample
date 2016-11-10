package my.upload.system.dto;

import java.io.Serializable;

/**
*
* @author Arip Permana <rest.arip06022016@gmail.com>
*
*/
public class UploadFileDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String filename; 
	
	private String message;
	
	public UploadFileDTO (String filename, String message){
		this.filename = filename;
		this.message = message;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
