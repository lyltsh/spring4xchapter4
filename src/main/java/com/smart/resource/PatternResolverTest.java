package com.smart.resource;

import org.junit.jupiter.api.Test;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PatternResolverTest {
    @Test
    public void getResource() throws Throwable {
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        //加载所有类包com.smart及子孙包下以.xml为后缀的资源
        Resource resources[] = resolver.getResources("classpath*:com/smart/**/*.xml");
        assertNotNull(resources);
        for (Resource r : resources) {
            System.out.println(r.getDescription());
        }
    }
}
