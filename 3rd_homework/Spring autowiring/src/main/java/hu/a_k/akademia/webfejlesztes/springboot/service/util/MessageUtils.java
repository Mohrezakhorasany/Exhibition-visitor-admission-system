package hu.a_k.akademia.webfejlesztes.springboot.service.util;

import hu.a_k.akademia.webfejlesztes.springboot.domain.message.AbstractMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageUtils {
    @Autowired
    private AbstractMessage successMessage;
    @Autowired
    private AbstractMessage errorMessage;

    public AbstractMessage getSuccessMsg() {
        return successMessage;
    }

    public AbstractMessage getErrorMsg() {
        return errorMessage;
    }
}
