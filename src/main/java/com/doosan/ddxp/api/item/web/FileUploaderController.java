package com.doosan.ddxp.api.item.web;

import java.io.IOException;

import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


@Controller
public class FileUploaderController {

	
	 @PostMapping("/upload")
	  public void upload(@RequestParam("file") MultipartFile file) throws IOException{ 

	    String extension = FilenameUtils.getExtension(file.getOriginalFilename()); 

	    if (!extension.equals("xlsx") && !extension.equals("xls")) {
	      throw new IOException("check your file extension");
	    }

	    Workbook workbook = null;

	    if (extension.equals("xlsx")) {
	      workbook = new XSSFWorkbook(file.getInputStream());
	    } else if (extension.equals("xls")) {
	      workbook = new HSSFWorkbook(file.getInputStream());
	    }

	    Sheet worksheet = workbook.getSheetAt(0);

	    for (int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++) {

	      Row row = worksheet.getRow(i);
	      
	      System.out.println((int) row.getCell(0).getNumericCellValue());
	      System.out.println(row.getCell(1).getStringCellValue());
	      System.out.println(row.getCell(2).getStringCellValue());
     
	    }
	  }
}
