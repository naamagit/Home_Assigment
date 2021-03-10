package com.naama.forecast.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.naama.forecast.entities.Forecast;

public interface ForecastRepository extends JpaRepository<Forecast, Long> {
	public List<Forecast> findByLatitudeAndLongitude(float latitude, float longitude);

	
	//@Query(value="SELECT forecast_time, temperature, precipitation From Forecast f WHERE f.latitude =:latitude and longitude =:longitude", nativeQuery = true)
	//List<Object[]> findByLatitudeAndLongitude(@Param("latitude") float latitude, @Param("longitude") float longitude);
}
