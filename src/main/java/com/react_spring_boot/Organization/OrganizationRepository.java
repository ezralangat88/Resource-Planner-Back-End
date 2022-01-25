package com.react_spring_boot.Organization;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface OrganizationRepository extends JpaRepository<Organization, Integer> {

    @Query("SELECT o FROM Organization o WHERE o.organizationId = ?1")
    Optional<Organization> findById(Integer organizationId);
}

