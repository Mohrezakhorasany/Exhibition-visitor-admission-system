package com.m.reza.khorasany.participant.aspects;

import com.m.reza.khorasany.participant.repository.ParticipantRepository;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Aspect
@Slf4j
@Component
public class ParticipantAuditionAspect {
    @Autowired
    private ParticipantRepository participantRepository;

    @Around("@annotation(com.m.reza.khorasany.participant.aspects.ParticipantAuditionAspect.LogInformation)")
    public Object auditParticipant(final ProceedingJoinPoint joinPoint) throws Throwable {
        final Object[] args = joinPoint.getArgs();
        final Integer id = ((Integer) args[0]);
        participantRepository.findById(id)
                .ifPresentOrElse(person -> log.info("Operation on Participant '{}'", person),
                        () -> log.warn("Participant with id '{}' does not exist.", id));
        return joinPoint.proceed();
    }

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface LogInformation {
    }
}
