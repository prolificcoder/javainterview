public abstract class SearchTree {
    public static SearchTree empty() {
        return new EmptyTree();
    }
	
    public abstract boolean isEmpty();
    public abstract SearchTree insert(Comparable item);
    public abstract SearchTree remove(Comparable item);

}