package com.arminzheng;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Armin Zheng
 * @since 2021-08-25
 */
public class StreamTest {

    public static void main(String[] args) {
        new Student();
        Stream<Student> studentStream = Stream.of(
                new Student(2, 3, "小明", 80),
                new Student(3, 1, "小王", 90),
                new Student(1, 2, "小强", 100),
                new Student(3, 1, "小红", 90),
                new Student(1, 2, "小黄", 100),
                new Student(2, 3, "小黑", 80),
                new Student(1, 2, "小军", 100),
                new Student(2, 3, "小乔", 80),
                new Student(3, 1, "小林", 90));

        Map<Integer, Map<Integer, List<Student>>> studentByGradeAndClass =
                studentStream.parallel().collect(
                        Collectors.groupingBy(Student::getGradeId,
                                Collectors.groupingBy(Student::getClassId)));
        studentByGradeAndClass.forEach((k, m) -> {
            System.out.print("Grade" + k + " ");
            m.forEach((key, value) -> System.out.println("Class" + key + " = " + value));
        });

        //

        Student student = new Student();
        Student.Ant ant = student.new Ant();
        Student.Ant ant1 = new Student().new Ant();
        Student.Insect insect = new Student.Insect();
    }
}

@Data
@NoArgsConstructor
class Student {
    int gradeId; // 年级
    int classId; // 班级
    String name; // 名字
    int score; // 分数

    public Student(int gradeId, int classId, String name, int score) {
        this.gradeId = gradeId;
        this.classId = classId;
        this.name = name;
        this.score = score;
        Insect insect = new Insect();
        Insect.say();
    }

    public static void main(String[] args) {
        List<String> props = Arrays.asList("a=1", "b=2", "c=3", "b=4");
        // props.add("hhhh"); // 会报错 UnsupportedOperationException
        Map<String, String> map = props.stream().parallel()  //加上parallel() 和不加结果不一样
                .map(kv -> {
                    String[] ss = kv.split("\\=");
                    HashMap<String, String> hashMap = new HashMap<>();
                    hashMap.put(ss[0], ss[1]);
                    return hashMap;
                })
                .reduce(new HashMap<>(), (m, kv) -> {
                    m.putAll(kv);
                    return m;
                });
        map.forEach((k, v) -> {
            System.out.println(k + " = " + v);
        });
    }

    public static StudentBuilder builder() {
        return new StudentBuilder();
    }

    static class Insect {
        static String name = "aa";
        String mate = "bb";

        public static void say() {
            System.out.println("name = " + name);
        }
    }

    public static class StudentBuilder {
        private int gradeId;
        private int classId;
        private String name;
        private int score;

        StudentBuilder() {
        }

        public StudentBuilder gradeId(int gradeId) {
            this.gradeId = gradeId;
            return this;
        }

        public StudentBuilder classId(int classId) {
            this.classId = classId;
            return this;
        }

        public StudentBuilder name(String name) {
            this.name = name;
            return this;
        }

        public StudentBuilder score(int score) {
            this.score = score;
            return this;
        }

        public Student build() {
            return new Student(gradeId, classId, name, score);
        }

        public String toString() {
            return "com.arminzheng.Student.StudentBuilder(gradeId=" + this.gradeId + ", classId=" + this.classId + ", name=" + this.name + ", score=" + this.score + ")";
        }
    }

    class Ant {
        String mate = "bb";
    }
}
