package com.ats.webapi.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ats.webapi.model.Info;

import javassist.bytecode.stackmap.BasicBlock.Catch;


@RestController
public class ImageUploadController {

	/*private static String SUGGESTION_URL = "/opt/apache-tomcat-8.5.37/webapps/uploadspune/SUGGESTION/";
	private static String COMPLAINT_URL = "/opt/apache-tomcat-8.5.37/webapps/uploadspune/COMPLAINT/";
	private static String NOTIFICATION_URL = "/opt/apache-tomcat-8.5.37/webapps/uploadspune/NOTIFICATION/";
	private static String FEEDBACK_URL = "/opt/apache-tomcat-8.5.37/webapps/uploadspune/FEEDBACK/";
	
	public static final String M_SP_CAKE_FOLDER = "/opt/apache-tomcat-8.5.37/webapps/uploadspune/MSPCAKE/";
	public static final String MSG_FOLDER = "/opt/apache-tomcat-8.5.37/webapps/uploadspune/MSG/";
	public static final String FR_FOLDER = "/opt/apache-tomcat-8.5.37/webapps/uploadspune/FR/";
	public static final String ITEM_FOLDER = "/opt/apache-tomcat-8.5.37/webapps/uploadspune/ITEM/";
	public static final String RAW_MAT_IMAGE_FOLDER = "/opt/apache-tomcat-8.5.37/webapps/uploadspune/RAWMAT/";
	public static final String GATE_ENTRY_IMAGE_FOLDER = "/opt/apache-tomcat-8.5.37/webapps/uploadspune/GATEENTRY/";
	private static final String SP_CAKE_FOLDER = "/opt/apache-tomcat-8.5.37/webapps/uploadspune/SPCAKE/";
	private static final String CUST_CHOICE_PHOTO_CAKE_FOLDER = "/opt/apache-tomcat-8.5.37/webapps/uploadspune/CUSTCHOICEPHOTOCAKE/";
*/
  private static String SUGGESTION_URL = "/opt/apache-tomcat-8.5.37/webapps/uploads/SUGGESTION/";
	private static String COMPLAINT_URL = "/opt/apache-tomcat-8.5.37/webapps/uploads/COMPLAINT/";
	private static String NOTIFICATION_URL = "/opt/apache-tomcat-8.5.37/webapps/uploads/NOTIFICATION/";
	private static String FEEDBACK_URL = "/opt/apache-tomcat-8.5.37/webapps/uploads/FEEDBACK/";
	
	public static final String M_SP_CAKE_FOLDER = "/opt/apache-tomcat-8.5.37/webapps/uploads/MSPCAKE/";
	public static final String MSG_FOLDER = "/opt/apache-tomcat-8.5.37/webapps/uploads/MSG/";
	public static final String FR_FOLDER = "/opt/apache-tomcat-8.5.37/webapps/uploads/FR/";
	public static final String ITEM_FOLDER = "/opt/apache-tomcat-8.5.37/webapps/uploads/ITEM/";
	public static final String RAW_MAT_IMAGE_FOLDER = "/opt/apache-tomcat-8.5.37/webapps/uploads/RAWMAT/";
	public static final String GATE_ENTRY_IMAGE_FOLDER = "/opt/apache-tomcat-8.5.37/webapps/uploads/GATEENTRY/";
	private static final String SP_CAKE_FOLDER = "/opt/apache-tomcat-8.5.37/webapps/uploads/SPCAKE/";
	private static final String CUST_CHOICE_PHOTO_CAKE_FOLDER = "/opt/apache-tomcat-8.5.37/webapps/uploads/CUSTCHOICEPHOTOCAKE/";

	//private static String BILL_FOLDER ="/home/maxadmin/Desktop/photos/";
	
	

	@RequestMapping(value = { "/photoUpload" }, method = RequestMethod.POST)
	public @ResponseBody Info getFarmerContract(@RequestParam("file") MultipartFile uploadfile , @RequestParam("imageName") String imageName,@RequestParam("type") String type) {

		Info info = new Info();

		System.out.println("File Name " + uploadfile.getOriginalFilename());

		try {

			saveUploadedFiles(Arrays.asList(uploadfile) ,  imageName,type);

			info.setError(false);
			info.setMessage("File uploaded successfully");

		} catch (IOException e) {

			e.printStackTrace();
			info.setError(true);
			info.setMessage("File upload failed");
		}

		return info;
	}

	// save file
	private void saveUploadedFiles(List<MultipartFile> files,  String imageName,String type) throws IOException {

		try {
		for (MultipartFile file : files) {
			Path path=null;
			if (file.isEmpty()) {
				continue; 
			}
            if(type.equalsIgnoreCase("s"))
            {
			 path =Paths.get(SUGGESTION_URL + imageName);
            }
            else if(type.equalsIgnoreCase("c"))
            {
   			 path =Paths.get(COMPLAINT_URL + imageName);

            }
            else if(type.equalsIgnoreCase("nf"))	
            {
   			 path =Paths.get(NOTIFICATION_URL + imageName);

            }
            else if(type.equalsIgnoreCase("f"))
            {
   			 path =Paths.get(FEEDBACK_URL + imageName);

            }
            else if(type.equalsIgnoreCase("sp"))
            {
   			 path =Paths.get(M_SP_CAKE_FOLDER + imageName);

            }
            else if(type.equalsIgnoreCase("fr"))
            {
   			 path =Paths.get(FR_FOLDER + imageName);

            }
            else if(type.equalsIgnoreCase("item"))
            {
   			 path =Paths.get(ITEM_FOLDER + imageName);

            }
          else if(type.equalsIgnoreCase("ph1"))
            {
   			 path =Paths.get(SP_CAKE_FOLDER + imageName);

            }
            else if(type.equalsIgnoreCase("ph2"))
            {
   			 path =Paths.get(CUST_CHOICE_PHOTO_CAKE_FOLDER + imageName);

            }
            else if(type.equalsIgnoreCase("msg"))
            {
   			 path =Paths.get(MSG_FOLDER + imageName);

            }
			byte[] bytes = file.getBytes();
			
			Files.write(path, bytes);

		}

	
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}

}
}
