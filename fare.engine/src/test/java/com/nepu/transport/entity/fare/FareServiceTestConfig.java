package com.nepu.transport.entity.fare;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import com.nepu.transport.entity.specialhours.SpecialHoursService;

@Profile("mockSpecialHoursService")
@Configuration
public class FareServiceTestConfig {

	@Bean
	@Primary
	public SpecialHoursService specialHoursService() {
		return Mockito.mock(SpecialHoursService.class);
	}

}
