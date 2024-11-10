package io.swagger.repository;

import io.swagger.model.Content;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContentRepository extends JpaRepository<Content, Integer> {
    @Query(value = "SELECT DISTINCT c.* FROM Content c " +
            "LEFT JOIN Content_Actor ca ON c.id = ca.content_id " +
            "LEFT JOIN Actor a ON ca.actor_id = a.id " +
            "LEFT JOIN Content_Director cd ON c.id = cd.content_id " +
            "LEFT JOIN Director d ON cd.director_id = d.id " +
            "WHERE (LOWER(c.title) LIKE LOWER('%' || :keyword || '%') " +
            "OR LOWER(c.synopsis) LIKE LOWER('%' || :keyword || '%') " +
            "OR LOWER(a.name) LIKE LOWER('%' || :keyword || '%') " +
            "OR LOWER(d.name) LIKE LOWER('%' || :keyword || '%')) " +
            "AND c.status = 'public'",
            nativeQuery = true)
    List<Content> searchByKeyword(@Param("keyword") String keyword);
}