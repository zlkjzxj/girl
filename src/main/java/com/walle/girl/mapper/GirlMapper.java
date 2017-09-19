package com.walle.girl.mapper;

import com.walle.girl.entity.Girl;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface GirlMapper {
    @Select("select * from girl where id = #{id}")
    public Girl findGirl(int id);

    @Select("select * from girl")
    public List<Girl> getGirlList();

    @Insert("insert into girl(name,cupSize,age) values(#{name},#{cupSize},#{age})")
    @Options(useGeneratedKeys=true,keyColumn="id",keyProperty="id")//设置id自增长
    public void insertAGirl(Girl girl);

    @Insert("update girl set name = #{name},cupSize=#{cupSize},age=#{age} where id = #{id}")
    public void updateAGirl(Girl girl);
    @Insert("delete from girl where id = #{id}")
    public void deleteAGirl(int id);
}
