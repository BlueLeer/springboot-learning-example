package demo.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class WebApplicationTests {


    /**
     * Redis的连接工厂,可以通过这个连接工厂获取连接
     */
    @Autowired
    RedisConnectionFactory redisConnectionFactory;

    /**
     * 使用redisConnectionFactory获取连接然后操作redis数据库需要每次将其转黄成byte数组,很不方便
     * 因此可以使用redis template(redis模板)来进行操作
     */
    @Autowired
    RedisTemplate<String, String> redisTemplate;


    /**
     * 使用Connection操作 key-value形式的数据
     */
    @Test
    public void factoryTest() {
        RedisConnection connection = redisConnectionFactory.getConnection();
        connection.set("name".getBytes(), "wangle".getBytes());
        System.out.println("-----" + connection.get("name".getBytes()));
    }

    /**
     * 操作 key-value形式的数据
     */
    @Test
    public void templateTest() {
//        redisTemplate.setConnectionFactory(redisConnectionFactory);
        // 操作key-value形式的数据
        redisTemplate.opsForValue().set("name2", "张三");
        String name2 = redisTemplate.opsForValue().get("name2");
        System.out.println("name2:" + name2);
    }

    /**
     * 操作列表
     */
    @Test
    public void templateTest2() {
        redisTemplate.opsForList().leftPush("ages", "20");
        redisTemplate.opsForList().leftPush("ages", "30");
        List<String> ages = redisTemplate.opsForList().range("ages", 0, 1);
        for (String s : ages) {
            System.out.println("----------" + s);
        }
    }


    @Test
    public void testRegex(){
        String regex = "(Java).*(Java)";
        String str = "JavajfdisfjJava";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        matcher.lookingAt();
        while (matcher.find()){
            System.out.println(matcher.group());
        }

    }

}
