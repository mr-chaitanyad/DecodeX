import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import java.awt.Color;
import javax.swing.*;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class main extends JFrame implements ActionListener{
    JTextField t1 = new JTextField(10);
    JButton b1 = new JButton("Convert");
    JLabel l1 = new JLabel("DecodeX");
    JLabel l2 = new JLabel("Encrypted: ");
    JLabel l3 = new JLabel("Decrypted: ");
    Font font1 = new Font("SansSerif", Font.BOLD, 20);
    ImageIcon image = new ImageIcon("C://Desktop//Java Code//back.jpg");
	JLabel background = new JLabel(image);
    main()
    {
        setSize(600,500);
        setTitle("DecodeX");
        setLayout(null);
        setVisible(true);
        background.setBounds(0,0,600,500);
        t1.setBounds(100,170,300,50);
        b1.setBounds(150,240,200,50);
        l1.setBounds(160,50,390,50);
        l2.setBounds(100,300,300,50);
        l3.setBounds(100,350,300,50);
    
        l1.setFont(new Font("SansSerif", Font.BOLD, 40));
        l2.setFont(font1);
        l3.setFont(font1);
        t1.setFont(font1);
        b1.setFont(font1);
        l2.setForeground(Color.WHITE);
        l3.setForeground(Color.RED);
        l1.setForeground(Color.GREEN);
        
        add(background);
        t1.setText("Enter String to Convert....");
        background.add(l1);
        background.add(t1);
        background.add(b1);
        background.add(l2);
        background.add(l3);        


        b1.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e)
    {
        try{
            String s1 = t1.getText();
            KeyGenerator key = KeyGenerator.getInstance("DES");
            SecretKey myKey = key.generateKey();
            Cipher desCipher = Cipher.getInstance("DES");

            byte[]  text = t1.getText().toString().getBytes("UTF8");
            desCipher.init(Cipher.ENCRYPT_MODE,myKey);
            byte[] textEncrypted = desCipher.doFinal(text); 


            String s = new String(textEncrypted);
            
            
            l2.setText(l2.getText()+s);

            desCipher.init(Cipher.DECRYPT_MODE, myKey);
            byte[] textDecrypted
                = desCipher.doFinal(textEncrypted);
 
            // Converting decrypted byte array to string
            s = new String(textDecrypted);
            l3.setText(l3.getText()+s);
        }
        catch(Exception e1){
            System.out.println(e1.getMessage());
        }
    }
    public static void main(String args[])
    {
        new main();
    }
}