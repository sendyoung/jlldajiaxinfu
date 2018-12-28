package jll.pdf.service;


import jll.model.DetailsInformation;

public interface BuildPDF {

	public void generatePDF(String num, String pdfFile, String userPassWord, int permission, DetailsInformation dic);
	
}
