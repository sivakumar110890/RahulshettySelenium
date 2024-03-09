package seleniumBasics;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

public class ChromeOptionsExample {
	public static Properties prop;
	public static void main(String[] args) {
		//HashMapExample();
	}
	
	public static Properties PropertyFileLoader() throws IOException {
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"//config.config.properties");
		prop= new Properties();
		prop.load(file);
		return prop;
	}
	
	public static void HashMapExample() {
		HashMap<String, Integer> amap=new HashMap<String, Integer>();
		amap.put("siva", 33);
		amap.put("Daivik", 10);
		amap.put("Balaji", 4);
		
		int balajiAge=amap.get("Balaji");
		int daivikAge=amap.get("Daivik");
		System.out.println("Balaji age is : "+balajiAge);
		System.out.println("Daivik age is : "+daivikAge);
		
	}

}
