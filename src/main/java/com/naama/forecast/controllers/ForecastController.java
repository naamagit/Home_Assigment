package com.naama.forecast.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.naama.forecast.entities.Forecast;
import com.naama.forecast.services.ForecastService;

@RestController

public class ForecastController {

	@Autowired
	private ForecastService forecastService;

	/*
	 * @RequestMapping("/weather/data/{latitude}/{longitude}") public List<Forecast>
	 * getForecast(@PathVariable float latitude, @PathVariable float longitude) {
	 * return forecastService.getForecastByLatAndLon(latitude, longitude);
	 * 
	 * }
	 */

	@RequestMapping("/weather/data/{latitude}/{longitude}")
	public List<Map<String, Object>> getForecast(@PathVariable float latitude, @PathVariable float longitude) {
		List<Forecast> allforecasts = forecastService.getForecastByLatAndLon(latitude, longitude);
		List<Map<String, Object>> forecastCollection = new ArrayList<Map<String, Object>>();

		for (Forecast forecast : allforecasts) {
			Map<String, Object> forecastValuesMap = new HashMap<String, Object>();
			forecastValuesMap.put("temperature", forecast.getTemperature());
			forecastValuesMap.put("precipitation", forecast.getPrecipitation());
			forecastValuesMap.put("forecastTime", forecast.getForecastTime());
			forecastCollection.add(forecastValuesMap);

		}
		return forecastCollection;
	}

	/*
	 * @RequestMapping("/weather/data/{latitude}/{longitude}") public List<Object[]>
	 * getForecast(@PathVariable float latitude, @PathVariable float longitude) {
	 * return forecastService.getForecastByLatAndLon(latitude, longitude);
	 * 
	 * }
	 */

}
