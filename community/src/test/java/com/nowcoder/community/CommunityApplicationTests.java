package com.nowcoder.community;

import com.nowcoder.community.dao.Alpha;
import com.nowcoder.community.service.AlphaService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)//得到配置类
class CommunityApplicationTests implements ApplicationContextAware {


    private ApplicationContext applicationContext;
	@Autowired
	private SimpleDateFormat simpleDateFormat;
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
	@Test
	public void test(){
		System.out.println(applicationContext);
		Alpha alpha = applicationContext.getBean(Alpha.class);
		System.out.println(alpha.select());
		//获取特定的bean
		Alpha a = applicationContext.getBean("one",Alpha.class);
		System.out.println(alpha.select());

	}
	@Test
	public  void AlphaServiceTest(){
		AlphaService ser = applicationContext.getBean(AlphaService.class);
		System.out.println(ser);
		AlphaService ser2 = applicationContext.getBean(AlphaService.class);
		System.out.println(ser2);
	}
	@Test
	public void ConfigBeanTest(){

		System.out.println(simpleDateFormat.format(new Date()));
	}

}
