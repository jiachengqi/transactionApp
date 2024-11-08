package frankfurt.transaction.Configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * Configuration class to enable JPA Auditing
 */
@Configuration
@EnableJpaAuditing
public class JpaAuditingConfig {
}