from google.oauth2 import service_account
from googleapiclient.discovery import build
from googleapiclient.http import MediaIoBaseDownload  # Import MediaIoBaseDownload
import io

# Path to the service account credentials JSON file
credentials_file = 'aerobic-copilot-411010-3b76aa87ba33.json'

# ID of the Google Sheets file you want to download
file_id = '1WjpNLSL0eM01nbzRbzMP4EUr3qAWeEiwd5h0dfRCBVY'

# Destination path to save the downloaded file
destination_path = 'file.xlsx'

# Create credentials object from the JSON file
credentials = service_account.Credentials.from_service_account_file(
    credentials_file,
    scopes=['https://www.googleapis.com/auth/drive.readonly']  # Specify the necessary scope
)

# Build the Drive service
drive_service = build('drive', 'v3', credentials=credentials)

# Use the export functionality of Google Sheets API to download the file as Excel
request = drive_service.files().export_media(fileId=file_id, mimeType='application/vnd.openxmlformats-officedocument.spreadsheetml.sheet')

# Download the file
with open(destination_path, 'wb') as fh:
    downloader = MediaIoBaseDownload(fh, request)
    done = False
    while done is False:
        status, done = downloader.next_chunk()
        print("Download %d%%." % int(status.progress() * 100))

print(f"File downloaded to: {destination_path}")
