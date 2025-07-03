package com.pedrooomv.crud_usuarios.repository;

import com.pedrooomv.crud_usuarios.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
