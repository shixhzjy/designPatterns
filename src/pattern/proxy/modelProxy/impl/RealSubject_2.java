package pattern.proxy.modelProxy.impl;

import pattern.proxy.modelProxy.Subject;

/**
 * 被代理对象2
 * 它还有其他被代理对象没有的操作
 * 
 * @author admin
 * @date 2015年4月22日 下午10:03:29
 * @version 1.0
 */
public class RealSubject_2 implements Subject {

	@Override
	public void operate() {
		System.out.println("我是被代理对象：RealSubject_2---------");
	}

}
