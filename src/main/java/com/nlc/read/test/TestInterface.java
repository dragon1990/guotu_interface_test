/**  
 * @Title: TestInterface.java
 * @Package com.nlc.read.test
 * @Description: 
 * @author 王金龙  
 * @date 2016年8月18日 下午2:12:31
 * @version V1.0  
 */
package com.nlc.read.test;

import com.alibaba.fastjson.JSON;
import com.nlc.read.common.constant.Constants;
import com.nlc.read.common.dto.ReqValue;
import com.nlc.read.common.util.DESUtil;
import com.nlc.read.common.util.MD5Util;
import com.nlc.read.test.util.HttpUtil;
import org.junit.Test;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: TestInterface
 * @Description:
 * @author 王金龙
 * @date 2016年8月18日 下午2:12:31
 *
 */
public class TestInterface {

	private static final String url = "http://localhost:8080/nlc_read_home/service.do";
//	private static final String url = "http://122.224.218.58:8088/nlc_read_home/service.do";

	private static HashMap<String, String> datas = new HashMap<String, String>();
	private Long timeStamp = System.currentTimeMillis();


	@SuppressWarnings("deprecation")
	public void excute(String cmd) {
		ReqValue reqValue = new ReqValue();
		reqValue.setSiteId(1L);
		reqValue.setUserId(1L);
		reqValue.setFromSource(3);
		reqValue.setOsType(5);
		reqValue.setVersion("1.0.1");
		reqValue.setVersionCode(10003);
		//reqValue.setBdChannelId("baidu");

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

	@Test
	public void qryRecommendSysList() {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("timeStamp", timeStamp);
		paramMap.put("pageSize", 10);
		paramMap.put("pageNum", 1);
		String t1 = JSON.toJSONString(paramMap);
		datas.put("qryRecommendSysList", DESUtil.encrypt(t1, Constants.WEB_PUBLIC_DES_KEY));
		String cmd = "qryRecommendSysList";
		this.excute(cmd);
	}

	@Test
	public void qryRecommendNewList() {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("timeStamp", timeStamp);
		paramMap.put("pageSize", 10);
		paramMap.put("pageNum", 1);
		String t1 = JSON.toJSONString(paramMap);
		datas.put("qryRecommendNewList", DESUtil.encrypt(t1, Constants.WEB_PUBLIC_DES_KEY));
		String cmd = "qryRecommendNewList";
		this.excute(cmd);
	}
	@Test
	public void qryRecommendHotList() {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("timeStamp", timeStamp);
		paramMap.put("pageSize", 10);
		paramMap.put("pageNum", 1);
		String t1 = JSON.toJSONString(paramMap);
		datas.put("qryRecommendHotList", DESUtil.encrypt(t1, Constants.WEB_PUBLIC_DES_KEY));
		String cmd = "qryRecommendHotList";
		this.excute(cmd);
	}
	@Test
	public void addShare() {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("timeStamp", timeStamp);
		paramMap.put("resType", 1);
		paramMap.put("resId", 2);
		paramMap.put("shareChannel",3);
		paramMap.put("title", "title");
		paramMap.put("content", "content");
		paramMap.put("linkUrl","linkUrl");
		paramMap.put("qrLinkUrl","qrLinkUrl");
		paramMap.put("picUrl", "picUrl");
		//paramMap.put("uaInfo",MD5Util.digest("dragon").toLowerCase());
		String t1 = JSON.toJSONString(paramMap);
		datas.put("addShare", DESUtil.encrypt(t1, Constants.WEB_PUBLIC_DES_KEY));
		String cmd = "addShare";
		this.excute(cmd);
	}
	@Test
	public void qryTopicGroupResList() {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("timeStamp", timeStamp);
		paramMap.put("groupId", 1);
		paramMap.put("pageSize", 10);
		paramMap.put("pageNum",1);
		//paramMap.put("uaInfo",MD5Util.digest("dragon").toLowerCase());
		String t1 = JSON.toJSONString(paramMap);
		datas.put("qryTopicGroupResList", DESUtil.encrypt(t1, Constants.WEB_PUBLIC_DES_KEY));
		String cmd = "qryTopicGroupResList";
		this.excute(cmd);
	}
	@Test
	public void qryTopicGroupList() {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("timeStamp", timeStamp);
		paramMap.put("topicId", 1);
		//paramMap.put("uaInfo",MD5Util.digest("dragon").toLowerCase());
		String t1 = JSON.toJSONString(paramMap);
		datas.put("qryTopicGroupList", DESUtil.encrypt(t1, Constants.WEB_PUBLIC_DES_KEY));
		String cmd = "qryTopicGroupList";
		this.excute(cmd);
	}
	@Test
	public void qryTopicList() {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("timeStamp", timeStamp);
		paramMap.put("pageSize", 10);
		paramMap.put("pageNum",1);
		//paramMap.put("uaInfo",MD5Util.digest("dragon").toLowerCase());
		String t1 = JSON.toJSONString(paramMap);
		datas.put("qryTopicList", DESUtil.encrypt(t1, Constants.WEB_PUBLIC_DES_KEY));
		String cmd = "qryTopicList";
		this.excute(cmd);
	}
	@Test
	public void qrySiteAdvertList() {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("timeStamp", timeStamp);
		paramMap.put("pageSize", 10);
		paramMap.put("pageNum",1);
		//paramMap.put("uaInfo",MD5Util.digest("dragon").toLowerCase());
		String t1 = JSON.toJSONString(paramMap);
		datas.put("qrySiteAdvertList", DESUtil.encrypt(t1, Constants.WEB_PUBLIC_DES_KEY));
		String cmd = "qrySiteAdvertList";
		this.excute(cmd);
	}

	@Test
	public void addReadRecord() {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("timeStamp", timeStamp);
		paramMap.put("resType",1);
		paramMap.put("resId",3);
		paramMap.put("chapterId",5);
		paramMap.put("chapterName","测试章44节");
		paramMap.put("isOffline",2);
		String t1 = JSON.toJSONString(paramMap);
		datas.put("addReadRecord", DESUtil.encrypt(t1, Constants.WEB_PUBLIC_DES_KEY));
		String cmd = "addReadRecord";
		this.excute(cmd);
	}
	@Test
	public void qrySiteInfoList() {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("timeStamp", timeStamp);
		paramMap.put("name","%");
		String t1 = JSON.toJSONString(paramMap);
		datas.put("qrySiteInfoList", DESUtil.encrypt(t1, Constants.WEB_PUBLIC_DES_KEY));
		String cmd = "qrySiteInfoList";
		this.excute(cmd);
	}
	@Test
	public void qryMyReadRecord() {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("timeStamp", timeStamp);
		paramMap.put("pageSize", 10);
		paramMap.put("pageNum",1);
		//paramMap.put("uaInfo",MD5Util.digest("dragon").toLowerCase());
		String t1 = JSON.toJSONString(paramMap);
		datas.put("qryMyReadRecord", DESUtil.encrypt(t1, Constants.WEB_PUBLIC_DES_KEY));
		String cmd = "qryMyReadRecord";
		this.excute(cmd);
	}

	@Test
	public void delMyBookrack() {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("timeStamp", timeStamp);
		paramMap.put("bookrackId", 41);
		//paramMap.put("uaInfo",MD5Util.digest("dragon").toLowerCase());
		String t1 = JSON.toJSONString(paramMap);
		datas.put("delMyBookrack", DESUtil.encrypt(t1, Constants.WEB_PUBLIC_DES_KEY));
		String cmd = "delMyBookrack";
		this.excute(cmd);
	}


	@Test
	public void qryMyBookrack() {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("timeStamp", timeStamp);
		paramMap.put("pageSize", 10);
		paramMap.put("pageNum",1);
		paramMap.put("uaInfo",MD5Util.digest("dragon").toLowerCase());
		String t1 = JSON.toJSONString(paramMap);
		datas.put("qryMyBookrack", DESUtil.encrypt(t1, Constants.WEB_PUBLIC_DES_KEY));
		String cmd = "qryMyBookrack";
		this.excute(cmd);
	}
	@Test
	public void delMyCollect() {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("timeStamp", timeStamp);
		paramMap.put("collectId", 5);
		String t1 = JSON.toJSONString(paramMap);
		datas.put("delMyCollect", DESUtil.encrypt(t1, Constants.WEB_PUBLIC_DES_KEY));
		String cmd = "delMyCollect";
		this.excute(cmd);
	}

	@Test
	public void qryMyCollect() {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("timeStamp", timeStamp);
		paramMap.put("pageSize", 10);
		paramMap.put("pageNum",1);
		String t1 = JSON.toJSONString(paramMap);
		datas.put("qryMyCollect", DESUtil.encrypt(t1, Constants.WEB_PUBLIC_DES_KEY));
		String cmd = "qryMyCollect";
		this.excute(cmd);
	}

	@Test
	public void setBookrack() {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("timeStamp", timeStamp);
		paramMap.put("userId", 1);
		paramMap.put("resType", 2);
		paramMap.put("resId", 4);
		paramMap.put("chapterId",1);
		paramMap.put("chapterName","dd");
		paramMap.put("status",1);
		String t1 = JSON.toJSONString(paramMap);
		datas.put("setBookrack", DESUtil.encrypt(t1, Constants.WEB_PUBLIC_DES_KEY));
		String cmd = "setBookrack";
		this.excute(cmd);
	}
	@Test
	public void qryBookrack() {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("timeStamp", timeStamp);
		paramMap.put("userId", 1);
		paramMap.put("resType", 2);
		paramMap.put("resId",4);
		String t1 = JSON.toJSONString(paramMap);
		datas.put("qryBookrack", DESUtil.encrypt(t1, Constants.WEB_PUBLIC_DES_KEY));
		String cmd = "qryBookrack";
		this.excute(cmd);
	}

	@Test
	public void qryCollect() {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("timeStamp", timeStamp);
		paramMap.put("userId", 1);
		paramMap.put("resType", 2);
		paramMap.put("resId", 3);
		String t1 = JSON.toJSONString(paramMap);
		datas.put("qryCollect", DESUtil.encrypt(t1, Constants.WEB_PUBLIC_DES_KEY));
		String cmd = "qryCollect";
		this.excute(cmd);
	}

	@Test
	public void setCollect() {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("timeStamp", timeStamp);
		paramMap.put("userId", 1);
		paramMap.put("resType", 2);
		paramMap.put("resId", 3);
		paramMap.put("status",1);
		String t1 = JSON.toJSONString(paramMap);
		datas.put("setCollect", DESUtil.encrypt(t1, Constants.WEB_PUBLIC_DES_KEY));
		String cmd = "setCollect";
		this.excute(cmd);
	}
	@Test
	public void qryUgcInfo() {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("timeStamp", timeStamp);
		paramMap.put("siteId", 1);
		paramMap.put("dataId",76);
		paramMap.put("dataType",1);
		String t1 = JSON.toJSONString(paramMap);
		datas.put("qryUgcInfo", DESUtil.encrypt(t1, Constants.WEB_PUBLIC_DES_KEY));
		String cmd = "qryUgcInfo";
		this.excute(cmd);
	}
	@Test
	public void delComment() {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("timeStamp", timeStamp);
		paramMap.put("commentId", 10);
		String t1 = JSON.toJSONString(paramMap);
		datas.put("delComment", DESUtil.encrypt(t1, Constants.WEB_PUBLIC_DES_KEY));
		String cmd = "delComment";
		this.excute(cmd);
	}

	@Test
	public void qryReadUserInfo() {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("timeStamp", timeStamp);
		paramMap.put("userId", 1);
		String t1 = JSON.toJSONString(paramMap);
		datas.put("qryReadUserInfo", DESUtil.encrypt(t1, Constants.WEB_PUBLIC_DES_KEY));
		String cmd = "qryReadUserInfo";
		this.excute(cmd);
	}
	@Test
	public void qryMyFeedbackList() {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("timeStamp", timeStamp);
		paramMap.put("userId", 1);
		paramMap.put("pageSize", 10);
		paramMap.put("pageNum",1);
		String t1 = JSON.toJSONString(paramMap);
		datas.put("qryMyFeedbackList", DESUtil.encrypt(t1, Constants.WEB_PUBLIC_DES_KEY));
		String cmd = "qryMyFeedbackList";
		this.excute(cmd);
	}
	@Test
	public void addFeedback() {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("timeStamp", timeStamp);
		paramMap.put("userId", 1);
		paramMap.put("type", 0);
		paramMap.put("content","测试留言");
		paramMap.put("attachInfos","attachInfos");
		String t1 = JSON.toJSONString(paramMap);
		datas.put("addFeedback", DESUtil.encrypt(t1, Constants.WEB_PUBLIC_DES_KEY));
		String cmd = "addFeedback";
		this.excute(cmd);
	}
	@Test
	public void addComment() {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("timeStamp", timeStamp);
		paramMap.put("resType", 1);
		paramMap.put("resId", 3);
		paramMap.put("userId",1);
		paramMap.put("content","asdaswwwwwwd");
		String t1 = JSON.toJSONString(paramMap);
		datas.put("addComment", DESUtil.encrypt(t1, Constants.WEB_PUBLIC_DES_KEY));
		String cmd = "addComment";
		this.excute(cmd);
	}
	@Test
	public void qryCommentList() {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("timeStamp", timeStamp);
		paramMap.put("resType", 1);
		paramMap.put("resId", 4);
		paramMap.put("pageSize", 10);
		paramMap.put("pageNum",1);
		String t1 = JSON.toJSONString(paramMap);
		datas.put("qryCommentList", DESUtil.encrypt(t1, Constants.WEB_PUBLIC_DES_KEY));
		String cmd = "qryCommentList";
		this.excute(cmd);
	}

	@Test
	public void setCommendFlag() {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("timeStamp", timeStamp);
		paramMap.put("resType", 1);
		paramMap.put("resId", 3);
		paramMap.put("userId", 4);
		paramMap.put("flag",1);
		String t1 = JSON.toJSONString(paramMap);
		datas.put("setCommendFlag", DESUtil.encrypt(t1, Constants.WEB_PUBLIC_DES_KEY));
		String cmd = "setCommendFlag";
		this.excute(cmd);
	}

	@Test
	public void qryCommendNum() {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("timeStamp", timeStamp);
		paramMap.put("resType", 1);
		paramMap.put("resId", 4);
		paramMap.put("userId", 1);
		String t1 = JSON.toJSONString(paramMap);
		datas.put("qryCommendNum", DESUtil.encrypt(t1, Constants.WEB_PUBLIC_DES_KEY));
		String cmd = "qryCommendNum";
		this.excute(cmd);
	}

	@Test
	public void qryPoetryList() {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("timeStamp", timeStamp);
		paramMap.put("yearValue", 2016);
		paramMap.put("monthValue", 8);
		paramMap.put("pageSize", 10);
		paramMap.put("pageNum", 1);
		String t1 = JSON.toJSONString(paramMap);
		datas.put("qryPoetryList", DESUtil.encrypt(t1, Constants.WEB_PUBLIC_DES_KEY));
		String cmd = "qryPoetryList";
		this.excute(cmd);
	}
	@Test
	public void qryPoetryDate() {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("timeStamp", timeStamp);
		String t1 = JSON.toJSONString(paramMap);
		datas.put("qryPoetryDate", DESUtil.encrypt(t1, Constants.WEB_PUBLIC_DES_KEY));
		String cmd = "qryPoetryDate";
		this.excute(cmd);
	}

	@Test
	public void qryPoetry() {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("timeStamp", timeStamp);
		String t1 = JSON.toJSONString(paramMap);
		datas.put("qryPoetry", DESUtil.encrypt(t1, Constants.WEB_PUBLIC_DES_KEY));
		String cmd = "qryPoetry";
		this.excute(cmd);
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
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("timeStamp", timeStamp);
		String t1 = JSON.toJSONString(paramMap);
		datas.put("qrySiteInfo", DESUtil.encrypt(t1, Constants.WEB_PUBLIC_DES_KEY));
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
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("timeStamp", timeStamp);
		paramMap.put("isDiscoveryShow",1);
		String t1 = JSON.toJSONString(paramMap);
		datas.put("qrySiteNavList", DESUtil.encrypt(t1, Constants.WEB_PUBLIC_DES_KEY));
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
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("timeStamp", timeStamp);
		paramMap.put("navRelationId", 1);
		String t1 = JSON.toJSONString(paramMap);
		datas.put("qrySiteColumnList", DESUtil.encrypt(t1, Constants.WEB_PUBLIC_DES_KEY));
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
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("timeStamp", timeStamp);
		paramMap.put("columnId", 1);
		paramMap.put("pageSize", 100);
		paramMap.put("pageNum", 1);
		String t1 = JSON.toJSONString(paramMap);
		datas.put("qryColumnResList", DESUtil.encrypt(t1, Constants.WEB_PUBLIC_DES_KEY));
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

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("timeStamp", timeStamp);
		paramMap.put("msgType", 2);
		paramMap.put("pageSize", 10);
		paramMap.put("pageNum", 1);
		String t2 = JSON.toJSONString(paramMap);
		datas.put("qryMessageList", DESUtil.encrypt(t2, Constants.WEB_PUBLIC_DES_KEY));
		String cmd = "qryMessageList";
		this.excute(cmd);
	}

	
	/**
	 * 
	 * @Title: qryMessageDetailTest
	 * @Description: 获取公告明细
	 * @throws
	 */
	@Test
	public void qryMessageDetailTest() {

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("timeStamp", timeStamp);
		paramMap.put("msgId", 1);
		String t2 = JSON.toJSONString(paramMap);
		datas.put("qryMessageDetail", DESUtil.encrypt(t2, Constants.WEB_PUBLIC_DES_KEY));
		String cmd = "qryMessageDetail";
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

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("timeStamp", timeStamp);
		paramMap.put("navId", 1L);
		String t3 = JSON.toJSONString(paramMap);
		datas.put("qryBannerList", DESUtil.encrypt(t3, Constants.WEB_PUBLIC_DES_KEY));
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
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("timeStamp", timeStamp);
		String t7 = JSON.toJSONString(paramMap);
		datas.put("qryFriendLinkList", DESUtil.encrypt(t7, Constants.WEB_PUBLIC_DES_KEY));
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
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("timeStamp", timeStamp);
		paramMap.put("resourceId", 1L);
		String t21 = JSON.toJSONString(paramMap);
		datas.put("qryResourceInfo", DESUtil.encrypt(t21, Constants.WEB_PUBLIC_DES_KEY));
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
	public void qryChapterList1() {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("timeStamp", timeStamp);
		paramMap.put("resourceId", 6L);
		paramMap.put("pageSize", 5L);
		paramMap.put("pageNum", 1L);
		String t21 = JSON.toJSONString(paramMap);
		datas.put("qryChapterList", DESUtil.encrypt(t21, Constants.WEB_PUBLIC_DES_KEY));
		String cmd = "qryChapterList";
		this.excute(cmd);
	}

	/**
	 * 
	 * @Title: qryChapterList
	 * @Description: 获取章节列表 void
	 * @throws
	 */
	@Test
	public void qryChapterList2() {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("timeStamp", timeStamp);
		paramMap.put("resourceId", 6L);
		paramMap.put("pageSize", 5L);
		paramMap.put("pageNum", 2L);
		String t21 = JSON.toJSONString(paramMap);
		datas.put("qryChapterList", DESUtil.encrypt(t21, Constants.WEB_PUBLIC_DES_KEY));
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
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("timeStamp", timeStamp);
		paramMap.put("chapterId", 326L);
		String t21 = JSON.toJSONString(paramMap);
		datas.put("qryChapterDetails", DESUtil.encrypt(t21, Constants.WEB_PUBLIC_DES_KEY));
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
		datas.put("login", DESUtil.encrypt(t32, Constants.WEB_PUBLIC_DES_KEY));
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
		paramMap.put("account", "test0005");
		paramMap.put("phone", "13175286561");
		paramMap.put("name", "test0002");
		paramMap.put("identityCard", "330621199012264214");
		paramMap.put("pwd", "12345678");
		paramMap.put("confirmPwd", "12345678");
		paramMap.put("validateCode", "validateCode");
		String t32 = JSON.toJSONString(paramMap);
		datas.put("register", DESUtil.encrypt(t32, Constants.WEB_PUBLIC_DES_KEY));
		String cmd = "register";
		this.excute(cmd);

	}

	/**
	 * 
	 * @Title: qryMagInfoTest
	 * @Description:获取期刊资源
	 *  void
	 * @throws
	 */
	@Test
	public void qryMagInfoTest() {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("timeStamp", timeStamp);
		paramMap.put("magId", 5279);
		String t41 = JSON.toJSONString(paramMap);
		datas.put("qryMagInfo", DESUtil.encrypt(t41, Constants.WEB_PUBLIC_DES_KEY));
		String cmd = "qryMagInfo";
		this.excute(cmd);
	}
	
	/**
	 * 
	* @Title: qryMagArticleListTest
	* @Description 获取期刊文章列表
	* void    
	* @throws
	 */
	@Test
	public void qryMagArticleListTest() {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("timeStamp", timeStamp);
		paramMap.put("magId", 5279);
		paramMap.put("pageNum", 1);
		paramMap.put("pageSize", 10);
		String t42 = JSON.toJSONString(paramMap);
		datas.put("qryMagArticleList", DESUtil.encrypt(t42, Constants.WEB_PUBLIC_DES_KEY));
		String cmd = "qryMagArticleList";
		this.excute(cmd);
	}
	
	@Test
	public void qryMagArticleDetailTest() {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("timeStamp", timeStamp);
		paramMap.put("articleId", 63579);
		String t42 = JSON.toJSONString(paramMap);
		datas.put("qryMagArticleDetail", DESUtil.encrypt(t42, Constants.WEB_PUBLIC_DES_KEY));
		String cmd = "qryMagArticleDetail";
		this.excute(cmd);
	}
	
	@Test
	public void qryCategoryListTest1() {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("timeStamp", timeStamp);
		paramMap.put("resourceType", 1L);
		String t42 = JSON.toJSONString(paramMap);
		datas.put("qryCategoryList", DESUtil.encrypt(t42, Constants.WEB_PUBLIC_DES_KEY));
		String cmd = "qryCategoryList";
		this.excute(cmd);
	}
	@Test
	public void qryCategoryListTest2() {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("timeStamp", timeStamp);
		paramMap.put("resourceType", 2L);
		String t42 = JSON.toJSONString(paramMap);
		datas.put("qryCategoryList", DESUtil.encrypt(t42, Constants.WEB_PUBLIC_DES_KEY));
		String cmd = "qryCategoryList";
		this.excute(cmd);
	}
}
