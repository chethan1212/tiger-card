package com.nepu.transport.fare.engine;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import com.nepu.transport.entity.fare.FareService;
import com.nepu.transport.entity.farecap.FareCapService;

@Profile("mocksForFareEngineTest")
@Configuration
public class FareEngineTestConfig {
	
	@Bean
	@Primary
	public FareCapService fareCapService() {
		return Mockito.mock(FareCapService.class);
	}
	
	@Bean
	@Primary
	private FareService fareService() {
		return Mockito.mock(FareService.class);
	}
	

}
