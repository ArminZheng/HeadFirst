import com.arminzheng.observer.infrastructure.util.AttributeUtils;
import com.arminzheng.observer.pojo.Person;
import com.arminzheng.observer.pojo.Student;
import lombok.SneakyThrows;

import java.lang.reflect.Field;

/**
 * @author Armin Zheng
 * @since 2021-09-04
 */
public class CopyTest {

    @SneakyThrows
    public static void main(String[] args) {
        Person person = new Person();
        person.age = 12;
        person.sex = "male";
        Field name = person.getClass().getDeclaredField("name");
        name.setAccessible(true);
        name.set(person, "zhang3");
        System.out.println("person = " + person);
        Student student = new Student();
        AttributeUtils.copy(person, student,"c2");
        System.out.println("student(c2) = " + student);
        AttributeUtils.copy(person, student,"c1");
        System.out.println("student(c1) = " + student);
    }
}
