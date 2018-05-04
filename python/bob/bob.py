import re

def hey(what):
    if is_question(what):
        return 'Sure.'
    elif is_yelling(what):
        return 'Whoa, chill out!'
    elif is_empty(what):
        return 'Fine. Be that way!'
    else:
        return 'Whatever.'

def is_question(what):
    return re.search(r'\w*\?$', what) and not is_yelling(what)

def is_yelling(what):
    return re.search(r'[a-zA-Z]+', what) and what.upper() == what and not is_empty(what)

def is_empty(what):
    return re.search(r'^\s*$', what)
    