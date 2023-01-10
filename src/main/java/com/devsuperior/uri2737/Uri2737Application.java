package com.devsuperior.uri2737;

import com.devsuperior.uri2737.projections.LawyerMinProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.uri2737.repositories.LawyerRepository;

import java.util.List;

@SpringBootApplication
public class Uri2737Application implements CommandLineRunner {

	@Autowired
	private LawyerRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(Uri2737Application.class, args);
	}

	@Autowired
	private LawyerRepository lawyerRepository;

	@Override
	public void run(String... args) throws Exception {
		List<LawyerMinProjection> search = lawyerRepository.searchLawyerByMaxMinCustomersNumber();
		search.forEach(x -> System.out.println(x.getName()+" " + x.getCustomersNumber()));

	}
}
