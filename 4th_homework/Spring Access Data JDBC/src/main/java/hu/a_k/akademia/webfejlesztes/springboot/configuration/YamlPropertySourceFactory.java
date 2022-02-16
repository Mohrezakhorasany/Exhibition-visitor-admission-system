package hu.a_k.akademia.webfejlesztes.springboot.configuration;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertySourceFactory;

import java.util.Objects;
import java.util.Properties;

public class YamlPropertySourceFactory implements PropertySourceFactory {

    @Override
    public PropertySource<?> createPropertySource(final String name, final EncodedResource resource) {
        final YamlPropertiesFactoryBean factory = new YamlPropertiesFactoryBean();
        factory.setResources(resource.getResource());
        final Properties properties = Objects.requireNonNull(factory.getObject(), "properties");
        final String filename = Objects.requireNonNull(resource.getResource().getFilename(), "fileName");
        return new PropertiesPropertySource(filename, properties);
    }
}