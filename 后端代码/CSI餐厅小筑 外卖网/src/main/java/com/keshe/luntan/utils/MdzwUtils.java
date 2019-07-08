package com.keshe.luntan.utils;

import com.keshe.luntan.utils.manager.LoginManager;
import com.keshe.luntan.utils.manager.UserStateManager;
import net.minidev.json.JSONObject;
import net.sf.json.JSONArray;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.*;

public class MdzwUtils {
	

	//下线一个用户
	public static void quitUser(int userid) {
		//删除用户登录信息
		LoginManager.DelLoginflag(userid);
		//删除用户权限副本
		UserStateManager.DelUserStateflag(userid);
	}
	//保存上传的图片
	public static String cacheFile(String name,MultipartFile file) throws IOException {
		// 获取文件名
		String oriName = file.getOriginalFilename();
		// 获取图片后缀
		String extName = oriName.substring(oriName.lastIndexOf("."));
		String filename = name + extName;
		// 开始上传保存到指定位置
		file.transferTo(new File("D://image/" + filename));
		return filename;
	}
	//从硬盘读取文件
	public static String readFile(String name, String location) throws IOException {
		File file = new File(location + name);
		FileInputStream in = new FileInputStream(file);
		String content = null;
		int size=in.available();
		byte[] buffer=new byte[size];
		in.read(buffer);
		content = new String(buffer);
		in.close();
		return content;
	}
	//存文件到硬盘
	public static void writeFile(String name, String content, String location) throws IOException {
		OutputStream out = new FileOutputStream(location + name);
		byte[] list = content.getBytes();
		out.write(list);
		out.close();
	}
	//从硬盘删文件
	public static void deleteFile(String name, String location) {
		File file = new File(location + name);
		// 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
		if (file.exists() && file.isFile()) {
			file.delete();
		}
	}

	
	//JSON转map
	public static Map<String, Object> parseJSON2Map(JSONObject json) {
        Map<String, Object> map = new HashMap<String, Object>();
        // 最外层解析
        for (Object k : json.keySet()) {
            Object v = json.get(k);
            // 如果内层还是数组的话，继续解析
            if (v instanceof JSONArray) {
                List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
                @SuppressWarnings("unchecked")
				Iterator<JSONObject> it = ((JSONArray) v).iterator();
                while (it.hasNext()) {
                    JSONObject json2 = it.next();
                    list.add(parseJSON2Map(json2));
                }
                map.put(k.toString(), list);
            } else {
                map.put(k.toString(), v);
            }
        }
        return map;
    }

}
