package ms.vanity.stats.dto

class PageableResult {

    public final Integer total

    public final List<?> page

    PageableResult(Integer total, List<?> page) {
        this.total = total
        this.page = page
    }
}
