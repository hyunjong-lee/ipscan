package util;

public class StringUtil
{
	public static String convertForMySQL(String str)
	{
		str = str.replaceAll("\'", "\\'\\'");
		str = str.replaceAll("\"", "\\\"");
		str = str.replaceAll(",", "\\,");
		str = str.replaceAll("`", "\\`");
		
		return str;
	}
}
