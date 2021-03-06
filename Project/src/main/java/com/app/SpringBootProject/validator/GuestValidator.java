package com.app.SpringBootProject.validator;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.app.SpringBootProject.bean.Guest;

@Component("beforeCreateGuestValidator")
public class GuestValidator implements Validator {

	/*
	 * org.springframework.validation.Validator#supports(java.lang.Class)
	 */
	@Override
	public boolean supports(Class<?> clazz) {
		return Guest.class.equals(clazz);
	}

	/*
	 * org.springframework.validation.Validator#validate(java.lang.Object,
	 * org.springframework.validation.Errors)
	 */
	@Override
	public void validate(Object obj, Errors errors) {

		ValidationUtils.rejectIfEmpty(errors, "firstName", "guest.firstName.empty");
		ValidationUtils.rejectIfEmpty(errors, "lastName", "guest.lastName.empty");
		ValidationUtils.rejectIfEmpty(errors, "email", "guest.email.empty");
		ValidationUtils.rejectIfEmpty(errors, "address", "guest.address.empty");
		ValidationUtils.rejectIfEmpty(errors, "phone", "guest.phone.empty");
		ValidationUtils.rejectIfEmpty(errors, "password", "guest.password.empty");

		Guest guest = (Guest) obj;
		Pattern pattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,3}$", Pattern.CASE_INSENSITIVE);
		if (!(pattern.matcher(guest.getEmail()).matches())) {
			errors.rejectValue("email", "guest.email.invalid");
		}

		if (!(guest.getPhone().matches("\\d{10}"))) {
			errors.rejectValue("phone", "guest.phone.invalid");
		}

	}

}
