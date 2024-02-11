import gspread
from oauth2client.service_account import ServiceAccountCredentials

# Define the scope
scope = ['https://spreadsheets.google.com/feeds',
         'https://www.googleapis.com/auth/drive']

# Authenticate using service account credentials
creds = ServiceAccountCredentials.from_json_keyfile_name('aerobic-copilot-411010-3b76aa87ba33.json', scope)
client = gspread.authorize(creds)

# Create a new Google Sheets document
new_spreadsheet = client.create('Pyscript')

print(f"New spreadsheet '{new_spreadsheet.title}' created with ID: {new_spreadsheet.id}")
