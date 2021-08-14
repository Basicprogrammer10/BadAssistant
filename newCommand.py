# By Connor Slade - 2021

# Make a new Command
# Makes a folder and the needed files
# Base code is sourced from base/
# Its not a very fancy script but hey it works

import sys
import os


def make_dir(path):
    try:
        os.stat(path)
    except:
        os.mkdir(path)


def main():
    print("[*] Starting NewCommand\n[*] By Connor Slade\n")

    if len(sys.argv) < 2:
        print("[-] You must define a command name... smh")
        return

    command = sys.argv[1].title().replace(" ", "")
    print(f"[*] Adding Command '{command}'")

    cmd_dir = f'src/com/connorcode/assistant/app/commands/{command}'
    print(f"[*] Making new Folder '{cmd_dir}'")
    make_dir(cmd_dir.lower())

    print(f"[*] Moving Files")
    for i in ["#App.kt", "Get#Action.kt"]:
        app = open(f"base/{i}", 'r').read()
        app = app.replace("{name}", command)
        app = app.replace("{lower_name}", command.lower())
        open(f"{cmd_dir.lower()}/{i.replace('#', command)}", 'w+').write(app)

    print("[*] Done :P")


if __name__ == '__main__':
    main()
