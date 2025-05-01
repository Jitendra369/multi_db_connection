package com.dbconnect.multipleDBConnect.repo.user;

import com.dbconnect.multipleDBConnect.entities.userentity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<UserInfo, Integer> {
}
