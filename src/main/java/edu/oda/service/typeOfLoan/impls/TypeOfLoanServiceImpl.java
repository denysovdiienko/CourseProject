package edu.oda.service.typeOfLoan.impls;

import edu.oda.model.TypeOfLoan;
import edu.oda.repository.FakeTypeOfLoanRepository;
import edu.oda.repository.TypeOfLoanMongoRepository;
import edu.oda.service.typeOfLoan.interfaces.ITypeOfLoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TypeOfLoanServiceImpl implements ITypeOfLoanService {
    @Autowired
    FakeTypeOfLoanRepository repository;

    @Autowired
    TypeOfLoanMongoRepository mongoRepository;

    @PostConstruct
    void init(){
        List<TypeOfLoan> list = repository.getAll();
        mongoRepository.saveAll(list);
    }
    @Override
    public TypeOfLoan create(TypeOfLoan typeOfLoan) {
        typeOfLoan.setCreatedAt(LocalDateTime.now());
        typeOfLoan.setUpdatedAt(LocalDateTime.now());
        return mongoRepository.save(typeOfLoan);
    }

    @Override
    public TypeOfLoan get(String id) {
        return mongoRepository.findById(id).get();
    }

    @Override
    public TypeOfLoan update(TypeOfLoan typeOfLoan) {
        TypeOfLoan typeOfLoanToUpdate = this.get(typeOfLoan.getId());
        LocalDateTime creation = typeOfLoanToUpdate.getCreatedAt();
        typeOfLoan.setCreatedAt(creation);
        typeOfLoan.setUpdatedAt(LocalDateTime.now());
        return mongoRepository.save(typeOfLoan);
    }

    @Override
    public TypeOfLoan delete(String id) {
        TypeOfLoan typeOfLoan = this.get(id);
        mongoRepository.deleteById(id);
        return typeOfLoan;
    }

    @Override
    public List<TypeOfLoan> getAll() {
        return mongoRepository.findAll();
    }
}
