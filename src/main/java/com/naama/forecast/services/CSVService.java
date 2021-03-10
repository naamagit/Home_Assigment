package com.naama.forecast.services;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.naama.forecast.entities.Forecast;
import com.naama.forecast.repos.ForecastRepository;
import com.naama.forecast.util.CSVHelper;

@Service
public class CSVService {
	@Autowired
	ForecastRepository forecastRepository;

	public void save(MultipartFile file) {
		try {
			List<Forecast> tutorials = CSVHelper.csvToTutorials(file.getInputStream());
			forecastRepository.saveAll(tutorials);
		} catch (IOException e) {
			throw new RuntimeException("fail to store csv data: " + e.getMessage());
		}
	}

}
