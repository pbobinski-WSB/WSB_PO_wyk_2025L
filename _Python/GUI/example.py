import tkinter as tk
from tkinter import ttk, messagebox

class TkinterExample:
    def __init__(self, root):
        self.root = root
        self.root.title("Tkinter GUI Example")

        self.notebook = ttk.Notebook(root)
        self.list_tab = tk.Frame(self.notebook)
        self.info_tab = tk.Frame(self.notebook)
        self.notebook.add(self.list_tab, text='Lista')
        self.notebook.add(self.info_tab, text='Info')
        self.notebook.pack(expand=True, fill='both')

        self.elements = []

        self.input_var = tk.StringVar()

        input_frame = tk.Frame(self.list_tab)
        input_frame.pack(pady=5)
        tk.Label(input_frame, text="Element:").pack(side='left')
        self.entry = tk.Entry(input_frame, textvariable=self.input_var)
        self.entry.pack(side='left')

        self.listbox = tk.Listbox(self.list_tab)
        self.listbox.pack(padx=10, pady=10, expand=True, fill='both')

        btn_frame = tk.Frame(self.list_tab)
        btn_frame.pack()

        tk.Button(btn_frame, text="Dodaj", command=self.add_item).pack(side='left', padx=5)
        tk.Button(btn_frame, text="Usuń", command=self.remove_item).pack(side='left', padx=5)
        tk.Button(btn_frame, text="Edytuj", command=self.edit_item).pack(side='left', padx=5)

        tk.Label(self.info_tab, text="Zakładka informacyjna", font=('Arial', 14)).pack(pady=20)

    def add_item(self):
        text = self.input_var.get().strip()
        if text:
            self.listbox.insert(tk.END, text)
            self.input_var.set("")

    def remove_item(self):
        selected = self.listbox.curselection()
        if selected:
            self.listbox.delete(selected[0])

    def edit_item(self):
        selected = self.listbox.curselection()
        text = self.input_var.get().strip()
        if selected and text:
            self.listbox.delete(selected[0])
            self.listbox.insert(selected[0], text)
            self.input_var.set("")

if __name__ == '__main__':
    root = tk.Tk()
    root.geometry("400x300")
    app = TkinterExample(root)
    root.mainloop()
