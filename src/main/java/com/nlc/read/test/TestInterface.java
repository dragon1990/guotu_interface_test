/**  
 * @Title: TestInterface.java
 * @Package com.nlc.read.test
 * @Description: 
 * @author 王金龙  
 * @date 2016年8月18日 下午2:12:31
 * @version V1.0  
 */
package com.nlc.read.test;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.nlc.read.common.constant.Constants;
import com.nlc.read.common.dto.ReqValue;
import com.nlc.read.common.util.DESUtil;
import com.nlc.read.common.util.MD5Util;
import com.nlc.read.test.util.HttpUtil;

/**
 * @ClassName: TestInterface
 * @Description:
 * @author 王金龙
 * @date 2016年8月18日 下午2:12:31
 *
 */
public class TestInterface {

	private static final String url = "http://localhost:8080/readhome/service.do";

	private static HashMap<String, String> datas = new HashMap<String, String>();
	private Long timeStamp = System.currentTimeMillis();

	@Before
	public void init() {

		Map qrySiteNavListMap = new HashMap<String, Object>();
		qrySiteNavListMap.put("timeStamp", timeStamp);
		String t4 = JSON.toJSONString(qrySiteNavListMap);
		datas.put("qrySiteNavList", DESUtil.encrypt(t4, Constants.PUBLIC_DES_KEY));

		Map qrySiteColumnListMap = new HashMap<String, Object>();
		qrySiteColumnListMap.put("timeStamp", timeStamp);
		qrySiteColumnListMap.put("navRelationId", 1L);
		String t5 = JSON.toJSONString(qrySiteColumnListMap);
		datas.put("qrySiteColumnList", DESUtil.encrypt(t5, Constants.PUBLIC_DES_KEY));

		Map qryColumnResListMap = new HashMap<String, Object>();
		qryColumnResListMap.put("timeStamp", timeStamp);
		qryColumnResListMap.put("columnId", 1);
		qryColumnResListMap.put("pageSize", 100L);
		qryColumnResListMap.put("pageNum", 1L);
		String t6 = JSON.toJSONString(qryColumnResListMap);
		datas.put("qryColumnResList", DESUtil.encrypt(t6, Constants.PUBLIC_DES_KEY));

	}

	public void excute(String cmd) {
		ReqValue reqValue = new ReqValue();
		reqValue.setSiteId(1L);
		reqValue.setUserId(10004L);
		reqValue.setFromSource(2);
		reqValue.setOsType(4);
		reqValue.setVersion("6");
		reqValue.setVersionCode(10003);
		reqValue.setBdChannelId("baidu");

		reqValue.setTimeStamp(timeStamp);
		reqValue.setData(datas.get(cmd));
		reqValue.setHashCode(MD5Util.digest(timeStamp + Constants.PUBLIC_MD5_KEY));
		String sendDataString = JSON.toJSONString(reqValue);
		System.out.println("请求命令为:" + cmd);
		System.out.println("请求参数value为:" + sendDataString);
		String result = HttpUtil.doPost(url, "cmd=" + cmd + "&value=" + URLEncoder.encode(sendDataString));
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("返回数据为：");
		System.out.println(result);

	}

	/**
	 * 获取站点信息
	 * 
	 * @Title: qrySiteInfo
	 * @Description: TODO void
	 * @throws
	 */
	@Test
	public void qrySiteInfo() {
		Map qrySiteInfoMap = new HashMap<String, Object>();
		qrySiteInfoMap.put("timeStamp", timeStamp);
		String t1 = JSON.toJSONString(qrySiteInfoMap);
		datas.put("qrySiteInfo", DESUtil.encrypt(t1, Constants.PUBLIC_DES_KEY));
		String cmd = "qrySiteInfo";
		this.excute(cmd);
	}

	/**
	 * 
	 * @Title: qrySiteNavList
	 * @Description: 获取站点导航 void
	 * @throws
	 */
	@Test
	public void qrySiteNavList() {
		Map qrySiteNavListMap = new HashMap<String, Object>();
		qrySiteNavListMap.put("timeStamp", timeStamp);
		String t1 = JSON.toJSONString(qrySiteNavListMap);
		datas.put("qrySiteNavList", DESUtil.encrypt(t1, Constants.PUBLIC_DES_KEY));
		String cmd = "qrySiteNavList";
		this.excute(cmd);
	}

	/**
	 * 
	 * @Title: qrySiteColumnList
	 * @Description: 获取站点栏目 void
	 * @throws
	 */
	@Test
	public void qrySiteColumnList() {
		Map qrySiteColumnListMap = new HashMap<String, Object>();
		qrySiteColumnListMap.put("timeStamp", timeStamp);
		String t1 = JSON.toJSONString(qrySiteColumnListMap);
		datas.put("qrySiteColumnList", DESUtil.encrypt(t1, Constants.PUBLIC_DES_KEY));
		String cmd = "qrySiteColumnList";
		this.excute(cmd);
	}

	/**
	 * 
	 * @Title: qryColumnResList
	 * @Description: 获取栏目资源 void
	 * @throws
	 */
	@Test
	public void qryColumnResList() {
		Map qryColumnResListMap = new HashMap<String, Object>();
		qryColumnResListMap.put("timeStamp", timeStamp);
		String t1 = JSON.toJSONString(qryColumnResListMap);
		datas.put("qryColumnResList", DESUtil.encrypt(t1, Constants.PUBLIC_DES_KEY));
		String cmd = "qryColumnResList";
		this.excute(cmd);
	}

