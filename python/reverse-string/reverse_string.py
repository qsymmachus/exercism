def reverse(input=''):
    if input == '':
        return ''
    else:
        return input[-1] + reverse(input[0:-1])
