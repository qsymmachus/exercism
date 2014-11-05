var Bob = function() {
  function isBlank(string) {
    return /^\s*$/.test(string);
  }

  function isUpperCase(string) {
    if (!hasLetters(string)) return false;
    return string === string.toUpperCase() ? true : false; 
  }

  function isQuestion(string) {
    return string[string.length - 1] === '?' ? true : false;
  }

  function hasLetters(string) {
    return /[a-zA-Z]/.test(string)
  }

  return {
    hey: function(input) {
      if (isBlank(input)) {
        return "Fine. Be that way!";
      } else if (isUpperCase(input)) {
        return "Whoa, chill out!";
      } else if (isQuestion(input)) {
        return "Sure."
      } else {
        return "Whatever.";
      }
    }
  }
}

module.exports = Bob;