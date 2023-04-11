package kambaa;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DemoRepository extends CrudRepository<DemoEntity, Long> {

    @Query(value = "Select id,name,surname from DEMO where id between 1 and 101", nativeQuery = true)
    public List<DemoEntity> getCustomDemoEntities();

}
