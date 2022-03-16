import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description
 * @Author liam661
 * @Date 2022/3/13 17:39
 **/
@Configuration
public class TestConfig {
	@Bean
	public String name(){
		return "Hello Spring";
	}
}
