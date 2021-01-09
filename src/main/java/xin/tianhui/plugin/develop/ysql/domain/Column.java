package xin.tianhui.plugin.develop.ysql.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @author xiaobang_1118
 */
@Data
public class Column implements Serializable {
    private String fixed;

    private String key;

    private String title;

    private String width;
}
