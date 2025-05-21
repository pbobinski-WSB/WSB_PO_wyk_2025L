import tkinter as tk

def say_hello():
    label.config(text="Witaj!")

root = tk.Tk()
root.title("Moje okno")

label = tk.Label(root, text="Kliknij przycisk")
label.pack()

button = tk.Button(root, text="Kliknij mnie", command=say_hello)
button.pack()

root.mainloop()
