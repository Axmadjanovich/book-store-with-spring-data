package uz.yt.springdata.rest;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import uz.yt.springdata.dao.User;
import uz.yt.springdata.dto.BookDTO;
import uz.yt.springdata.dto.ResponseDTO;
import uz.yt.springdata.dto.UserDTO;
import uz.yt.springdata.service.UserService;

@RestController
@RequestMapping("/user")
public class UserResource {

    private final UserService userService;

    public UserResource(UserService userService) {
        this.userService = userService;
    }

//    CREATE
    @PostMapping("/add")
    public ResponseDTO<UserDTO> addUser(@RequestBody UserDTO userDTO){
        return userService.addUser(userDTO);
    }

//    READ
    @GetMapping("/get-one/{id}")
    public ResponseDTO<UserDTO> getUserById(@PathVariable Integer id){
        return  userService.getUserById(id);
    }


    @GetMapping("/all-page")
    public ResponseDTO<Page<User>>  getAllUsersPage(
            @RequestParam(name = "size", defaultValue = "5" ) Integer size,
            @RequestParam(name = "page", defaultValue = "0" ) Integer page){
        return userService.getAllUsersPage(size, page);
    }

//    UPDATE
    @PutMapping("edit")
    public ResponseDTO<UserDTO> editUser(@RequestBody UserDTO userDTO){
        return userService.editUser(userDTO);
    }

//    DELETE
    @DeleteMapping("/delete/{id}")
    public ResponseDTO<UserDTO> deleteUser(@PathVariable Integer id){
        return userService.deleteUser(id);
    }




}