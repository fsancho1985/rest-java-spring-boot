package br.com.sancho.rest_api_spring_boot.services;

import br.com.sancho.rest_api_spring_boot.data.vo.v1.PersonVO;
import br.com.sancho.rest_api_spring_boot.data.vo.v2.PersonVOV2;
import br.com.sancho.rest_api_spring_boot.exceptions.ResourceNotFoundException;
import br.com.sancho.rest_api_spring_boot.mapper.DozerMapper;
import br.com.sancho.rest_api_spring_boot.mapper.custom.PersonMapper;
import br.com.sancho.rest_api_spring_boot.model.Person;
import br.com.sancho.rest_api_spring_boot.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    @Autowired
    PersonRepository repository;

    @Autowired
    PersonMapper mapper;

    public PersonVO findById(Long id) {

        logger.info("Finding person by id!");

         var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this id!"));

         return DozerMapper.parseObject(entity, PersonVO.class);
    }

    public List<PersonVO> findAll(){

        logger.info("Finding all people!");

        return DozerMapper.parseListObjects(repository.findAll(), PersonVO.class);
    }

    public PersonVO create(PersonVO person) {

        logger.info("Creating person!");

        var entity = DozerMapper.parseObject(person, Person.class);

        var vo = DozerMapper.parseObject(repository.save(entity), PersonVO.class);

        return vo;
    }

    public PersonVOV2 createV2(PersonVOV2 person) {

        logger.info("Creating person with V2!");

        var entity = mapper.convertVoToEntity(person);

        var vo = mapper.convertEntityToVo(repository.save(entity));

        return vo;
    }

    public PersonVO update(PersonVO person) {

        logger.info("Updating person!");

        var entity = repository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this id!"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        var vo = DozerMapper.parseObject(repository.save(entity), PersonVO.class);

        return vo;
    }

    public void delete(Long id) {

        logger.info("Deleting person!");

        var entity = repository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("No records found for this id!"));

        repository.delete(entity);
    }

}
