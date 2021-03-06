import java.io.File;
import java.util.ArrayList;

public class ThreadManager extends Main
{
	static int numberOfInputFiles;
	static int numberOfThreads;
	static File InDir;
	static File OutDir;
	
	
	public ThreadManager(int numberOfInputFiles, int numberOfThreads, File InDir, File OutDir)
	{
		this.numberOfInputFiles = numberOfInputFiles;
		this.numberOfThreads = numberOfThreads;
		this.InDir = InDir;
		this.OutDir = OutDir;
		
	}
	
	void runnableManager()
	{
		int chunksOfFiles=numberOfInputFiles/numberOfThreads;
		
		int remainingFiles=numberOfInputFiles%numberOfThreads;
		
		System.out.println("debug chunk size: "+chunksOfFiles+" remaining size: "+remainingFiles);
		
		for(int firstIndex = 0; firstIndex < numberOfInputFiles; firstIndex += chunksOfFiles){

			int lastIndex;
			int runnableId=firstIndex/chunksOfFiles;
			
			if(numberOfInputFiles-((runnableId+1)*chunksOfFiles) < chunksOfFiles && remainingFiles!=0)
			{
				
				Reader inputReader = new Reader(InDir);
				Writer outputWriter = new Writer(OutDir);
				
				lastIndex=firstIndex+chunksOfFiles+remainingFiles-1;
				
				System.out.println("First Index: "+firstIndex+" Last Index: "+lastIndex);
				
				ReadWriteRunnable tempRunnable = 
					new ReadWriteRunnable(inputReader,outputWriter,firstIndex,lastIndex,runnableId);
					listOfRunnables.add(tempRunnable);
					break;
			}
			else
			{
				
				Reader inputReader = new Reader(InDir);
				Writer outputWriter = new Writer(OutDir);
				
				lastIndex=firstIndex+chunksOfFiles-1;
				
				System.out.println("First Index: "+firstIndex+" Last Index: "+lastIndex);
				
				ReadWriteRunnable tempRunnable = 
					new ReadWriteRunnable(inputReader,outputWriter,firstIndex,lastIndex,runnableId);
					listOfRunnables.add(tempRunnable);
			}
	
		}
	}
	
	
	void threadCreator()
	{
		for(int runnableIndex = 0; runnableIndex < listOfRunnables.size(); runnableIndex++){
			Thread tempThread=new Thread(listOfRunnables.get(runnableIndex));
			listOfReadWriteThreads.add(tempThread);	
		}
	}
	
	
	void threadStartAndJoin()
	{
		for(int threadIndex = 0; threadIndex < listOfReadWriteThreads.size(); threadIndex++){
			
			listOfReadWriteThreads.get(threadIndex).start();
			try{
				listOfReadWriteThreads.get(threadIndex).join();
			}
			catch(Exception exception)
			{
				exception.printStackTrace();
			}
		}
	}
	
	
	void threadReadWrite()
	{
		runnableManager();

		threadCreator();

		threadStartAndJoin();
	}
	
	void masterReadWrite(File masterInDir, File masterOutDir)
	{
		Reader masterReader = new Reader(masterInDir);
		Writer masterWriter = new Writer(masterOutDir);
		
		ArrayList<String> masterAllInputStrings = new ArrayList<String>();
		masterAllInputStrings=masterReader.read(0, numberOfThreads-1);
		masterWriter.write(masterAllInputStrings, -1);
	}
}