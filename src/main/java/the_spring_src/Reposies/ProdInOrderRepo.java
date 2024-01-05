package the_spring_src.Reposies;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;
import the_spring_src.Domains.ProdInOrderEntity;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Repository
public class ProdInOrderRepo implements JpaRepository <ProdInOrderEntity, Integer>{

    @Override
    public void flush() {

    }

    @Override
    public <S extends ProdInOrderEntity> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends ProdInOrderEntity> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<ProdInOrderEntity> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> integers) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public ProdInOrderEntity getOne(Integer integer) {
        return null;
    }

    @Override
    public ProdInOrderEntity getById(Integer integer) {
        return null;
    }

    @Override
    public ProdInOrderEntity getReferenceById(Integer integer) {
        return null;
    }

    @Override
    public <S extends ProdInOrderEntity> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends ProdInOrderEntity> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends ProdInOrderEntity> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends ProdInOrderEntity> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends ProdInOrderEntity> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends ProdInOrderEntity> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends ProdInOrderEntity, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends ProdInOrderEntity> S save(S entity) {
        return null;
    }

    @Override
    public <S extends ProdInOrderEntity> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<ProdInOrderEntity> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public List<ProdInOrderEntity> findAll() {
        return null;
    }

    @Override
    public List<ProdInOrderEntity> findAllById(Iterable<Integer> integers) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(ProdInOrderEntity entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends ProdInOrderEntity> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<ProdInOrderEntity> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<ProdInOrderEntity> findAll(Pageable pageable) {
        return null;
    }
}
