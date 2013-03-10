/*
* JBoss, Home of Professional Open Source
* Copyright 2009, Red Hat, Inc. and/or its affiliates, and individual contributors
* by the @authors tag. See the copyright.txt in the distribution for a
* full listing of individual contributors.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
* http://www.apache.org/licenses/LICENSE-2.0
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package org.hibernate.beanvalidation.tck.tests.xmlconfiguration;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.Max;
import javax.validation.constraints.Pattern;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author Hardy Ferentschik
 */
@Constraint(validatedBy = ConsistentUserValidator.class)
@Documented
@Target({ METHOD, FIELD, TYPE })
@Retention(RUNTIME)
public @interface ConsistentUserInformation {
	String message() default "User information is not consistent.";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };

	byte byteParam() default 0;

	short shortParam() default 0;

	int intParam() default 0;

	long longParam() default 0;

	float floatParam() default 0;

	double doubleParam() default 0;

	boolean booleanParam() default false;

	char charParam() default 0;

	String stringParam() default "";

	Class<?> classParam() default void.class;

	Class<?> unqualifiedClassParam() default void.class;

	String[] stringArrayParam() default { };


	Max max() default @Max(value = 10);

	Pattern[] patterns();

	UserType userType() default UserType.BUYER;
}
