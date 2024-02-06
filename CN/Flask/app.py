from flask import Flask, render_template, request
import ipaddress

app = Flask(__name__)

def get_classless_info(ip, prefix):
    try:
        parts = ip.split('\t')
        if len(parts) == 2:
            ip_obj = ipaddress.ip_network(parts[0] + '/' + str(parts[1]), strict=False)
            mask_decimal = ipaddress.IPv4Network(parts[0] + '/' + str(parts[1]), strict=False).netmask
            no_of_ips = ipaddress.IPv4Network(parts[0] + '/' + str(parts[1]), strict=False).num_addresses
            first_ip = ipaddress.IPv4Network(parts[0] + '/' + str(parts[1]), strict=False).network_address + 1
            last_ip = ipaddress.IPv4Network(parts[0] + '/' + str(parts[1]), strict=False).broadcast_address - 1
            network_address = ipaddress.IPv4Network(parts[0] + '/' + str(parts[1]), strict=False).network_address

            return str(prefix), str(mask_decimal), str(no_of_ips), str(first_ip), str(last_ip), str(network_address)
        else:
            return "Invalid Input", None, None, None, None, None
    except ValueError:
        return "Invalid Input", None, None, None, None, None


@app.route('/', methods=['GET', 'POST'])
def index():
    result = None

    if request.method == 'POST':
        ip_address = request.form['ip_address']
        result = get_classless_info(ip_address.split('\')[0], int(ip_address.split('\')[1]))

    return render_template('index.html', result=result)

if __name__ == '__main__':
    app.run(debug=True)
