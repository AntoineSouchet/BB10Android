package fr.bb.android.util;

public class StringCorrection {
	
	
	public String Majuscule(String string)
	{
		StringBuilder result = new StringBuilder(string);
		result.replace(0, 1, result.substring(0, 1).toUpperCase());
		return result.toString();
	}

}
