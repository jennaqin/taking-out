package com.keshe.luntan.service.Imp;

import com.keshe.luntan.entity.ResponseBean;
import com.keshe.luntan.service.ResourceService;
import com.keshe.luntan.utils.MdzwUtils;
import com.keshe.luntan.utils.ResultEnum;
import com.keshe.luntan.utils.exception.ServiceException;
import com.keshe.luntan.utils.manager.SmsManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Service
@Transactional
public class ResourceServiceImp implements ResourceService {
	
	// 上传文件
	@Override
	public ResponseBean uploadFile(MultipartFile file) {
		String prename = UUID.randomUUID().toString().replace("-", "");
		String filename = null;
		try {
			filename = MdzwUtils.cacheFile(prename, file);
		} catch (IOException e) {
			throw new ServiceException(ResultEnum.DISKIO_EROOR.getResultMsg(),e);
		}
		return new ResponseBean(ResultEnum.RESULT_SUCCESS.getResultMsg(), filename);
	}
	//获取手机验证码
	@Override
	public ResponseBean getPhoneCode(String phonenumber) {
		//ResultEnum resultMessage = ;
		String keyname = phonenumber;

		if (SmsManager.tryAddSms(keyname)) {
			throw new ServiceException(ResultEnum.SEND_2FAST.getResultMsg());
		} else {
			String code = "520111";
			//SendSmsResponse sendresult = null;
//			try {
//				//调用接口
//				sendresult = SmsUtils.sendSms(phonenumber,code);
				SmsManager.addSms(phonenumber,code);
//			} catch (ClientException e) {
//				throw new ServiceException(ResultEnum.SEND_FAIL.getResultMsg(),e);
//			}
//			if("OK".equals(sendresult.getMessage())) {
				return new ResponseBean(ResultEnum.RESULT_SUCCESS.getResultMsg(),code);
//			}else {
//				throw new ServiceException(ResultEnum.SEND_FAIL.getResultMsg());
//			}
		}
	}

	//生成手机验证码
	private String createPhonecode() {
		//生成验证码
		StringBuilder code = new StringBuilder();
		for(int i = 0; i < 6; i++) {
			int temp = (int) (Math.random()*10);
			code.append(temp);
		}
		return code.toString();
	}

	//删除文件
	@Override
	public ResponseBean delateFile(String fileName) {
		MdzwUtils.deleteFile(fileName, "D://image/");
		return new ResponseBean(ResultEnum.RESULT_SUCCESS.getResultMsg());
	}
}
