package pattern.proxy.modelProxy;

/**
 * 抽象角色，这是被代理对象（真实对象）和代理对象的共同接口
 * 
 * @author admin
 * @date 2015年4月22日 下午9:55:26
 * @version 1.0
 */
public interface Subject {

	/**
	 * 被代理对象共有的操作（方法）
	 * 
	 * @return
	 */
	public void operate();
	
}
