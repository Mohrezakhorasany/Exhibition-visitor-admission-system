package hu.a_k.akademia.webfejlesztes.springboot.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PalindromeValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Palindrome {
    String message() default "List of '${validatedValue}' contained elements which are not palindrome";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
