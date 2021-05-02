package com.arpan.controllers;

import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import java.io.*;
import java.util.*;

import com.arpan.beans.Users;
import com.arpan.services.ReadCSV;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class ReadCSVController {

	private final static Logger log = LoggerFactory.getLogger(ReadCSVController.class);
	
	@Value(value = "${file.upload-dir}")
	private String PATH_FOLDER;

	@Autowired
	private ReadCSV readCvs;

	@PostMapping("/upload-csv-file")
	public String uploadCSVFile(@RequestParam("file") MultipartFile file, Model model) {

		// validate file
		if (file.isEmpty()) {
			model.addAttribute("status", false);
			model.addAttribute("message", "Please select a CSV file to upload.");

		} else {

			// parse CSV file to create a list of `User` objects
			try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {

				// create csv bean reader
				CsvToBean<Users> csvToBean = new CsvToBeanBuilder(reader).withType(Users.class)
						.withIgnoreLeadingWhiteSpace(true).build();

				// Convert `CsvToBean` object to list of users
				List<Users> users = csvToBean.parse();

				// TODO: Calling API?

				// save users list on model
				model.addAttribute("status", true);
				model.addAttribute("users", users);
				// model.addAttribute("message", "Upload CSV file Successfully.");

			} catch (Exception ex) {
				model.addAttribute("status", false);
				model.addAttribute("message", "Please Select CSV file.");

			}
		}

		return "file-upload-status";
	}

	@PostMapping("/upload-mp4-file")
	public String singleFileUpload(@RequestParam("file") MultipartFile file, Model model)
			throws Exception {

		String extension = FilenameUtils.getExtension(file.getOriginalFilename());

		if (file.isEmpty()) {
			model.addAttribute("status", false);
			model.addAttribute("message", "Please select a WAV file to upload.");
		} else {

			if (extension == "wav" || extension.equalsIgnoreCase("wav")) {

				try {
					//String PATH_FOLDER = Paths.get("").toAbsolutePath().toString();
			        //System.out.println("Working Directory = " + PATH_FOLDER);
			        //PATH_FOLDER = PATH_FOLDER.replace("\\", "/");
			        //PATH_FOLDER = PATH_FOLDER + "/src/main/webapp/WEB-INF/wav/";
			        
					// Get the file and save it somewhere
					byte[] bytes = file.getBytes();
					Path path = Paths.get(PATH_FOLDER + file.getOriginalFilename());
					Files.write(path, bytes);
					// convert to mp4

					String filePath = PATH_FOLDER + file.getOriginalFilename();
					File fileCon = new File(filePath);
					String fileNameWithOutExt = FilenameUtils.removeExtension(file.getOriginalFilename());
					String mp4 = fileNameWithOutExt + ".mp4";
					PATH_FOLDER = PATH_FOLDER + mp4;
					
					readCvs.convertToMP4(fileCon, PATH_FOLDER);
                    boolean fileDelete = fileCon.delete();
                    log.info(" DOWNLOAd_FOLDER : " + PATH_FOLDER);
					
					model.addAttribute("status", true);
					model.addAttribute("message", "You successfully Converted " + file.getOriginalFilename() + " to " + mp4);
					model.addAttribute("download", PATH_FOLDER);

				} catch (IOException e) {
					model.addAttribute("status", false);
					model.addAttribute("message", "Please Select WAV file.");
					e.printStackTrace();
				}
			} else {
				model.addAttribute("status", false);
				model.addAttribute("message", "Please Select WAV file Not ." + extension);
			}
		}
		return "convert-file-status";
	}
}
