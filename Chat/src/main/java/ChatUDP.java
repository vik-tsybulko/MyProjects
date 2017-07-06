import javax.swing.*;
import java.awt.*;
import java.net.*;

/**
 * Created by viktor on 28.11.16.
 */
public class ChatUDP extends JFrame {
    private JTextArea taMain;
    private JTextField tfMsg;

    private final String FRM_TITLE = "Our Tiny Chat";
    private final int FRM_LOC_X = 100;
    private final int FRM_COL_Y = 100;
    private final int FRM_WIDTH = 400;
    private final int FRM_HEIGHT = 400;

    private final int PORT = 9876;
    private final String IP_BROADCAST = "192.168.10.255";



    private class thdReceiver extends Thread{
        @Override
        public void start(){
            super.start();
            System.out.println("Hello from thread");
        }

    }
    private void btnSendHandler() throws Exception{
        DatagramSocket sendSocket = new DatagramSocket();//jnкрывает сокет куда будет приходить сообщение
        InetAddress IPAddress = InetAddress.getByName(IP_BROADCAST);
        byte[] sendData;
        String sentence = tfMsg.getText();
        tfMsg.setText("");
        sendData = sentence.getBytes("UTF-8");
        //DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress);
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, Integer.parseInt(IP_BROADCAST));
        sendSocket.send(sendPacket);
    }
    private void frameDraw(JFrame frame){
        tfMsg = new JTextField();
        taMain = new JTextArea(FRM_HEIGHT/19, 50);
        JScrollPane spMain = new JScrollPane(taMain);
        spMain.setLocation(0,0);
        taMain.setLineWrap(true);
        taMain.setEditable(false);

        JButton btnSend = new JButton();
        btnSend.setText("Send");
        btnSend.setToolTipText("Broadcast a mesage");
        btnSend.addActionListener (e -> {
            try{
                btnSendHandler();

            }catch (Exception ex){
                ex.printStackTrace();
            }
        });
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle(FRM_TITLE);
        frame.setLocation(FRM_LOC_X, FRM_COL_Y);
        frame.setSize(FRM_WIDTH, FRM_HEIGHT);
        frame.setResizable(false);
        frame.getContentPane().add(BorderLayout.NORTH, spMain);
        frame.getContentPane().add(BorderLayout.CENTER, tfMsg);
        frame.getContentPane().add(BorderLayout.EAST, btnSend);
        frame.setVisible(true);

    }
    private void antistatic(){
        frameDraw(new ChatUDP());
        new thdReceiver().start();
    }

    public static void main(String[] args) {
        new ChatUDP().antistatic();
    }
}
