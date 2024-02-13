import sys

def is_valid_ipv4(ip_address):
    octets = ip_address.split('.')
    if len(octets) != 4:
        return False
    for octet in octets:
        try:
            value = int(octet)
            if not (0 <= value <= 255):
                return False
        except ValueError:
            return False
    return True

def get_ip_class(ip_address):
    if not is_valid_ipv4(ip_address):
        return 'Invalid', 'N/A', 'N/A', 'N/A'

    octets = ip_address.split('.')
    first_octet = int(octets[0])
    second_octet = int(octets[1])
    third_octet = int(octets[2])
    fourth_octet = int(octets[3])

    if first_octet >= 1 and first_octet <= 127:
        ip_class = 'Class A'
        block_number = first_octet
        first_address = f"{first_octet}.0.0.0"
        last_address = f"{first_octet}.255.255.255"
    elif first_octet >= 128 and first_octet <= 191:
        ip_class = 'Class B'
        block_number = (second_octet << 16) + (third_octet << 8) + fourth_octet
        first_address = f"{octets[0]}.{octets[1]}.0.0"
        last_address = f"{octets[0]}.{octets[1]}.255.255"
    elif first_octet >= 192 and first_octet <= 223:
        ip_class = 'Class C'
        block_number = (third_octet << 8) + fourth_octet
        first_address = f"{octets[0]}.{octets[1]}.{octets[2]}.0"
        last_address = f"{octets[0]}.{octets[1]}.{octets[2]}.255"
    elif first_octet >= 224 and first_octet <= 239:
        ip_class = 'Class D'
        block_number = 'Multicast'
        first_address = '224.0.0.0'
        last_address = '239.255.255.255'
    elif first_octet >= 240 and first_octet <= 255:
        ip_class = 'Class E'
        block_number = 'Reserved Address Space'
        first_address = '240.0.0.0'
        last_address = '255.255.255.255'
    else:
        ip_class = 'Invalid'
        block_number = 'N/A'
        first_address = 'N/A'
        last_address = 'N/A'

    return ip_class, block_number, first_address, last_address

def get_subnet_mask(subnet_bits):
    subnet_mask = [0, 0, 0, 0]
    for i in range(subnet_bits):
        subnet_mask[i // 8] |= (1 << (7 - i % 8))
    return '.'.join(map(str, subnet_mask))

def calculate_subnet_address(ip_octets, subnet_mask):
    subnet_address = []
    subnet_mask_octets = subnet_mask.split('.')
    for i in range(4):
        subnet_address.append(str(int(ip_octets[i]) & int(subnet_mask_octets[i])))
    return '.'.join(subnet_address)

def calculate_broadcast_address(ip_octets, subnet_mask):
    broadcast_address = []
    subnet_mask_octets = subnet_mask.split('.')
    for i in range(4):
        broadcast_address.append(str(int(ip_octets[i]) | ~int(subnet_mask_octets[i]) & 0xff))
    return '.'.join(broadcast_address)

def calculate_num_hosts_per_subnet(subnet_bits):
    return 2 ** (32 - subnet_bits) - 2

def calculate_first_host_id(subnet_address):
    first_host_id = subnet_address.split('.')
    first_host_id[-1] = str(int(first_host_id[-1]) + 1)
    return '.'.join(first_host_id)

def main_menu():
    print("\nWelcome to IP Tool\n")
    print("1. IP Class Classification")
    print("2. Subnet Calculation(classless Addressing)")
    print("3. Quit")

    choice = input("\nEnter your choice: ")

    if choice == '1':
        ip_address = input("Enter the IP address: ")
        ip_class, block_number, first_address, last_address = get_ip_class(ip_address)
        print("\nIP Class Classification:")
        print("IP address:", ip_address)
        print("IP class:", ip_class)
        print("Block number:", block_number)
        print("First address:", first_address)
        print("Last address:", last_address)
    elif choice == '2':
        ip_address = input("Enter the IP address: ")
        subnet_bits = int(input("Enter the subnet bits: "))
        subnet_mask = get_subnet_mask(subnet_bits)
        ip_octets = ip_address.split('.')
        subnet_address = calculate_subnet_address(ip_octets, subnet_mask)
        broadcast_address = calculate_broadcast_address(ip_octets, subnet_mask)
        num_hosts_per_subnet = calculate_num_hosts_per_subnet(subnet_bits)
        first_host_id = calculate_first_host_id(subnet_address)
        print("\nSubnet Calculation:")
        print("IP address:", ip_address)
        print("Subnet mask:", subnet_mask)
        print("Subnet address:", subnet_address)
        print("Broadcast address:", broadcast_address)
        print("Number of hosts per subnet:", num_hosts_per_subnet)
        print("First host ID:", first_host_id)
    elif choice == '3':
        print("Exiting...")
        sys.exit(0)
    else:
        print("Invalid choice. Please choose a valid option.")
    main_menu()

if __name__ == "__main__":
    main_menu()
