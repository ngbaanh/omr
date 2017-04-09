package omr.gui.navigation;


import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Observable;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

import omr.Project;
import omr.Sheet;
import omr.gui.SheetEditor;
import omr.gui.UndoSupport;

/**
 * A panel where the properties of the sheet structure can be edited.
 * 
 * @author Tapio Auvinen
 */
public class NavigationTreePanel extends JPanel implements ItemListener {
    private static final long serialVersionUID = 1L;
    
    protected UndoSupport undoSupport;
    
    private Project project;
    private SheetEditor sheetEditor; 
    //private AttributeEdit currentEdit;                // Current undo object. Changes are accumulated until another component is selected. 
    
    private ProjectTreeModel projectComboModel;
    private JComboBox treeCombo;
    
    public NavigationTreePanel() {
    	
        projectComboModel = new ProjectTreeModel();
        treeCombo = new JComboBox(projectComboModel);
        this.add(treeCombo);
    }
    
    public void setUndoSupport(UndoSupport undo) {
        this.undoSupport = undo;
    }
    
    /**
     * Sets the sheet structure to be edited.
     */
    public void setProject(Project project) {
        this.project = project;
        this.projectComboModel.setProject(project);
    }
    
    
   
    
    public void fetchSheetList() {
    	// Update sheet list
    	treeCombo.removeAllItems();
    	
    	for (Sheet sheet : project.getAnswerSheets()) {
    		treeCombo.addItem(sheet);
    	}
    }
    
    /**
     * Notified by the SheetsContainer when the sheet list is updated.
     */
    public void update(Observable source, Object arg1) {
    	fetchSheetList();
    }

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}
    
}
