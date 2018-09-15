package org.springframework.beans.factory;

import org.springframework.beans.BeansException;
import org.springframework.core.ResolvableType;
import org.springframework.lang.Nullable;


/**
 * 在BeanFactory中只对IOC容器的基本行为做了定义，不关心Bean是如何定义，怎样加载的。
 * 结果导向。Bean工厂，应该是只关注我能拿到什么样的bean。
 *
 * @author King Chen
 */
public interface BeanFactory {

	String FACTORY_BEAN_PREFIX = "&";

	/**
	 * 根据bean名称获得bean
	 *
	 * @param name bean名称
	 * @return JavaBean
	 * @throws BeansException bean加载异常
	 */
	Object getBean(String name) throws BeansException;


	/**
	 * 根据bean名称以及bean类型获得bean
	 *
	 * @param name         bean名称
	 * @param requiredType bean类型
	 * @param <T>          与requiredType同样类型的bean
	 * @throws BeansException bean加载一异常
	 * @return JavaBean
	 */
	<T> T getBean(String name, @Nullable Class<T> requiredType) throws BeansException;

	/**
	 * @param name bean名称
	 * @param args
	 * @return JavaBean
	 * @throws BeansException bean加载异常
	 */
	Object getBean(String name, Object... args) throws BeansException;

	/**
	 * @param requiredType bean类型
	 * @param <T>
	 * @return JavaBean
	 * @throws BeansException bean加载异常
	 */
	<T> T getBean(Class<T> requiredType) throws BeansException;

	/**
	 * @param requiredType bean类型
	 * @param args
	 * @param <T>
	 * @return JavaBean
	 * @throws BeansException bean加载异常
	 */
	<T> T getBean(Class<T> requiredType, Object... args) throws BeansException;


	/**
	 * 判断容器中是否含有该名称的bean
	 *
	 * @param name bean名称
	 * @return true/false
	 */
	boolean containsBean(String name);

	/**
	 * 判断该名称的bean是否是单例
	 *
	 * @param name bean名称
	 * @return true/false
	 * @throws NoSuchBeanDefinitionException bean加载异常
	 */
	boolean isSingleton(String name) throws NoSuchBeanDefinitionException;

	/**
	 * @param name bean名称
	 * @return true/false
	 * @throws NoSuchBeanDefinitionException bean加载异常
	 */
	boolean isPrototype(String name) throws NoSuchBeanDefinitionException;

	/**
	 * @param name        bean名称
	 * @param typeToMatch
	 * @return true/false
	 * @throws NoSuchBeanDefinitionException bean加载异常
	 */
	boolean isTypeMatch(String name, ResolvableType typeToMatch) throws NoSuchBeanDefinitionException;

	/**
	 * @param name        bean名称
	 * @param typeToMatch 需要比较的类类型
	 * @return true/false
	 * @throws NoSuchBeanDefinitionException bean加载异常
	 */
	boolean isTypeMatch(String name, @Nullable Class<?> typeToMatch) throws NoSuchBeanDefinitionException;

	/**
	 * 获得该bean类型
	 *
	 * @param name bean名称
	 * @return ClassType
	 * @throws NoSuchBeanDefinitionException bean加载异常
	 */
	@Nullable
	Class<?> getType(String name) throws NoSuchBeanDefinitionException;

	/**
	 * 获得bean别名，如果根据别名检索，原名也将检索出来
	 *
	 * @param name bean名称/别名
	 * @return 别名/原名
	 */
	String[] getAliases(String name);

}
