package com.example.webservice.dto;

import com.example.webservice.web.dto.HelloResponseDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class HelloResponseDtoTest {
    @Test
    public void dtoTest() {
        //given
        String name = "test";
        int amount = 10000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        //then
        Assertions.assertThat(dto.name()).isEqualTo(name);
        Assertions.assertThat(dto.amount()).isEqualTo(amount);
    }
}