package pattern.proxy.protectProxy.handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import pattern.proxy.protectProxy.IPersonBean;

/**
 * 拥有者InvocationHandler
 * 
 * @author admin
 * @date 2015年4月22日 下午9:46:29
 * @version 1.0
 */
public class OwnerInvocationHandler implements InvocationHandler {

    IPersonBean person;

    public OwnerInvocationHandler(IPersonBean person) {
        this.person = person;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws IllegalAccessException {

        try {
            if (method.getName().startsWith("get")) {
                // 如果方法是一个getter，就允许调用
                return method.invoke(person, args);
            } else if (method.getName().equals("setHotOrNotRating")) {
                // 否则，如果方法是HotOrNotRating(), 因为不能给自己打分，所以就抛出异常，表示不允许
                throw new IllegalAccessException();
            } else if (method.getName().startsWith("set")) {
                // 如果是setter，可以设置自己的信息，所以就给调用
                return method.invoke(person, args);
            }
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null; // 其他方法都是未定义的，返回null
    }

}
