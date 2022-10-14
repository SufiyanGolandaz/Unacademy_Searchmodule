package utlities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadPropFile {
	Properties prop=new Properties();
	
	public void readfile() throws IOException {
		FileInputStream fis=new FileInputStream("C:\\Users\\safzalgo\\eclipse-workspace\\Unacademy_SearchModule\\src\\test\\resources\\dataSource\\config.properties");
		prop.load(fis);
	}
	
	public String getquery() {
		return prop.getProperty("query");
	}
	
}
