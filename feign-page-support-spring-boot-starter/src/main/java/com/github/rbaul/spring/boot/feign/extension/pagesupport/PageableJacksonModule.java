package com.github.rbaul.spring.boot.feign.extension.pagesupport;

import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.data.domain.Page;

public class PageableJacksonModule extends SimpleModule {

    @Override
    public void setupModule(SetupContext context) {
        context.setMixInAnnotations(Page.class, PageMixIn.class);
    }
}
