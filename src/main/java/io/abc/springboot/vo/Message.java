package io.abc.springboot.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: Y.Z.Y
 * @Descriptions:
 * @Date: Created in 2022/2/13
 */
@Data
public class Message implements Serializable {

    private String content;
    private Date date;

}
