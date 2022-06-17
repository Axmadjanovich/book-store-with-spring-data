package uz.yt.springdata.mapping;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import uz.yt.springdata.dao.Book;
import uz.yt.springdata.dto.BookDTO;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, typeConversionPolicy = ReportingPolicy.IGNORE)
public interface BookMapper{

//    @Mapping(target = "publishedDate", source = "publishedDate", dateFormat = "dd.MM.yyyy")
//    BookDTO toDto(Book book);
//    @Mapping(target = "publishedDate", source = "publishedDate", dateFormat = "dd.MM.yyyy")
//    Book toEntity(BookDTO bookDTO);
//    List<BookDTO> toDtoList(List<Book> books);
//    List<Book> toEntityList(List<BookDTO> bookDTOS);

}
