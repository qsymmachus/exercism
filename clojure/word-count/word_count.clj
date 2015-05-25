(ns word-count
  (:require [clojure.string :as str]))

(declare normalize-word)

(defn word-count
  "Return a word count map for a given string."
  [string]
  (frequencies
    (filter (fn [word] (not (str/blank? word)))
      (map normalize-word 
        (str/split string #" ")))))

(defn normalize-word
  "Normalize a string by removing punctuation and converting it to lower case."
  [string]
  (str/lower-case (str/replace string #"\W" "")))
