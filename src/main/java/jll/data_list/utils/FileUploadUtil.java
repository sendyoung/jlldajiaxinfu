package jll.data_list.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

/**
 * 图片上传
 * */
public class FileUploadUtil {
	public static String imageUpload(MultipartFile file,String path,String filename){
		//如果文件不为空，写入上传路径
	    if(!file.isEmpty()) {
	        //上传文件路径path
	        //上传文件名
	        File filepath = new File(path,filename);
	        //判断路径是否存在，如果不存在就创建一个
	        if (!filepath.getParentFile().exists()) { 
	            filepath.getParentFile().mkdirs();
	        }
	        //将上传文件保存到一个目标文件当中
	        try {
				file.transferTo(new File(path + File.separator + filename));
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        return "success";
	    } else {
	    	return "error";
	    }
	} 
}
