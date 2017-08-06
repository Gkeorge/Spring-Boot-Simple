package simple.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.boot.test.rule.OutputCapture;

import simple.MainApp;

/**
 * Tests for {@link MainApp}.
 * 
 * @author Nanor
 *
 */
public class SimpleApplicationTest {

	//JUnit {@link @Rule} to capture output {@link OutputCapture} from System.out and System.err.
	
	@Rule
	public OutputCapture outputCapture = new OutputCapture();

	private String profiles;

	@Before
	public void init() {
		this.profiles = System.getProperty("spring.profiles.active");
	}

	@After
	public void after() {
		if (this.profiles != null) {
			System.setProperty("spring.profiles.active", this.profiles);
		}
		else {
			System.clearProperty("spring.profiles.active");
		}
	}

	@Test
	public void testDefaultSettings() throws Exception {
		MainApp.main(new String[0]);
		String output = this.outputCapture.toString();
		assertThat(output).contains("Hello Phil");
		assertThat(output).contains("The @ConfigurationProperties bean class "
				+ "simple.SampleConfigurationProperties contains "
				+ "validation constraints but had not been annotated "
				+ "with @Validated");
	}

	@Test
	public void testCommandLineOverrides() throws Exception {
		MainApp.main(new String[] { "--name=Gordon" });
		String output = this.outputCapture.toString();
		assertThat(output).contains("Hello Gordon");
	}
}
