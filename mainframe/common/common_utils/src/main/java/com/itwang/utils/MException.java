package com.itwang.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: whiteanbird
 * @Descripter:
 * @Date: 2020:10:06  22:26
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MException extends RuntimeException{
    private Integer code;

    private String message;
}
