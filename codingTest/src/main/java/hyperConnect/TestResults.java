package hyperConnect;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Question 3.
 * Implement the studentsThatPass method, that takes a Stream<Student> and an int passingScore,
 * and returns a list of the student names that have a score greater than or equal
 * to passingScore in order of highest to lowest.
 *
 * For example:
 *
 * List<Student> students = new ArrayList<Student>();
 *
 * students.add(new Student("Mike", 80));
 * students.add(new Student("James", 57));
 * students.add(new Student("Alan", 21));
 *
 * studentsThatPass(students.stream(), 50).forEach(System.out::println);
 *
 * Should print "Mike" then "James".
 */

public class TestResults {
    public static class Student {
        private String name;
        private int score;

        public Student(String name, int score) {
            this.name = name;
            this.score = score;
        }

        public int getScore() {
            return score;
        }

        public String getName() {
            return name;
        }
    }

    public static List<String> studentsThatPass(Stream<Student> students, int passingScore) {
        /*
         * given
         * throw new UnsupportedOperationException("Waiting to be implemented.");
         */

        // implementation
        return students.filter(
                student -> student.getScore() >= passingScore
        ).sorted(
                (it, other) -> other.getScore() - it.getScore()
        ).map(
                Student::getName
        ).collect(Collectors.toList());
    }

    public static void main(String[] args) {

        List<Student> students = new ArrayList<Student>();

        students.add(new Student("Mike", 80));
        students.add(new Student("James", 57));
        students.add(new Student("Alan", 21));

        studentsThatPass(students.stream(), 50).forEach(System.out::println);
    }
}
