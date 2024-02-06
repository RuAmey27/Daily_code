import ipaddress

def get_classful_info(ip):
    ip_obj = ipaddress.ip_address(ip)
    if ip_obj.is_reserved:
        return "Reserved", None, None, None, None, None
    elif ip_obj.is_global:
        ip_class = ipaddress.ip_network(ip).network_address
        ip_class_str = str(ip_class)
        ip_class_str = ip_class_str.split('.')
        ip_class_str = ip_class_str[0]
        if 1 <= int(ip_class_str) <= 126:
            ip_class_str = "A"
        elif 128 <= int(ip_class_str) <= 191:
            ip_class_str = "B"
        elif 192 <= int(ip_class_str) <= 223:
            ip_class_str = "C"
        elif 224 <= int(ip_class_str) <= 239:
            ip_class_str = "D"
        else:
            ip_class_str = "E"
        default_mask = ipaddress.IPv4Network(ip, strict=False).netmask
        default_mask_str = str(default_mask)
        block = ipaddress.IPv4Network(ip, strict=False).num_addresses
        first_ip = ipaddress.IPv4Network(ip, strict=False).network_address + 1
        last_ip = ipaddress.IPv4Network(ip, strict=False).broadcast_address - 1
        network_address = ipaddress.IPv4Network(ip, strict=False).network_address

        return "Public", ip_class_str, default_mask, block, first_ip, last_ip, network_address
    else:
        ip_class = ipaddress.IPv4Network(ip, strict=False).network_address
        ip_class_str = str(ip_class)
        ip_class_str = ip_class_str.split('.')
        ip_class_str = ip_class_str[0]
        if 10 <= int(ip_class_str) <= 10:
            ip_class_str = "A"
        elif 172 <= int(ip_class_str) <= 172:
            ip_class_str = "B"
        elif 192 <= int(ip_class_str) <= 192:
            ip_class_str = "C"
        default_mask = ipaddress.IPv4Network(ip, strict=False).netmask
        default_mask_str = str(default_mask)
        block = ipaddress.IPv4Network(ip, strict=False).num_addresses
        first_ip = ipaddress.IPv4Network(ip, strict=False).network_address + 1
        last_ip = ipaddress.IPv4Network(ip, strict=False).broadcast_address - 1
        network_address = ipaddress.IPv4Network(ip, strict=False).network_address

        return "Private", ip_class_str, default_mask, block, first_ip, last_ip, network_address

def get_classless_info(ip, prefix):
    ip_obj = ipaddress.ip_network(ip+'/'+prefix, strict=False)
    mask_decimal = ipaddress.IPv4Network(ip+'/'+prefix, strict=False).netmask
    no_of_ips = ipaddress.IPv4Network(ip+'/'+prefix, strict=False).num_addresses
    first_ip = ipaddress.IPv4Network(ip+'/'+prefix, strict=False).network_address + 1
    last_ip = ipaddress.IPv4Network(ip+'/'+prefix, strict=False).broadcast_address - 1
    network_address = ipaddress.IPv4Network(ip+'/'+prefix, strict=False).network_address

    return prefix, mask_decimal, no_of_ips, first_ip, last_ip, network_address

if __name__ == "__main__":
    ip_address = input("Enter The IP Address: ")
    classful_info = get_classful_info(ip_address)
    classless_prefix = int(input("Enter the prefix for classless addressing: "))
    classless_info = get_classless_info(ip_address, classless_prefix)

    print("\nFor Classful Addressing:")
    print("Given IP is", classful_info[0])
    print("This IP Address Belongs to Class:", classful_info[1])
    print("Default Mask:", classful_info[2])
    print("Block:", classful_info[3])
    print("First IP:", classful_info[4])
    print("Last IP:", classful_info[5])
    print("Network Address:", classful_info[6])

    print("\nFor Classless Addressing:")
    print("/ Value:", classless_info[0])
    print("Mask in Decimal:", classless_info[1])
    print("No of IP Addresses in Block:", classless_info[2])
    print("First IP:", classless_info[3])
    print("Last IP:", classless_info[4])
    print("Network Address:", classless_info[5])
