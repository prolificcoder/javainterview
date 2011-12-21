//Based on http://www.cogs.susx.ac.uk/courses/dats/notes/html/node59.html

public class TernaryTreeNode extends SearchTree {
	SearchTree left;
	SearchTree right;
	SearchTree middle;
	Object data;
	public TernaryTreeNode(Comparable data){
		this.left=new EmptyTree();
		this.right=new EmptyTree();
		this.middle=new EmptyTree();
		this.data=data;	
	}
	public TernaryTreeNode(SearchTree left,SearchTree right, SearchTree middle, Object data) {
		this.left=left;
		this.right=right;
		this.middle=middle;
		this.data=data;
	}
	
	public TernaryTreeNode insert(Comparable item)
	{
		int compare= item.compareTo(data);
		if (compare < 0) {
	        left = left.insert(item);
	    } else if (compare > 0) {
	        right = right.insert(item);
	    }
	    else 
	    	middle= middle.insert(item);
	    return this;
	}
	
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}
	
	private Comparable findMin() {
	    if (left.isEmpty()) {
	        return (Comparable) data;
	    } else {
	        return ((TernaryTreeNode) left).findMin();
	    }
	}

	private SearchTree removeMin() {
	    if (left.isEmpty()) {
	        return right; 
	    } else {
	        left = ((TernaryTreeNode) left).removeMin();
	        return this;
	    }
	}

	public SearchTree remove(Comparable item) {
	    int compare = item.compareTo(data);
	    if (compare == 0 &&!(this.middle instanceof EmptyTree)){
	    		TernaryTreeNode parent= this;	    		
	    		TernaryTreeNode cur= this;
	    		while(cur.middle instanceof TernaryTreeNode)
	    		{
	    			parent = cur;
	    			cur=(TernaryTreeNode) cur.middle;
	    		}
	    		parent.middle= new EmptyTree();
	    }
	    else   if(compare == 0 &&	right.isEmpty()) {
		        return left;
		}
	    else {
	        if (compare < 0) {
	            left = left.remove(item);
	        } else if (compare > 0) {
	            right = right.remove(item);
	        } else {
	            data = ((TernaryTreeNode) right).findMin();
	            right = ((TernaryTreeNode) right).removeMin();
	        }
	       
	    }
	    return this;
	}
}
