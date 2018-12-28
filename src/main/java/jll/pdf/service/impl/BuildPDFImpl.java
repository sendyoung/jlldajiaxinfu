package jll.pdf.service.impl;

import com.lowagie.text.Document;
import com.lowagie.text.Image;
import com.lowagie.text.pdf.*;
import jll.model.DetailsInformation;
import jll.pdf.service.BuildPDF;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;



@Service
public class BuildPDFImpl implements BuildPDF {
	
	// 添加水印图片路径
	private static final String imageFilePath = "F:/idea_work/jlldajiaxingfu/target/jll-dajiaxinfu-1.0-SNAPSHOT/WEB-INF/classes/config/images/征信水印很浅.png";
	// 生成临时文件前缀
	private static final String prefix = "tempFile";
	// 所有者密码
	private static final String OWNERPASSWORD = null;

	/**
	 * 生成加密有水印的PDF文档(没水印的是临时的)
	 * @param num  编号
	 * @param pdfFile
	 * @param userPassWord
	 * @param permission
	 */
	public void generatePDF(String num,String pdfFile, String userPassWord, int permission,DetailsInformation dic) {
		try {
			// 生成临时文件
			File file = File.createTempFile(prefix, ".pdf");
			String path = file.getPath();
			// 创建pdf文件到临时文件
			if (createPDF(path,num,dic)) {
				// 增加水印和加密
				imageWaterMark(path, pdfFile, userPassWord, OWNERPASSWORD, permission);
				System.out.println("水印版文档生成成功");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 生成临时的PDF文档(没有水印)
	 * @param outputFilePath
	 * @return
	 * @throws Exception
	 */
	public static boolean createPDF(String outputFilePath,String num,DetailsInformation dic) throws Exception {

		try {
			Document doc = PDFUtil.createDoc(outputFilePath);
			// 开启文档
			doc.open();
			// 封面
			PDFUtil.createCover(doc,num,dic);
			// 内容
			PDFUtil.createText(doc,dic);
			doc.close();
			System.out.println("报告成功生成,准备生成水印版");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 加水印的PDF文档(图片)
	 * @param //inputFiles需要加水印的PDF路径
	 * @param //outputFile输出生成PDF的路径
	 * @param userPassWord 加密密码
	 * @param ownerPassWord  所有者密码
	 * @param permission
	 */
	public static void imageWaterMark(String inputFile, String outputFile, String userPassWord, String ownerPassWord,
			int permission) {
		try {
			PdfReader reader = new PdfReader(inputFile);
			PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(outputFile));
			// 设置密码
			//stamper.setEncryption(userPassWord.getBytes(), ownerPassWord.getBytes(), permission, false);
			// 禁止修改，复制，具体可以参照stamper类方法的详细信息
			// stamper.setEncryption(null,null, PdfWriter.ALLOW_FILL_IN, false);
			stamper.setEncryption(PdfWriter.STRENGTH128BITS, userPassWord, ownerPassWord, permission);
			int total = reader.getNumberOfPages() + 1;

			Image image = Image.getInstance(imageFilePath);
			image.setAbsolutePosition(400, 20);// 坐标
			// image.scaleAbsolute(800, 1000);// 自定义大小
			// image.setRotation(-20);//旋转 弧度
			// image.setRotationDegrees(-45);//旋转 角度
			image.scalePercent(10);// 依照比例缩放

			PdfGState gs = new PdfGState();
			gs.setFillOpacity(0.5f);// 设置透明度

			PdfContentByte under;
			// 给每一页加水印
			for (int i = 1; i < total; i++) {
				under = stamper.getUnderContent(i);
				under.beginText();
				// 添加水印图片
				under.addImage(image);
				under.setGState(gs);
			}
			stamper.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
