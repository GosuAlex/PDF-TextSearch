package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JPanel;

import gui.FolderSelector;
import logic.SearchCardID;

public class SearchBarItem extends JPanel {
	private FolderSelector folderSelector;

	private int searchBarItemID;

	public int getSearchBarItemID() {
		return searchBarItemID;
	}

	public SearchBarItem() {
		searchBarItemID = SearchCardID.newID();
		setLayout(new BorderLayout(15, 15));
		add(new JButton(new AbstractAction("Select folder") {
			public void actionPerformed(ActionEvent e) {
				setEnabled(false);
				SearchBarItem.this.add(SearchBarItem.this.folderSelector = new FolderSelector(this));
			}
		}), "North");
	}

}