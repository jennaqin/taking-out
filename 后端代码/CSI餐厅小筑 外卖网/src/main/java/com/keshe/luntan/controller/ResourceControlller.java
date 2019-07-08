package com.keshe.luntan.controller;

import com.keshe.luntan.entity.ResponseBean;
import com.keshe.luntan.service.ResourceService;
import com.keshe.luntan.utils.ResultEnum;
import com.keshe.luntan.utils.checker.MyStringChecker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/***
 * <h3>资源Controller</h3>
 * @author 燕富成
 */
@RestController
public class ResourceControlller {
	
	@Autowired
	private ResourceService rsservice;
	
	/***
	 * <p>上传文件</p>
	 * @param file
	 * @return bean
	 */
	@RequestMapping(value="/user/uploadfile",method=RequestMethod.POST)
	public ResponseBean uploadFile(MultipartFile file) {
		ResponseBean bean = null;
		if(file == null) {
			bean = new ResponseBean(ResultEnum.UPLOADFILE_ERROR.getResultMsg());
		}else {
			bean = rsservice.uploadFile(file);
		}
		return bean;
	}

	/***
	 * <p>删除文件</p>
	 * @param fileName
	 * @return bean
	 */
	@RequestMapping(value="/user/deletefile",method=RequestMethod.POST)
	public ResponseBean delateFile(String fileName) {
		ResponseBean bean = null;
		if(fileName == null) {
			bean = new ResponseBean(ResultEnum.UPLOADFILE_ERROR.getResultMsg());
		}else {
			bean = rsservice.delateFile(fileName);
		}
		return bean;
	}
	
	/***
	 * <p>获取手机验证码</p>
	 * @param userphone
	 * @return bean
	 */
	@RequestMapping("/getphonecode")
	public ResponseBean getphonecode(String userphone) {
		ResponseBean bean = null;
		if(!MyStringChecker.stringExtChecker(userphone, MyStringChecker.StringExtRule.PHONE_CHECKER)) {
			bean = new ResponseBean(ResultEnum.PHONE_ERROR.getResultMsg());
		}else {
			bean = rsservice.getPhoneCode(userphone);
		}
		return bean;
	}
}
