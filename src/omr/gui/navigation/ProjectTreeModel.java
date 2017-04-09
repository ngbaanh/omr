package omr.gui.navigation;

import java.util.AbstractList;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

import omr.Project;
import omr.Sheet;
import sun.launcher.resources.launcher_zh_TW;

public class ProjectTreeModel implements TreeModel, Observer {
    
    private static final long serialVersionUID = 1L;
    private Project project;
    private Sheet selectedSheet;
    
    private LinkedList<ListDataListener> listDataListeners;
    
//    public ProjectTreeModel() {
//        this.listDataListeners = new LinkedList<ListDataListener>();
//    }
    public ProjectTreeModel(Project project) {
    	this.project = project;
    	this.listDataListeners = new LinkedList<ListDataListener>();
    }
    public void setProject(Project project) {
        // Unsubscribe from previous model
        if (this.project != null) {
            this.project.getSheetsContainer().deleteObserver(this);
        }
        
        this.project = project;
        
        // Subscribe to new model
        if (project != null) {
            project.getSheetsContainer().addObserver(this);
          
        }
        
        notifyListeners();
    }
    
    /**
     * Notified by the SheetsContainer when the sheet list is updated.
     */
    public void update(Observable source, Object event) {
    	// Event is set to null when the whole list changes. Otherwise, it contains an Integer specifying the changed row.
    	if (event == null) {
    		notifyListeners();
    	}
    }
    
    private void notifyListeners() {
        // Notify listeners
        for (ListDataListener listener : this.listDataListeners) {
            listener.contentsChanged(new ListDataEvent(this, ListDataEvent.CONTENTS_CHANGED, 0, this.getSize()));
           
        }
    }

    public Object getSelectedItem() {
        return this.selectedSheet;
    }

    public void setSelectedItem(Object sheet) {
        this.selectedSheet = (Sheet)sheet;
    }
    
    public int getSize() {
        if (project != null) {
            return project.getAnswerSheets().size();
        } else {
            return 0;
        }
    }
    
 

    public void addListDataListener(ListDataListener listener) {
        this.listDataListeners.add(listener);
    }
    
    public void removeListDataListener(ListDataListener listener) {
        this.listDataListeners.remove(listener);
    }

	@Override
	public void addTreeModelListener(TreeModelListener l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object getChild(Object parent, int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getChildCount(Object parent) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getIndexOfChild(Object parent, Object child) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public Object getRoot() {
		  if (this.project != null) {
			  
	            AbstractList<Sheet> sheets = project.getAnswerSheets();
	            
	            try {
	            	System.out.println(sheets.get(1).getFileName());
	                return sheets.get(1).getFileName();
	            } catch(IndexOutOfBoundsException e) {
	                return null;
	            }
	        } else {
	            return null;
	        }
//		String aString = project.toString();
//		return (aString);
	}

	@Override
	public boolean isLeaf(Object node) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeTreeModelListener(TreeModelListener l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void valueForPathChanged(TreePath path, Object newValue) {
		// TODO Auto-generated method stub
		
	}
    
}
