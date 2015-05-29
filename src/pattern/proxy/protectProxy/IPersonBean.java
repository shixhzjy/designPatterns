package pattern.proxy.protectProxy;

/**
 * 被代理对象
 * 这个接口可以设置和取得人的名字，性别，兴趣，和评分
 * 
 * @author syb
 * @date 2015年4月18日 下午12:49:15
 * @version 1.0
 */
public interface IPersonBean {

    String getName(); // 获取名字

    String getGender(); // 过去性别

    String getInterests(); // 获取兴趣

    int getHotOrNotRating(); // 获取评分值

    void setName(String name); // 设置姓名

    void setGender(String gender); // 设置性别

    void setInterests(String interests); // 设置兴趣

    void setHotOrNotRating(int rating); // 设置评分

}
