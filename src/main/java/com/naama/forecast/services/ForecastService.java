package com.naama.forecast.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naama.forecast.entities.Forecast;
import com.naama.forecast.repos.ForecastRepository;
@Service
public class ForecastService {

	@Autowired
	private ForecastRepository forecastRepository;

	public List<Forecast> getForecastByLatAndLon(float latitude, float longitude) {
	return forecastRepository.findByLatitudeAndLongitude(latitude, longitude);
} 
	
	/*public List<Object[]> getForecastByLatAndLon(float latitude, float longitude) {
		return forecastRepository.findByLatitudeAndLongitude(latitude, longitude);
	} */


}
