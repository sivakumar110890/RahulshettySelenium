package javaBasics;

import java.util.stream.Stream;

import org.testng.annotations.Test;

public class JavaStreamExample {
	
	public static void main(String[] args) {
		
	}
	
	@Test
	public static void javaStreamTest() {
		Stream.of("Anbu","Pangajam","geethakumari","vinothkumar","sivakumar","balaji","pragathi").filter(s->s.endsWith("i")).
		map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		
	}

}
