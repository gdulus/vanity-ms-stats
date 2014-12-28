package ms.vanity.stats.repositores

import ms.vanity.stats.domains.ArticlePopularity
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.Repository

interface ArticlePopularityRepository extends Repository<ArticlePopularity, Long> {

    @Query("select new map(articleId as id, max(rank) as rank) from ArticlePopularity where day >= ?1 group by articleId order by max(rank) desc")
    public List<Map<String, ?>> find(Date day, Pageable pageable)

    @Query("select count(distinct articleId) from ArticlePopularity where day >= ?1")
    public Integer count(Date day)

}
