package cz.suky.taxonomy.server.api;

import cz.suky.taxonomy.server.api.dto.Login;
import cz.suky.taxonomy.server.entity.User;
import cz.suky.taxonomy.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by none_ on 03/14/16.
 */
@RestController
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/api/login")
    public ResponseEntity<Void> login(@RequestBody Login login) {
        if (userService.verifyUser(login.username, login.password)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
