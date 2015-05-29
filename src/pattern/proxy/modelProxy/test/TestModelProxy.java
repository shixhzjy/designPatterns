package pattern.proxy.modelProxy.test;

import pattern.proxy.modelProxy.impl.RealSubject_1;
import pattern.proxy.modelProxy.impl.RealSubject_2;
import pattern.proxy.modelProxy.Subject;
import pattern.proxy.modelProxy.proxy.SubjectProxy;

/**
 * 模仿客户端
 * 调用服务端的对象
 * 
 * @author admin
 * @date 2015年4月22日 下午10:08:52
 * @version 1.0
 */
public class TestModelProxy {

	public static void main(String[] args) {
		Subject subject = new RealSubject_1();
		SubjectProxy proxy = new SubjectProxy(subject);
		// 对外显示的是调用SubjectProxy的operate方法，但是方法执行完后，内容是RealSubject_1的operate方法
		proxy.operate();
		
		System.out.println("--------------------------------------");
		
		subject = new RealSubject_2();
		proxy = new SubjectProxy(subject);
		// 对外显示的是调用SubjectProxy的operate方法，但是方法执行完后，内容是RealSubject_2的operate方法
		// 另外还有RealSubject_2独有的操作
		proxy.operate();
	}

}
