package ms.vanity.stats.controllers

import ms.vanity.stats.services.PopularityService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

import static org.springframework.web.bind.annotation.RequestMethod.GET

@RestController
@RequestMapping(value = "/popularity")
class PopularityController {

    @Autowired
    private PopularityService service

    @RequestMapping(value = "/tags", method = GET)
    public def getTopTags(@RequestParam final Long timestamp, @RequestParam final Integer page, @RequestParam final Integer size) {
        return service.findPopularTags(new Date(timestamp), page, size)
    }

    @RequestMapping(value = "/articles", method = GET)
    public def getTopArticles(@RequestParam final Long timestamp, @RequestParam final Integer page, @RequestParam final Integer size) {
        return service.findPopularArticles(new Date(timestamp), page, size)
    }

}
