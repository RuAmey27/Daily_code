# app.py

from flask import Flask, render_template, request

app = Flask(__name__)

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
    return 2 ** (32 - subnet_bits)

def calculate_first_host_id(subnet_address):
    first_host_id = subnet_address.split('.')
    first_host_id[-1] = str(int(first_host_id[-1]) + 1)
    return '.'.join(first_host_id)

def is_private_ip(ip_octets):
    first_octet = int(ip_octets[0])
    second_octet = int(ip_octets[1])
    third_octet = int(ip_octets[2])
    
    # Private IP ranges
    if first_octet == 10 \
        or (first_octet == 172 and 16 <= second_octet <= 31) \
        or (first_octet == 192 and second_octet == 168):
        return True
    return False

def is_reserved_ip(ip_octets):
    first_octet = int(ip_octets[0])
    second_octet = int(ip_octets[1])

    # Reserved IP ranges
    if first_octet == 0 \
        or (first_octet == 192 and second_octet == 0) \
        or (first_octet == 192 and second_octet == 0 and ip_octets[2] == 2) \
        or (first_octet == 192 and second_octet == 88 and ip_octets[2] == 99) \
        or (first_octet == 198 and second_octet == 51 and ip_octets[2] == 100) \
        or (first_octet == 203 and second_octet == 0 and ip_octets[2] == 113) \
        or (first_octet == 224):
        return True
    return False

def get_ip_class(ip_with_mask):
    ip_parts = ip_with_mask.split('/')
    
    if len(ip_parts) != 2:
        return 'Invalid input format', 'N/A', 'N/A', 'N/A', 'N/A', 'N/A', 'N/A'
    
    ip_address = ip_parts[0]
    subnet_bits = int(ip_parts[1])
    
    if subnet_bits < 0 or subnet_bits > 32:
        return 'Invalid subnet bits', 'N/A', 'N/A', 'N/A', 'N/A', 'N/A', 'N/A'
    
    subnet_mask = get_subnet_mask(subnet_bits)

    ip_octets = ip_address.split('.')
    subnet_address = calculate_subnet_address(ip_octets, subnet_mask)
    broadcast_address = calculate_broadcast_address(ip_octets, subnet_mask)
    num_hosts_per_subnet = calculate_num_hosts_per_subnet(subnet_bits)
    first_host_id = calculate_first_host_id(subnet_address)

    ip_class = 'Classless'
    if is_private_ip(ip_octets):
        ip_class = 'Private'
    elif is_reserved_ip(ip_octets):
        ip_class = 'Reserved'
    else:
        ip_class = 'Public'

    return ip_class, subnet_address, broadcast_address, num_hosts_per_subnet, first_host_id, subnet_mask

@app.route('/', methods=['GET', 'POST'])
def index():
    if request.method == 'POST':
        ip_with_mask = request.form['ip_with_mask']
        ip_class, subnet_address, broadcast_address, num_hosts_per_subnet, first_host_id, subnet_mask = get_ip_class(ip_with_mask)
        return render_template('result.html', ip_with_mask=ip_with_mask, ip_class=ip_class, subnet_address=subnet_address, broadcast_address=broadcast_address, num_hosts_per_subnet=num_hosts_per_subnet, first_host_id=first_host_id, subnet_mask=subnet_mask)
    return render_template('index.html')

if __name__ == "__main__":
    app.run(debug=True)
