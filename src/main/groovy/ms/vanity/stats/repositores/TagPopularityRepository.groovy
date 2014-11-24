package ms.vanity.stats.repositores

import ms.vanity.stats.domains.TagPopularity
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.Repository

interface TagPopularityRepository extends Repository<TagPopularity, Long> {

    @Query("select new map(tagId as id, max(rank) as rank) from TagPopularity where day >= ?1 group by tagId order by max(rank) desc")
    public List<Map<String, ?>> findPopularTags(Date day, Pageable pageable)

}
