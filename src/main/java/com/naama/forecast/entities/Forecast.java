package com.naama.forecast.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "forecast")
public class Forecast {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "longitude")
	private  float  longitude;
	@Column(name = "latitude")
	private  float latitude;
	@Column(name = "forecastTime")
	//private Timestamp forecastTime;
	private String forecastTime;
	@Column(name = "temperature")
	private  float temperature;
	@Column(name = "precipitation")
	private  float precipitation;
		
	public Forecast() {
	}

	public Forecast(Long id, float longitude, float latitude, String forecastTime, float temperature,
			float precipitation) {
		this.id = id;
		this.longitude = longitude;
		this.latitude = latitude;
		this.forecastTime = forecastTime;
		this.temperature = temperature;
		this.precipitation = precipitation;
	}

	public Forecast(String forecastTime, float temperature, float precipitation) {
		this.forecastTime = forecastTime;
		this.temperature = temperature;
		this.precipitation = precipitation;
	}

	public Forecast( float longitude, float latitude, String forecastTime, float temperature,
			float precipitation) {
		this.longitude = longitude;
		this.latitude = latitude;
		this.forecastTime = forecastTime;
		this.temperature = temperature;
		this.precipitation = precipitation;
	}
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public  float getLongitude() {
		return longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

	public  float getLatitude() {
		return latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	public String getForecastTime() {
		return forecastTime;
	}

	public void setForecastTime(String forecastTime) {
		this.forecastTime = forecastTime;
	}

	public  float getTemperature() {
		return temperature;
	}

	public void setTemperature(float temperature) {
		this.temperature = temperature;
	}

	public  float getPrecipitation() {
		return precipitation;
	}

	public void setPrecipitation(float precipitation) {
		this.precipitation = precipitation;
	}

}
