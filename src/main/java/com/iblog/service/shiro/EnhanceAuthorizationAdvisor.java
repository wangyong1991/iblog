package com.iblog.service.shiro;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresGuest;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.springframework.core.annotation.AnnotationUtils;

public class EnhanceAuthorizationAdvisor extends AuthorizationAttributeSourceAdvisor {

	private static final long serialVersionUID = 3696206699191850594L;

	private static final List<Class<? extends Annotation>> AUTHZ_ANNOTATION_CLASSES = Arrays.asList(
			RequiresPermissions.class, RequiresRoles.class, RequiresUser.class, RequiresGuest.class,
			RequiresAuthentication.class);

	@Override
	@SuppressWarnings("rawtypes")
	public boolean matches(Method method, Class targetClass) {
		return super.matches(method, targetClass) || isAuthzAnnotationPresent(method.getDeclaringClass());
	}

	private boolean isAuthzAnnotationPresent(Class<?> clazz) {
		for (Class<? extends Annotation> annClass : AUTHZ_ANNOTATION_CLASSES) {
			Annotation a = AnnotationUtils.findAnnotation(clazz, annClass);
			if (a != null) {
				return true;
			}
		}
		return false;
	}

}
