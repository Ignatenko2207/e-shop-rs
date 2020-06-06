package info.sjd.controller;

import info.sjd.model.User;
import info.sjd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping
    public ResponseEntity<User> save(@RequestBody User user){
        User userFromDB = userService.save(user);
        if (userFromDB != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<User> update(@RequestBody User user){
        User userFromDB = userService.update(user);
        if (userFromDB != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping(path = "/{id}")
    public ResponseEntity<User> getById(@PathVariable Integer id){
        return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public ResponseEntity<List> getAll(){
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(path = "by-login")
    public ResponseEntity<User> getByLogin(@RequestParam String login){
        return new ResponseEntity<>(userService.findByLogin(login), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(path = "by-login-and-password")
    public ResponseEntity<User> getByLoginAndPassword(@RequestParam String login, @RequestParam String password){
        return new ResponseEntity<>(userService.findByLoginAndPassword(login, password), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping(path = "/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        User user = userService.findById(id);
        if (user != null) {
            userService.delete(user);
        }
        return new ResponseEntity(HttpStatus.OK);
    }

}
