import java.io.File;
import java.util.ArrayList;

public class ReadWriteRunnable implements Runnable 
{
	Reader inputReader;
	Writer outputWriter;
	int firstIndex;
	int lastIndex;
	int threadId;
	ArrayList<String> chunkInputStrings;
	
	public ReadWriteRunnable(Reader InReader , Writer OutWriter,int first, int last, int id)
	{
		this.inputReader = InReader;
		this.outputWriter = OutWriter;
		this.firstIndex = first;
		this.lastIndex = last;
		this.threadId = id;
	}
	
	
	void InThreadRead()
	{
		System.out.println("ReaderWriter Thread running: "+threadId);
		
		chunkInputStrings=inputReader.read(firstIndex,lastIndex);
		
		//inputReader.readerTestPrint(); //debug print
		
		
	}
	
	void InThreadWrite(){
		outputWriter.write(chunkInputStrings,threadId);
	}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		InThreadRead();
		InThreadWrite();	
	}
	
}