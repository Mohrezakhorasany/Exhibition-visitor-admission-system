package hu.a_k.akademia.webfejlesztes.springboot.domain.message;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class AbstractMessage {
    protected final String msg;

}
