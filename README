--Query Parans/String ou Path Parans, a diferênça?
 
 
 @requestMapping(value=/sum/{oneparam}/{twoparam})
 
 Nesta situação é utilizado a Query Parans/String, onde não é obrigado informar valores
 @RequestVariable (value="oneparam", defaultValue="NumberDefault") Strinh oneParam, value="twoparam", defaultValue="NumberDefault") Strinh twoParam
 
 
 Nesta situação é utilizado a Path Parans,  é obrigado informar valores
 @PathVariable(value="oneparam") Strinh oneParam, value="twoparam") Strinh twoParam
 
 
 
 --Exceptions in RestAPI
 --No Rest se retorna StatusCode com um exception customizada que define o tipo de exception lançada
  
 @requestMapping(value=/sum/{oneparam}/{twoparam})
 public sun(@PathVariable(value="oneparam"),@PathVariable(value="oneparam")) trows Exception(){
	if (true) trow new CustomizedresponseException();
 }
  
 
 ---Packege Exception
 @ResponseStatus(HttpStatus.BAD_REQUEST)
 public class ExampleException extends RunTimeException{}
 
 
 ---Class Serializavel Entity de retorno
 @AllArgsConstructor
 public class ExceptionResponse implemtns Serializavel {
 
	private Date timestamp;
	private String message;
	private String details;
 }
 
 
 ControllerAdvice é Utilizado para tratamento GLOBAL dos controllers, isso quer dizer que caso exista uma exception não tratada, em algum controler, ela será lançada a mais generica desta classe
 também ela vai centralizar todos os tipos de exceptions.
 
 ---Packege handler
 @ControllerAdvice 
 @RestController
 public class CustomizedresponseException extends ResponseEntityExceptionHandler{
 
 
 
 ---Generica, para Todas Exception
 @ExceptionHandler(Exception.class)
 public final ResponseEntity<ExceptionResponse> handleAllException(Exception ex, WebRequest request, ){
		ExceptionResponse  exceptionResponse new ExceptionResponse(
				new Date(), 
				ex.getMessage(),
				request. getdescription(false))
				
				return new ResponseEntity<>( exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR)
	}
 
  ---Exception Customizada
 @ExceptionHandler(CustomizedresponseException.class){
 public final ResponseEntity<Exceptionresponse> handleCustomizedException(CustomizedresponseException ex, WebRequest request, )
		ExceptionResponse  exceptionResponse new ExceptionResponse(
				new Date(), 
				ex.getMessage(),
				request. getdescription(false))
				
				return nre ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST)
	}
 }
