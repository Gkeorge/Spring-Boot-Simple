package simple;

import org.springframework.boot.ExitCodeGenerator;
import org.springframework.stereotype.Component;

/**
 * Class to exit spring application 
 * Interface {@link ExitCodeGenerator} used to generate an 'exit code' from a 
 * running command line SpringApplication.
 * Can be used on exceptions as well as directly on beans.
 * 
 * @author Nanor
 */
@SuppressWarnings("serial")
@Component
public class ExitException extends RuntimeException implements ExitCodeGenerator {

	@Override
	public int getExitCode() {
		return 10;
	}
													
}
