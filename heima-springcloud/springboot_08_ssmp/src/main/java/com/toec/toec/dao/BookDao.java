package com.toec.toec.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.toec.toec.domain.Book;
import org.apache.ibatis.annotations.Mapper;

// 数据层
@Mapper
public interface BookDao  extends BaseMapper<Book> {
//    @Select("select * from tb1_book where id = #{id}")
//    public Book getById(Integer id);

}
