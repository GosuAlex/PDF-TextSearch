package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import logic.DocLogic;

public class FolderSelector extends JPanel implements ActionListener {

	DocLogic logic = null; 
	JFileChooser filechooser;
	File selectedDirectory = new File(".");
	private FileResults results; 
	private JButton openButton;
	
	public FolderSelector(AbstractAction abstractAction) {
		
		setLayout(new BorderLayout(30,30));
		filechooser = new JFileChooser(selectedDirectory);
		filechooser.setFileSelectionMode(1);
		openButton = new JButton("Open a File");
        openButton.addActionListener(this);
		if (filechooser.showOpenDialog(null) == 0) {
			
			selectedDirectory = filechooser.getSelectedFile();
			abstractAction.putValue("Name", selectedDirectory.getAbsolutePath());			
			results = new FileResults();
            add(results);
			logic = new DocLogic(selectedDirectory, results);
			logic.start();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}