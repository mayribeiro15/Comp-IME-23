import string
def isdigit(c):
    if c in "0123456789":
        return True
    return False

def isalnum(c):
    if c in string.ascii_letters:
        return True
    return False

def isspace(c):
    if c in [chr(10), chr(13), "\f", "\v", "\t"," "]:
        return True
    return False

def binarysearch(name, key_words):
    left = 0
    right = len(key_words) - 1
    while left <= right:
        middle = (left + right) // 2
        if key_words[middle] == name:
            return middle
        elif key_words[middle] > name:
            right = middle - 1
        else:
            left = middle + 1
    return -1 