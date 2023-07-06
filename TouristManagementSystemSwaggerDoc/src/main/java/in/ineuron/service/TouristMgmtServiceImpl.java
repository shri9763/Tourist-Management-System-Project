package in.ineuron.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import in.ineuron.dao.ITouristManagementDao;
import in.ineuron.exception.TouristNotFoundException;
import in.ineuron.model.Tourist;

@Service
public class TouristMgmtServiceImpl implements ITouristManagementService {

	@Autowired
	private ITouristManagementDao dao;

	@Override
	public String registerTourist(Tourist tourist) {
		Integer tid = dao.save(tourist).getTid();
		return "Tourist Registered with tid:: " + tid;
	}

	@Override
	public List<Tourist> getAllTourist() {
		List<Tourist> list = (List<Tourist>) dao.findAll();
		return list;
	}

	@Override
	public Tourist getTouristById(Integer id) {
//		Optional<Tourist> optional = dao.findById(id);
//		if (optional.isPresent()) {
//			return optional.get();
//		} else {
//			throw new TouristNotFoundException("tourist with id "+id+" not found");
//		}
		
		return dao.findById(id).orElseThrow(()->new TouristNotFoundException("tourist with id "+id+" not found"));
	}

	@Override
	public String updateStudentRecord(Tourist tourist) {
		Optional<Tourist> findById = dao.findById(tourist.getTid());
		if(findById.isPresent()) {
			dao.save(tourist);
			return "tourist record is updated::"+tourist.getTid()+"";
		}
		else {
			throw new TouristNotFoundException("tourist with id "+tourist.getTid()+" not found for updation");
		}
	}
	
	@Override
	public String deleteStudentRecord(Integer id) {
		Optional<Tourist> findById = dao.findById(id);
		if(findById.isPresent()) {
			dao.deleteById(id);
			return "tourist record is deleted::"+id+"";
		}
		else {
			throw new TouristNotFoundException("tourist with id "+id+" not found for updation");
		}
	}
	

}
