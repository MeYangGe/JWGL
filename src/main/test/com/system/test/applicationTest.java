package com.system.test;

import com.system.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/***
 * 整合 spring + junit ，junit版本必须在4.12以上
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml"})
public class applicationTest {
    @Autowired
    private ApplicationContext ac;

    @Test
    public void SpringTest() {
        User user = ac.getBean(User.class);
        if (user != null) {
            System.out.println("spring可用");
        }
    }
}
