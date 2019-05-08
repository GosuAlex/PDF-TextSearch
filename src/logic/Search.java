package logic;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public abstract interface Search {

	public abstract void setFound(boolean paramBoolean);

	public abstract String getSearchForText();
	
	public abstract String getFilename();
	
	public abstract File getPdf();
	
	public abstract int getWordCount();
	
	public abstract String getIndexLines();
	
	public abstract void setWordCount();
	
	public abstract void setIndexLines(int i);
	
	public abstract void resetCounts();
}
