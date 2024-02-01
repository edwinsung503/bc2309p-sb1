package com.vtxlab.bootcampbeanconfig;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest // A test env. -> Spring Context contains Bean area,you only need to concern yr bean (Controller/Service)
//ensure all beans are avaiable in this env.
class BootcampBeanConfigApplicationTests {

	@Test // check all beans dependenies before creating the beans
	void contextLoads() {
	}
	

}
