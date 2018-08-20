package com.shensu.tool;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;

public class DeleteLocationImgHelper {

	public static void deleteLocationImg(String URL, HttpServletRequest request) {

		String requestUrl = request.getScheme() // 当前链接使用的协议
				+ "://" + request.getServerName()// 服务器地址
				+ "RegistCompanyIMG/";
		String qzz = request.getSession().getServletContext().getRealPath("/");
		qzz = qzz.replace(request.getContextPath().substring(1), "RegistCompanyIMG");
		String hz = URL.substring(requestUrl.length() + 1);
		String allUrl = qzz + hz;
		File targetFile = new File(allUrl);
		if (targetFile.exists()) {
			System.out.println("文件存在");
		} else {
			System.out.println("文件不存在");
		}

		if (targetFile.isDirectory()) { // 如果是 文件夹
			try {
				FileUtils.deleteDirectory(targetFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (targetFile.isFile()) {// 如果是文件
			targetFile.delete();
		}
	}
}
