package cn.itcast.test;

import cn.itcast.domain.User;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

/**
 * @ClassName: BeanUtilsTest
 * @Description:
 * @Author 梁智
 * @Date 2020/11/19
 * @Version 1.0
 */

/**
 * 成员变量和属性的区别
 * 成员变量：成员变量是自定义在类里面的，是类中的属性
 * 属性：setter和getter方法截取后的产物（属性大多数和成员变量是一样的也可以不一样）
 *      getUsername()->Username->username
 */

public class BeanUtilsTest {
    @Test
    public void test(){
        User user = new User();
        try {
            BeanUtils.setProperty(user,"username","杨帆");//BeanUtils操作的是属性而不是成员变量
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(user);

    }
}
