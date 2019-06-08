package com.jay.app.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.assertj.core.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.jay.app.model.User;
import com.jay.app.repo.UserRepo;



@RestController
@RequestMapping("file")
public class FileController {
	
	Logger logger = LoggerFactory.getLogger(FileController.class);
	
	@Autowired
	UserRepo userRepo;
	
	
	
	@RequestMapping("test")
	void testing() {
		System.out.println("Reference is "+  userRepo.toString());
	}
	
	@PostMapping("upload")
    List<User> fileUploaded( @RequestParam("upload") MultipartFile file,HttpServletRequest request) throws IOException {
	    
		System.out.println(file.getOriginalFilename());
		
		
		Path newfile = Paths.get("the-file-name.xlsx");
		try {
			Files.write(newfile,file.getBytes());
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	   List<User> uploadList = this.ReadingExcelFile("the-file-name.xlsx");
	
		return uploadList;
		
	}	
	
	
	
	
	
	@RequestMapping("read")
	List<User> ReadingExcelFile(String fileName) throws IOException {
		File currentFile = new File("the-file-name.xlsx");
		FileInputStream excelFile = new FileInputStream(currentFile);
		Workbook workbook = new XSSFWorkbook(excelFile);
		Sheet datatypeSheet = workbook.getSheetAt(0);
		List<User> uploadList = new ArrayList<>();
        Iterator<Row> iterator = datatypeSheet.iterator();
        int row = 0 ;
        while (iterator.hasNext()) {
            Row currentRow = iterator.next();
            
            if(row == 0 ) {
            	row++;
            	continue;
            }
            
            User user = new User();
            user.setName(currentRow.getCell(0).getStringCellValue());
            user.setAge((int)currentRow.getCell(1).getNumericCellValue());
            user.setExpertise(currentRow.getCell(2).getStringCellValue());
            user.setExperience((int)currentRow.getCell(3).getNumericCellValue());
            user.setCurrentLocation(currentRow.getCell(4).getStringCellValue());
            boolean opentorelocation =  currentRow.getCell(5).getStringCellValue().toUpperCase().equals("YES") ? true : false;
            user.setOpentorelocation(opentorelocation);
            user.setVisaStatus(currentRow.getCell(7).getStringCellValue());
           
          
            List<String> prefferedLocations = new ArrayList<String>();
            prefferedLocations.add(currentRow.getCell(6).getStringCellValue());
            user.setPreffredLocation(prefferedLocations);
            user.setEmail(currentRow.getCell(8).getStringCellValue());
            
            
            
          //  userRepo.save(user);
            uploadList.add(user);
            System.out.println();
          
            }
		currentFile.delete();
        return uploadList;
		
        }

	}