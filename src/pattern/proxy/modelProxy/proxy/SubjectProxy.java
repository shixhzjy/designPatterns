package pattern.proxy.modelProxy.proxy;

import pattern.proxy.modelProxy.impl.RealSubject_2;
import pattern.proxy.modelProxy.Subject;

public class SubjectProxy implements Subject {

	private Subject subject;
	
	public SubjectProxy(Subject subject) {
		this.subject = subject;
	}
	
	@Override
	public void operate() {
		// 这里虽然是实现了Subject接口的方法，但是真正执行的是被代理对象RealSubjec的operrate方法
		subject.operate();
		
		if(subject instanceof RealSubject_2) {
			realSubject_2();
		}
	}
	
	private void realSubject_2() {
		System.out.println("被代理对象2独有的操作");
	}

}
