package cz.suky.taxonomy.server.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * User: msoukup
 * Date: 2/12/2016
 * Time: 22:52
 */
@Entity
public class User extends AbstractEntity {

    private String username;

    private String firstName;

    private String lastName;

    private String password;

    private Role role;

    public String getUsername() {
        return username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
