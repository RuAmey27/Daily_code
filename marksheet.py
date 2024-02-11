import tkinter as tk
from tkinter import messagebox
import pandas as pd

class MarksheetApp:
    def __init__(self, master):
        self.master = master
        self.master.title("Marksheet App")

        self.subjects = ["Subject 1", "Subject 2", "Subject 3", "Subject 4"]
        self.marks = {subject: tk.DoubleVar() for subject in self.subjects}

        self.create_widgets()

    def create_widgets(self):
        self.entries = {}
        for i, subject in enumerate(self.subjects):
            tk.Label(self.master, text=subject).grid(row=i, column=0)
            entry = tk.Entry(self.master, textvariable=self.marks[subject])
            entry.grid(row=i, column=1)
            self.entries[subject] = entry

        tk.Button(self.master, text="Calculate SGPA", command=self.calculate_sgpa).grid(row=len(self.subjects), columnspan=2)

    def calculate_sgpa(self):
        marks_data = {subject: self.marks[subject].get() for subject in self.subjects}
        df = pd.DataFrame(list(marks_data.items()), columns=["Subject", "Marks"])

        try:
            df["Credits"] = # add your logic to calculate credits based on marks
            total_credits = df["Credits"].sum()
            sgpa = # add your logic to calculate SGPA based on total credits and marks
            messagebox.showinfo("Result", f"Total Credits: {total_credits}\nSGPA: {sgpa}")
        except Exception as e:
            messagebox.showerror("Error", f"Error calculating SGPA: {e}")

def main():
    root = tk.Tk()
    app = MarksheetApp(root)
    root.mainloop()

if __name__ == "__main__":
    main()
