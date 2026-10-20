package cz.osu.mydemo.firstapp.user.controllers;

import cz.osu.mydemo.firstapp.user.Address;
import cz.osu.mydemo.firstapp.user.User;
import cz.osu.mydemo.firstapp.user.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/user")
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/hello")
    public User getUser() {
        User user = new User();
        user.setId(1L);
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setAge(30);
        user.setUsername("johndoe");
        user.setEmail("john.doe@example.com");
        user.setPhoneNumber("+420123456789");
        return user;
    }

    @PostMapping
    public User getPostUser() {
        User user = new User();
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setAge(30);
        user.setUsername("johndoe");
        user.setEmail("john.doe@example.com");
        user.setPhoneNumber("+420123456789");

        Address address = new Address();
        address.setStreet("123 Main Street");
        address.setCity("Ostrava");
        address.setState("Moravian-Silesian Region");
        address.setPostalCode("702 00");
        address.setCountry("Czech Republic");

        Address secondAddress = new Address();
        secondAddress.setStreet("456 Oak Avenue");
        secondAddress.setCity("Prague");
        secondAddress.setState("Prague");
        secondAddress.setPostalCode("110 00");
        secondAddress.setCountry("Czech Republic");

        user.addAddress(address);
        user.addAddress(secondAddress);

        return userRepository.save(user);
    }
}
