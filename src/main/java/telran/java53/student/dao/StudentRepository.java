package telran.java53.student.dao;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import telran.java53.student.model.Student;

public interface StudentRepository extends MongoRepository<Student, Long> {
    Stream<Student> getAllBy();

    Stream<Student> findByNameIgnoreCase(String name);

    long countByNameIgnoreCase(Set<String> name);

    @Query("{\'scores.?0': {$gt:?1}}")
    Stream<Student> findByExamAndScoreGreaterThen(String exam, int score);
}
