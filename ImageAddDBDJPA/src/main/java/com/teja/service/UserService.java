package com.teja.service;

import java.io.*;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teja.repository.UserRepository;
import com.teja.repository.*;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepo;

	public void saveUser() throws Exception {

		String imagePath = "C:\\Users\\Teja\\Pictures\\shivansh.jpeg";

		User user = new User();
		user.setUserName("Ramu");
		user.setUserEmail("ramu@gmail.com");

		long size = Files.size(Paths.get(imagePath));

		byte[] arr = new byte[(int) size];
		FileInputStream fis = new FileInputStream(new File(imagePath));
		fis.read(arr);
		fis.close();

		user.setUserImage(arr);

		userRepo.save(user);
	}

}
