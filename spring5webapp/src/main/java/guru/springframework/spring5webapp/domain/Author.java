package guru.springframework.spring5webapp.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class Author {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;

private String firstName;
private String lastName;

@ManyToMany(mappedBy = "authors")
private Set<Book> books = new HashSet<>();

public Author() {
}

public Author(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
}

@Override
public String toString() {
    return "Author{" +
               "id=" + id +
               ", firstName='" + firstName + '\'' +
               ", lastName='" + lastName + '\'' +
               ", books=" + books +
               '}';
}

@Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Author author = (Author) o;
    return id != null ? id.equals(author.id) : author.id == null;
}

@Override
public int hashCode() {
    return id != null ? id.hashCode() : 0;

}
}
