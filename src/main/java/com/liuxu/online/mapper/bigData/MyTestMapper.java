package com.liuxu.online.mapper.bigData;		

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.liuxu.online.entity.MyScore;
import com.liuxu.online.entity.MyTest;


/**
 * <p>
 * 发生单表 Mapper 接口
 * </p>
 *
 * @author likaile
 * @since 2018-07-30
 */
public interface MyTestMapper extends BaseMapper<MyTest> {

	@Select("select * from my_test ")
	List<MyTest> selectByDateRange();
	
	@Select("select * from my_score ")
	List<MyScore> selectMyScore(); 
	
	@Select("<script>  select * from my_score  <if test='testId!=null'> where  test_id=#{testId} </if>  </script>")
	List<MyScore> selectMyScoreById(@Param("testId") Long testId);
	
	@Select("select * from my_test ")
	List<MyTest> selectNoticePage(Pagination page);
	
	
}
