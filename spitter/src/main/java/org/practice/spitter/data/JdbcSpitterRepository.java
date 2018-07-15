package org.practice.spitter.data;

import org.practice.spitter.Spitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class JdbcSpitterRepository implements SpitterRepository {

    private JdbcOperations jdbc;

    @Autowired
    JdbcSpitterRepository(JdbcOperations jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public Spitter save(Spitter spitter) throws IllegalArgumentException {
        if (spitter == null)
            throw new IllegalArgumentException("The argument shouldn't be null");

        jdbc.update(
                "INSERT INTO Spitter (username, password, first_name, last_name, email) " +
                        "VALUES (?, ?, ?, ?, ?)",
                spitter.getUsername(),
                spitter.getPassword(),
                spitter.getFirstName(),
                spitter.getLastName(),
                spitter.getEmail());
        return spitter;
    }

    @Override
    public Spitter findByUsername(String username) {
        return jdbc.queryForObject(
                "SELECT id, username, NULL, first_name, last_name, email " +
                        "FROM Spitter WHERE username=?",
                new SpitterRowMapper(),
                username);
    }

    private static class SpitterRowMapper implements RowMapper<Spitter> {
        public Spitter mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Spitter(
                    rs.getLong("id"),
                    rs.getString("first_name"),
                    rs.getString("last_name"),
                    rs.getString("username"),
                    null,
                    rs.getString("email"));
        }
    }
}
