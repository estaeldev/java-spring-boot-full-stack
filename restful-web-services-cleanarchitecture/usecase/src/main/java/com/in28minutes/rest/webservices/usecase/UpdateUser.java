package com.in28minutes.rest.webservices.usecase;

import java.util.UUID;

import com.in28minutes.rest.webservices.core.domain.User;

public interface UpdateUser {

    User update(User user);

    User updateById(UUID id, User user);

}
