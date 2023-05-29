import java.util.HashMap;
import java.util.UUID;
public class Cust {
    private int money;
    private String account_name;
    private String password;
    static int count_ac=0;
    static HashMap<String,user> ac = new HashMap<String,user>();
    static Cust now_Cust;
    public Cust()throws AccountExistsException{
        this.money=(int)(Math.random()*10000);
        this.account_name=this.Random_username();
        this.password="123456";
        if(ac.containsKey(account_name))throw new AccountExistsException("账户已存在!");
        count_ac++;
        ac.put(account_name,new user(account_name,password));
    }
    public Cust(String name,String p)throws AccountExistsException{
        if(name.equals(""))throw new AccountNotExistsException("用户名不能为空!");
        if(p.equals(""))this.password="123456";
        this.money=(int)(Math.random()*10000);
        this.account_name=name;
        this.password=p;
        if(ac.containsKey(account_name))throw new AccountExistsException("账户已存在!");
        count_ac++;
        ac.put(account_name,new user(account_name,password));
    }
    public int getMoney() {
        return this.money;
    }
    public void saveMoney(int n){
        this.money+=n;
    }
    public void takeMoney(int n)throws NotEnoughMoneyException{
        if(this.getMoney()<n)throw new NotEnoughMoneyException("金钱不足！");
        this.money=this.money-n;
    }
    public String get_Accountname(){
        return this.account_name;
    }
    public void transferMoney(String m,Cust t) throws NotEnoughMoneyException,AccountNotExistsException,NumberFormatException{
        if(t==null) throw new AccountNotExistsException("账户不存在!");
        if(t==this) throw new AccountExistsException("不可以给自己转账!");
        int now_m = this.getMoney();
        int trans_m = Integer.parseInt(m);
        if(now_m<trans_m)throw new NotEnoughMoneyException("余额不足!");
        if(!ac.containsKey(t.get_Accountname())) throw new AccountNotExistsException();
        this.money-=trans_m;
        t.saveMoney(trans_m);
    }
    private String Random_username(){
        UUID randomUID = UUID.randomUUID();
        return randomUID.toString().replaceAll("-","").substring(0,6);
    }
    public static boolean Login(String u,String p){
        if(!ac.containsKey(u))throw new AccountNotExistsException("账户不存在!");
        user t = ac.get(u);
        if(!t.password.equals(p))throw new WrongPassWordException("密码错误!");
        return true;
    }
}
class user{
    String ac_name;
    String password;
    user(String s,String p){
        this.ac_name=s;
        this.password=p;
    }
}