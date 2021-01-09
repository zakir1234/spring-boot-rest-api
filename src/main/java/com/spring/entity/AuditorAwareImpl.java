package com.spring.entity;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;

import com.spring.common.util.UserInfoUtils;

public class AuditorAwareImpl implements AuditorAware<String> {

	@Override
	public Optional<String> getCurrentAuditor() {
		return Optional.of(UserInfoUtils.getLoggedInUser());		
	}
}
