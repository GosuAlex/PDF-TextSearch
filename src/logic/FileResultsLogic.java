package logic;

import java.io.File;
import java.util.ArrayList;

public interface FileResultsLogic {

	public abstract void search(String paramString);
	
	public abstract void finished();
	
	public abstract void addFile(File paramFile);

	public abstract void searchProgress(String string);
	
	public abstract void pingChange();
	
	public abstract void EnableSearch();
	
	public abstract void counter();
	
	public abstract int getCount();
	
	public abstract void resetCounter();
}
