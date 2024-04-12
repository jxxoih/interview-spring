package com.interview.qna;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.InvocationTargetException;

@SpringBootApplication
public class QnaApplication {

	public static void main(String[] args) throws NoSuchMethodException, IllegalAccessError {
		try {
			SpringApplication.run(QnaApplication.class, args);
		} catch (Exception e) {
			System.out.println("Error ::" + e);
		}
    }

}
