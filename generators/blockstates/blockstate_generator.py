from time import sleep
import json

types = ["concrete", "terracotta", "wool"]
colors = ["white", "black", "blue", "brown", "cyan", "gray", "green", "light_blue", "light_gray", "lime",
    "magenta", "orange", "pink", "purple", "red", "white", "yellow"]
singular_block_types = ["terracotta"]

def process_data():
    print("Beginning data processing...")

    # For Shelves of multiple types and colors (ie: wool, concrete, terracotta)
    for color in colors:
        for type in types:
            block_state_data = createBlockStateData(type, color)
            block_path = f"{color}_{type}"
            saveBlockStatesToJson(block_path, block_state_data)

    # however Terracotta has a its own singular variant named 'terracotta', so we handle single block variants here.
    for type in singular_block_types:
        block_state_data =createBlockStateData(type, "")
        block_path = f"{type}"
        saveBlockStatesToJson(block_path, block_state_data)

    print("Data processing finished.")
    return colors


def saveBlockStatesToJson(block_path, model_data):

    filename = f'{block_path}_bookshelf.json'
    print(f"Saving {block_path}, To: {filename}")
    with open(filename, "w", encoding="utf-8") as writeJSON:
        json.dump(model_data, writeJSON, ensure_ascii=False, indent=4)
    print(f'{block_path}_bookshelf.json was saved')


def createBlockStateData(type, color):
    if color != "":
        data = {
                 "variants": {
                   "number_of_books=0": {"model": f"shelveit:block/{color}_{type}_bookshelf_0"},
                   "number_of_books=1": {"model": f"shelveit:block/{color}_{type}_bookshelf_1"},
                   "number_of_books=2": {"model": f"shelveit:block/{color}_{type}_bookshelf_2"},
                   "number_of_books=3": {"model": f"shelveit:block/{color}_{type}_bookshelf_3"},
                   "number_of_books=4": {"model": f"shelveit:block/{color}_{type}_bookshelf_4"},
                   "number_of_books=5": {"model": f"shelveit:block/{color}_{type}_bookshelf_5"},
                   "number_of_books=6": {"model": f"shelveit:block/{color}_{type}_bookshelf_6"},
                   "number_of_books=7": {"model": f"shelveit:block/{color}_{type}_bookshelf_7"},
                   "number_of_books=8": {"model": f"shelveit:block/{color}_{type}_bookshelf_8"},
                   "number_of_books=9": {"model": f"shelveit:block/{color}_{type}_bookshelf_9"},
                   "number_of_books=10": {"model": f"shelveit:block/{color}_{type}_bookshelf_10"},
                   "number_of_books=11": {"model": f"shelveit:block/{color}_{type}_bookshelf_11"},
                   "number_of_books=12": {"model": f"shelveit:block/{color}_{type}_bookshelf_12"},
                   "number_of_books=13": {"model": f"shelveit:block/{color}_{type}_bookshelf_13"},
                   "number_of_books=14": {"model": f"shelveit:block/{color}_{type}_bookshelf_14"},
                   "number_of_books=15": {"model": f"shelveit:block/{color}_{type}_bookshelf_15"},
                   "number_of_books=16": {"model": f"shelveit:block/{color}_{type}_bookshelf_16"},
                   "number_of_books=17": {"model": f"shelveit:block/{color}_{type}_bookshelf_17"},
                   "number_of_books=18": {"model": f"shelveit:block/{color}_{type}_bookshelf_18"},
                   "number_of_books=19": {"model": f"shelveit:block/{color}_{type}_bookshelf_19"},
                   "number_of_books=20": {"model": f"shelveit:block/{color}_{type}_bookshelf_20"},
                   "number_of_books=21": {"model": f"shelveit:block/{color}_{type}_bookshelf_21"},
                   "number_of_books=22": {"model": f"shelveit:block/{color}_{type}_bookshelf_22"},
                   "number_of_books=23": {"model": f"shelveit:block/{color}_{type}_bookshelf_23"},
                   "number_of_books=24": {"model": f"shelveit:block/{color}_{type}_bookshelf_24"},
                   "number_of_books=25": {"model": f"shelveit:block/{color}_{type}_bookshelf_25"},
                   "number_of_books=26": {"model": f"shelveit:block/{color}_{type}_bookshelf_26"},
                   "number_of_books=27": {"model": f"shelveit:block/{color}_{type}_bookshelf_27"}
                 }
               }
    else:
        data = {
                  "variants": {
                    "number_of_books=0": {"model": f"shelveit:block/{type}_bookshelf_0"},
                    "number_of_books=1": {"model": f"shelveit:block/{type}_bookshelf_1"},
                    "number_of_books=2": {"model": f"shelveit:block/{type}_bookshelf_2"},
                    "number_of_books=3": {"model": f"shelveit:block/{type}_bookshelf_3"},
                    "number_of_books=4": {"model": f"shelveit:block/{type}_bookshelf_4"},
                    "number_of_books=5": {"model": f"shelveit:block/{type}_bookshelf_5"},
                    "number_of_books=6": {"model": f"shelveit:block/{type}_bookshelf_6"},
                    "number_of_books=7": {"model": f"shelveit:block/{type}_bookshelf_7"},
                    "number_of_books=8": {"model": f"shelveit:block/{type}_bookshelf_8"},
                    "number_of_books=9": {"model": f"shelveit:block/{type}_bookshelf_9"},
                    "number_of_books=10": {"model": f"shelveit:block/{type}_bookshelf_10"},
                    "number_of_books=11": {"model": f"shelveit:block/{type}_bookshelf_11"},
                    "number_of_books=12": {"model": f"shelveit:block/{type}_bookshelf_12"},
                    "number_of_books=13": {"model": f"shelveit:block/{type}_bookshelf_13"},
                    "number_of_books=14": {"model": f"shelveit:block/{type}_bookshelf_14"},
                    "number_of_books=15": {"model": f"shelveit:block/{type}_bookshelf_15"},
                    "number_of_books=16": {"model": f"shelveit:block/{type}_bookshelf_16"},
                    "number_of_books=17": {"model": f"shelveit:block/{type}_bookshelf_17"},
                    "number_of_books=18": {"model": f"shelveit:block/{type}_bookshelf_18"},
                    "number_of_books=19": {"model": f"shelveit:block/{type}_bookshelf_19"},
                    "number_of_books=20": {"model": f"shelveit:block/{type}_bookshelf_20"},
                    "number_of_books=21": {"model": f"shelveit:block/{type}_bookshelf_21"},
                    "number_of_books=22": {"model": f"shelveit:block/{type}_bookshelf_22"},
                    "number_of_books=23": {"model": f"shelveit:block/{type}_bookshelf_23"},
                    "number_of_books=24": {"model": f"shelveit:block/{type}_bookshelf_24"},
                    "number_of_books=25": {"model": f"shelveit:block/{type}_bookshelf_25"},
                    "number_of_books=26": {"model": f"shelveit:block/{type}_bookshelf_26"},
                    "number_of_books=27": {"model": f"shelveit:block/{type}_bookshelf_27"}
                      }
               }

    return data


def main():
    print("Starting block state file creation....")
    process_data()
    print("Done....")



if __name__ == "__main__":
    main()