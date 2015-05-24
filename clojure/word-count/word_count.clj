(ns word-count)

(declare normalize-word)

(defn word-count
  "Return a word count map for a given string."
  [string]
  (frequencies
    (filter (fn [word] (not (clojure.string/blank? word)))
      (map normalize-word 
        (clojure.string/split string #" ")))))

(defn normalize-word
  "Normalize a string by removing punctuation and converting it to lower case."
  [string]
  (clojure.string/lower-case (clojure.string/replace string #"\W" "")))
