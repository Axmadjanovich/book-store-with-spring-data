package uz.yt.springdata.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.yt.springdata.dto.TimeTableDTO;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClassDTO {
    private Integer id;

    private String class_name;

    private Integer class_count;

    private TimeTableDTO timeTableDTO;

    public ClassDTO(Integer id, String class_name, Integer class_count) {
        this.id = id;
        this.class_name = class_name;
        this.class_count = class_count;
    }
}
