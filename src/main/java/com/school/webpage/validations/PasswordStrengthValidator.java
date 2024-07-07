package com.school.webpage.validations;

import com.school.webpage.annotations.PasswordValidator;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;
import java.util.List;
// ConstraintValidator<what is the annotationName  for which these validator class is applicable,
// Target field type(String). On which type we can use these annotation>
public class PasswordStrengthValidator implements ConstraintValidator<PasswordValidator, String> {

    List<String> weakPasswords;
    @Override
    public void initialize(PasswordValidator constraintAnnotation) {
       weakPasswords = Arrays.asList("12345", "password", "qwerty");
    }

    @Override
    public boolean isValid(String passwordField, ConstraintValidatorContext constraintValidatorContext) {
        return  passwordField != null && (!weakPasswords.contains(passwordField));
    }
}
