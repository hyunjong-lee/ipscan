package util;
import java.io.File;
import java.util.Vector;

public class FileUtility
{
	public static Vector<String> GetAllFileList(String filePath, String filter)
	{
		Vector<String> fileList = new Vector<String>();

		// Find All files
		File DirEntryPoint = new File(filePath);
		File[] EntryFileList = DirEntryPoint.listFiles();
		
		for(int i = 0; i < EntryFileList.length; i++)
		{
			if(EntryFileList[i].isDirectory())
			{
				fileList.addAll(GetAllFileList(EntryFileList[i].getAbsolutePath(), filter));
			}
			else if(EntryFileList[i].isFile())
			{
				String fileName = EntryFileList[i].getAbsolutePath();
				if(filter.equals("") || fileName.contains(filter))
					fileList.add(fileName);
			}
		}
		return fileList;
	}
}
