package ms.vanity.stats.config

import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.EnableAspectJAutoProxy
import org.springframework.transaction.annotation.EnableTransactionManagement

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
@EnableTransactionManagement
class BaseConfig {

}
