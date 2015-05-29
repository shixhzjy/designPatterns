package pattern.proxy.protectProxy.handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import pattern.proxy.protectProxy.IPersonBean;

/**
 * 非拥有者InvocationHandler
 * 
 * @author admin
 * @date 2015年4月22日 下午9:46:29
 * @version 1.0
 */
public class NonOwnerInvocationHandler implements InvocationHandler {

    IPersonBean person;

    public NonOwnerInvocationHandler(IPersonBean person) {
        this.person = person;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws IllegalAccessException {

        try {
            if (method.getName().startsWith("get")) {
                // 可以查看其他人的信息
                return method.invoke(person, args);
            } else if (method.getName().equals("setHotOrNotRating")) {
                // 可以给其他人评分
                return method.invoke(person, args);
            } else if (method.getName().startsWith("set")) {
                // 不可以设置别人的信息,所以返回异常
                throw new IllegalAccessException();
            }
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return null;
    }

}
