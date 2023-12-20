package the_spring_src.Reposies;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import the_spring_src.Domains.ProdInOrderEntity;

@Repository
public abstract class ProdInOrderRepo implements JpaRepository <ProdInOrderEntity, Integer>{

}
