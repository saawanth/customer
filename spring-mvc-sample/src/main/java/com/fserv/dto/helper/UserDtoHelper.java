package com.fserv.dto.helper;

import org.springframework.stereotype.Component;

import com.fserv.dto.UsrDto;
import com.fserv.jpa.model.UserJpa;

@Component
public class UserDtoHelper implements DtoHelper<UsrDto, UserJpa> {

  @Override
  public UserJpa dtoToModel(UsrDto dto) {
    return null;
  }

  @Override
  public UsrDto modelToDto(UserJpa model) {
    return null;
  }

}
