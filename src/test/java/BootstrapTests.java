import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import tech.sun.BootStrap;

/**
 * @program: springboot_tech
 * @description: 测试
 * @author: 孙东昊
 * @create: 2020-09-18 19:00
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BootStrap.class)
@ActiveProfiles("test")
public class BootstrapTests {

    @Test
    public void testMother() {
        System.out.println("good！！");
    }
}
