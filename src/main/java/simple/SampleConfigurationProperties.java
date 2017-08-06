package simple;

import javax.validation.constraints.NotNull;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

/**
 * Configuration class to load command line args or 
 * properties defined in application.properties
 * 
 * @author Nanor
 */

@Component
@ConfigurationProperties(prefix = "sample")
//@Validated
public class SampleConfigurationProperties {
	
	@NotNull
	private String name;

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
