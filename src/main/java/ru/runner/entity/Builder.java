package ru.runner.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Builder {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    @Type(type = "text")
    private String version;

    @Getter
    @Setter
    @Type(type = "text")
    private String logo;

    @Getter
    @Setter
    @Transient
    @ManyToMany(mappedBy = "languages")
    private Set<Project> builders;
}
