package dio.apirest.controller;

import dio.apirest.model.User;
import dio.apirest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository repository;

    @GetMapping("/users")
    public List<User> getUsers(){
      return repository.findAll();
    }

    @GetMapping("/users/{username}")
    public User buscaUsuario(@PathVariable("username") String username){
        return repository.findByUsername(username);
    }

    @DeleteMapping("/users/{id}")
    public void delete(@PathVariable("id") Integer id){
        repository.deleteById(id);
    }

    @PostMapping()
    public void salvaUsuario(@RequestBody User user){
        repository.save(user);
    }

    @PutMapping()
    public void putUser(@RequestBody User user){
        repository.save(user);
    }
}
