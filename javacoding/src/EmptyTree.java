
public class EmptyTree extends SearchTree {

	@Override
	public boolean isEmpty() {
		return true;
	}

	@Override
	public SearchTree insert(Comparable item) {
		return new TernaryTreeNode(item);
	}

	@Override
	public SearchTree remove(Comparable item) {
		return this;
	}

}
