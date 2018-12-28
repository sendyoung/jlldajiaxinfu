package jll.pdf.service.impl;

import com.lowagie.text.Font;
import com.lowagie.text.pdf.BaseFont;

public class FontUtil {

	public static Font getFont(String font) throws Exception {
		// 添加中文字体
		BaseFont bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
		// 设置字体样式
		
		//新版本信用报告字体设置
		Font bigTitleFont = new Font(bfChinese, 36, Font.BOLD); //大标题
		Font abstractTitleFont = new Font(bfChinese, 22, Font.BOLD);//摘要标题 
		Font abstractTextFont = new Font(bfChinese, 16, Font.BOLD);//摘要内容
		Font firstTitleFont = new Font(bfChinese, 26, Font.BOLD);//一级标题
		Font secondTitleFont = new Font(bfChinese, 18, Font.BOLD);//二级标题
		Font thirdTitleFont = new Font(bfChinese, 15, Font.BOLD);//三级标题
		Font fourthTitleFont = new Font(bfChinese, 14, Font.BOLD);//四级标题
		Font thirdTextFont = new Font(bfChinese, 15, Font.NORMAL);//三级内容
		Font fourthTextFont = new Font(bfChinese, 14, Font.NORMAL);//四级内容
		Font textFont = new Font(bfChinese, 11, Font.NORMAL);//正常字号
		
		Font littleFourthBoldFont = new Font(bfChinese, 12, Font.BOLD);//小四  加粗
		Font littleFourthFont = new Font(bfChinese, 12, Font.NORMAL);//小四正常
		//以下两个字以后要换微软雅黑
		Font boldTableFont = new Font(bfChinese, 11, Font.BOLD);//表格文字
		Font tableFont = new Font(bfChinese, 11, Font.NORMAL);//表格内容
		
		if(font.equals("bigTitleFont")) {
			return bigTitleFont;
		}else if(font.equals("abstractTitleFont")){
			return abstractTitleFont;
		}else if(font.equals("abstractTextFont")){
			return abstractTextFont;
		}else if(font.equals("firstTitleFont")){
			return firstTitleFont;
		}else if(font.equals("secondTitleFont")){
			return secondTitleFont;
		}else if (font.equals("thirdTitleFont")) {
			return thirdTitleFont;
		}else if (font.equals("fourthTitleFont")) {
			return fourthTitleFont;
		}else if (font.equals("thirdTextFont")) {
			return thirdTextFont;
		}else if (font.equals("fourthTextFont")) {
			return fourthTextFont;
		}else if(font.equals("boldTableFont")) {
			return boldTableFont;
		}else if(font.equals("tableFont")) {
			return tableFont;
		}else if(font.equals("littleFourthBoldFont")) {
			return littleFourthBoldFont;
		}else if(font.equals("littleFourthFont")) {
			return littleFourthFont;
		}else {
			return textFont;
		}
		
		

	}
	}
