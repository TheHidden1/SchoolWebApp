package com.school.webpage.audit;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Optional;
// Implementation of AudotorAware to identify who is logged in user who is trying to perform certain action
//Optional because the user can be Anonymous, then the return will be null
@Component("auditAwareImpl") // bean name
public class AuditAwareImpl implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication().getName());
    }
}
