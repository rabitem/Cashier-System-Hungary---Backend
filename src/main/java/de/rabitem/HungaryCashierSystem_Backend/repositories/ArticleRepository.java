package de.rabitem.HungaryCashierSystem_Backend.repositories;

import de.rabitem.HungaryCashierSystem_Backend.entities.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Integer> {
    Optional<Article> findByArticleCode(final int articleCode);
}

