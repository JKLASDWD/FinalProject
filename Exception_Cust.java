public class Exception_Cust extends Exception{
}
class NotEnoughMoneyException extends RuntimeException{
    private String messageDescription; //异常对应的描述信息
    public NotEnoughMoneyException(){
        super();
    }
    public NotEnoughMoneyException(String m){
        super(m);
        this.messageDescription=m;
    }
}
class WrongPassWordException extends RuntimeException{
    private String messageDescription; //异常对应的描述信息
    public WrongPassWordException(){
        super();
    }
    public WrongPassWordException(String m){
        super(m);
        this.messageDescription=m;
    }
}
class AccountExistsException extends RuntimeException{
    private String messageDescription; //异常对应的描述信息
    public AccountExistsException(){
        super();
    }
    public AccountExistsException(String m){
        super(m);
        this.messageDescription=m;
    }
}
class AccountNotExistsException extends RuntimeException{
    private String messageDescription; //异常对应的描述信息
    public AccountNotExistsException(){
        super();
    }
    public AccountNotExistsException(String m){
        super(m);
        this.messageDescription=m;
    }
}