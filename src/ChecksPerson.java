package src;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

public class ChecksPerson {

public static List<Person> check (List<Person> persons, personCheck testing ) {
List<Person> list = new LinkedList<>();
for(Person person: persons ) {
    if(testing.test(person))list.add(person);
}

return list;

}

    private boolean test(Person persons) {
        return false;
    }

class localChecker implements personCheck {
    public boolean test (Person person) {
        return person.getGender().equals(Person.Sex.FEMALE) && person.getAge() >=21;

    }

}

public ChecksPerson anonymous() {
    ChecksPerson anonymousCheck = new ChecksPerson() {
        public boolean test(Person person) {
            return person.getGender().equals(Person.Sex.FEMALE) && person.getAge() >= 21;
        }

    };
    return anonymousCheck;
}

    class LambdaChecker implements personCheck {

        Predicate<Person> predicate;

        LambdaChecker(Predicate<Person> predicate) {
            this.predicate = predicate;
        }

        public boolean test(Person person) {
            return predicate.test(person);
        }


    }
}

