(ns beer-song)

(defn verse
    "Given a verse number, returns a verse of the 'beer song'."
    [n]
    (cond
        (= 0 n) "No more bottles of beer on the wall, no more bottles of beer.\nGo to the store and buy some more, 99 bottles of beer on the wall.\n"
        (= 1 n) "1 bottle of beer on the wall, 1 bottle of beer.\nTake it down and pass it around, no more bottles of beer on the wall.\n"
        (= 2 n) "2 bottles of beer on the wall, 2 bottles of beer.\nTake one down and pass it around, 1 bottle of beer on the wall.\n"
        (<= 3 n) (format "%d bottles of beer on the wall, %d bottles of beer.\nTake one down and pass it around, %d bottles of beer on the wall.\n" n n (dec n))))

(defn sing
    "This is a multi-arity function.
        1. Given a single verse number, returns the beer song starting at that
        verse and ending with the last verse.
        2. Given starting and ending verse numbers, returns multiple verses of
        the 'beer song' in that range.
    All but the last verse are separated by two newline characters."
    ([n] 
        (sing n 0))
    ([start end]
        (if (< start end)
            ""
            (apply str (concat 
                (verse start)
                (if (not (= start end)) "\n" "") 
                (sing (dec start) end))))))