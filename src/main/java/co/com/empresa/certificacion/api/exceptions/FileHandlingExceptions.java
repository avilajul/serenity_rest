package co.com.empresa.certificacion.api.exceptions;

public class FileHandlingExceptions extends AssertionError{
    private static final String FILE_SEND_PROBLEMS = "El archivo json a enviar no pudo ser diligenciado";
    public FileHandlingExceptions(String message, Throwable cuase){
        super(FILE_SEND_PROBLEMS, cuase);
    }
    public FileHandlingExceptions(){
        super(FILE_SEND_PROBLEMS);
    }
}
