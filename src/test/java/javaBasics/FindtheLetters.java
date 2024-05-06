package javaBasics;

import java.util.ArrayList;
import java.util.stream.Stream;

public class FindtheLetters {
	public static void main(String[] args) {
		JavaStreamExample();
		StreamExample();
	}

	public static void ArrayListExample() {
		ArrayList<String> arrList = new ArrayList<String>();
		arrList.add("Sivakumar");
		arrList.add("Anbu");
		arrList.add("Vinothkumar");
		arrList.add("Selvam");
		arrList.add("Shilpa");
		arrList.add("Shaily");
		arrList.add("Shibshankar");
		arrList.add("Kavita");
		int count = 0;

		for (int i = 0; i < arrList.size(); i++) {

			String name = arrList.get(i);
			if (name.startsWith("S")) {
				count++;
			}

		}
		System.out.println("Total Names containing \"S\" as a First letter is : " + count);
	}

	public static void JavaStreamExample() {

		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList.add("Vikrant");
		arrayList.add("Sivakumar");
		arrayList.add("Shrusti");
		arrayList.add("Ankush");
		arrayList.add("Kavita");
		arrayList.add("Shaju");
		arrayList.add("Sowjanya");
		arrayList.add("Bhagya");
		arrayList.add("Khajal");
		arrayList.add("Hritvik");
		arrayList.add("Ajay");

		long count = arrayList.stream().filter(s -> s.startsWith("S")).count();
		System.out.println("Total Names containing \"S\" as a First letter is : " + count);
	}

	public static void StreamExample() {
		Stream<String> count = Stream.of("Abc", "Acc", "Add", "Aef", "Agh", "Bcc", "Ccc", "Bdv").filter(f->
		{
			f.startsWith("A");
			return true;
		}}
}
