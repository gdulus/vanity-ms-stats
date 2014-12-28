package ms.vanity.stats.services

import ms.vanity.stats.dto.PageableResult
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
    public PageableResult findPopularTags(final Date from, final Integer page = 0, final Integer size = defaultMaxPositions) {
        Integer total = tagPopularityRepository.count(from)
        List<Map<String, ?>> pageResult = tagPopularityRepository.find(from, new PageRequest(page, size))
        return new PageableResult(total, pageResult)
    }

    @Transactional(readOnly = true)
    public PageableResult findPopularArticles(final Date from, final Integer page = 0, final Integer size = defaultMaxPositions) {
        Integer total = articlePopularityRepository.count(from)
        List<Map<String, ?>> pageResult = articlePopularityRepository.find(from, new PageRequest(page, size))
        return new PageableResult(total, pageResult)
    }
}
