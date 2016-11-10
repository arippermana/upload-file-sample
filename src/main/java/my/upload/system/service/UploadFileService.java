package my.upload.system.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import my.upload.system.dto.UploadFileDTO;
import my.upload.system.shared.Constant;
import my.upload.system.shared.UploadFileException;

/**
*
* @author Arip Permana <rest.arip06022016@gmail.com>
*
*/

@Service
public class UploadFileService {
	
	@Value("${uploadFileDirectory}")
	private String uploadFileDirectory;
	
	public UploadFileDTO saveFile(MultipartFile file){
		File fileLocation = new File(uploadFileDirectory);
		
		if (!fileLocation.exists()){
			fileLocation.mkdirs();
		}
		
		try{
			
			if (file.isEmpty()){
				throw new UploadFileException(Constant.FILE_NOT_FOUND);
			}
			
			File convertedFile = 
					File.createTempFile(FilenameUtils.removeExtension(file.getOriginalFilename()), 
										'.' + FilenameUtils.getExtension(file.getOriginalFilename()), fileLocation);
			
			FileOutputStream fos = new FileOutputStream(convertedFile);
			fos.write(file.getBytes());
			fos.close();
		} catch (IOException e){
			throw new UploadFileException(Constant.ERROR, e);
		}
		
			
		return new UploadFileDTO(file.getOriginalFilename(), Constant.SUCCESS);
	}
}