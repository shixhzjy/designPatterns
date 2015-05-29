package pattern.iterator.modelIterator.iterator.listIterator;

import java.util.List;

import pattern.iterator.modelIterator.iterator.Iterator;

public class ListIterator implements Iterator {

	List<Object> objList;
	int index = 0;
	
	public  ListIterator(List<Object> objList) {
		this.objList = objList;
	}
	
	@Override
	public boolean hasNext() {
		
		if(index >= objList.size() || objList.get(index) == null) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public Object next() {
		
		Object object = objList.get(index);
		index = index + 1;
		
		return object;
	}

}
