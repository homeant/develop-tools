package xin.tianhui.plugin.develop.tools.tool.unixtime;

import lombok.Data;

import java.io.Serializable;

@Data
public class DateType implements Serializable {
    private String type;

    private String title;

    public DateType(String type,String title){
        this.type = type;
        this.title = title;
    }
}
