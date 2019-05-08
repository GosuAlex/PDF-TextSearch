package gui;

import java.awt.BorderLayout;
import javax.swing.Action;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class SearchFieldEditor extends JPanel {

	private JTextField textField;

	public SearchFieldEditor(Action a) {
		setLayout(new BorderLayout());
		add(textField = new JTextField()
			{
				public void setBorder(Border border) {}
			});
		
		add(new JPanel() {}, "East");
		add(new JPanel(), "West");
		add(new JPanel(), "South");
		add(new JPanel(), "North");
	}
	
	public void prohibitEditor() {
		textField.setEditable(false);
	}
	
	public String getText() {
		return textField.getText();
	}
}
