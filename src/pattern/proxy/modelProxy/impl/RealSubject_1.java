package pattern.proxy.modelProxy.impl;

import pattern.proxy.modelProxy.Subject;

public class RealSubject_1 implements Subject {

	@Override
	public void operate() {
		System.out.println("我是被代理对象：RealSubject_1---------");
	}

}
