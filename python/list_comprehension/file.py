
from string import ascii_lowercase

# task: print out a list of 5 colors
COLORS = ["Yellow", "Green", "Red", "White", "Orange"]
print(COLORS)


# write a function to loop through list and print
COLORS = ["Yellow", "Green", "Red", "White", "Orange"]


def print_colors(li):
    return_list = []
    for color in li:
        return_list.append("Color is: " + color)
    return return_list


print(print_colors(COLORS))


# write a function to loop through list and print using list comprehension
def print_colors_comprehension(li):
    return ["Color is: " + color for color in li]


print(print_colors_comprehension(COLORS))


# write a function to return all colors longer than 4 characters long
def print_long_colors_comprehension(li):
    return ["Long word Color is: " + color for color in li if len(color) > 4]


print(print_long_colors_comprehension(COLORS))


# write a function that maps an integer to all alphebet characters
LETTERS = [letter + ":" + str(index)
           for index, letter in enumerate(ascii_lowercase, start=1)]
print(LETTERS)

# write a function that maps an integer to all alphebet characters
LETTERS = {letter: str(index)
           for index, letter in enumerate(ascii_lowercase, start=1)}
print(LETTERS)
