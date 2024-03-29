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
        broadcast_address.append(str(int(ip_octets[i]) | (~int(subnet_mask_octets[i]) & 0xff)))
    return '.'.join(broadcast_address)


def calculate_num_hosts_per_subnet(subnet_bits):
    return 2 ** (32 - subnet_bits) - 2


def calculate_first_host_id(subnet_address):
    first_host_id = subnet_address.split('.')
    first_host_id[-1] = str(int(first_host_id[-1]) + 1)
    return '.'.join(first_host_id)

def get_ip_class(ip_with_mask):
    ip_parts = ip_with_mask.split('/')
    
    if len(ip_parts) != 2:
        return 'Invalid input format', 'N/A', 'N/A', 'N/A', 'N/A', 'N/A'
    
    ip_address = ip_parts[0]
    subnet_bits = int(ip_parts[1])
    
    if subnet_bits < 0 or subnet_bits > 32:
        return 'Invalid subnet bits', 'N/A', 'N/A', 'N/A', 'N/A', 'N/A'
    
    subnet_mask = get_subnet_mask(subnet_bits)

    ip_octets = ip_address.split('.')
    subnet_address = calculate_subnet_address(ip_octets, subnet_mask)
    broadcast_address = calculate_broadcast_address(ip_octets, subnet_mask)
    num_hosts_per_subnet = calculate_num_hosts_per_subnet(subnet_bits)
    first_host_id = calculate_first_host_id(subnet_address)

    return 'Classless', subnet_address, broadcast_address, num_hosts_per_subnet, first_host_id, subnet_mask


@app.route('/', methods=['GET', 'POST'])
def index():
    if request.method == 'POST':
        ip_address = request.form['ip_address']
        subnet_bits = request.form['subnet_bits']
        ip_with_mask = f"{ip_address}/{subnet_bits}"
        ip_class, subnet_address, broadcast_address, num_hosts_per_subnet, first_host_id, subnet_mask = get_ip_class(ip_with_mask)
        return render_template('result.html', ip_with_mask=ip_with_mask, ip_class=ip_class, subnet_address=subnet_address, broadcast_address=broadcast_address, num_hosts_per_subnet=num_hosts_per_subnet, first_host_id=first_host_id, subnet_mask=subnet_mask)
    return render_template('index.html')


if __name__ == "__main__":
    app.run(debug=True)
