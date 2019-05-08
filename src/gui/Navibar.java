package gui;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.awt.Component;
import logic.CardSelector;
import logic.CardStacker;

public class Navibar extends JMenuBar implements CardSelector {
	private JMenu cardselector;
	private JMenu tools;
	private Component frame;

	public Navibar(final CardStacker s) {
		add(this.cardselector = new JMenu("Cards"));
		add(this.tools = new JMenu("Tools"));

		this.tools.add(new JMenuItem(new AbstractAction("Add a new search card") {
			public void actionPerformed(ActionEvent e) {
				s.newCard();
				
			}
		}));

		this.tools.addSeparator();
		this.tools.add(new JMenuItem(new AbstractAction("Close Program") {
			public void actionPerformed(ActionEvent event) {
		        confirmAndExit();}
		}));
	}

	public void addCardSelect(final Container container, final CardLayout cardlayout, int CardID)
	{
		this.cardselector.add(new JMenuItem(new AbstractAction("Search Card "+ CardID)
			{
			public void actionPerformed(ActionEvent e)
			{
				cardlayout.show(container, Integer.toString(CardID));
			}
			}));
	}
	
	void confirmAndExit() {
	    if (JOptionPane.showConfirmDialog(
	      frame,
	      "Are you sure you want to quit?",
	      "Please confirm",
	      JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION
	    ) {
	      System.exit(0);
	    }
	  }
}

