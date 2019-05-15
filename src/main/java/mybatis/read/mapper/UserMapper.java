package mybatis.read.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author gaoxx gxx@fxiaoke.com
 * @ClassName: UserMapper
 * @Description: TODO
 * @datetime 2019/4/25 19:43
 * @Version 1.0
 */
public interface UserMapper {
    @Select("SELECT userName FROM user WHERE id = #{userId}")
    String getUser(@Param("userId") Integer userId);
}
