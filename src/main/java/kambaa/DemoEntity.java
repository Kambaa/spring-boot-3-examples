package kambaa;

import jakarta.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "DEMO")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class DemoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column
    private String name;
    @Column
    private String surname;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public DemoEntity(long id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public DemoEntity() {
    }
}
