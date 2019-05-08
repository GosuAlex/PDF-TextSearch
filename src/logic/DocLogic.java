package logic;

import java.io.File;
import logic.FileResultsLogic;

public class DocLogic extends Thread {
	
	  private FileResultsLogic fileresults;
	  private File dir;
	  int n = 0;
	  
	    public DocLogic(File selectedDirectory, FileResultsLogic r) {
		    dir = selectedDirectory;
		    fileresults = r;
	    }
	    
	    public void run() {
	    	SearchPDF(dir);
		    fileresults.finished();
		}
	  
	  private void SearchPDF(File file) {
		fileresults.searchProgress("Searching");
	    if (file.isDirectory()) {
	      File[] l = file.listFiles();
	      if (l != null) { for (File n : l) {
	    	  SearchPDF(n);
	        }
	      }
	      fileresults.searchProgress("Found PDF");
	    }
	    else if (file.getAbsolutePath().endsWith(".pdf")) {
	      fileresults.addFile(file);
	    }
	  }
}