	/**
	 * 
	 * @Title: qryMessageList
	 * @Description: 获取公告
	 * @throws
	 */
	@Test
	public void qryMessageList() {

		Map qryMessageListMap = new HashMap<String, Object>();
		qryMessageListMap.put("timeStamp", timeStamp);
		String t2 = JSON.toJSONString(qryMessageListMap);
		datas.put("qryMessageList", DESUtil.encrypt(t2, Constants.PUBLIC_DES_KEY));
		String cmd = "qryMessageList";
		this.excute(cmd);
	}

	/**
	 * 
	 * @Title: qryBannerList
	 * @Description:获取Banner
	 * @throws
	 */
	@Test
	public void qryBannerList() {

		Map qryBannerListMap = new HashMap<String, Object>();
		qryBannerListMap.put("timeStamp", timeStamp);
		qryBannerListMap.put("navId", 1L);
		String t3 = JSON.toJSONString(qryBannerListMap);
		datas.put("qryBannerList", DESUtil.encrypt(t3, Constants.PUBLIC_DES_KEY));
		String cmd = "qryBannerList";
		this.excute(cmd);
	}

	/**
	 * 
	 * @Title: qryFriendLinkList
	 * @Description: 获取友情链接 void
	 * @throws
	 */
	@Test
	public void qryFriendLinkList() {
		Map qryFriendLinkListMap = new HashMap<String, Object>();
		qryFriendLinkListMap.put("timeStamp", timeStamp);
		String t7 = JSON.toJSONString(qryFriendLinkListMap);
		datas.put("qryFriendLinkList", DESUtil.encrypt(t7, Constants.PUBLIC_DES_KEY));
		String cmd = "qryFriendLinkList";
		this.excute(cmd);
	}

	/**
	 * 
	 * @Title: qryResourceInfo
	 * @Description: 获取图书资源 void
	 * @throws
	 */
	@Test
	public void qryResourceInfo() {
		Map qryResourceInfoMap = new HashMap<String, Object>();
		qryResourceInfoMap.put("timeStamp", timeStamp);
		qryResourceInfoMap.put("resourceId", 1L);
		String t21 = JSON.toJSONString(qryResourceInfoMap);
		datas.put("qryResourceInfo", DESUtil.encrypt(t21, Constants.PUBLIC_DES_KEY));
		String cmd = "qryResourceInfo";
		this.excute(cmd);
	}

	/**
	 * 
	 * @Title: qryChapterList
	 * @Description: 获取章节列表 void
	 * @throws
	 */
	@Test
	public void qryChapterList() {
		Map qryChapterListMap = new HashMap<String, Object>();
		qryChapterListMap.put("timeStamp", timeStamp);
		qryChapterListMap.put("resourceId", 1L);
		qryChapterListMap.put("pageSize", 100L);
		qryChapterListMap.put("pageNum", 1L);
		String t21 = JSON.toJSONString(qryChapterListMap);
		datas.put("qryChapterList", DESUtil.encrypt(t21, Constants.PUBLIC_DES_KEY));
		String cmd = "qryChapterList";
		this.excute(cmd);
	}

	/**
	 * 
	 * @Title: qryChapterDetails
	 * @Description:获取章节内容 void
	 * @throws
	 */
	@Test
	public void qryChapterDetails() {
		Map qryChapterDetailsMap = new HashMap<String, Object>();
		qryChapterDetailsMap.put("timeStamp", timeStamp);
		qryChapterDetailsMap.put("chapterId", 239L);
		String t21 = JSON.toJSONString(qryChapterDetailsMap);
		datas.put("qryChapterDetails", DESUtil.encrypt(t21, Constants.PUBLIC_DES_KEY));
		String cmd = "qryChapterDetails";
		this.excute(cmd);
	}

	/**
	 * 
	 * @Title: loginTest
	 * @Description:登录 void
	 * @throws
	 */
	@Test
	public void loginTest() {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("timeStamp", timeStamp);
		paramMap.put("account", "test0002");
		paramMap.put("pwd", "12345678");
		paramMap.put("validateCode", "validateCode");
		String t32 = JSON.toJSONString(paramMap);
		datas.put("login", DESUtil.encrypt(t32, Constants.PUBLIC_DES_KEY));
		String cmd = "login";
		this.excute(cmd);
	}

	/**
	 * 
	 * @Title: registerTest
	 * @Description: 注册 void
	 * @throws
	 */
	@Test
	public void registerTest() {

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("timeStamp", timeStamp);
		paramMap.put("account", "test0002");
		paramMap.put("phone", "13175286561");
		paramMap.put("name", "test0002");
		paramMap.put("identityCard", "330621199012264234");
		paramMap.put("pwd", "12345678");
		paramMap.put("confirmPwd", "12345678");
		paramMap.put("validateCode", "validateCode");
		String t32 = JSON.toJSONString(paramMap);
		datas.put("register", DESUtil.encrypt(t32, Constants.PUBLIC_DES_KEY));
		String cmd = "register";
		this.excute(cmd);

	}

}
