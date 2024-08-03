package com.Try.Production_Base.Repository.ThreeClass;

import com.Try.Production_Base.Entity.ThreeClasses.FirstEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FirstRepo extends JpaRepository<FirstEntity,Long> {

    @Query(value = "SELECT f.id, f.f1, f.f2, " +
            "       s.s1, s.s2, " +
            "       t.t1, t.t2 " +
            "FROM first_entity f " +
            "JOIN second_entity s ON f.id = s.first_id " +
            "JOIN third_entity t ON s.id = t.second_id " +
            "WHERE s.s1 = :s1", nativeQuery = true)
    List<FirstRepoImpl> getThreeTablesData(@Param("s1") String s1);

}
