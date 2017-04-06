package omr.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class NavigationPanel extends JPanel {
	// TODO: do navigation panel
	// Properties
	private JPanel nameProjectPanel;
	private JPanel projectTreePanel;
	private JScrollPane projectTreeScroll;
	private JLabel nameProjectLabel;
	
	public NavigationPanel() {
		this.setBorder(BorderFactory.createLineBorder(Color.gray));
		
		// Name Project Panel
		nameProjectPanel = new JPanel();
		
		nameProjectLabel = new JLabel("Math 208");
		Font fontNameProjectLabel = nameProjectLabel.getFont();
		nameProjectLabel.setFont(fontNameProjectLabel.deriveFont(fontNameProjectLabel.getStyle() ^ Font.BOLD));
		
		nameProjectPanel.add(nameProjectLabel);
		nameProjectPanel.setAlignmentX(FlowLayout.TRAILING);

		// Projects Tree Panel
		projectTreePanel = new JPanel();
		
		
		// Create the nodes
		DefaultMutableTreeNode top = new DefaultMutableTreeNode("The Courses");
		createNodes(top);
		JTree tree = new JTree(top);
		projectTreePanel.add(tree);
		
		projectTreeScroll = new JScrollPane(projectTreePanel);
		projectTreeScroll.setPreferredSize(new Dimension(200, 500));
		
		
		// Add Panels to Main Navigation Frame
		this.setLayout(new BorderLayout());
		this.add(nameProjectPanel, BorderLayout.NORTH);
		this.add(projectTreeScroll, BorderLayout.CENTER);
		
			
	}

	  private class BookInfo {
	        public String bookName;
	        public URL bookURL;
	 
	        public BookInfo(String book, String filename) {
	            bookName = book;
	            bookURL = getClass().getResource(filename);
	            if (bookURL == null) {
	                System.err.println("Couldn't find file: "
	                                   + filename);
	            }
	        }
	 
	        public String toString() {
	            return bookName;
	        }
	    }
	
	private void createNodes(DefaultMutableTreeNode top) {
		 DefaultMutableTreeNode category = null;
	        DefaultMutableTreeNode book = null;
	 
	        category = new DefaultMutableTreeNode("Math 208");
	        top.add(category);
	 
	        //original Tutorial
	        book = new DefaultMutableTreeNode(new BookInfo
	            ("Nguyen Van A Test.jpeg",
	            "tutorial.html"));
	        category.add(book);
	 
	        //Tutorial Continued
	        book = new DefaultMutableTreeNode(new BookInfo
	            ("Nguyen Van B Test.jpeg",
	            "tutorialcont.html"));
	        category.add(book);
	 
	        //JFC Swing Tutorial
	        book = new DefaultMutableTreeNode(new BookInfo
	            ("Nguyen Van C Test.jpeg",
	            "swingtutorial.html"));
	        category.add(book);
	 
	        category = new DefaultMutableTreeNode("Physic 105");
	        top.add(category);
	 
	        //VM
	        book = new DefaultMutableTreeNode(new BookInfo
		            ("Nguyen Van A Test.jpeg",
		            "tutorial.html"));
		        category.add(book);
		 
		        //Tutorial Continued
		        book = new DefaultMutableTreeNode(new BookInfo
		            ("Nguyen Van B Test.jpeg",
		            "tutorialcont.html"));
		        category.add(book);
		 
		        //JFC Swing Tutorial
		        book = new DefaultMutableTreeNode(new BookInfo
		            ("Nguyen Van C Test.jpeg",
		            "swingtutorial.html"));
		        category.add(book);
		
	}
}
