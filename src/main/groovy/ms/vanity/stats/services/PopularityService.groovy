package ms.vanity.stats.services

import groovy.util.logging.Slf4j
import ms.vanity.stats.repositores.ArticlePopularityRepository
import ms.vanity.stats.repositores.TagPopularityRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Slf4j
@Service
class PopularityService {

    @Autowired
    private ArticlePopularityRepository articlePopularityRepository

    @Autowired
    private TagPopularityRepository tagPopularityRepository

    @Value('${ms.stats.popularity.maxPositions}')
    private Integer defaultMaxPositions

    @Transactional(readOnly = true)
    public List<Map<String, ?>> findPopularTags(final Date date, final Integer max = null) {
        log.info('Finding popular tags starting at {}', date)
        tagPopularityRepository.findPopularTags(date.clearTime(), new PageRequest(0, max ?: defaultMaxPositions))
    }

    @Transactional(readOnly = true)
    public List<Map<String, ?>> findPopularArticles(final Date date, final Integer max = null) {
        log.info('Finding popular starting starting at {}', date)
        articlePopularityRepository.findPopularArticles(date.clearTime(), new PageRequest(0, max ?: defaultMaxPositions))
    }
}
