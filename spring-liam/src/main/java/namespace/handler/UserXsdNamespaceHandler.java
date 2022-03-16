package namespace.handler;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;
import parser.UserXsdParser;

/**
 * @Description
 * @Author liam661
 * @Date 2022/3/16 11:12
 **/
public class UserXsdNamespaceHandler extends NamespaceHandlerSupport {

	@Override
	public void init() {
		registerBeanDefinitionParser("user", new UserXsdParser());
	}
}
