package rahulsheetyacademy.data;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataReader {
//read json to string
/*public List<HashMap<String,String>> getJsonDataMaP(String filepath) throws IOException {
	String jsonContent =FileUtils.readFileToString(new File(System.getProperty("user.dir")+"\\src\\test\\java\\rahulsheetyacademy\\data\\PurchaseOrder.json"),
			StandardCharsets.UTF_8);
	ObjectMapper mapper=new ObjectMapper();
	List<HashMap<String,String>> data=mapper.readValue(jsonContent,new TypeReference<List<HashMap<String,String>>>(){
		//return data;
	});*/
	}


