from scapy.layers.l2 import Ether
from scapy.layers.inet import ARP
from scapy.sendrecv import sendp

# Create RARP Request Packet
rarp_request = Ether(dst="ff:ff:ff:ff:ff:ff") / ARP(
    op=ARP.who_has(),             # Use ARP.who_has for request
    hwsrc="00:11:22:33:44:55",  # Sender MAC Address
    psrc="192.168.1.1",         # Sender IP Address
    hwdst="00:00:00:00:00:00",  # Target MAC Address (usually blank in RARP request)
    pdst="0.0.0.0"              # Target IP Address (usually blank in RARP request)
)


# Send packets
sendp(rarp_request)

