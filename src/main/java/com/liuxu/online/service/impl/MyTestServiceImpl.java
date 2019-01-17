package com.liuxu.online.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.liuxu.online.entity.MyScore;
import com.liuxu.online.entity.MyTest;
import com.liuxu.online.mapper.bigData.MyTestMapper;
import com.liuxu.online.service.IMyTestService;

import lombok.extern.slf4j.Slf4j;


/**
 * 
 * @author lishouxu-ds
 *
 */
@Slf4j
@Service
public class MyTestServiceImpl extends ServiceImpl<MyTestMapper, MyTest> implements IMyTestService {

	@Autowired
	MyTestMapper myTestMapper;

	public boolean insertTest(MyTest test) throws Exception {
        this.insert(test);
		return true;
	}

	public List<MyTest> selectTest() {
		List<MyTest> list=myTestMapper.selectByDateRange();
		log.info("doSNSLogin-URLEncoder  list：{} ,list.ize:{}",list,list.size());
		return null;
	}

	public List<MyScore> selectMyScore(){
		return myTestMapper.selectMyScore();
	}
	
	public List<MyScore> selectMyScoreById(Long testId) {
		
		return myTestMapper.selectMyScoreById(testId);
	}

	public Page<MyTest> getPageNotice(Page<MyTest> page) {
		page.setRecords(myTestMapper.selectNoticePage(page));
		return page;
	}

	

}
