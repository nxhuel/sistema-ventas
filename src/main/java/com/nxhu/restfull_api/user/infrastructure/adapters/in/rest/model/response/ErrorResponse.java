package com.nxhu.restfull_api.user.infrastructure.adapters.in.rest.model.response;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {

	private HttpStatus status;
	private String message;
	private List<String> details;
	private LocalDateTime timestamp;
}
