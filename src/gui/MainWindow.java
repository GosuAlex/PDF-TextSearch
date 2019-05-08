package gui;

import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import logic.CardStacker;

public class MainWindow extends JFrame implements CardStacker {
	private Navibar naviBar;
	private CardLayout cardLayout;
	private JPanel containers;
	
	int cardID = 0;

	public MainWindow() {
		setTitle("PDFFinder v1.4.0");
		cardLayout = new CardLayout(10, 10);
		containers = new JPanel(cardLayout);
		add(containers);
		setSize(1280, 720);
		naviBar = new Navibar(this); 
		setJMenuBar(naviBar);
		setLocationByPlatform(true);
		setVisible(true);
		setDefaultCloseOperation(3);
	}

	public void newCard() {
		SearchBarItem s = new SearchBarItem();
		containers.add(s, Integer.toString(s.getSearchBarItemID())); 
		s.updateUI();
		naviBar.addCardSelect(containers, cardLayout, s.getSearchBarItemID()); 
		cardLayout.show(containers, Integer.toString(s.getSearchBarItemID()));
	}
}
