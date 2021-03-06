package com.tensquare.article.dao;

import com.tensquare.article.pojo.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * 数据访问接口
 *
 * @author Administrator
 */
public interface ArticleDao extends JpaRepository<Article, String>, JpaSpecificationExecutor<Article> {
    /**
     * 文章审核 修改state
     *
     * @param id
     */
    @Modifying
    @Query(value = "update Article set state = '1' where id=?1")
    void examine(String id);

    /**
     * 文章点赞
     *
     * @param articleid
     */
    @Modifying
    @Query("update Article set thumbup=thumbup+1 where id=?1")
    void thumbup(String articleid);
}
