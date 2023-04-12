package kambaa;

import jakarta.persistence.QueryHint;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DemoRepository extends CrudRepository<DemoEntity, Long> {

    @Query(value = "from DemoEntity d where d.id between 1 and 101", nativeQuery = false)
    @QueryHints({@QueryHint(name = "org.hibernate.cacheable", value = "true")})
    public List<DemoEntity> getCustomDemoEntities();

}
