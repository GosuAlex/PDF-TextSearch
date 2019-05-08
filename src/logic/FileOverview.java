package logic;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class FileOverview extends AbstractTableModel {

	private ArrayList<PDFFound> data;

	public FileOverview(ArrayList<PDFFound> found) {
		this.data = found;
	}

	public int getColumnCount() {
		return 4;
	}

	public int getColumn(int c) {
		return 150;
	}
	
	public int getRowCount() {
		return this.data.size();
	}

	public Object getValueAt(int value0, int value1) {
		if (value1 == 0) {return ((PDFFound) this.data.get(value0)).getFilename();}
		if (value1 == 1) {return ((PDFFound) this.data.get(value0)).getSearchStatus();}
		if (value1 == 2) {return ((PDFFound) this.data.get(value0)).getWordCount();}
		if (value1 == 3) {return ((PDFFound) this.data.get(value0)).getIndexLines();}
		return null;
	}
	
	public String getColumnName(int column) {
		if (column==0) {column++; return "path";}
		if (column==1) {column++; return "search results";}
		if (column==2) {column++; return "times word occur";}
		if (column==3) {column++; return "line number";}
		return null;		
	}

}
