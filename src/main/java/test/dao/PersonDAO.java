package test.dao;

import org.springframework.stereotype.Component;
import test.models.Person;

import javax.swing.text.ParagraphView;
import java.util.ArrayList;
import java.util.List;
@Component
public class PersonDAO {
    static int PEOPLE_COUNT = 0;
    private final List<Person> people;
    {
        people = new ArrayList<>();
        people.add(new Person(++PEOPLE_COUNT,"Alice"));
        people.add(new Person(++PEOPLE_COUNT, "Bob"));
        people.add(new Person(++PEOPLE_COUNT, "Mike"));
        people.add(new Person(++PEOPLE_COUNT, "Kate"));
    }
    public List<Person> index() {
        return people;
    }

    public Person show(int id){
            return people.stream().filter(person->person.getId() == id).findAny().orElse(null);

    }
}
