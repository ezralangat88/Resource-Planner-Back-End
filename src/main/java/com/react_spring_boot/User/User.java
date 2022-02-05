package com.react_spring_boot.User;


import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.react_spring_boot.Organization.Organization;
import com.react_spring_boot.Role.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIncludeProperties({"id","firstName", "lastName","username","phoneNo", "gender"})
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String phoneNo;
    private String gender;

    @ManyToOne
//    @NotBlank(message = "Organization is required")
    @JoinColumn(name = "organization_id")
    private Organization organization;

    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Role> roles = new ArrayList<>();

}

