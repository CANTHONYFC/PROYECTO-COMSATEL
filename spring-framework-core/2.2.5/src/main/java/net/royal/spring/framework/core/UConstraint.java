package net.royal.spring.framework.core;

import java.util.Iterator;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

public class UConstraint<T> {

	private static UConstraint<?> constraint;
	private static Validator validator;

	public UConstraint() {
		validator = Validation.buildDefaultValidatorFactory().getValidator();
	}

	public Set<ConstraintViolation<T>> validate(T bean) {
		Set<ConstraintViolation<T>> retorno = validator.validate(bean);
		return retorno;
	}

	public Iterator<ConstraintViolation<T>> validateIterator(T bean) {
		Set<ConstraintViolation<T>> constraintViolations = validator.validate(bean);
		Iterator<ConstraintViolation<T>> iterator = constraintViolations.iterator();
		return iterator;
	}

	public static UConstraint<?> getInstance() {
		if (constraint == null) {
			constraint = new UConstraint<Object>();
		}
		return constraint;
	}

}