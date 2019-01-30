
package com.liuxu.online;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.baomidou.mybatisplus.plugins.Page;
import com.liuxu.online.entity.MyScore;
import com.liuxu.online.entity.MyTest;
import com.liuxu.online.service.IMyTestService;
import com.liuxu.online.util.SnowflakeIdWorker;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ServiceOrderApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableAutoConfiguration
public class MyTestA {
	@Autowired
	IMyTestService myTestService;
	@Autowired
	SnowflakeIdWorker snowflakeIdWorker;
	@Test
	public void selTest() {
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		myTestService.selectTest();
	}
	@Test
	public void insertTest(){
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		for(int i=10;i<30;i++){
			MyTest test=new MyTest();
			test.setId(snowflakeIdWorker.nextId());
			test.setAge(34L);
			test.setName("张飞"+i);
			try {
				System.out.println(myTestService.insert(test));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		
	}
	
	@Test
	public void updateTest(){
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		MyTest test=new MyTest();
		test.setId(534760541873377280L);
		test.setAge(100L);
		test.setName("张飞");
		try {
			System.out.println("***********************"+myTestService.updateById(test));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void delTest(){
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		try {
			System.out.println("***********************"+myTestService.deleteById(534760541873377280L));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void selectMyScore(){
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		List<MyScore> list=myTestService.selectMyScore();
		for(MyScore myScore:list){
			System.out.println(myScore.getId()+"************"+myScore.getTestId()+"***********"+myScore.getScore());
			
		}
	}
	
	@Test
	public void selectMyScoreById(){
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		List<MyScore> list=myTestService.selectMyScoreById(1L);
		for(MyScore myScore:list){
			System.out.println(myScore.getId()+"************"+myScore.getTestId()+"***********"+myScore.getScore());
			
		}
	}
	@Test
	public void selectPage(){
		//需要传入两个参数page（当前页数），limit（每页数量）
		Page<MyTest> page =new Page<MyTest>(1,10);
//		page.setSize(10);
//		page.setCurrent(1);
		page=myTestService.getPageNotice(page);
		for(MyTest myTest:page.getRecords()){
			System.out.println("********************"+myTest.getId()+"***"+myTest.getName()+"****"+myTest.getAge());
			
		}
	}
}
