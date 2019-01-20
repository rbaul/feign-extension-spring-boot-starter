package com.github.rbaul.spring.boot.sample.client.feign.extension.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@FieldNameConstants
public class SampleDto {
    private Long id;

    @NotNull
    private String name;

    private String description;

}
