package jll.pdf.service.impl;

import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfPTableEvent;
import com.lowagie.text.pdf.PdfWriter;
import jll.model.DetailsInformation;
import jll.utils.DateUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;

public class PDFUtil {
	/**
	 * 定义全局变量
	 */
	static Paragraph p;//段落
	static Phrase ph;//短语
	static PdfPCell cell;//单元格
	static PdfPTable table;//表格
	static Date date = new Date();
	//获取大写日期
	static String dateToCN = DateUtils.DateToCN(date);
	//获取数字日期
	static String dateToNum = DateUtils.DateToNum(date);
	//获取时分秒日期
	static String dateToHms = DateUtils.DateToHms(date);
	//获取年份
	static String dateToYear = DateUtils.DateToYear(date);
	/**
	 * 创建文档对象,并设置纸张,页眉等属性
	 * @param outPath
	 * @return
	 * @throws Exception
	 */
	public static Document createDoc(String outPath) throws Exception {
		// 设置纸张
		Rectangle rect = new Rectangle(PageSize.A4);
		// 创建文档实例
		Document doc = new Document(rect);
		// 设置字体样式
		Font textFont = FontUtil.getFont("textFont"); // 正常,红色
		// 创建输出流
		PdfWriter.getInstance(doc, new FileOutputStream(new File(outPath)));
		Image image = Image.getInstance("F:/idea_work/jlldajiaxingfu/target/jll-dajiaxinfu-1.0-SNAPSHOT/WEB-INF/classes/config/images/header(征信).png");
		image.scalePercent(40);
		p = new Paragraph();
		p.add(image);
		//HeaderFooter的第2个参数为非false时代表打印页码 页眉页脚中也可以加入图片，并非只能是文字
		HeaderFooter header = new HeaderFooter(p,false);
		// 设置是否有边框等
		header.setBorder(Rectangle.NO_BORDER);
		//0是靠左 1是居中 2是居右
		header.setAlignment(0);
		doc.setHeader(header);
		HeaderFooter footer=new HeaderFooter(new Phrase("-",textFont),new Phrase("-",textFont));  
		/** 
         * 0是靠左 
         * 1是居中 
         * 2是居右 
         */  
        footer.setAlignment(1);  
        footer.setBorder(Rectangle.NO_BORDER);  
        doc.setFooter(footer); 
        
		return doc;
	}
	/**
	 * 创建空白行,写入提示信息
	 * */
	public static void createBlankLine(String content,int cols) throws Exception {
		Font tableFont = FontUtil.getFont("tableFont");// 表格内容
		cell = new PdfPCell(new Phrase("暂未查询到"+content+"相关信息，不排除存在时间相对滞后或信息公开来源尚未公示的信息。仅供客户参考。", tableFont));
		cell.setColspan(cols);
		cell.setMinimumHeight(30); // 设置单元格高度
		cell.setUseAscender(true); // 设置可以居中
		cell.setHorizontalAlignment(Cell.ALIGN_CENTER); // 设置水平居中
		cell.setVerticalAlignment(Cell.ALIGN_MIDDLE); // 设置垂直居中
		table.addCell(cell);
	}
	
