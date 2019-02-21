(ns project-euler.ex-022)

;; Using names.txt (right click and 'Save Link/Target As...'), a 46K text file
;; containing over five-thousand first names, begin by sorting it into
;; alphabetical order. Then working out the alphabetical value for each name,
;; multiply this value by its alphabetical position in the list to obtain a name
;; score.

;; For example, when the list is sorted into alphabetical order, COLIN, which is
;; worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list. So, COLIN
;; would obtain a score of 938 × 53 = 49714.

;; What is the total of all the name scores in the file?

(defn char-val
  "Return numerical value of char.
   Ex. \\A returns 1."
  [char]
  (- (int char) 64))

(defn word-sum
  "Returns sum of character values in word."
  [word]
  (apply + (map char-val word)))

(def sorted-names
  "Name strings in a vector in alphabetical order."
  (->> (re-seq #"\"([^\"]*)\""
               (slurp "resources/p022_names.txt"))
       (map second)
       sort))

(defn solve []
  (->> (map word-sum sorted-names)
       (map * (iterate inc 1))
       (apply +)))
