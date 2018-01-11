package com.hbase;


import java.util.List;
import java.util.Map;

import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.util.Bytes;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.hadoop.hbase.HbaseTemplate;
import org.springframework.data.hadoop.hbase.RowMapper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:hbase/hbase-context.xml" })
public class hbaseTest {

	private Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	private HbaseTemplate hbaseTemplate;
	
	private String tableName = "win_shophour";

	public static byte[] CF_INFO = Bytes.toBytes("cfInfo");

	private byte[] qSitekey = Bytes.toBytes("sitekey");
	

	@Test
	public void userRepositoryTest() {
		//Apple_00001P00153
		
//		List<WinShopHour> list = hbaseTemplate.find(tableName, "cfInfo", new RowMapper<WinShopHour>() {
//			@Override
//			public WinShopHour mapRow(Result result, int rowNum) throws Exception {
//				return new WinShopHour(Bytes.toString(result.getValue(CF_INFO, qSitekey)));
//			}
//		});
		// List<Map<String,Object>>  mapList1 =hbaseTemplate.find(tableName, null, null);
		
		

 //  System.out.println(list.size());
	}


	

}