	/**
	 * 封面内容
	 * @param doc
	 * @throws Exception
	 */
	// 封面内容
	public static void createCover(Document doc,String num,DetailsInformation dic) throws Exception {

		// 设置字体样式
		Font bigTitleFont = FontUtil.getFont("bigTitleFont");// 大标题
		Font fourthTextFont = FontUtil.getFont("fourthTextFont");// 四号内容
		Font thirdTextFont = FontUtil.getFont("thirdTextFont");// 小三内容
		
		p = new Paragraph("企  业  信  用  报  告", bigTitleFont);
		p.setLeading(200);
		p.setSpacingAfter(100);
		p.setAlignment(Element.ALIGN_CENTER);
		doc.add(p);
		
		p = new Paragraph(" ", bigTitleFont);
		p.setSpacingAfter(100);
		p.setAlignment(Element.ALIGN_CENTER);
		doc.add(p);

		// 创建一个有2列的表格
		table = new PdfPTable(2);
		table.setTotalWidth(new float[] { 80, 200 }); // 设置列宽
		table.setLockedWidth(true); // 锁定列宽
		
		
		cell = new PdfPCell(new Phrase("报告名称：", fourthTextFont));
		cell.setMinimumHeight(15); // 设置单元格高度
		cell.setUseAscender(true); // 设置可以居中
		cell.setRowspan(2);
		cell.setBorder(0);
		cell.setHorizontalAlignment(Cell.ALIGN_RIGHT); // 设置水平靠右
		cell.setVerticalAlignment(Cell.ALIGN_MIDDLE); // 设置垂直居中
		table.addCell(cell);
		cell = new PdfPCell(new Phrase("君乐联", fourthTextFont));
		cell.setUseAscender(true); // 设置可以居中
		cell.setBorder(0);
		cell.setHorizontalAlignment(Cell.ALIGN_LEFT); // 设置水平靠左
		cell.setVerticalAlignment(Cell.ALIGN_MIDDLE); // 设置垂直居中
		table.addCell(cell);
		cell = new PdfPCell(new Phrase(dateToYear + "年度信用报告", fourthTextFont));
		cell.setUseAscender(true); // 设置可以居中
		cell.setBorder(0);
		cell.setHorizontalAlignment(Cell.ALIGN_LEFT); // 设置水平靠左
		cell.setVerticalAlignment(Cell.ALIGN_MIDDLE); // 设置垂直居中
		table.addCell(cell);
		
		cell = new PdfPCell(new Phrase("提供机构：", fourthTextFont));
		cell.setMinimumHeight(30); // 设置单元格高度
		cell.setUseAscender(true); // 设置可以居中
		cell.setBorder(0);
		cell.setHorizontalAlignment(Cell.ALIGN_RIGHT); // 设置水平靠右
		cell.setVerticalAlignment(Cell.ALIGN_MIDDLE); // 设置垂直居中
		table.addCell(cell);
		cell = new PdfPCell(new Phrase("北京君乐联信息咨询有限公司", fourthTextFont));
		cell.setUseAscender(true); // 设置可以居中
		cell.setBorder(0);
		cell.setHorizontalAlignment(Cell.ALIGN_LEFT); // 设置水平靠左
		cell.setVerticalAlignment(Cell.ALIGN_MIDDLE); // 设置垂直居中
		table.addCell(cell);
		
		cell = new PdfPCell(new Phrase("报告时间：", fourthTextFont));
		cell.setMinimumHeight(30); // 设置单元格高度
		cell.setUseAscender(true); // 设置可以居中
		cell.setBorder(0);
		cell.setHorizontalAlignment(Cell.ALIGN_RIGHT); // 设置水平靠右
		cell.setVerticalAlignment(Cell.ALIGN_MIDDLE); // 设置垂直居中
		table.addCell(cell);
		cell = new PdfPCell(new Phrase(dateToNum, fourthTextFont));
		cell.setUseAscender(true); // 设置可以居中
		cell.setBorder(0);
		cell.setHorizontalAlignment(Cell.ALIGN_LEFT); // 设置水平靠左
		cell.setVerticalAlignment(Cell.ALIGN_MIDDLE); // 设置垂直居中
		table.addCell(cell);
		
		cell = new PdfPCell(new Phrase("报告编号：", fourthTextFont));
		cell.setMinimumHeight(30); // 设置单元格高度
		cell.setUseAscender(true); // 设置可以居中
		cell.setBorder(0);
		cell.setHorizontalAlignment(Cell.ALIGN_RIGHT); // 设置水平靠右
		cell.setVerticalAlignment(Cell.ALIGN_MIDDLE); // 设置垂直居中
		table.addCell(cell);
		cell = new PdfPCell(new Phrase(num, fourthTextFont));
		cell.setUseAscender(true); // 设置可以居中
		cell.setBorder(0);
		cell.setHorizontalAlignment(Cell.ALIGN_LEFT); // 设置水平靠左
		cell.setVerticalAlignment(Cell.ALIGN_MIDDLE); // 设置垂直居中
		table.addCell(cell);
				
		doc.add(table);

		// 创建新的页
		doc.newPage();

		p = new Paragraph("报告说明", bigTitleFont);
		p.setLeading(50);
		p.setAlignment(Element.ALIGN_CENTER);
		doc.add(p);

		p = new Paragraph();
		ph = new Phrase();
		p.setSpacingBefore(50);
		p.setLeading(30);
		Chunk c5 = new Chunk(
				"1、本报告内容是北京君乐联信息咨询有限公司接受您的委托，基于企业公开信息挖掘的结果，并未对信息本身的真实性、准确性进行分辨或验证，本报告内容不构成我们对任何人或企业之明示或暗示的观点或保证，仅供用户参考，真实结果请以各官方网站的公布结果为准。",
				thirdTextFont);
		ph.add(c5);
		p.add(ph);
		doc.add(p);

		p = new Paragraph();
		ph = new Phrase();
		p.setLeading(30);
		Chunk c6 = new Chunk("2、本报告生产时间为", thirdTextFont);
		Chunk c66 = new Chunk(dateToHms, thirdTextFont);
		Chunk c666 = new Chunk("，报告内容为截止该时间点的数据快照。",thirdTextFont);
		ph.add(c6);
		ph.add(c66);
		ph.add(c666);
		p.add(ph);
		doc.add(p);

		p = new Paragraph();
		p.setSpacingBefore(150);
		p.setLeading(30);
		p.setAlignment(Element.ALIGN_RIGHT);
		ph = new Phrase();
		Chunk c7 = new Chunk("北京君乐联信息咨询有限公司", fourthTextFont);
		ph.add(c7);
		p.add(ph);
		doc.add(p);
		
		p = new Paragraph();
		p.setLeading(30);
		p.setAlignment(Element.ALIGN_RIGHT);
		ph = new Phrase();
		Chunk c8 = new Chunk(dateToCN, fourthTextFont);
		ph.add(c8);
		p.add(ph);
		doc.add(p);
	}
	
