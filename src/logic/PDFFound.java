package logic;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import logic.Search;
import logic.FileResultsLogic;
import logic.TextSearch;

public class PDFFound implements Search { 

	private String searchForText;
	private File pdf = null;
	
	private TextSearch TextSearcher;
	
	private int count = 0;
	private List<Integer> indexLines = new ArrayList();
	
	public int getWordCount() {
		return count;
	}
	
	public String getIndexLines() {
		return indexLines.toString().replaceAll("\\[|\\]", "");
	}
	
	public void setWordCount() {
		count++;
	}
	
	public void setIndexLines(int i) {
		indexLines.add(i);
	}
	
	private String searchStatus = "";
	
	public PDFFound(File pdfInject) {
		pdf = pdfInject;
	}
	
	public void resetCounts() {
		count = 0;
		indexLines.clear();
	}
		
	public String getFilename() {
		return pdf.getAbsolutePath();
	}
	
	public File getPdf() {
		return pdf;
	}
	
	public String getSearchStatus() {
		return searchStatus;
	}
	
	public String getSearchForText() {
		return searchForText;
	}
	
	public void setEmptySearchStatus() {
		searchStatus = "" ;
	}

	public void setFound(boolean bool) {
		if(bool == true) {
			searchStatus = "Found";
		}
		else {
			searchStatus = "No hits";
		}
	}
    
	public void runTextSearch(String searchForText, FileResultsLogic fileResults) {
		searchStatus = "Searching for text";
		fileResults.pingChange();
		this.searchForText = searchForText;
		TextSearcher = new TextSearch(this , fileResults);
		TextSearcher.start();
	}
}