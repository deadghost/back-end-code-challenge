(ns project-euler.ex-002)

;; Each new term in the Fibonacci sequence is generated by adding the previous
;; two terms. By starting with 1 and 2, the first 10 terms will be:
;; 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
;; By considering the terms in the Fibonacci sequence whose values do not exceed
;; four million, find the sum of the even-valued terms.

(def fib-seq
  "Lazy infinite fib sequence using corecursion.
  Realize using the take function."
  (lazy-cat [1 1] (map +' fib-seq (rest fib-seq))))

(->> (take-while #(<= % 4000000) fib-seq)
     (filter even?)
     (apply +))
