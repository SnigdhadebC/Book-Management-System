package com.application.bookmanagementsystem;

import com.application.bookmanagementsystem.model.Book;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class BookManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookManagementSystemApplication.class, args);
	}

	/**
	 *
	 * @return
	 * @throws IOException
	 */
	@Bean
	public List<Book> readContentFromFile() throws IOException{
		Resource resource = new ClassPathResource("/static/test.json");
		InputStream inputStream = resource.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(reader,new TypeReference<List<Book>>(){});
	}



}
