package ru.runner.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
public class Builder {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

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
    @ManyToOne(optional = false, cascade = CascadeType.DETACH)
    @JoinColumn(name = "language_id", nullable = false)
    private Language language;

}
