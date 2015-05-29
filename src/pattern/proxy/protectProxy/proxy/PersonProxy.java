package pattern.proxy.protectProxy.proxy;

import java.lang.reflect.Proxy;

import pattern.proxy.protectProxy.IPersonBean;
import pattern.proxy.protectProxy.handler.NonOwnerInvocationHandler;
import pattern.proxy.protectProxy.handler.OwnerInvocationHandler;

/**
 * 代理对象
 * 用Java提供的Proxy代理类，不是接口
 * 
 * @author admin
 * @date 2015年4月22日 下午9:47:46
 * @version 1.0
 */
public class PersonProxy {

    // private IPersonBean person;
    //
    // public PersonProxy(IPersonBean person) {
    // super(null);
    // this.person = person;
    // }

    /**
     * 拥有者代理
     * 
     * @param person
     * @return
     */
    // 此方法需要一个person对象作为参数，然后返回该对象的代理proxy
    // 因为代理和主题有相同的接口，所以我们返回接口PersonBean
    public static IPersonBean getOwnerProxy(IPersonBean person) {
        ClassLoader classLoader = person.getClass().getClassLoader();
        System.out.println("classLoader:" + classLoader);
        System.out.println("getInterfaces" + person.getClass().getInterfaces());

        // 此代码创建了代理（代码有点丑）
        // 我们利用Proxy类的静态newProxyInstance方法创建代理对象(Java反射机制)
        return (IPersonBean) Proxy.newProxyInstance(classLoader, // 将personBean的类载入器当作参数
                person.getClass().getInterfaces(), // 代理需要实现的接口
                new OwnerInvocationHandler(person)); // 调用非拥有者的处理器
    }

    /**
     * 非拥有者代理
     * 
     * @param person
     * @return
     */
    public static IPersonBean getNonOwnerProxy(IPersonBean person) {

        return (IPersonBean) Proxy.newProxyInstance(person.getClass().getClassLoader(), person.getClass()
                .getInterfaces(), new NonOwnerInvocationHandler(person));
    }

}
