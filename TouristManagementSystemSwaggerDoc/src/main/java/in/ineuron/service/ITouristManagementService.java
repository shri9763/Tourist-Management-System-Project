package in.ineuron.service;

import java.util.List;

import in.ineuron.model.Tourist;

public interface ITouristManagementService {

	public String registerTourist(Tourist tourist);
	public List<Tourist> getAllTourist();
	public Tourist getTouristById(Integer id);
	public String updateStudentRecord(Tourist tourist);
	public String deleteStudentRecord(Integer id);
}
