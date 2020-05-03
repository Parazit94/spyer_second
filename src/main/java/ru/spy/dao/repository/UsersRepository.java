package ru.spy.dao.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.spy.dao.entity.UserEntity;

import java.util.Optional;

@Repository
public interface UsersRepository extends CrudRepository<UserEntity, Long> {

    Optional<UserEntity> findByLogin(String login);
}
