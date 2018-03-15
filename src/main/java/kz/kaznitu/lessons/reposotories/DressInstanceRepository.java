package kz.kaznitu.lessons.reposotories;

import kz.kaznitu.lessons.models.DressInstance;
import org.springframework.data.repository.CrudRepository;

public interface DressInstanceRepository extends CrudRepository<DressInstance, Long> {
    DressInstance getUserById(long id);
}
