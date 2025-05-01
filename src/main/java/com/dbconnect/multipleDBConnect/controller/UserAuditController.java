package com.dbconnect.multipleDBConnect.controller;

import com.dbconnect.multipleDBConnect.entities.auditentity.Audit;
import com.dbconnect.multipleDBConnect.entities.userentity.UserInfo;
import com.dbconnect.multipleDBConnect.service.UserAuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/muldb")
public class UserAuditController {

    @Autowired
    private UserAuditService userAuditService;

    @PostMapping("/user")
    public UserInfo saveUser(@RequestBody UserInfo user){
        return userAuditService.saveUser(user);
    }

    @PostMapping("/audit")
    public Audit saveAudit(@RequestBody Audit audit){
        return userAuditService.saveAuditInfo(audit);
    }
}
