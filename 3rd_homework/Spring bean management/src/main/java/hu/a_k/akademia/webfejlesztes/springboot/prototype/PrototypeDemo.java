package hu.a_k.akademia.webfejlesztes.springboot.prototype;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(scopeName = BeanDefinition.SCOPE_PROTOTYPE)
@NoArgsConstructor
public class PrototypeDemo {


}
