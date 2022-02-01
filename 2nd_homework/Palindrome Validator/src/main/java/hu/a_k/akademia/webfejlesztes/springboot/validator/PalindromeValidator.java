package hu.a_k.akademia.webfejlesztes.springboot.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Collection;
import java.util.stream.IntStream;

public class PalindromeValidator implements ConstraintValidator<Palindrome, Collection<String>> {


    @Override
    public boolean isValid(Collection<String> strings, ConstraintValidatorContext constraintValidatorContext) {
        for (String s : strings) {
            if (!isPalindrome(s)) {
                return false;
            }
        }
        return true;
    }

    private boolean isPalindrome(String s) {
        return IntStream.range(0, s.length() / 2).noneMatch(i -> Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(s.length() - i - 1)));
    }
}
