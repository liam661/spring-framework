/*
 * Copyright 2002-2022 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.beans.factory.generator;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.generator.config.BeanDefinitionRegistrar;
import org.springframework.javapoet.CodeBlock;

/**
 * A specialization of {@link BeanRegistrationContributionProvider} that handles
 * inner bean definitions.
 *
 * @author Stephane Nicoll
 */
class InnerBeanRegistrationBeanFactoryContribution extends BeanRegistrationBeanFactoryContribution {

	InnerBeanRegistrationBeanFactoryContribution(String beanName, BeanDefinition beanDefinition,
			BeanInstantiationGenerator beanInstantiationGenerator,
			DefaultBeanRegistrationContributionProvider innerBeanRegistrationContributionProvider) {
		super(beanName, beanDefinition, beanInstantiationGenerator, innerBeanRegistrationContributionProvider);
	}

	@Override
	protected CodeBlock initializeBeanDefinitionRegistrar() {
		return CodeBlock.of("$T.inner(", BeanDefinitionRegistrar.class);
	}

}
