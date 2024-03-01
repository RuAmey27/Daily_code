import gspread
from oauth2client.service_account import ServiceAccountCredentials

# Define the scope
scope = ['https://spreadsheets.google.com/feeds',
         'https://www.googleapis.com/auth/drive']

# Authenticate using credentials
creds = ServiceAccountCredentials.from_json_keyfile_name('aerobic-copilot-411010-f2e99e4a5e5e.json', scope)
client = gspread.authorize(creds)

# Open the Google Sheets document
spreadsheet_id = '1n58WlOch0e22P2ITrgHGGBAUzcOvlQaGj_ulA2YjApQ'
spreadsheet = client.open_by_key(spreadsheet_id)


# Select the worksheet
worksheet = spreadsheet.sheet1

# Define the headers
headers = ["Subject", "Marks"]

# Update headers in the first row
worksheet.append_row(headers)

# Define the subjects and marks
subjects = ["Subject 1", "Subject 2", "Subject 3", "Subject 4"]
marks = [90, 85, 75, 80]  # Example marks, you can replace them with actual marks

# Add marks to the worksheet
for subject, mark in zip(subjects, marks):
    worksheet.append_row([subject, mark])

print("Marks added successfully.")
