package hu.a_k.akademia.webfejlesztes.springboot.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Collection;
import java.util.stream.IntStream;

public class PalindromeValidator implements ConstraintValidator<Palindrome, Collection<String>> {


    @Override
    public boolean isValid(Collection<String> strings, ConstraintValidatorContext constraintValidatorContext) {
        for (String s : strings) {
            return isPalindrome(s);
        }
        return true;
    }

    private boolean isPalindrome(String s) {
        return IntStream.rangeClosed(0, s.length() / 2).noneMatch(i -> s.charAt(i) != s.charAt(s.length() - i - 1));
    }
}
