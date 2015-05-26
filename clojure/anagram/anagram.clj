(ns anagram
  (:require [clojure.string :as cstr]))

(declare anagram? canonical)

(defn anagrams-for
  "Given a word and a list of possible anagrams, selects the correct sublist."
  [word word-list]
  (filter 
    (fn [test-word] (anagram? word test-word)) 
    word-list))

(defn anagram?
  "Determines whether two strings are anagrams of each other."
  [string1 string2]
  (if 
    (= 
      (cstr/lower-case string1) 
      (cstr/lower-case string2))
    false
    (= 
      (frequencies (canonical string1)) 
      (frequencies (canonical string2)))))

(defn canonical
  "Returns a canonical representation of a string as a character-split vector."
  [string]
  (cstr/split (cstr/lower-case string) #""))
