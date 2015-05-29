package pattern.iterator.modelIterator.iterator.arrayIterator;

import pattern.iterator.modelIterator.iterator.Iterator;

public class ArrayIterator implements Iterator {

	Object[] objs;
	int index = 0;
	
	public ArrayIterator(Object[] objs) {
		this.objs = objs;
	}
	
	@Override
	public boolean hasNext() {
		
		if(index >= objs.length || objs[index] == null) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public Object next() {
		
		Object object = objs[index];
		index = index + 1;
		
		return object;
	}

}
