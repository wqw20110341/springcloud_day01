package com.toec;

import com.toec.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@SpringBootTest
class SqlApplicationTests {

    @Test
    void contextLoads(@Autowired JdbcTemplate jdbcTemplate) {
        String sql = "select * from tb1_book";
//        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
//        System.out.println(maps);
        RowMapper<Book> rm = new RowMapper<Book>() {
            @Override
            public Book mapRow(ResultSet resultSet, int rowNum) throws SQLException {
                Book book = new Book();
                book.setId(resultSet.getInt("id"));
                book.setName(resultSet.getString("name"));
                book.setType(resultSet.getString("type"));
                book.setDescription(resultSet.getString("description"));
                return book;
            }
        };
        List<Book> maps = jdbcTemplate.query(sql,rm);
        System.out.println(maps);
    }

    @Test
    void contextLoadSave(@Autowired JdbcTemplate jdbcTemplate) {
        String sql = "insert into tb1_book values(null,'springboot1','springboot2','springboot3')";
        jdbcTemplate.update(sql);
    }

    @Test
    void contextLoadSave2(@Autowired JdbcTemplate jdbcTemplate) {
        String sql = "insert into tbl_book values(1,'springboot1','springboot2','springboot3')";
        jdbcTemplate.update(sql);
    }


//    void contextEsFindAll(@Autowired ElasticsearchTemplate template){
//
//        template.query();
//    }





}
