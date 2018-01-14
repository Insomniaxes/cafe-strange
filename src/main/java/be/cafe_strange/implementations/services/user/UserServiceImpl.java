package be.cafe_strange.implementations.services.user;

import be.cafe_strange.enums.AuthorizationRole;
import be.cafe_strange.implementations.services.EmailValidator;
import be.cafe_strange.interfaces.repositories.UserRepo;
import be.cafe_strange.interfaces.services.UserService;
import be.cafe_strange.models.user.Role;
import be.cafe_strange.models.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public User findById(int id) {
        return userRepo.findById(id);
    }

    @Override
    public User findByUsername(String username) {
        return userRepo.findByUsername(username);
    }

    @Override
    public User findByEmail(String email) {
        return userRepo.findByEmail(email);
    }

    @Override
    public List<User> findAll() {
        return userRepo.findAll();
    }

    @Override
    public List<User> findByLastName(String lastName) {
        return userRepo.findByLastName(lastName);
    }

    @Override
    public List<User> findByRole(String role) {
        return userRepo.findByRole(role);
    }

    @Override
    public User create(User user) {
        Calendar calendar = Calendar.getInstance();
        user.setJoinDate(new java.sql.Date(calendar.getTime().getTime()));
        userRepo.create(user);
        return userRepo.findByUsername(user.getUsername());
    }

    @Override
    public boolean update(User user) {
        user.setPassword(findById(user.getId()).getPassword());
        user.setRoles(findById(user.getId()).getRoles());
        user.setJoinDate(findById(user.getId()).getJoinDate());
        return userRepo.update(user);
    }

    // todo nog confirmatie
    @Override
    public boolean delete(int userId) {
        return userRepo.delete(userId);
    }

    @Override
    public String checkUserCreateFormData(User user, String passwordRetype) {
        StringBuilder errorMessage = new StringBuilder();
        if (!user.getPassword().equals(passwordRetype)) {
            errorMessage.append("<br>Wachtwoorden stemmen niet overeen");
        }
        if (findByUsername(user.getUsername()) != null) {
            errorMessage.append("<br>Gebruikersnaam is reeds in gebruik");
        }
        if (user.getUsername().isEmpty()) {
            errorMessage.append("<br>Gelieve een gebruikersnaam in te vullen");
        }
        if (user.getFirstName().isEmpty()) {
            errorMessage.append("<br>Gelieve uw voornaam in te vullen");
        }
        if (user.getLastName().isEmpty()) {
            errorMessage.append("<br>Gelieve uw achternaam in te vullen");
        }
        if (user.getBirthday().toLocalDate().isAfter(LocalDate.now()) | user.getBirthday() == null){
            errorMessage.append("<br>Gelieve een corecte geboortedatum in te vullen");
        }
        EmailValidator emailValidator = new EmailValidator();
        if (!emailValidator.validateEmail(user.getEmail())) {
            errorMessage.append("<br>Gelieve een correct emailadres in te vullen");
        }
        if (findByEmail(user.getEmail()) != null) {
            errorMessage.append("<br>Email adres is reeds in gebruik");
        }
        return errorMessage.toString();
    }

}