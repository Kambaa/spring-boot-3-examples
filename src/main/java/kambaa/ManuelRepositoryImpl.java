package kambaa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ManuelRepositoryImpl implements ManuelRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<DemoEntity> getSomeDemoEntityList() {
        return entityManager.createNativeQuery("""
                        SELECT d.*
                        FROM DEMO d
                        ORDER BY d.id
                        """, DemoEntity.class)
//                              .unwrap(org.hibernate.query.Query.class)
//                .setHint("org.hibernate.cacheable", true)
//                .setResultTransformer(new PostDTOResultTransformer())
                .getResultList();
    }

    @Override
    public DemoEntity getSomeDemoEntity(Long id) {
        return (DemoEntity) entityManager.createNativeQuery("""
                        SELECT d.id,
                               d.name,
                               d.surname
                        FROM DEMO d
                        Where d.id=:id
                        """, DemoEntity.class)
//                .setHint("org.hibernate.cacheable", true)
                .setParameter("id", id)
                .getSingleResult();
    }
}
