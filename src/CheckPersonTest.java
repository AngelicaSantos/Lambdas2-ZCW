package src;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

import static junit.framework.TestCase.assertTrue;

public class CheckPersonTest {

   List<Person> list = new LinkedList<>();
   Person person1 = new Person("Angie", LocalDate.of(1992, 8, 13), Person.Sex.FEMALE, "myemail@gmail.com");
   Person person2 = new Person ("Stephanie", LocalDate.of(1994,1,6),Person.Sex.FEMALE,"stephy@gmail.com");
   Person person3 = new Person ("Deon",LocalDate.of(1993,1,26),Person.Sex.MALE,"d5jones@gmail.com");
   Person person4 = new Person ("Kevin",LocalDate.of(1992,5,3),Person.Sex.MALE,"kevinmorel@gmail.com");
   private Person[] persons;


   @Before
   public void setUp() {
      list.add(person1);
      list.add(person2);
      list.add(person3);
      list.add(person4);

   }

   @Test
   public void localTest() {
      //given:
      ChecksPerson checksPerson = new ChecksPerson();
      personCheck tester = checksPerson.new localChecker();

      //When:
      List<Person> expected = ChecksPerson.check(list, tester);

      //Then:
      assertTrue(hasExpected(expected, person1, person3));
   }

   @Test
   public void anonymousTest() {
      //given:
      ChecksPerson checksPerson = new ChecksPerson();
      personCheck tester = (personCheck) checksPerson.anonymous();

      //When:
      List<Person> expected = ChecksPerson.check(list, tester);

      //Then:
      assertTrue(hasExpected(expected, person1, person3));
   }

   @Test
   public void lambdaClassTest() {

      //Given
      Predicate<Person> predicate = (person) ->
              person.getGender() == Person.Sex.MALE && person.getAge() >= 18;
      ChecksPerson personChecker = new ChecksPerson();
      personCheck tester = personChecker.new LambdaChecker(predicate);

      //When
      List<Person> expected = ChecksPerson.check(list, tester);

      //Then
      assertTrue(hasExpected(expected, person1, person3));
   }



   private boolean hasExpected(List<Person> expected, Person person1, Person person3) {
      list.stream().forEach(person -> System.out.print(person.getName() + " "));
      System.out.println();
      for(Person person : persons) {
         if(!list.contains(person)) return false;
      }
      return true;
   }




   }





