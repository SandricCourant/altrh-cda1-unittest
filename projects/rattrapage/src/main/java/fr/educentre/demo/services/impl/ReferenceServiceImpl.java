package fr.educentre.demo.services.impl;


import fr.educentre.demo.services.ReferenceService;
import org.springframework.stereotype.Service;

@Service
public class ReferenceServiceImpl implements ReferenceService {

    private int currentReference = 238394;

    @Override
    public int getNewReference() {
        return ++currentReference;
    }

}
