package com.toec;

import com.toec.config.MsConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@SpringBootTest
@Import({MsConfig.class})
public class ConfigurationTest {


    @Autowired
    private String msg;

    @Test
    public void testConfiguration(){
        System.out.println(msg);
    }
}
