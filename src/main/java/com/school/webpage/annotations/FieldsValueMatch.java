package com.school.webpage.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import com.school.webpage.validations.FieldsValueMatchValidator;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//Code similar to jakarta.validation.constraints
@Constraint(validatedBy = FieldsValueMatchValidator.class) // Where we have written our custom logic
@Target({ ElementType.TYPE }) // Where we can use this annotation
@Retention(RetentionPolicy.RUNTIME) // Performed in Runtime not Compilation time
public @interface FieldsValueMatch {

    Class<?>[] groups() default {}; // we can group our annotations based on our requirements
    Class<? extends Payload>[] payload() default {};

    String message() default "Fields values don't match!";

    String field();

    String fieldMatch();

    @Target({ ElementType.TYPE })
    @Retention(RetentionPolicy.RUNTIME)
    @interface List {
        FieldsValueMatch[] value();
    }
}
