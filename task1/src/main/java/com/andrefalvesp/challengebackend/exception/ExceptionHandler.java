package com.andrefalvesp.challengebackend.exception;

import com.fasterxml.jackson.core.JsonProcessingException;
import javax.servlet.http.HttpServletRequest;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.ConversionFailedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver;

@Slf4j
@RestControllerAdvice
@NoArgsConstructor
public class ExceptionHandler extends DefaultHandlerExceptionResolver {

  @org.springframework.web.bind.annotation.ExceptionHandler({InvalidDateRangeException.class})
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ExceptionResponse handleFinalDateLessThanBeginDateException(
      final InvalidDateRangeException ex,
      final HttpServletRequest request) {
    log.warn(ex.getMessage(), ex);
    return new ExceptionResponse(ex.getMessage(), HttpStatus.BAD_REQUEST, request.getRequestURI());
  }

  @org.springframework.web.bind.annotation.ExceptionHandler({HttpMessageNotReadableException.class})
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ExceptionResponse handleMessageNotReadableException(
      final HttpMessageNotReadableException ex,
      final HttpServletRequest request) {
    log.warn(ex.getMessage(), ex);
    return new ExceptionResponse(ex.getMessage(), HttpStatus.BAD_REQUEST, request.getRequestURI());
  }

  @org.springframework.web.bind.annotation.ExceptionHandler({ConversionFailedException.class})
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ExceptionResponse handleConversionFailedException(final ConversionFailedException ex,
      final HttpServletRequest request) {
    log.warn(ex.getMessage(), ex);
    return new ExceptionResponse(ex.getMessage(), HttpStatus.BAD_REQUEST, request.getRequestURI());
  }

  @org.springframework.web.bind.annotation.ExceptionHandler({
      MethodArgumentTypeMismatchException.class})
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ExceptionResponse handleMethodArgumentTypeMismatchException(
      final ConversionFailedException ex,
      final HttpServletRequest request) {
    log.warn(ex.getMessage(), ex);
    return new ExceptionResponse(ex.getMessage(), HttpStatus.BAD_REQUEST, request.getRequestURI());
  }

  @org.springframework.web.bind.annotation.ExceptionHandler({ServletRequestBindingException.class})
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ExceptionResponse servletRequestBindingException(final ServletRequestBindingException ex,
      final HttpServletRequest request) {
    log.warn(ex.getMessage(), ex);
    return new ExceptionResponse(ex.getMessage(), HttpStatus.BAD_REQUEST, request.getRequestURI());
  }

  @org.springframework.web.bind.annotation.ExceptionHandler({
      HttpRequestMethodNotSupportedException.class})
  @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
  public ExceptionResponse methodNotSupportedException(
      final HttpRequestMethodNotSupportedException ex,
      final HttpServletRequest request) {
    log.warn(ex.getMessage(), ex);
    return new ExceptionResponse(ex.getMessage(), HttpStatus.METHOD_NOT_ALLOWED,
        request.getRequestURI());
  }


  @org.springframework.web.bind.annotation.ExceptionHandler({HttpMediaTypeException.class})
  @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
  public ExceptionResponse unsupportedException(final HttpMediaTypeException ex,
      final HttpServletRequest request) {
    log.warn(ex.getMessage(), ex);
    return new ExceptionResponse(ex.getMessage(), HttpStatus.UNSUPPORTED_MEDIA_TYPE,
        request.getRequestURI());
  }

  @org.springframework.web.bind.annotation.ExceptionHandler({JsonProcessingException.class})
  @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
  public ExceptionResponse jsonProcessingException(final JsonProcessingException ex,
      final HttpServletRequest request) {
    log.warn(ex.getMessage(), ex);
    return new ExceptionResponse(ex.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY,
        request.getRequestURI());
  }

  @org.springframework.web.bind.annotation.ExceptionHandler({Throwable.class})
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public ExceptionResponse handleGenericException(final Throwable ex,
      final HttpServletRequest request) {
    log.warn(ex.getMessage(), ex);
    return new ExceptionResponse(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR,
        request.getRequestURI());
  }
}