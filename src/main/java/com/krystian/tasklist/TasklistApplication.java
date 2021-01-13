package com.krystian.tasklist;

import com.krystian.tasklist.domain.TaskDto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class TasklistApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {

		SpringApplication.run(TasklistApplication.class, args);

	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(TasklistApplication.class);
	}
}
