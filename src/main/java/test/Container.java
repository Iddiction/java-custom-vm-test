package test;

import java.util.Random;

public class Container {

	public Container() {
		String[] data = generateRandomWords(10);
		str1 = data[0];
		str2 = data[1];
		str3 = data[2];
		str4 = data[3];
		str5 = data[4];
		str6 = data[5];
		str7 = data[6];
		str8 = data[7];
		str9 = data[8];
		str10 = data[9];
	}

	public String str1;
	public String str2;
	public String str3;
	public String str4;
	public String str5;
	public String str6;
	public String str7;
	public String str8;
	public String str9;
	public String str10;

	public static String[] generateRandomWords(int numberOfWords) {
		String[] randomStrings = new String[numberOfWords];
		Random random = new Random();
		for (int i = 0; i < numberOfWords; i++) {
			char[] word = new char[10]; // words of length 10
			for (int j = 0; j < word.length; j++) {
				word[j] = (char) ('a' + random.nextInt(26));
			}
			randomStrings[i] = new String(word);
		}
		return randomStrings;
	}
}
