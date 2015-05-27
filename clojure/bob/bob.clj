(ns bob
  (:require [clojure.string :as cstr]))

(defn yelling?
  "Checks whether a string 'yelling'. A string is yelling if:
    1. It is all upper case,
    2. It contains at least one letter."
  [string]
  (and 
    (= string (cstr/upper-case string)) 
    (re-find #"\p{L}" string)))

(defn question?
  "Checks whether a string is question (that is, whether it ends in '?')."
  [string]
  (= \? (last string)))

(defn response-for
  "Bob the lackadaisical teenager will respond to your statements."
  [statement]
  (cond
    (cstr/blank? statement) "Fine. Be that way!"
    (yelling? statement) "Whoa, chill out!"
    (question? statement) "Sure."
    :else "Whatever."))
