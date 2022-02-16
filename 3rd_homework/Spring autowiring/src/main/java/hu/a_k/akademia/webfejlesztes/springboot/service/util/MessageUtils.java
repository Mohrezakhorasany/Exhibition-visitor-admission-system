package hu.a_k.akademia.webfejlesztes.springboot.service.util;

import hu.a_k.akademia.webfejlesztes.springboot.domain.message.AbstractMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class MessageUtils {
    @Autowired
    @Qualifier("successMessage")
    private AbstractMessage successMessage;
    @Autowired
    @Qualifier("errorMsg")
    private AbstractMessage errorMessage;

    public AbstractMessage getSuccessMsg() {
        return successMessage;
    }

    public AbstractMessage getErrorMsg() {
        return errorMessage;
    }
}
