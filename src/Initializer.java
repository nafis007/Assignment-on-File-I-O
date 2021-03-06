import java.io.File;

public class Initializer extends Main
{
	public Initializer(int inputFileNumber, int threadNumber)
	{
		numberOfInputFiles = inputFileNumber;
		numberOfThreads = threadNumber;
		
		targetInputDirectory = new File( "D:\\randomInputFolder" );
		targetOutputDirectory = new File( "D:\\targetOutputFolder" );
		masterOutputDirectory = new File( "D:\\masterOutputFolder" );
		
		cleanDirectories();
		
		new RandomInputGenerator(targetInputDirectory,numberOfInputFiles);
	}
	
    void cleanDirectories(){
		
		System.out.println("Cleaning Directories");
		
		for (File file: targetInputDirectory.listFiles()) 
		{
			if (!file.isDirectory()) 
			{
				file.delete();
			}
		}
		
		for (File file: targetOutputDirectory.listFiles()) 
		{
			if (!file.isDirectory()) 
			{
				file.delete();
			}
		}
	}
}