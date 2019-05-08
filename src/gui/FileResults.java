package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

import logic.PDFFound;
import logic.FileResultsLogic;
import logic.FileOverview;

public class FileResults extends JPanel implements FileResultsLogic {

	private SearchBar searchBar = null; 
	private JTable tableofPDF_Files = null;
	private ArrayList<PDFFound> listOfFiles = new ArrayList<PDFFound>();
	private FileOverview tablemodel;
	private int textCount = 0;
	private String stringTextCount;

	public FileResults() {
		searchBar = new SearchBar(this, new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				for (PDFFound tf : FileResults.this.listOfFiles ) {
					tf.setEmptySearchStatus();
				}
				FileResults.this.pingChange();
				}
		});
				
		setLayout(new BorderLayout());
		tableofPDF_Files = new JTable(tablemodel = new FileOverview(listOfFiles));
		
		for (int i = 0; i < tableofPDF_Files.getColumnCount(); i++) {
			TableColumn column = tableofPDF_Files.getColumnModel().getColumn(i);
			if (i == 0) {
				column.setPreferredWidth(350);
			}
			else if (i == 3) {
				column.setPreferredWidth(500);
			}
			else
			{
				column.setPreferredWidth(40);
			}
		}
		
		add(new JScrollPane(tableofPDF_Files));
		add(searchBar, "South");
	}


	public void counter() {
		textCount++;
		stringTextCount = Integer.toString(textCount);
		this.searchProgress("Total words found: " + textCount);
	}
	
	public int getCount() {
		return textCount;
	}

	public void search(String text) {
	
		for (PDFFound tf : listOfFiles) {
			tf.runTextSearch(text, this);
		}
	}

	public void finished() {
	
		if (listOfFiles.isEmpty()) {
			remove(searchBar);
			add(new JLabel("No pdfs found in this directory",0), "South");
		}
		else {
			searchBar.showSearchField();
		}
		updateUI();
	}

	public void addFile(File f) {

		listOfFiles.add(new PDFFound(f));
		tablemodel.fireTableDataChanged();
	}

	public void pingChange() {
		
		this.tablemodel.fireTableDataChanged();
	}
	
	public void searchProgress(String string) {
		searchBar.working(string);
		updateUI();
	}
	
	public void EnableSearch() {
		searchBar.showSearchField();
	}
	
	public void resetCounter() {
		textCount = 0;
	}
}

