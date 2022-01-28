package com.react_spring_boot.Venues;

import com.react_spring_boot.Organization.Organization;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Boardroom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "boardroom_id")
    private int boardroom_id;
    @Column(name = "boardroom_name")
    private String boardroom_name;
    @Column(name = "capacity")
    private int capacity;
    @Column(name = "tv")
    private String tv;
    @Column(name = "whiteboard")
    private String whiteboard;
    @Column(name = "conference_phone")
    private String conference_phone;

//    @ToString.Exclude
//    @ManyToOne
//    @JoinColumn(name = "organization_id")
////    @NotBlank(message = "Organization cannot be blank!")
//    private Organization organization;


}
