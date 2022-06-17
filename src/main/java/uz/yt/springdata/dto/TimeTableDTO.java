package uz.yt.springdata.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TimeTableDTO {
    private Integer id;
    @NotNull
    private DayWeekDTO day_week;
    @NotNull
    @Min(value = 1,message = "dushanbadan shanbaga qadar kamida 1-dars bo'lishi shart")
    @Max(value = 7,message = "dushanbadan shanbaga qadar maximum 7-dars bo'lishi shart")
    @Digits(integer = 10,fraction = 2 , message = "number_format error")
    private Integer lesson_numbers;
    @NotNull
    private LessonDTO lessonDTOs;
    @NotNull
    @Pattern(regexp = "\\d{4}-(0?\\d|1[012])-(0?\\d|[12]\\d|3[01])",
            message = "start-time -> date format error")
    //regex for date yyyy-MM-dd (0-9999)->(0-12)<-->(0-31)<-
    private Date start_time;
    @NotNull
    @Pattern(regexp = "\\d{4}-(0?\\d|1[012])-(0?\\d|[12]\\d|3[01])",
            message = "start-time -> date format error")

    private Date end_time;

    private RoomDTO roomDTO;

    private TeacherDTO teacherDTOs;

    private ClassDTO classDTO;

    public TimeTableDTO(Integer id, Integer lesson_numbers, Date start_time, Date end_time) {
        this.id = id;
        this.lesson_numbers = lesson_numbers;
        this.start_time = start_time;
        this.end_time = end_time;
    }

}
