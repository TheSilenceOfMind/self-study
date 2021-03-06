package org.practice.spitter;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.validator.constraints.Email;
import org.springframework.context.annotation.PropertySource;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Class representing user in the social network.
 */
public class Spitter {

    private Long id;

    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;

    public Spitter() {
    }

    public Spitter(String firstName, String lastName, String username, String password, String email) {
        this(null, firstName, lastName, username, password, email);
    }

    public Spitter(Long id, String firstName, String lastName, String username, String password, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public Spitter(Long id, Spitter spitter) {
        this.id = id;
        this.firstName = spitter.firstName;
        this.lastName = spitter.lastName;
        this.password = spitter.password;
        this.username = spitter.username;
        this.email = spitter.email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Spitter anotherSpitter = (Spitter) o;

        return new EqualsBuilder()
                .append(username, anotherSpitter.username)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(username)
                .toHashCode();
    }

    @Override
    public String toString() {
        return "Spitter{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}