package uz.yt.springdata.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import uz.yt.springdata.dao.Book;
import uz.yt.springdata.dto.BookDTO;
import uz.yt.springdata.dto.ResponseDTO;
import uz.yt.springdata.mapping.BookMapping;
import uz.yt.springdata.repository.BookRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;


    public ResponseDTO<BookDTO> addNew(BookDTO bookDTO){
        try {
            Book book = BookMapping.toEntity(bookDTO);
            book.setId(null);
            bookRepository.save(book);
            return new ResponseDTO<>(true, 0, "OK", BookMapping.toDto(book, 1));
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseDTO<>(false, -1, "ERROR in saving", null);
        }
    }

    public ResponseDTO<List<BookDTO>> findByAuthorName(String name){
        List<Book> books = bookRepository.findByAuthorName(name, PageRequest.of(0, 3));

        if (books != null){
            List<BookDTO> bookDTOS = books
                    .stream()
                    .map(a -> BookMapping.toDto(a, 1))
                    .collect(Collectors.toList());
            return new ResponseDTO<>(true, 0, "OK", bookDTOS);
        }

        return new ResponseDTO<>(false, -1, "NOT FOUND", null);

    }

    public ResponseDTO<Page<BookDTO>> getAllBooks(Integer size, Integer page){
        PageRequest pageable = PageRequest.of(page, size);
        Page<Book> books = bookRepository.findAll(pageable);
        if (!books.isEmpty()){
            List<BookDTO> response = new ArrayList<>();
            for (Book book : books){
                response.add(BookMapping.toDto(book, 1));
            }

            Page<BookDTO> result = new PageImpl(response, books.getPageable(), books.getTotalElements());
            return new ResponseDTO<>(true, 0, "OK", result);
        }

        return new ResponseDTO<>(false, -1, "ERROR", null);
    }

    public ResponseDTO<BookDTO> update(BookDTO bookDTO) {
        try {
            if (bookDTO.getId() == null){
                return new ResponseDTO<>(false, -2, "ID bo'sh bo'lishi mumkin emas", bookDTO);
            }

            Optional<Book> _book = bookRepository.findById(bookDTO.getId());
            if (!_book.isPresent()){
                return new ResponseDTO<>(false, -3, "Bu ID bo'yicha ma'lumot mavjud emas", bookDTO);
            }
            Book book = _book.get();
            BookMapping.setEntity(book, bookDTO);

            bookRepository.save(book);

            return new ResponseDTO<>(true, 0, "OK", bookDTO);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseDTO<>(false, 0, e.getMessage(), null);
        }
    }
}
