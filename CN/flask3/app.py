from flask import Flask, render_template, request

app = Flask(__name__)

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

def is_valid_classful_format(ip_address):
    try:
        octet = int(ip_address)
        return 0 <= octet <= 255
    except ValueError:
        return False

def is_private_ip(ip_address):
    octets = ip_address.split('.')
    first_octet = int(octets[0])

    if first_octet == 10 or \
       (first_octet == 172 and 16 <= int(octets[1]) <= 31) or \
       (first_octet == 192 and int(octets[1]) == 168):
        return True

    return False

def is_reserved_ip(ip_address):
    octets = ip_address.split('.')
    first_octet = int(octets[0])

    if (first_octet == 0) or \
       (first_octet == 192 and int(octets[1]) == 0 and int(octets[2]) == 0) or \
       (first_octet == 192 and int(octets[1]) == 0 and int(octets[2]) == 2) or \
       (first_octet == 192 and int(octets[1]) == 88 and int(octets[2]) == 99) or \
       (first_octet == 198 and int(octets[1]) == 51 and int(octets[2]) == 100) or \
       (first_octet == 203 and int(octets[1]) == 0 and int(octets[2]) == 113) or \
       (224 <= first_octet <= 239):
        return True

    return False

def get_classful_ip_info(ip_address):
    if not is_valid_ipv4(ip_address):
        return 'Invalid', 'N/A', 'N/A', 'N/A', 'N/A'

    octets = ip_address.split('.')
    first_octet = int(octets[0])
    second_octet = int(octets[1])
    third_octet = int(octets[2])

    if first_octet >= 1 and first_octet <= 127:
        ip_class = 'Class A'
    elif first_octet >= 128 and first_octet <= 191:
        ip_class = 'Class B'
    elif first_octet >= 192 and first_octet <= 223:
        ip_class = 'Class C'
    elif first_octet >= 224 and first_octet <= 239:
        ip_class = 'Class D'
    elif first_octet >= 240 and first_octet <= 255:
        ip_class = 'Class E'
    else:
        ip_class = 'Invalid'

    block_number = '.'.join(octets[:2]) if ip_class != 'Invalid' else 'N/A'
    first_address = '.'.join(octets[:3] + ['0'])
    last_address = '.'.join(octets[:3] + ['255'])

    ip_type = 'Public'
    if is_private_ip(ip_address):
        ip_type = 'Private'
    elif is_reserved_ip(ip_address):
        ip_type = 'Reserved'

    return ip_class, block_number, first_address, last_address, ip_type

def get_classless_ip_info(ip_address):
    if not is_valid_ipv4(ip_address):
        return 'Invalid', 'N/A', 'N/A', 'N/A', 'N/A'

    # Assuming the subnet mask is provided in the format "/xx"
    ip_parts = ip_address.split('/')
    if len(ip_parts) != 2:
        return 'Invalid', 'N/A', 'N/A', 'N/A', 'N/A'

    subnet_mask = int(ip_parts[1])
    if subnet_mask < 0 or subnet_mask > 32:
        return 'Invalid', 'N/A', 'N/A', 'N/A', 'N/A'

    ip_address = ip_parts[0]
    octets = ip_address.split('.')
    ip_class = 'Classless'
    block_number = 'N/A'  # Classless IP does not have a block number

    # Calculate subnet address
    subnet_address = calculate_subnet_address(octets, subnet_mask)

    # Calculate broadcast address
    broadcast_address = calculate_broadcast_address(octets, subnet_mask)

    # Calculate number of hosts per subnet
    num_hosts_per_subnet = calculate_num_hosts_per_subnet(subnet_mask)

    # Calculate first host ID
    first_host_id = calculate_first_host_id(subnet_address)

    # Determine IP type
    ip_type = determine_ip_type(ip_address)

    return ip_class, block_number, subnet_address, broadcast_address, num_hosts_per_subnet, first_host_id, ip_type

def calculate_subnet_address(ip_octets, subnet_mask):
    subnet_address = []
    subnet_mask_octets = get_subnet_mask(subnet_mask).split('.')
    for i in range(4):
        subnet_address.append(str(int(ip_octets[i]) & int(subnet_mask_octets[i])))
    return '.'.join(subnet_address)

def calculate_broadcast_address(ip_octets, subnet_mask):
    broadcast_address = []
    subnet_mask_octets = get_subnet_mask(subnet_mask).split('.')
    for i in range(4):
        broadcast_address.append(str(int(ip_octets[i]) | ~int(subnet_mask_octets[i]) & 0xff))
    return '.'.join(broadcast_address)

def calculate_num_hosts_per_subnet(subnet_mask):
    return 2 ** (32 - subnet_mask) - 2

def calculate_first_host_id(subnet_address):
    first_host_id = subnet_address.split('.')
    first_host_id[-1] = str(int(first_host_id[-1]) + 1)
    return '.'.join(first_host_id)

def determine_ip_type(ip_address):
    if is_private_ip(ip_address):
        return 'Private'
    elif is_reserved_ip(ip_address):
        return 'Reserved'
    else:
        return 'Public'


@app.route('/', methods=['GET', 'POST'])
def index():
    if request.method == 'POST':
        ip_address = request.form['ip_address']
        if is_valid_classful_format(ip_address):
            ip_class, block_number, first_address, last_address, ip_type = get_classful_ip_info(ip_address)
        else:
            ip_class, block_number, first_address, last_address, ip_type = get_classless_ip_info(ip_address)
        return render_template('index.html', ip_address=ip_address, ip_class=ip_class, block_number=block_number, first_address=first_address, last_address=last_address, ip_type=ip_type)
    return render_template('index.html')

if __name__ == "__main__":
    app.run(debug=True)
