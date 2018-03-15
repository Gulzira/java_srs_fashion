package kz.kaznitu.lessons.reposotories;

import kz.kaznitu.lessons.models.Brand;
import org.springframework.data.repository.CrudRepository;

public interface BrandRepository extends CrudRepository<Brand,Long> {
    Brand getUserById(long id);
}
