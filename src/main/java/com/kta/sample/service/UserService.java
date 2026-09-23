package com.kta.sample.service;

import com.kta.sample.dto.UserDTO;
import com.kta.sample.dto.UserRecord;
import com.kta.sample.exception.UserFetchException;
import org.springframework.resilience.annotation.Retryable;

public interface UserService {

    @Deprecated
    UserDTO getUserDetails(Long userId);

    @Retryable(includes = {UserFetchException.class},// Exceptions to trigger a retry
            maxRetries = 3,                   // 3 extra retries after the first failure
            delayString = "1000ms",           // Base wait duration
            multiplier = 2.0,                 // Exponential backoff strategy
            maxDelay = 5000
    )// Cap on max wait time
    UserRecord getUser(Long userId);

    String getUserFailureMessage(UserFetchException userFetchException);
}
