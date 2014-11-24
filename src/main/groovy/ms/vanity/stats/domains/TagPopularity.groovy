package ms.vanity.stats.domains

import javax.persistence.DiscriminatorValue
import javax.persistence.Entity
import javax.validation.constraints.NotNull

@Entity
@DiscriminatorValue('vanity.stats.TagPopularity')
class TagPopularity extends Popularity {

    @NotNull
    Long tagId

}