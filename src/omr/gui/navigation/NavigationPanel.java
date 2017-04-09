package omr.gui.navigation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;

import omr.Project;
import omr.gui.MyGUI;

public class NavigationPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Properties
	private JPanel nameProjectPanel;
	private JPanel projectTreePanel;
	private JScrollPane projectTreeScroll;
	private JLabel nameProjectLabel;
	private Project project;
	
	private ProjectTreeModel projectTreeModel;
	private JTree projectTree;
	
	public NavigationPanel() {
		this.setBorder(BorderFactory.createLineBorder(Color.gray));
		
		// Name Project Panel
		nameProjectPanel = new JPanel();
		
		nameProjectLabel = new JLabel("Math 209");
		Font fontNameProjectLabel = nameProjectLabel.getFont();
		nameProjectLabel.setFont(fontNameProjectLabel.deriveFont(fontNameProjectLabel.getStyle() ^ Font.BOLD));
		
		nameProjectPanel.add(nameProjectLabel);
		nameProjectPanel.setAlignmentX(FlowLayout.TRAILING);


		// Create the nodes
//		DefaultMutableTreeNode top = new DefaultMutableTreeNode("The Courses");
//		createNodes(top);
//		JTree tree = new JTree(top);
//		projectTreePanel.add(tree);
		
		//projectTreeModel = new ProjectTreeModel();
		projectTreeModel = new ProjectTreeModel();
		projectTree = new JTree(projectTreeModel);
		
		//Note: Try later to remove projectTreeScroll
		
		projectTreeScroll = new JScrollPane(projectTree);
		projectTreeScroll.setPreferredSize(new Dimension(200, 500));
		
		
		// Add Panels to Main Navigation Frame
		this.setLayout(new BorderLayout());
		this.add(nameProjectPanel, BorderLayout.NORTH);
		this.add(projectTreeScroll, BorderLayout.CENTER);

	}
	
	 public void setProject(Project project) {
	        this.project = project;
	        this.projectTreeModel.setProject(project);
	        
	       
	    }
}
