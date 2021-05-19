package ru.runner.entity;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;
import java.util.Set;

@Entity
public class Language {

    @Getter
    @Setter
    @Id
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
    private Set<Project> projects;
}
