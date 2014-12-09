package ms.vanity.stats.services

import ms.vanity.stats.repositores.ArticlePopularityRepository
import ms.vanity.stats.repositores.TagPopularityRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class PopularityService {

    @Autowired
    private ArticlePopularityRepository articlePopularityRepository

    @Autowired
    private TagPopularityRepository tagPopularityRepository

    @Value('${ms.stats.popularity.maxPositions}')
    private Integer defaultMaxPositions

    @Transactional(readOnly = true)
    public List<Map<String, ?>> findPopularTags(final Date date, final Integer page = 0, final Integer size = null) {
        tagPopularityRepository.findPopularTags(date.clearTime(), new PageRequest(page, size ?: defaultMaxPositions))
    }

    @Transactional(readOnly = true)
    public List<Map<String, ?>> findPopularArticles(final Date date, final Integer page = 0, final Integer size = null) {
        articlePopularityRepository.findPopularArticles(date.clearTime(), new PageRequest(page, size ?: defaultMaxPositions))
    }
}
