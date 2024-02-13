import java.net.InetAddress;
import java.net.UnknownHostException;
import java.io.IOException;
import java.util.Scanner;

class IPAddressInfo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the IP Address: ");
        String ipAddress = scanner.nextLine();

        try {
            InetAddress inetAddress = InetAddress.getByName(ipAddress);

            // Check if the IP address is reserved, public, or private
            String ipType = getIPType(inetAddress);

            // Determine the IP class
            char ipClass = getIPClass(inetAddress);

            // Calculate the default mask
            String defaultMask = getDefaultMask(ipClass);

            // Calculate the block, first IP, last IP, and network address for classful addressing
            String block = inetAddress.getHostAddress() + "/" + (int) Math.pow(2, 32 - inetAddress.getAddress().length);
            String firstIP = getFirstIP(inetAddress);
            String lastIP = getLastIP(inetAddress);
            String networkAddress = getNetworkAddress(inetAddress);

            System.out.println("IP Address: " + inetAddress.getHostAddress());
            System.out.println("Reserved/Public/Private: " + ipType);
            System.out.println("IP Class: " + ipClass);
            System.out.println("Default Mask: " + defaultMask);
            System.out.println("Block: " + block);
            System.out.println("First IP: " + firstIP);
            System.out.println("Last IP: " + lastIP);
            System.out.println("Network Address: " + networkAddress);

            // For classless addressing
            System.out.println("\nFor Classless Addressing:");
            System.out.print("/ Value: "); // Prompt for CIDR value
            int cidrValue = scanner.nextInt();

            // Calculate details for classless addressing
            String cidrMask = getCIDRMask(cidrValue);
            int numAddresses = (int) Math.pow(2, 32 - cidrValue);
            String cidrFirstIP = getFirstIPCIDR(inetAddress, cidrValue);
            String cidrLastIP = getLastIPCIDR(inetAddress, cidrValue);
            String cidrNetworkAddress = getNetworkAddressCIDR(inetAddress, cidrValue);

            System.out.println("Mask in Decimal: " + cidrMask);
            System.out.println("No of IP Addresses in Block: " + numAddresses);
            System.out.println("First IP: " + cidrFirstIP);
            System.out.println("Last IP: " + cidrLastIP);
            System.out.println("Network Address: " + cidrNetworkAddress);

        } catch (UnknownHostException e) {
            System.out.println("Invalid IP Address.");
        } finally {
            scanner.close();
        }
    }

    private static String getIPType(InetAddress inetAddress) {
        if (inetAddress.isAnyLocalAddress() || inetAddress.isLoopbackAddress() || inetAddress.isLinkLocalAddress()
                || inetAddress.isSiteLocalAddress() || inetAddress.isMulticastAddress()
                || inetAddress.isMCGlobal() || inetAddress.isMCLinkLocal() || inetAddress.isMCNodeLocal()
                || inetAddress.isMCOrgLocal() || inetAddress.isMCSiteLocal()) {
            return "Reserved";
        } else {
            return "Private";
        }
    }

    private static char getIPClass(InetAddress inetAddress) {
        byte[] addressBytes = inetAddress.getAddress();
        return addressBytes[0] >= 0 && addressBytes[0] <= 127 ? 'A'
                : (addressBytes[0] >= 128 && addressBytes[0] <= 191 ? 'B'
                : (addressBytes[0] >= 192 && addressBytes[0] <= 223 ? 'C'
                : (addressBytes[0] >= 224 && addressBytes[0] <= 239 ? 'D' : 'E')));
    }

    private static String getDefaultMask(char ipClass) {
        switch (ipClass) {
            case 'A':
                return "255.0.0.0";
            case 'B':
                return "255.255.0.0";
            case 'C':
                return "255.255.255.0";
            default:
                return "Not Applicable";
        }
    }

    private static String getFirstIP(InetAddress inetAddress) {
        return inetAddress.getHostAddress().split("/")[0];
    }

    private static String getLastIP(InetAddress inetAddress) {
        int numAddresses = (int) Math.pow(2, 32 - inetAddress.getAddress().length);
        return inetAddress.getHostAddress().split("/")[0] + (numAddresses - 2);
    }

    private static String getNetworkAddress(InetAddress inetAddress) {
        return inetAddress.getHostAddress().split("/")[0];
    }
    

    private static String getCIDRMask(int cidrValue) {
        StringBuilder mask = new StringBuilder();
        int value = 0xffffffff << (32 - cidrValue);
        for (int i = 3; i >= 0; i--) {
            mask.insert(0, (value >> (8 * i)) & 255);
            if (i > 0) {
                mask.insert(0, ".");
            }
        }
        return mask.toString();
    }

    private static String getFirstIPCIDR(InetAddress inetAddress, int cidrValue) {
        int numAddresses = (int) Math.pow(2, 32 - cidrValue);
        String[] ipAddressParts = inetAddress.getHostAddress().split("\\.");
        int[] ipAddress = new int[ipAddressParts.length];
        for (int i = 0; i < ipAddressParts.length; i++) {
            ipAddress[i] = Integer.parseInt(ipAddressParts[i]);
        }

        ipAddress[3] += 1; // Increment last octet by 1

        // Handle overflow
        for (int i = 3; i >= 0; i--) {
            if (ipAddress[i] > 255) {
                ipAddress[i] = 0;
                if (i - 1 >= 0) {
                    ipAddress[i - 1] += 1;
                }
            }
        }

        return ipAddress[0] + "." + ipAddress[1] + "." + ipAddress[2] + "." + ipAddress[3];
    }

    private static String getLastIPCIDR(InetAddress inetAddress, int cidrValue) {
        int numAddresses = (int) Math.pow(2, 32 - cidrValue);
        String[] ipAddressParts = inetAddress.getHostAddress().split("\\.");
        int[] ipAddress = new int[ipAddressParts.length];
        for (int i = 0; i < ipAddressParts.length; i++) {
            ipAddress[i] = Integer.parseInt(ipAddressParts[i]);
        }

        ipAddress[3] += numAddresses - 2; // Increment last octet by numAddresses - 2

        // Handle overflow
        for (int i = 3; i >= 0; i--) {
            if (ipAddress[i] > 255) {
                ipAddress[i] = 0;
                if (i - 1 >= 0) {
                    ipAddress[i - 1] += 1;
                }
            }
        }

        return ipAddress[0] + "." + ipAddress[1] + "." + ipAddress[2] + "." + ipAddress[3];
    }

    private static String getNetworkAddressCIDR(InetAddress inetAddress, int cidrValue) {
        return inetAddress.getHostAddress().split("/")[0];
    }
}