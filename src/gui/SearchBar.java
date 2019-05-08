package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import logic.FileResultsLogic;
import gui.SearchFieldEditor;

public class SearchBar extends JPanel
{
  private JLabel status = null;
  private SearchFieldEditor searchField = null;
  private AbstractAction searchAction;  
  
  public SearchBar(final FileResultsLogic fr, final Action a)
  {
    setLayout(new BorderLayout(30, 20));
    add(new JPanel(), "North");
    add(status = new JLabel("0"), "West");
    add(searchField = new SearchFieldEditor(new AbstractAction()
    {
      public void actionPerformed(ActionEvent e)
      {
        a.actionPerformed(null);
        SearchBar.this.searchAction.setEnabled(true);
      }
    }));
    
    searchField.setEnabled(false);
    add(new JButton(searchAction = new AbstractAction("Search")
    {
      public void actionPerformed(ActionEvent e)
      {
        setEnabled(false);
        fr.resetCounter();
        fr.search(SearchBar.this.searchField.getText());
      }
    }), "East");
    searchAction.setEnabled(false);
    updateUI();
  }
  
  public void working(String string)
  {
    status.setText("" + string);
  }
  
  public void showSearchField()
  {
    searchAction.setEnabled(true);
    searchField.setEnabled(true);
  }

}