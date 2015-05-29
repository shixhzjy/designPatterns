package pattern.proxy.protectProxy.test;

import java.util.Hashtable;

import pattern.proxy.protectProxy.IPersonBean;
import pattern.proxy.protectProxy.impl.PersonBeanImpl;
import pattern.proxy.protectProxy.proxy.PersonProxy;

public class TestProtectProxy {

    public TestProtectProxy() {
        initializeDatabase();
    }

    // 实例变量, 当作是保存顾客的“数据库”
    Hashtable<String, IPersonBean> datingDB = new Hashtable<String, IPersonBean>();

    // 初始化“数据库”
    void initializeDatabase() {
        IPersonBean joe = new PersonBeanImpl();
        joe.setName("Joe Javabean");
        joe.setInterests("cars, computers, music");
        joe.setHotOrNotRating(7);
        datingDB.put(joe.getName(), joe);

        IPersonBean kelly = new PersonBeanImpl();
        kelly.setName("Kelly Klosure");
        kelly.setInterests("ebay, movies, music");
        kelly.setHotOrNotRating(6);
        datingDB.put(kelly.getName(), kelly);
    }

    public void drive() {
        IPersonBean joe = getPersonFromDatabase("Joe Javabean"); // 从数据库中取出一个人
        IPersonBean ownerProxy = PersonProxy.getOwnerProxy(joe); // 创建这个人的拥有者代理
        System.out.println("姓名：" + ownerProxy.getName()); // 输出这个人的名字
        ownerProxy.setInterests("bowling, Go"); // 使用拥有者代理来设置自己的兴趣
        System.out.println("Interests set from owner proxy");
        try {
            // 尝试用拥有者代理来给自己评分
            ownerProxy.setHotOrNotRating(10);
        } catch (Exception e) {
            // 如果给自己评分会出错
            System.out.println("Can't set rating from owner proxy");
        }
        System.out.println("Rating is " + ownerProxy.getHotOrNotRating());

        // 创建一个非拥有者的代理
        IPersonBean nonOwnerProxy = PersonProxy.getNonOwnerProxy(joe);
        System.out.println("Name is " + nonOwnerProxy.getName());
        try {
            // 尝试用非拥有者代理来设置兴趣
            nonOwnerProxy.setInterests("bowling, Go");
        } catch (Exception e) {
            // 不可以给别人设置兴趣
            System.out.println("Can't set interests from non owner proxy");
        }
        // 可以给别人评分
        nonOwnerProxy.setHotOrNotRating(3);
        System.out.println("Rating set from non owner proxy");
        System.out.println("Rating is " + nonOwnerProxy.getHotOrNotRating());
    }

    IPersonBean getPersonFromDatabase(String name) {
        return (IPersonBean) datingDB.get(name);
    }

    public static void main(String[] args) {
        TestProtectProxy test = new TestProtectProxy();
        test.drive();
    }

}
