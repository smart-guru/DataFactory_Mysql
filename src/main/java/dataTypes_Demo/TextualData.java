package dataTypes_Demo;

import org.fluttercode.datafactory.impl.DataFactory;

public class TextualData {
	public static void main(String[] args) {
    DataFactory df = new DataFactory();
    System.out.println(df.getRandomText(20, 26));
    System.out.println(df.getRandomChars(20));
    System.out.println(df.getRandomWord(4, 10));

}
}