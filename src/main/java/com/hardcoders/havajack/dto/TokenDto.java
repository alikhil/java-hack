package com.hardcoders.havajack.dto;

import lombok.*;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TokenDto implements Serializable {
    String token;
}
