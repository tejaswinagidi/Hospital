package com.miniproject.Hospital;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.miniproject.Hospital.Entity.Patient;

@SpringBootApplication(exclude = {ErrorMvcAutoConfiguration.class})
@EntityScan(basePackageClasses=Patient.class)
@EnableJpaRepositories("com.miniproject.Hospital.Repository")
@EnableTransactionManagement

public class HospitalApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalApplication.class, args);
	}

}
