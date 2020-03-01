package io.couponplus.generic;

import java.io.File;
import java.util.ArrayList;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class PdfReader {
	String CouponValue= null;
	
	public void reader(String path, String product) {

	    PDDocument pdDoc = null;
	    COSDocument cosDoc = null;
	    PDFTextStripper pdfStripper;

	    String parsedText;
	    String fileName = path+"/"+product+".pdf";
	    try {
	      

	        pdfStripper = new PDFTextStripper();
	        pdDoc = new PDDocument(cosDoc);
	        pdDoc = PDDocument.load(new File(fileName));
	        pdfStripper = new PDFTextStripper();
	        parsedText = pdfStripper.getText(pdDoc);
	        Thread.sleep(4000);
	        ArrayList<String> itemsToAdd = new ArrayList<String>();
	        String [] strWords = parsedText.split("\\s");
	        String coupanName = product.substring(0, 4);
	        
	        
	        for(String strWord:strWords)
	        
	        {
	            if(strWord.contains(coupanName
	            		+ "")){
	                itemsToAdd.add(strWord);
	            }
	        }
	           CouponValue = itemsToAdd.get(1);
	           
	        } catch (Exception e1) {
	            e1.printStackTrace();
	        }
	    

	    }
	public Object couponVal()
	{
		return CouponValue;
	}}
