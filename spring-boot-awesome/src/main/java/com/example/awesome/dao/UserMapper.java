package com.example.awesome.dao;

import org.apache.ibatis.annotations.*;

/**
 * Created by likang on 2019/3/12.
 */
@Mapper
public interface UserMapper {

    @Select("select count(*) from t_user where id=#{id}")
    Integer getUserById(Integer id);

    /** 返回自增ID*/
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    @Insert("insert into t_user(name,age)values(#{name},#{age})")
    void insertUser(User user);

    @Select("select * from t_user where ${column} = #{value}")
    User selectByColumn(@Param("column") String column,@Param("value") String value);

    /**这个例子展示了如何使用 @SelectKey 注解来在插入前读取数据库序列的值*/
    @Insert("insert into table3 (id, name) values(#{nameId}, #{name})")
    @SelectKey(statement="call next value for TestSequence", keyProperty="nameId", before=true, resultType=int.class)
    int insertTable3(User user);

    /**这个例子展示了如何使用 @SelectKey 注解来在插入后读取数据库自增列的值*/
    @Insert("insert into table2 (name) values(#{name})")
    @SelectKey(statement="call identity()", keyProperty="nameId", before=false, resultType=int.class)
    int insertTable2(User user);
}
