package kz.kaznitu.lessons.reposotories;

import kz.kaznitu.lessons.models.Dress;
import org.springframework.data.repository.CrudRepository;


public interface DressRepository extends CrudRepository<Dress,Long> {
    Dress getUserById(long id);
}
