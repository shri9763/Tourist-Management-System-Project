package in.ineuron.error;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class ErrorDetails {

	private LocalDateTime ldt;
	private String msg;
	public ErrorDetails() {
		super();
	
	}
	public ErrorDetails(LocalDateTime ldt, String msg, String status) {
		super();
		this.ldt = ldt;
		this.msg = msg;
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "ErrorDetails [ldt=" + ldt + ", msg=" + msg + ", status=" + status + "]";
	}

	private String status;
}
