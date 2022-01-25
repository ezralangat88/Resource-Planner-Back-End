package com.react_spring_boot.Organization;

import com.react_spring_boot.User.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int organizationId;

    @Column(name = "organizationName")
    private String organizationName;

    @OneToMany(mappedBy = "organization")
    List<User> users = new ArrayList<>();
}
