package mybatis.read;

import mybatis.read.config.AppConfig;
import mybatis.read.mapper.UserMapper;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author gaoxx gaoxx@fxiaoke.com
 * @ClassName: Test
 * @Description: Test
 * @datetime 2019/4/25 19:36
 * @Version 1.0
 */
public class Test {

    private final UserMapper userMapper;

    public Test(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public String doSomeBusinessStuff(Integer userId) {
        return this.userMapper.getUser(userId);
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext
                = new AnnotationConfigApplicationContext(AppConfig.class);
        applicationContext.register();
        applicationContext.refresh();

        Test test = new Test(applicationContext.getBean(UserMapper.class));
        test.doSomeBusinessStuff(1);
    }
}
