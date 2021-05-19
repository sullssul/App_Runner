package ru.runner.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "t_project")
public class Project {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    @ManyToOne(optional = false, cascade = CascadeType.DETACH)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    @Type(type = "text")
    private String sourceUrl;

    @Getter
    @Setter
    @Type(type = "text")
    private String description;

    @Getter
    @Setter
    @Type(type = "text")
    private String logo;

    @Getter
    @Setter
    private Date creatingDate;

    @Getter
    @Setter
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Language> languages;

}
