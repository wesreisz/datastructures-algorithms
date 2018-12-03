from string import ascii_lowercase
LETTERS = {letter: str(index)
           for index, letter in enumerate(ascii_lowercase, start=1)}


def atoi(text):
    text = text.lower()
    numbers = [LETTERS[character]
               for character in text if character in LETTERS]
    val = ''.join(numbers)
    return int(val)
