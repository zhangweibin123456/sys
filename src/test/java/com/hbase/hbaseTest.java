package com.hbase;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:hbase/hbase-context.xml" })
public class hbaseTest {

	private Logger log = LoggerFactory.getLogger(getClass());



	@Test
	public void userRepositoryTest() {
		
		
		

System.out.println("2323");
	}



}
