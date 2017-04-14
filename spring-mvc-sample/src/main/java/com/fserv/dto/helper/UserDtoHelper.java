package com.fserv.dto.helper;

import org.springframework.stereotype.Component;

import com.fserv.dto.UsrDto;
import com.fserv.jpa.model.UserJpa;

@Component
public class UserDtoHelper implements DtoHelper<UsrDto, UserJpa> {

  @Override
  public UserJpa dtoToModel(UsrDto dto) {
    UserJpa user = new UserJpa();
    user.setContactNumber(Long.valueOf(dto.getContactNumber()));
    String[] nameArgs = dto.getName().split(" ");
    user.setFirstName(nameArgs[0]);
    user.setLastName(nameArgs[1]);
    user.setUsername(dto.getUsername());
    return user;
  }

  @Override
  public UsrDto modelToDto(UserJpa model) {
    UsrDto usrDto = new UsrDto();
    usrDto.setContactNumber(String.valueOf(model.getCellPhoneNumber()));
    usrDto.setName(model.getFirstName() + " " + model.getLastName());
    usrDto.setUsername(model.getUsername());
    return usrDto;
  }

}
