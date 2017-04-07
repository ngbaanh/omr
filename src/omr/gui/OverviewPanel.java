package omr.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class OverviewPanel extends JPanel {
	// TODO: do a stuff....
	public OverviewPanel() {
		this.setLayout(new GridLayout(2,2));
		for (int i = 0; i < 4; i++) {
			// Loading image
			BufferedImage image = null;
			try {
				image = ImageIO.read(new File("/Users/swift/test 1.jpg"));
			} catch (IOException e) {
			}
//			
//			Thumbnails thumb = new Thumbnails(image, "Image no. " + i);
//			thumb.setVisible(true);
//			this.add(thumb);
//			System.out.println(image.getWidth());
			JLabel picLabel = new JLabel(new ImageIcon(image));
			JScrollPane picScrollPane = new JScrollPane(picLabel);
			this.add(picScrollPane);
			
			
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
