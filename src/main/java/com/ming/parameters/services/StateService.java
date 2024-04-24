package com.ming.parameters.services;

import com.ming.parameters.models.State;
import com.ming.parameters.repositories.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StateService {
    @Autowired
    private StateRepository stateRepository;
    //get all states
    public List<State> findAll(){
        return stateRepository.findAll();
    }
//get states by id
    public State findById(Integer id){
        return stateRepository.findById(id).orElse(null);

    }
// delete state
    public void delete(Integer id){
        stateRepository.deleteById(id);
    }
//update state
    public void save(State state){
        stateRepository.save(state);
    }
}
