package br.com.sancho.rest_api_spring_boot.mapper.custom;

import br.com.sancho.rest_api_spring_boot.data.vo.v2.PersonVOV2;
import br.com.sancho.rest_api_spring_boot.model.Person;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PersonMapper {

    public PersonVOV2 convertEntityToVo(Person person) {
        PersonVOV2 vo = new PersonVOV2();
        vo.setId(person.getId());
        vo.setFirstName(person.getFirstName());
        vo.setLastName(person.getLastName());
        vo.setAddress(person.getAddress());
        vo.setGender(person.getGender());
        vo.setBirthDay(new Date());

        return vo;
    }

    public Person convertVoToEntity(PersonVOV2 person) {
        Person entity = new Person();
        entity.setId(person.getId());
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());
//        vo.setBirthDay(new Date());

        return entity;
    }

}
