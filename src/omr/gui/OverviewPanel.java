package omr.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class OverviewPanel extends JPanel {
	// TODO: do a stuff....
	public OverviewPanel() {
		this.setLayout(new GridLayout(3,5));
		for (int i = 0; i < 15; i++) {
			Thumbnails thumb = new Thumbnails(null, "Image no. " + i);
			this.add(thumb);
		}
	}
}

class Thumbnails extends JPanel {
	private Image image;
	private JLabel label;
	
	public Thumbnails(Image image, String labelString) {
		// do assigning data here
		this.image = image;
		this.label = new JLabel(labelString);
		this.setLayout(new BorderLayout());
		//this.add(image, BorderLayout.CENTER); ??
		this.add(label, BorderLayout.SOUTH);
		
		this.setBorder(BorderFactory.createLineBorder(Color.black));
	}
}
