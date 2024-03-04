package ATBAutomation.Data;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

//import org.apache.logging.log4j.core.util.FileUtils;
import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataReader {
	
	public List<HashMap<String, String>> getJsonDataToMap() throws IOException
	{
		//read json to string-- no need to download external dependency
		String jsonContent= FileUtils.readFileToString(new File(System.getProperty("user.dir")+"\\ATBAutomation\\src\\test\\java\\ATBAutomation\\Data\\PurchaseOrder.json"));

		// convert String to Hashmap-- downlaod dependency jackson	databind
		ObjectMapper mapper = new ObjectMapper();
		  List<HashMap<String,String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>()
		  {
	      });
		  return data;
		
		//{map, map}			
	
	}
	

}
