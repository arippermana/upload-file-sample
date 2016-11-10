package my.upload.test;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.io.FileInputStream;

import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import junit.framework.TestCase;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import my.upload.system.Application;
import my.upload.system.dto.UploadFileDTO;
import my.upload.system.service.UploadFileService;

/**
*
* @author Arip Permana <rest.arip06022016@gmail.com>
*
*/

@RunWith(SpringJUnit4ClassRunner.class)
@IntegrationTest
@WebAppConfiguration
@SpringApplicationConfiguration(classes = Application.class)
public class UploadFileTest extends TestCase {
	
	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@Autowired
	private UploadFileService uploadFileService;

	@Before
	public void setUp() throws Exception {
		mockMvc = webAppContextSetup(webApplicationContext).build();
	}
	
	//Test upload file
	@Test
	public void testUploadFile() throws Exception{
		FileInputStream inputFile = new FileInputStream( "src/test/resources/Google flight.jpg");  
		MockMultipartFile multipartFile = new MockMultipartFile("file", "testData.jpg", "multipart/form-data", inputFile); 
		//MockMultipartFile multipartFile = new MockMultipartFile("testingOnTheSpot.txt", "test for trusted company".getBytes());
		UploadFileDTO response = uploadFileService.saveFile(multipartFile);
		assertNotNull(response);
	}

}
