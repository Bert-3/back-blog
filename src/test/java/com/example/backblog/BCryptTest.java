package com.example.backblog;

import com.example.backblog.util.BCryptPasswordUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BCryptTest {

    @Autowired
    private BCryptPasswordUtil bCryptPasswordUtil;

    @Test
    public void testBCrypt() {
        String password = "123456";
        String hashedPassword = bCryptPasswordUtil.encode(password);
        System.out.println("hashedPassword = " + hashedPassword);
        System.out.println(bCryptPasswordUtil.matches(password, hashedPassword));
    }
}
