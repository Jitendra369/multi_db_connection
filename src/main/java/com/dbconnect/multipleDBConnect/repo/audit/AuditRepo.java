package com.dbconnect.multipleDBConnect.repo.audit;

import com.dbconnect.multipleDBConnect.entities.auditentity.Audit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditRepo extends JpaRepository<Audit, Integer> {
}