	/**
	 * 报告内容
	 * @param doc
	 * @throws Exception
	 */
	public static void createText(Document doc,DetailsInformation dic) throws Exception {
		// 设置字体样式
		Font abstractTitleFont = FontUtil.getFont("abstractTitleFont");// 摘要标题
		Font abstracttableFont = FontUtil.getFont("abstracttableFont");// 摘要内容
		Font firstTitleFont = FontUtil.getFont("firstTitleFont");// 一级标题
		Font secondTitleFont = FontUtil.getFont("secondTitleFont"); // 二级标题
		Font thirdTitleFont = FontUtil.getFont("thirdTitleFont");// 三级标题
		Font fourthTitleFont = FontUtil.getFont("fourthTitleFont");// 四级标题
		Font boldTableFont = FontUtil.getFont("boldTableFont");// 表格内容,加粗
		Font tableFont = FontUtil.getFont("tableFont");// 表格内容
		
		Font littleFourthBoldFont = FontUtil.getFont("littleFourthBoldFont");//小四加粗
		Font littleFourthFont = FontUtil.getFont("littleFourthFont");//小四正常
		int i;
		//加入隔行换色事件
        PdfPTableEvent event = new AlternatingBackground();
		
		// 创建新的页
		doc.newPage();

		p = new Paragraph("报告摘要", abstractTitleFont);
		p.setLeading(50);
		p.setAlignment(Element.ALIGN_CENTER);
		doc.add(p);
		
		p = new Paragraph();



		
	}

	/**
	 * 设置左边距
	 * @param str
	 * @param i
	 * @return
	 */
	public static String leftPad(String str, int i) {
		int addSpaceNo = i - str.length();
		String space = "";
		for (int k = 0; k < addSpaceNo; k++) {
			space = " " + space;
		}
		;
		String result = space + str;
		return result;
	}

	/**
	 * 创建单元格
	 * @param table
	 * @param row
	 * @param cols
	 * @return
	 * @throws Exception 
	 */
	private static PdfPTable createCell(PdfPTable table, String[] title, int row, int cols,Font font)
			throws Exception {
		for (int i = 0; i < row; i++) {

			for (int j = 0; j < cols; j++) {

				PdfPCell cell = new PdfPCell();
				if (i == 0 && title != null) {// 设置表头
					cell = new PdfPCell(new Phrase(title[j], font)); // 这样表头才能居中
				}

				cell.setMinimumHeight(30); // 设置单元格高度
				cell.setUseAscender(true); // 设置可以居中
				cell.setHorizontalAlignment(Cell.ALIGN_LEFT); // 设置水平居中
				cell.setVerticalAlignment(Cell.ALIGN_MIDDLE); // 设置垂直居中

				table.addCell(cell);
			}
		}

		return table;
	}

}
