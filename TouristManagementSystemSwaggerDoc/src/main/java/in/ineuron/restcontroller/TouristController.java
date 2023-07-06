package in.ineuron.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ineuron.model.Tourist;
import in.ineuron.service.ITouristManagementService;

@RestController
@RequestMapping("api/tourist")
public class TouristController {

	@Autowired
	private ITouristManagementService service;

	@PostMapping("/register")
	public ResponseEntity<String> registerTourist(@RequestBody Tourist tourist) {

		String body = service.registerTourist(tourist);
		return new ResponseEntity<String>(body, HttpStatus.OK);

	}

	@GetMapping("/find/{id}")
	public ResponseEntity<?> getRecordById(@PathVariable("id") Integer id) {

		Tourist tourist = service.getTouristById(id);
		return new ResponseEntity<Tourist>(tourist, HttpStatus.OK);
	}

	@GetMapping("/findAll")
	public ResponseEntity<?> getAllRecords() {
		try {
			List<Tourist> allTourist = service.getAllTourist();
			return new ResponseEntity<List<Tourist>>(allTourist, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Something goes wrong", HttpStatus.NOT_FOUND);
		}

	}

	@PutMapping("/modify")
	public ResponseEntity<String> getUpdateRecords(@RequestBody Tourist tourist) {
		String updateStudentRecord = service.updateStudentRecord(tourist);
		return new ResponseEntity<String>(updateStudentRecord, HttpStatus.OK);
	}

	@DeleteMapping("/modify/{id}")
	public ResponseEntity<String> getDeleteRecords(@PathVariable("id") Integer id) {
		String deleteStudentRecord =service.deleteStudentRecord(id);
		return new ResponseEntity<String>(deleteStudentRecord, HttpStatus.OK);
	}
}
