package mx.mariovaldez.codechallenge.polizascoppel.exception;

import mx.mariovaldez.codechallenge.polizascoppel.model.response.DataFailure;
import mx.mariovaldez.codechallenge.polizascoppel.model.response.Meta;
import mx.mariovaldez.codechallenge.polizascoppel.model.response.ResponseFailure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RequestExceptionHandler {

    @ExceptionHandler(value = RequestException.class)
    ResponseEntity<ResponseFailure> handleResponseRequestException(RequestException e) {
        ResponseFailure responseFailure = ResponseFailure.builder()
                .meta(new Meta("FAILURE"))
                .data(new DataFailure(e.getMessage())).build();

        return new ResponseEntity<>(responseFailure, HttpStatus.BAD_REQUEST);
    }
}
