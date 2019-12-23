package spring.boot.core;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;
import spring.boot.core.service.UserService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class PagingSortingApplicationTests {

	@Autowired
	private UserService userService;


	@Test
	public void contextLoads() {

	}


}
