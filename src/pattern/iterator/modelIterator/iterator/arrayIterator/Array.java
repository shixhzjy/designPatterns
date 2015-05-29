package pattern.iterator.modelIterator.iterator.arrayIterator;

import pattern.iterator.modelIterator.iterator.Iterator;

public class Array {
	
	Object[] objs;
	
	public Array(Object[] objs) {
		this.objs = objs;
	}
	
	public Iterator createIterator() {
		return new ArrayIterator(objs);
	}
}
