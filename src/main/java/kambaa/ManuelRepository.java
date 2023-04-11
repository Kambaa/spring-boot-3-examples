package kambaa;

import org.springframework.data.repository.Repository;

import java.util.List;

@org.springframework.stereotype.Repository
public interface ManuelRepository extends Repository<DemoEntity, Long> {

    List<DemoEntity> getSomeDemoEntityList();

    DemoEntity getSomeDemoEntity(Long id);

}
