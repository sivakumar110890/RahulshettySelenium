package dateExample;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateExample {

	public static void main(String[] args) {
		printtheDate();

	}

	public static void printtheDate() {
		Date d = new Date();
		System.out.println("IST : "+d.toString());
		System.out.println("GMT : "+d.toGMTString());
		SimpleDateFormat sdf = new SimpleDateFormat("d/M/yyyy hh:mm:ss");
		System.out.println("User defined format : "+sdf.format(d));
	
	}

}
