package com.hardcoders.havajack.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class VerificationCodeSumDto implements Serializable {

    private Integer sum;
}
