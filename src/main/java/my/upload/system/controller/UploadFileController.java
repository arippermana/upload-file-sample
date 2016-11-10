package my.upload.system.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import my.upload.system.dto.UploadFileDTO;
import my.upload.system.service.UploadFileService;

/**
*
* @author Arip Permana <rest.arip06022016@gmail.com>
*
*/

@RestController
@RequestMapping(value="/uploadFile")
public class UploadFileController {
	
	@Autowired
	private UploadFileService uploadFileService;
	
	private static final Logger LOG = LoggerFactory.getLogger(UploadFileController.class);
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public UploadFileDTO saveFileToSystem(@RequestParam("file") MultipartFile file){
		LOG.info("start to upload the file");
		return uploadFileService.saveFile(file);
	}

}
