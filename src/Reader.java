import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Reader 
{
	ArrayList<String> inputStringsMerger;  //merger StringList
	File targetDirectory;
	File[] listOfInputFiles;
	
	Reader(File Directory)
	{
		inputStringsMerger = new ArrayList<String>();
		targetDirectory=Directory;
		listOfInputFiles = sortFilesInDirectory(targetDirectory.listFiles()); 
	}
	
	File[] sortFilesInDirectory(File[] files)
	{
		Arrays.sort(files, new Comparator<File>()
		{
			public int compare(File file1, File file2) {
                int n1 = extractNumber(file1.getName());
                int n2 = extractNumber(file2.getName());
                return n1 - n2;
            }

            private int extractNumber(String name) {
                int i = 0;
                try {
                    int startPosition = 0;
                    int endPosition = name.lastIndexOf('.');
                    String number = name.substring(startPosition, endPosition);
                    i = Integer.parseInt(number);
                } catch(Exception e) {
                    i = 0; // if filename does not match the format
                           // then default to 0
                }
                return i;
            }
        });
        /*for(File f : files) {
            System.out.println(f.getName());    //debug sorted file list print
        }*/	 
        return files;
	}
	
	ArrayList<String> read(int firstFileIndex, int lastFileIndex)
	{
		try{
			for (int index = firstFileIndex; index <= lastFileIndex; index++) 
			{
				File inputFile = listOfInputFiles[index];
				if (inputFile.isFile() && inputFile.getName().endsWith(".txt")) 
				{
					FileReader inputFileReader = new FileReader(inputFile);
					BufferedReader inputBufferedReader = new BufferedReader(inputFileReader);
					
					
					String inputLine = null;
					while ((inputLine = inputBufferedReader.readLine()) != null)
					{
				//		System.out.println(inputLine); //debug
						inputStringsMerger.add(inputLine);  //merge
						
					} 
					inputBufferedReader.close();
				} 
			}
			
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
		return inputStringsMerger;
	}
	public void readerTestPrint()
	{   
		System.out.println("Inside reader");
		for(String line : inputStringsMerger)
		{	
			System.out.println("Reading lines: "+line);	
		}
	}
}