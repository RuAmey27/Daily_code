import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;
class IPAddressInfo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter The IP Address: ");
        String ipAddress = scanner.nextLine();

        // Classful Addressing
        String[] classfulInfo = getClassfulInfo(ipAddress);
        System.out.println("\nFor Classful Addressing:");
        System.out.println("Given IP is " + classfulInfo[0]);
        System.out.println("This IP Address Belongs to Class: " + classfulInfo[1]);
        System.out.println("Default Mask: " + classfulInfo[2]);
        System.out.println("Block: " + classfulInfo[3]);
        System.out.println("First IP: " + classfulInfo[4]);
        System.out.println("Last IP: " + classfulInfo[5]);
        System.out.println("Network Address: " + classfulInfo[6]);

        // Classless Addressing
        System.out.print("\nEnter the prefix for classless addressing: ");
        int classlessPrefix = scanner.nextInt();
        String[] classlessInfo = getClasslessInfo(ipAddress, classlessPrefix);
        System.out.println("\nFor Classless Addressing:");
        System.out.println("/ Value: " + classlessInfo[0]);
        System.out.println("Mask in Decimal: " + classlessInfo[1]);
        System.out.println("No of IP Addresses in Block: " + classlessInfo[2]);
        System.out.println("First IP: " + classlessInfo[3]);
        System.out.println("Last IP: " + classlessInfo[4]);
        System.out.println("Network Address: " + classlessInfo[5]);
    }

    private static String[] getClassfulInfo(String ipAddress) {
        try {
            InetAddress ip = InetAddress.getByName(ipAddress);

            if (ip.isAnyLocalAddress() || ip.isLoopbackAddress() || ip.isLinkLocalAddress() || ip.isMulticastAddress() || ip.isSiteLocalAddress()) {
                return new String[]{"Reserved", null, null, null, null, null, null};
            } else if (ip.isSiteLocalAddress()) {
                return new String[]{"Private", null, null, null, null, null, null};
            } else {
                String[] classfulInfo = new String[7];
                byte[] bytes = ip.getAddress();
                int firstByte = bytes[0] & 0xFF;

                if (firstByte >= 1 && firstByte <= 126) {
                    classfulInfo[1] = "A";
                } else if (firstByte >= 128 && firstByte <= 191) {
                    classfulInfo[1] = "B";
                } else if (firstByte >= 192 && firstByte <= 223) {
                    classfulInfo[1] = "C";
                } else if (firstByte >= 224 && firstByte <= 239) {
                    classfulInfo[1] = "D";
                } else {
                    classfulInfo[1] = "E";
                }

                classfulInfo[0] = "Public";
                classfulInfo[2] = InetAddress.getByName(ip.getHostAddress()).getNetworkAddress().getHostAddress();
                classfulInfo[3] = String.valueOf(InetAddress.getByName(ip.getHostAddress()).getAllByName(ip.getHostAddress()).length);
                classfulInfo[4] = InetAddress.getByName(ip.getHostAddress()).getHostAddress();
                classfulInfo[5] = InetAddress.getByName(ip.getHostAddress()).getAllByName(ip.getHostAddress())[InetAddress.getByName(ip.getHostAddress()).getAllByName(ip.getHostAddress()).length - 1].getHostAddress();
                classfulInfo[6] = InetAddress.getByName(ip.getHostAddress()).getNetworkAddress().getHostAddress();

                return classfulInfo;
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return new String[]{"Unknown", null, null, null, null, null, null};
        }
    }

    private static String[] getClasslessInfo(String ipAddress, int prefix) {
        try {
            InetAddress ip = InetAddress.getByName(ipAddress);
            String[] classlessInfo = new String[6];

            classlessInfo[0] = String.valueOf(prefix);
            classlessInfo[1] = InetAddress.getByName(ip.getHostAddress()).getNetworkPrefixLength() + "";
            classlessInfo[2] = String.valueOf(InetAddress.getByName(ip.getHostAddress()).getAllByName(ip.getHostAddress()).length);
            classlessInfo[3] = InetAddress.getByName(ip.getHostAddress()).getHostAddress();
            classlessInfo[4] = InetAddress.getByName(ip.getHostAddress()).getAllByName(ip.getHostAddress())[InetAddress.getByName(ip.getHostAddress()).getAllByName(ip.getHostAddress()).length - 1].getHostAddress();
            classlessInfo[5] = InetAddress.getByName(ip.getHostAddress()).getNetworkAddress().getHostAddress();

            return classlessInfo;
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return new String[]{"Unknown", null, null, null, null, null};
        }
    }
}
