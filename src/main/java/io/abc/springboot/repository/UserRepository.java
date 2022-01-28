package io.abc.springboot.repository;

import io.abc.springboot.model.UserRecord;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserRecord, String> {
}
