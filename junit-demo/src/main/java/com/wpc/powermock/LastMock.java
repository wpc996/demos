package com.wpc.powermock;

import com.example.demo.controller.UserController;
import com.example.demo.entity.User;
import com.example.demo.service.impl.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.powermock.api.mockito.PowerMockito.when;

/**
 * @author wangpeican
 * @date 2022/9/20 23:02
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(UserController.class)
public class LastMock {
    @Mock
    private UserServiceImpl serviceImpl;

    @InjectMocks
    private UserController controller;

    /**
     * mock service的保存方法
     */
    @Test
    public void mockSave() {
        User user1 = new User();
        User user2 = new User();
        user1.setId("1");
        user2.setId("2");
        Mockito.when(serviceImpl.save(user1)).thenReturn(user2); //当调用service的save()时，mock让他返回user2
        User saveUser = controller.saveUser(user1); //调用
        Mockito.verify(serviceImpl, Mockito.times(1)).save(user1);//verify验证mock次数
        assertEquals(user2, saveUser);//断言是否mock返回的是user2
    }

    /**
     * mock spy public方法
     *
     * @throws Exception xx
     */
    @Test
    public void spy_public_method() throws Exception {
        UserController spy = PowerMockito.spy(controller); //监视controller的publicCheck方法，让他返回true
        Mockito.when(spy.publicCheck()).thenReturn(true);
        String name = spy.getPrivateName("ljw");//执行该方法
        assertEquals("public 被mock 了", name);//验证
    }

    /**
     * mock私有方法
     *
     * @throws Exception xx
     */
    @Test
    public void spy_private_method() throws Exception {
        UserController spy = PowerMockito.spy(controller);
        PowerMockito.when(spy, "check", any()).thenReturn(true);//私有方法mockito不行了，需要用无所不能的PowerMock监视spy
        String name = spy.getPrivateName("ljw");
        assertEquals("private 被mock 了", name);
    }

    /**
     * mock 静态方法
     */
    @Test
    public void mockStaticMethod() {
        PowerMockito.mockStatic(UserController.class);//mock静态方法
        when(UserController.getStaticName(any())).thenReturn("hi");
        String staticName = UserController.getStaticName("ljw");//执行
        assertEquals("hi", staticName);//验证
    }

    @Test
    public void mockStaticMethod_2() {
        PowerMockito.mockStatic(UserController.class);
        when(UserController.getStaticName(any())).thenReturn("hi");
        String staticName = controller.returnName();//通过returnName()调用，看能否被mock
        assertEquals("hi", staticName);
    }

    /**
     * 测试私有方法一
     *
     * @throws InvocationTargetException xx
     * @throws IllegalAccessException    xx
     */
    @Test
    public void testPrivateMethod() throws InvocationTargetException, IllegalAccessException {
        Method method = PowerMockito.method(UserController.class, "say", String.class);
        Object say = method.invoke(controller, "hi");
        assertEquals("ljw say hi", say);
    }

    /**
     * 测试私有方法二
     *
     * @throws Exception xx
     */
    @Test
    public void testPrivateMethod_2() throws Exception {
        Object say = Whitebox.invokeMethod(controller, "say", "hi");
        assertEquals("ljw say hi", say);
    }
}
