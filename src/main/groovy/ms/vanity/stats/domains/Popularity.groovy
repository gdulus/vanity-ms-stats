package ms.vanity.stats.domains

import javax.persistence.DiscriminatorColumn
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.validation.constraints.Min
import javax.validation.constraints.NotNull

@Entity
@DiscriminatorColumn(name = "class")
abstract class Popularity {

    @Id
    @GeneratedValue
    Long id

    @NotNull
    @Min(0L)
    Integer rank = 0

    @NotNull
    Date day

}