package io.couponplus.generic;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;


public class PdfBox {
	public static void main(String args[]) {

	    PDDocument pdDoc = null;
	    COSDocument cosDoc = null;
	    PDFTextStripper pdfStripper;

	    String parsedText;
	    String fileName = "/home/sunny/Downloads/Pepsi.pdf";
	    try {
	      

	        pdfStripper = new PDFTextStripper();
	        pdDoc = new PDDocument(cosDoc);
	        pdDoc = PDDocument.load(new File(fileName));
	        pdfStripper = new PDFTextStripper();
	        parsedText = pdfStripper.getText(pdDoc);
	        System.out.println(parsedText.replaceAll("[^A-Za-z0-9. ]+", ""));
	        
	        String [] strWords = parsedText.split("\\s");
	        for(String strWord:strWords){
	            if(strWord.contains("Peps"
	            		+ "")){
	                System.out.println(strWord);
	                break;
	            }
	        }
	        Pattern p = Pattern.compile("Peps ");   // the pattern to search for
	        Matcher m = p.matcher(parsedText);

	        // if we find a match, get the group 
	        if (m.find())
	        {
	          // we're only looking for one group, so get it
	          String theGroup = m.group(	);
	          
	          // print the group out for verification
	          System.out.format("'%s'\n", theGroup);
	    }} catch (Exception e) {
	        e.printStackTrace();
	        try {
	            if (cosDoc != null)
	                cosDoc.close();
	            if (pdDoc != null)
	                pdDoc.close();
	        } catch (Exception e1) {
	            e1.printStackTrace();
	        }

	    }
	}
    	
    }
