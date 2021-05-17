from time import sleep
import json

types = ["concrete", "terracotta", "wool"]
colors = ["white", "black", "blue", "brown", "cyan", "gray", "green", "light_blue", "light_gray", "lime",
    "magenta", "orange", "pink", "purple", "red", "white", "yellow"]
singular_block_types = ["terracotta"]

def process_data():
    print("Beginning data processing...")

    # For Shelves of multiple types and colors (ie: wool, concrete, terracotta)
    for index in range(0, 28):
        for color in colors:
            for type in types:
                model_data = createModelData(type, color, index)
                block_path = f"{color}_{type}"
                saveModelToJson(block_path, index, model_data)

    # however Terracotta has a its own singular variant named 'terracotta', so we handle single block variants here.
    for index in range(0, 28):
        for type in singular_block_types:
            model_data = createModelData(type, "", index)
            block_path = f"{type}"
            saveModelToJson(block_path, index, model_data)

    print("Data processing finished.")
    return colors


def saveModelToJson(block_path, index, model_data):

    filename = f'{block_path}_bookshelf_{index}.json'
    print(f"Saving {block_path}_{index}, To: {filename}")
    with open(filename, "w", encoding="utf-8") as writeJSON:
        json.dump(model_data, writeJSON, ensure_ascii=False, indent=4)
    print(f'{block_path}_bookshelf_{index}.json was saved')


def createModelData(type, color, index):
    if color != "":
        data = {
                 "parent": "minecraft:block/cube",
                 "textures": {
                   "block": f"minecraft:block/{color}_{type}",
                   "overlay": f"shelveit:block/bookshelf_{index}",
                   "particle": f"minecraft:block/{color}_{type}"
                 },
                 "elements": [
                   {
                     "from": [ 0, 0, 0 ],
                     "to": [ 16, 16, 16 ],
                     "faces": {
                       "down":  { "uv": [0,0, 16,16], "texture": "#block", "cullface": "down" },
                       "up":    { "uv": [0,0, 16,16], "texture": "#block", "cullface": "up" },
                       "north": { "uv": [0,0, 16,16], "texture": "#block", "cullface": "north" },
                       "south": { "uv": [0,0, 16,16], "texture": "#block", "cullface": "south" },
                       "west":  { "uv": [0,0, 16,16], "texture": "#block", "cullface": "west" },
                       "east":  { "uv": [0,0, 16,16], "texture": "#block", "cullface": "east" }
                     }
                   },
                   {
                     "from": [ 0, 0, 0 ],
                     "to": [ 16, 16, 16 ],
                     "faces": {
                       "north": { "uv": [0,0, 16,16], "texture": "#overlay", "cullface": "north" },
                       "south": { "uv": [0,0, 16,16], "texture": "#overlay", "cullface": "south" },
                       "west":  { "uv": [0,0, 16,16], "texture": "#overlay", "cullface": "west" },
                       "east":  { "uv": [0,0, 16,16], "texture": "#overlay", "cullface": "east" }
                     }
                   }
                 ]
               }
    else:
        data = {
                 "parent": "minecraft:block/cube",
                 "textures": {
                   "block": f"minecraft:block/{type}",
                   "overlay": f"shelveit:block/bookshelf_{index}",
                   "particle": f"minecraft:block/{type}"
                 },
                 "elements": [
                   {
                     "from": [ 0, 0, 0 ],
                     "to": [ 16, 16, 16 ],
                     "faces": {
                       "down":  { "uv": [0,0, 16,16], "texture": "#block", "cullface": "down" },
                       "up":    { "uv": [0,0, 16,16], "texture": "#block", "cullface": "up" },
                       "north": { "uv": [0,0, 16,16], "texture": "#block", "cullface": "north" },
                       "south": { "uv": [0,0, 16,16], "texture": "#block", "cullface": "south" },
                       "west":  { "uv": [0,0, 16,16], "texture": "#block", "cullface": "west" },
                       "east":  { "uv": [0,0, 16,16], "texture": "#block", "cullface": "east" }
                     }
                   },
                   {
                     "from": [ 0, 0, 0 ],
                     "to": [ 16, 16, 16 ],
                     "faces": {
                       "north": { "uv": [0,0, 16,16], "texture": "#overlay", "cullface": "north" },
                       "south": { "uv": [0,0, 16,16], "texture": "#overlay", "cullface": "south" },
                       "west":  { "uv": [0,0, 16,16], "texture": "#overlay", "cullface": "west" },
                       "east":  { "uv": [0,0, 16,16], "texture": "#overlay", "cullface": "east" }
                     }
                   }
                 ]
               }

    return data


def main():
    print("Starting model creation....")
    process_data()
    print("Done....")



if __name__ == "__main__":
    main()