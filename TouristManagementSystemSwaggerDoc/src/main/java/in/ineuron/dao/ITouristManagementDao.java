package in.ineuron.dao;

import org.springframework.data.repository.CrudRepository;

import in.ineuron.model.Tourist;

public interface ITouristManagementDao extends CrudRepository<Tourist, Integer> {

}
