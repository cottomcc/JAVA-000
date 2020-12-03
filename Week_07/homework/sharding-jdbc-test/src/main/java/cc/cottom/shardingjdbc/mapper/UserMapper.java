package cc.cottom.shardingjdbc.mapper;

import cc.cottom.shardingjdbc.entities.User;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface UserMapper {
    @Select("select id, username, password, nickname, realname, face, mobile, email, sex, birthday, created_at, updated_at  from users where id=#{id}")
    User findUserById(@Param("id") String id);

    @Insert("INSERT into users(id, username, password, nickname, realname, face) VALUES(#{id}, #{username}, #{password}, #{nickname}, #{realname}, #{face})")
    void insertUser(User user);

    @Delete("DELETE FROM users WHERE id =#{id}")
    void deleteUser(@Param("id") String id);

    List<User> queryUsersByName(String username);
}
