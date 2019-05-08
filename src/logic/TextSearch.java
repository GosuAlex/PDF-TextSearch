package logic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import logic.Search;
import logic.FileResultsLogic;

public class TextSearch extends Thread {
	
	private String searchForText;
	
	private FileResultsLogic fileResults;
	private Search pdfFound = null;
	
	public TextSearch(Search s, FileResultsLogic fr) {
		pdfFound = s;
		fileResults = fr;
		searchForText = s.getSearchForText();
	}

	public void run() {
		try {
		PDDocument pdf = PDDocument.load(pdfFound.getPdf());
		String Text = new PDFTextStripper().getText(pdf);
		pdfFound.setFound(Text.indexOf(searchForText) > -1);
		fileResults.pingChange();		
		
		String[] words = Text.split(" ");
		pdfFound.resetCounts();
		
		for (int i = 0; i < words.length; i++) {
			if (words[i].contains(searchForText)) {
				pdfFound.setWordCount();
				pdfFound.setIndexLines(i);
				fileResults.counter();
			}
		}
		
		if (fileResults.getCount() > 0){
			fileResults.EnableSearch();
		}
		else {
			fileResults.searchProgress("Found nothing");
			fileResults.EnableSearch();
		}
		
      	
		pdf.close();
		
        } catch (IOException ex) {
        	System.err.println(ex.getMessage());
        }
		
	}
}
