package com.naama.forecast.util;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

import com.naama.forecast.entities.Forecast;

public class CSVHelper {
	public static String TYPE = "text/csv";
	static String[] HEADERs = { "Longitude", "Latitude", "forecast_time", "Temperature Celsius",
			"Precipitation Rate mm/hr" };

	public static boolean hasCSVFormat(MultipartFile file) {
		if (TYPE.equals(file.getContentType()) || file.getContentType().equals("application/vnd.ms-excel")) {
			return true;
		}

		return false;
	}

	public static List<Forecast> csvToTutorials(InputStream is) {
		try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
				CSVParser csvParser = new CSVParser(fileReader,
						CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

			List<Forecast> forecastlList = new ArrayList<>();

			Iterable<CSVRecord> csvRecords = csvParser.getRecords();

			for (CSVRecord csvRecord : csvRecords) {
				Forecast forecast = new Forecast(Float.parseFloat(csvRecord.get("Longitude")),
						Float.parseFloat(csvRecord.get("Latitude")), 
						//OffsetDateTime.parse(csvRecord.get("forecast_time"), DateTimeFormatter.ofPattern( "yyyy-MM-dd'T'HH:mm:ss" )),					
						csvRecord.get("forecast_time"),
						Float.parseFloat(csvRecord.get("Temperature Celsius")),
						Float.parseFloat(csvRecord.get("Precipitation Rate mm/hr")));

				forecastlList.add(forecast);
			}

			return forecastlList;
		} catch (IOException e) {
			throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
		}
	}

}
