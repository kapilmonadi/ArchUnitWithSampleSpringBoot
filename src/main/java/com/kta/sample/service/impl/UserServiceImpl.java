package com.kta.sample.service.impl;

import com.kta.sample.dto.UserDTO;
import com.kta.sample.dto.UserRecord;
import com.kta.sample.entity.User;
import com.kta.sample.exception.UserFetchException;
import com.kta.sample.exception.UserNotFoundException;
import com.kta.sample.service.UserService;
import org.apache.catalina.UserDatabase;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public UserDTO getUserDetails(Long userId) {
        return new UserDTO(1L, "Kaps", "Kumar");
    }

    @Override
    public UserRecord getUser(Long userId) {
        //TODO // for demo purpose
        //FIXME remove hardcoding and fetch an actual user from DB
        if(userId < 5){
            throw new UserFetchException("This user has been disabled");
        }
        else{
            return new UserRecord(1L, "Amit", "Kumar");
        }
    }

    @Override
    public String getUserFailureMessage(UserFetchException userFetchException) {
        throw new UserNotFoundException(userFetchException.getMessage());
    }
}
