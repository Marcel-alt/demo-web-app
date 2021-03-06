package com.example.demo.dao;

import com.example.demo.model.Person;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("postgres")
public class PersonDataAccessService implements PersonDao {
  private final JdbcTemplate jdbcTemplate;

  @Autowired
  public PersonDataAccessService(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }


  @Override
  public int insertPerson(UUID id, Person person) {
    return 0;
  }

  @Override
  public List<Person> selectAllPeople() {
    final String sql = "SELECT id, name FROM person";
    return jdbcTemplate.query(sql, (resultSet, i) -> {
      UUID id = UUID.fromString(resultSet.getString("id"));
      String name = resultSet.getString("name");
      return new Person(id, name);
    });
  }

  @Override
  public Optional<Person> selectPersonByID(UUID id) {
    return Optional.empty();
  }

  @Override
  public Optional<Person> SelectPersonByID(UUID id) {
    return Optional.empty();
  }

  @Override
  public int deletePersonByID(UUID id) {
    return 0;
  }

  @Override
  public int deletePersonByID(UUID id, Person person) {
    return 0;
  }

  @Override
  public int updatePersonByID(UUID id, Person newPerson) {
    return 0;
  }
}
