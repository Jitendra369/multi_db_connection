package com.dbconnect.multipleDBConnect.service;

import com.dbconnect.multipleDBConnect.entities.auditentity.Audit;
import com.dbconnect.multipleDBConnect.entities.userentity.UserInfo;
import com.dbconnect.multipleDBConnect.repo.audit.AuditRepo;
import com.dbconnect.multipleDBConnect.repo.user.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAuditService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private AuditRepo auditRepo;


    public UserInfo saveUser(UserInfo user){
        UserInfo save = userRepo.save(user);
        return save;
    }


    public Audit saveAuditInfo(Audit audit){
        Audit save = auditRepo.save(audit);
        return save;
    }
}
