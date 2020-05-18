package info.sjd.dao;

import info.sjd.EShopRsApplication;
import info.sjd.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringJUnitConfig(EShopRsApplication.class)
class UserDAOTest {

    @Autowired
    private UserDAO userDAO;

    @Test
    void findByLogin() {
        User user = new User("testLogin", "testPassword", "testName", "testSurname");

        userDAO.save(user);
        User foundUser = userDAO.findByLogin("testLogin");

        assertNotNull(foundUser);

    }
}