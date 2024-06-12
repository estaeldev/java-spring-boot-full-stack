package com.in28minutes.rest.webservices.restful_web_services.socialmediaapplication;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

    private static final List<User> USERS = new ArrayList<>();
    private static Integer countid = 0;

    static {
        USERS.add(new User(++countid, "Estael", LocalDate.now().minusYears(30)));
        USERS.add(new User(++countid, "Tael", LocalDate.now().minusYears(25)));
        USERS.add(new User(++countid, "Jim", LocalDate.now().minusYears(20)));
    }

    public List<User> findAll() {
        return USERS;
    }

    public User findById(Integer id) {
        Optional<User> userOpt = USERS.stream().filter(user -> user.getId().equals(id)).findFirst();
        return userOpt.orElse(null);
    }
    
    public User save(User user) {

        if(Objects.isNull(user.getId())) {
            countId();
            user.setId(countid);
            USERS.add(user);
            return user;
        }

        return null;
    }

    public void delete(Integer id) {
        User user = findById(id);

        if(Objects.nonNull(user)) {
            USERS.remove(user);
        }

    }

    private static void countId() {
        countid++;
    }
    
}
