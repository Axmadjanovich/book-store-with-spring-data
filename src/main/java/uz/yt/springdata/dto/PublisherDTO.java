package uz.yt.springdata.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PublisherDTO {

    private Integer id;
    private String name;
    private AddressDTO address;
    private List<BookDTO> books;
}
