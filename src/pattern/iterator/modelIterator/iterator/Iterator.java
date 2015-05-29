package pattern.iterator.modelIterator.iterator;

public interface Iterator {
	
	/**
	 * 是否还有下一个元素
	 * 
	 * @return
	 */
	public boolean hasNext();
	
	/**
	 * 返回下一个元素
	 * 
	 * @return
	 */
	public Object next();
}
