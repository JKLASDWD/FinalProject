import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
public class BankGUI extends JFrame{
    static JFrame mainJFrame = new JFrame("银行界面");
    static JPanel pn1 = new JPanel();
    static JPanel pn2 = new JPanel();
    static JPanel pn2_1= new JPanel();
    static JPanel pn2_2= new JPanel();
    static JPanel pn2_3= new JPanel();
    static CardLayout card = new CardLayout();
    static HashMap<String,Cust> h = new HashMap<String,Cust>();
    public static void main(String[] args) {;
        h.put("111",new Cust("111", "111"));
        Cust[] now_Cust = new Cust[1];
        mainJFrame.setSize(800, 600);
       // mainJFrame.setResizable(false);
        mainJFrame.setLocationRelativeTo(null);
        Container container = mainJFrame.getContentPane();
        container.setLayout(null);
        pn1.setLayout(new GridLayout(7,1));
        pn1.setBounds(0, 20, 100, 600);
        pn2.setLayout(card);
        pn2.setBounds(200, 200, 400, 350);
        pn2_1.setLayout(new GridLayout(4,2));
        pn2_2.setLayout(new GridLayout(4,2));
        JButton J_L = new JButton("登录界面");
        JButton J_L_2 = new JButton("注册界面"); 
        JButton J_L_3 = new JButton("取款界面");
        pn1.add(J_L);
        pn1.add(J_L_2);
        pn1.add(J_L_3);
        //登录界面
        JLabel error_t = new JLabel("");
        error_t.setFont(new Font("宋体", Font.PLAIN, 20));
        JLabel uJLabel = new JLabel("账号名");
        uJLabel.setFont(new Font("宋体", Font.PLAIN, 20));
        JLabel pJLabel = new JLabel("密码");
        pJLabel.setFont(new Font("宋体", Font.PLAIN, 20));
        JTextField username_= new JTextField(10);
        JPasswordField password_= new JPasswordField(10);
        JButton login_ = new JButton("登录", null);
        login_.setPreferredSize(new Dimension(90, 70));
        login_.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String u=username_.getText();
                String p=new String(password_.getPassword());
                try{
                    Cust.Login(u, p);
                    error_t.setText("登录成功!");
                    now_Cust[0] = h.get(u);
                }
                catch(WrongPassWordException e2){
                    error_t.setText(e2.getMessage());
                }
                catch(AccountNotExistsException e3){
                    error_t.setText(e3.getMessage());
                }
            }
        });
        JButton reset = new JButton("重置", null);
        reset.setPreferredSize(new Dimension(90, 70));
        reset.addActionListener(new ActionListener() {
            @Override
                public void actionPerformed(ActionEvent e) {
                    username_.setText("");
                    password_.setText("");
                }
        });
        J_L.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                card.show(pn2,"login");
                error_t.setText("");
                username_.setText("");
                password_.setText("");
            }
        });
        pn2_1.add(uJLabel);
        pn2_1.add(username_);
        pn2_1.add(pJLabel);
        pn2_1.add(password_);
        pn2_1.add(login_);
        pn2_1.add(reset);
        pn2_1.add(error_t);
        pn2.add(pn2_1,"login");
        //注册界面
        JLabel ruJLabel = new JLabel("账号名");
        ruJLabel.setFont(new Font("宋体", Font.PLAIN, 20));
        JLabel rpJLabel = new JLabel("密码");
        rpJLabel.setFont(new Font("宋体", Font.PLAIN, 20));
        JTextField rusername_= new JTextField(10);
        JPasswordField rpassword_= new JPasswordField(10);
        JLabel error_t_2 = new JLabel("");
        error_t_2.setText("");
        JButton register_ = new JButton("注册", null);
        JButton reset_r = new JButton("重置", null);
        reset_r.setPreferredSize(new Dimension(90, 70));
        reset_r.addActionListener(new ActionListener() {
            @Override
                public void actionPerformed(ActionEvent e) {
                    rusername_.setText("");
                    rpassword_.setText("");
                }
        });
        register_.setPreferredSize(new Dimension(90, 70));
        register_.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String u=rusername_.getText();
                String p=new String(rpassword_.getPassword());
                try{
                    Cust c = new Cust(u, p);
                    h.put(u, c);
                    error_t_2.setText("注册成功!");
                }
                catch (AccountExistsException e2){
                    error_t_2.setText(e2.getMessage());
                }
                catch(AccountNotExistsException e3){
                    error_t_2.setText(e3.getMessage());
                }
            }
        });
        J_L_2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                card.show(pn2,"register");
                error_t_2.setText("");
                rusername_.setText("");
                rpassword_.setText("");
            }
        });
        pn2_2.add(ruJLabel);
        pn2_2.add(rusername_);
        pn2_2.add(rpJLabel);
        pn2_2.add(rpassword_);
        pn2_2.add(register_);
        pn2_2.add(reset_r);
        pn2_2.add(error_t_2);
        pn2.add(pn2_2,"register");

        //取款界面
        JPanel pn2_3_1 = new JPanel();
        pn2_3_1.setLayout(new GridLayout(2, 2));
        JPanel pn2_3_2 = new JPanel(new GridLayout(3, 2));
        JPanel pn2_3_4 = new JPanel(new GridLayout(1, 1));
        JPanel pn2_3_5 = new JPanel(new GridLayout(1, 1));
        String[] name_J={"取3000","取2500","取2000","取1500","取1000","取500"};
        int [] money_c = {3000,2500,2000,1500,1000,500};
        JButton[] jButtons = new JButton[6];
        for(int i=0;i<6;i++){
            jButtons[i]=new JButton(name_J[i]);
            pn2_3_2.add(jButtons[i]);
            pn2_3_2.setPreferredSize(new Dimension(240, 120));
        }
        JLabel j3JLabel = new JLabel("当前存款");
        j3JLabel.setFont(new Font("宋体", Font.PLAIN, 20));
        JLabel tipsJLabel = new JLabel("",10);
        JTextField moneyField = new JTextField("",10);
        moneyField.setEditable(false);
        moneyField.setPreferredSize(new Dimension(200, 50));
        JButton saveMoneyButton = new JButton("确定");
        JLabel savemoneyJLabel = new JLabel("存款金额");
        savemoneyJLabel.setFont(new Font("宋体", Font.PLAIN, 20));
        saveMoneyButton.setPreferredSize(new Dimension(180, 50));
        JTextField saveMoneyField = new JTextField("",10);
        pn2_3_1.add(j3JLabel);
        pn2_3_1.add(moneyField);
        pn2_3_1.add(savemoneyJLabel);
        pn2_3_1.add(saveMoneyField);
        pn2_3_5.add(saveMoneyButton);
        pn2_3_5.add(tipsJLabel);
        pn2_3_4.add(pn2_3_2);
        pn2_3.add(pn2_3_1);
        pn2_3.add(pn2_3_4);
        pn2_3.add(pn2_3_5);
        pn2_3.setVisible(true);
        pn2.add(pn2_3,"saveMoney");
        J_L_3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               if(now_Cust[0]==null){
                    JDialog d =new MyDialog();
                    d.setLocationRelativeTo(null);
               }
               else{
                card.show(pn2,"saveMoney");
                moneyField.setText(""+now_Cust[0].getMoney());
                tipsJLabel.setText("");
               }
            }
        });
        for(int i=0;i<6;i++){
            final int b = money_c[i];
            jButtons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                        try {
                            now_Cust[0].takeMoney(b);
                            tipsJLabel.setText("取款成功");
                            moneyField.setText(""+now_Cust[0].getMoney());
                        }
                        catch(NotEnoughMoneyException e2){
                            tipsJLabel.setText(e2.getMessage());
                        }
                }
            });
        }
        saveMoneyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    final int m = Integer.parseInt(saveMoneyField.getText());
                    now_Cust[0].saveMoney(m);
                    moneyField.setText(""+now_Cust[0].getMoney());
                    tipsJLabel.setText("存款成功！");
                }
                catch(NumberFormatException e2){
                    tipsJLabel.setText("请输入正确的存款数目！");
                }
            }
        });

        //转账界面

        JPanel pn2_4_1 = new JPanel(new GridLayout(4,2));
        JButton J_L_4 = new JButton("转账界面");
        pn1.add(J_L_4);
        JLabel label2_4 = new JLabel("对方账户");
        JTextField textField2_4 = new JTextField("",10);
        JLabel label2_4_2 = new JLabel("当前账户余额");
        JTextField textField2_4_2 = new JTextField("",10);
        JLabel label2_4_3 = new JLabel("转账数目");
        JTextField textField2_4_3 = new JTextField("",10);
        textField2_4_2.setEditable(false);
        JButton button2_4 = new JButton("确定");
        JLabel tipslabel2_4 = new JLabel("");
        pn2_4_1.add(label2_4);
        pn2_4_1.add(textField2_4);
        pn2_4_1.add(label2_4_2);
        pn2_4_1.add(textField2_4_2);
        pn2_4_1.add(label2_4_3);
        pn2_4_1.add(textField2_4_3);
        pn2_4_1.add(button2_4);
        pn2_4_1.add(tipslabel2_4);
        pn2.add(pn2_4_1,"transfer");
        J_L_4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(now_Cust[0]==null){
                    JDialog d =new MyDialog();
                    d.setLocationRelativeTo(null);
               }
               else{
                card.show(pn2, "transfer");
                textField2_4_2.setText(""+now_Cust[0].getMoney());
                tipslabel2_4.setText("");
                textField2_4.setText("");
                textField2_4_3.setText("");
            }
            }
        });

        button2_4.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Cust tocust = h.get(textField2_4.getText());
                    now_Cust[0].transferMoney(textField2_4_3.getText(), tocust);
                    tipslabel2_4.setText("转账成功！");
                    textField2_4_2.setText(""+now_Cust[0].getMoney());
                }
                catch(AccountNotExistsException e2){
                    tipslabel2_4.setText(e2.getMessage());
                }
                catch(NotEnoughMoneyException e3){
                    tipslabel2_4.setText(e3.getMessage());
                }
                catch(NumberFormatException e4){
                    tipslabel2_4.setText("请输入正确的转账数字！");
                }
                catch(AccountExistsException e5){
                    tipslabel2_4.setText(e5.getMessage());
                }
            }
        });
        pn2.setVisible(true);
        pn1.setVisible(true);
        container.add(pn1);
        container.add(pn2);
        mainJFrame.setVisible(true);
    }
}
class MyDialog extends JDialog {
    public MyDialog() {
        setVisible(true);
        setBounds(0, 0, 300, 300);
        Container container = getContentPane();
        JLabel tips = new JLabel("您尚未登录!");
        tips.setFont(new Font("宋体",Font.PLAIN,30));
        container.add(tips);
    }
}