package uz.yt.springdata.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DayWeekDTO {
    private Integer id;

    private String dayName;
}
