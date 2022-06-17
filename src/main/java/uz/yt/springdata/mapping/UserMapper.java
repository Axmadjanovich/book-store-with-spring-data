package uz.yt.springdata.mapping;

import org.mapstruct.Mapper;
import uz.yt.springdata.dao.User;
import uz.yt.springdata.dto.UserDTO;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(UserDTO userDTO);
    UserDTO toDto(User user);
}

