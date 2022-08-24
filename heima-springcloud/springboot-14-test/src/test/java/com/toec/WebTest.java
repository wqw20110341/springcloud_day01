package com.toec;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.ContentResultMatchers;
import org.springframework.test.web.servlet.result.HeaderResultMatchers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.StatusResultMatchers;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
// 开启虚拟MVC调用
@AutoConfigureMockMvc
public class WebTest {

    @Test
    public void test(){
        System.out.println("------------------test----------------");
    }

    @Test
    public void testWeb(@Autowired MockMvc mvc) throws Exception {
        //  http://Localhost:8080/books/
        //  创建虚拟请求,当前访问/books
        MockHttpServletRequestBuilder  builder =  MockMvcRequestBuilders.get("/books");
        mvc.perform(builder);
    }

    @Test
    public void testStatus(@Autowired MockMvc mvc) throws Exception {
        //  http://Localhost:8080/books/
        //  创建虚拟请求,当前访问/books
        MockHttpServletRequestBuilder  builder =  MockMvcRequestBuilders.get("/books");
        ResultActions actions= mvc.perform(builder);

        // 设定预期值与真实值进行比较，成功测试通过，失败测试失败
        // 定义本次调用的预期值
        StatusResultMatchers status = MockMvcResultMatchers.status();
        //预计本次调用时成功，状态200
        ResultMatcher ok = status.isOk();
        System.out.println(ok);
        System.out.println(actions.andExpect(ok));
    }

    @Test
    public void testBody(@Autowired MockMvc mvc) throws Exception {
        //  http://Localhost:8080/books/
        //  创建虚拟请求,当前访问/books
        MockHttpServletRequestBuilder  builder =  MockMvcRequestBuilders.get("/books");
        ResultActions actions= mvc.perform(builder);

        // 设定预期值与真实值进行比较，成功测试通过，失败测试失败
        // 定义本次调用的预期值
        ContentResultMatchers content = MockMvcResultMatchers.content();
        //预计本次调用时成功，状态200
        ResultMatcher result = content.string("springboot");
//        System.out.println(ok);
        System.out.println(actions.andExpect(result));
    }


    @Test
    public void testJson(@Autowired MockMvc mvc) throws Exception {
        //  http://Localhost:8080/books/
        //  创建虚拟请求,当前访问/books
        MockHttpServletRequestBuilder  builder =  MockMvcRequestBuilders.get("/books");
        ResultActions actions= mvc.perform(builder);

        // 设定预期值与真实值进行比较，成功测试通过，失败测试失败
        // 定义本次调用的预期值
        ContentResultMatchers content = MockMvcResultMatchers.content();
        //预计本次调用时成功，状态200
        ResultMatcher result = content.json("{\"id\":12,\"name\":\"springboot2\",\"type\":\"spring\",\"description\":\"------------\"}");
//        System.out.println(ok);
        System.out.println(actions.andExpect(result));
    }

    @Test
    public void testContentType(@Autowired MockMvc mvc) throws Exception {
        //  http://Localhost:8080/books/
        //  创建虚拟请求,当前访问/books
        MockHttpServletRequestBuilder  builder =  MockMvcRequestBuilders.get("/books");
        ResultActions actions= mvc.perform(builder);

        // 设定预期值与真实值进行比较，成功测试通过，失败测试失败
        // 定义本次调用的预期值
        HeaderResultMatchers header = MockMvcResultMatchers.header();
        //预计本次调用时成功，状态200
        ResultMatcher result = header.string("Content-Type","application/json;charset=UTF-8");
//        System.out.println(ok);
        System.out.println(actions.andExpect(result));
    }
}
