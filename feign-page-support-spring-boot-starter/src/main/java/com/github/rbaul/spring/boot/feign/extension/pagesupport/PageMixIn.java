package com.github.rbaul.spring.boot.feign.extension.pagesupport;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as = SimplePageImpl.class)
public interface PageMixIn {
}
