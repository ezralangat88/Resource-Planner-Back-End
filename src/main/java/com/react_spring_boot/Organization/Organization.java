package com.react_spring_boot.Organization;

import com.react_spring_boot.User.User;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity


public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int organizationId;

    @Column(name = "organizationName")
    private String organizationName;

    @OneToMany(mappedBy = "organization")
    List<User> users = new ArrayList<>();


}
